package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist.DentistSearchActivity;

import java.util.List;

public class GuestMenuActivity extends AppCompatActivity implements GuestMenuView {
    final int REQUEST_CODE_DENTIST_SEARCH = 1;
    private GuestMenuPresenter presenter;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presenter = new GuestMenuPresenter(this);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_guest_menu);
        List<Specialization> specializations = presenter.getSpecializations();
        String Specializations[] = new String[specializations.size() + 1];
        Specializations[0] = "";
        for (int i = 1; i <= specializations.size(); i++) {
            Specializations[i] = specializations.get(i - 1).getSpecializationName();
        }
        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Specializations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        findViewById(R.id.search_dentist_with_filters).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String region = ((EditText) findViewById(R.id.Region)).getText().toString();
                String specialization = s.getSelectedItem().toString();
                presenter.searchbyfilters(region, specialization);
            }
        });
        findViewById(R.id.search_dentist_by_name).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String lastname = ((EditText) findViewById(R.id.lastname)).getText().toString();
                String firstname = ((EditText) findViewById(R.id.firstname)).getText().toString();
                presenter.searchbyname(lastname, firstname);
            }
        });
    }

    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }

    public void showSearchView(String lastname, String firstname) {
        Intent intent = new Intent(this, DentistSearchActivity.class);
        intent.putExtra("lastname", lastname);
        intent.putExtra("firstname", firstname);
        startActivityForResult(intent, 1);
    }

    public void showSearchViewFilters(String region, String specialization) {
        Intent intent = new Intent(this, DentistSearchActivity.class);
        intent.putExtra("region", region);
        intent.putExtra("specialization", specialization);
        startActivityForResult(intent, 1);
    }


}
