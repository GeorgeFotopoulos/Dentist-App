package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.ArrayList;
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

        Intent intent = getIntent();

        // extract search criteria from intent
        String lastname = intent.getStringExtra("lastname");
        String firstname = intent.getStringExtra("firstname");
        // find search result
        dentistSearchPresenter = new DentistSearchPresenter(this);
        Set<Dentist> result = dentistSearchPresenter.searchDentists(lastname, firstname);
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
       // mAdapter.setDentistSelectionListener(this);
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

}
