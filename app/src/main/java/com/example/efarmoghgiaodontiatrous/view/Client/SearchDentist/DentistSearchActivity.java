package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.efarmoghgiaodontiatrous.DentistAdapter;
import com.example.efarmoghgiaodontiatrous.ItemSelectionListener;
import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment.RequestAppointmentActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DentistSearchActivity extends AppCompatActivity implements ItemSelectionListener<Dentist>, DentistSearchView {
    RecyclerView recyclerView;
    private DentistAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DentistSearchPresenter dentistSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_search);
        Set<Dentist> result = new HashSet<>();
        Intent intent = getIntent();
        dentistSearchPresenter = new DentistSearchPresenter(this);
        // extract search criteria from intent
        if (intent.hasExtra("lastname")) {
            String lastname = intent.getStringExtra("lastname");
            String firstname = intent.getStringExtra("firstname");
            result = dentistSearchPresenter.searchDentists(lastname, firstname);
        } else if (intent.hasExtra("region")) {
            String region = intent.getStringExtra("region");
            String specialization = intent.getStringExtra("specialization");
            String service = intent.getStringExtra("service");
            result = dentistSearchPresenter.searchDentistsWithFilters(region, specialization, service);
        }
        // find search result

        // Update UI with the result
        recyclerView = findViewById(R.id.recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new DentistAdapter(new ArrayList<Dentist>(result));
        recyclerView.setAdapter(mAdapter);
        // register the current activity as listener for book selection events
        mAdapter.setDentistSelectionListener(this);
    }

    /**
     * The method will be called by the adapter, whenever the user clicks on a list item
     *
     * @param item
     */
    @Override
    public void onItemSelected(Dentist item) {
        dentistSearchPresenter.onDentistSelected(item);
    }

    @Override
    public void requestAppointment(Dentist item) {
        Intent intent = new Intent(this, RequestAppointmentActivity.class);
        intent.putExtra("DentistID", item.getID());
        startActivityForResult(intent, 1);
    }
}