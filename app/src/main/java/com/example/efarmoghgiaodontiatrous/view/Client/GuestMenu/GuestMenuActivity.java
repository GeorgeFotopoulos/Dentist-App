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
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist.DentistSearchActivity;

import java.util.List;

public class GuestMenuActivity extends AppCompatActivity implements GuestMenuView {
    final int REQUEST_CODE_DENTIST_SEARCH = 1;
    private GuestMenuPresenter presenter;
    Spinner s, s1, s2;

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
        s = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Specializations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        List<Service> services = presenter.getServices();
        String Services[] = new String[services.size() + 1];
        Services[0] = "";
        for (int i = 1; i <= services.size(); i++) {
            Services[i] = services.get(i - 1).getServiceName();
        }
        s1 = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Services);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);

        findViewById(R.id.search_dentist_with_filters).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String region = ((EditText) findViewById(R.id.Region)).getText().toString();
                String specialization = s.getSelectedItem().toString();
                String service = s1.getSelectedItem().toString();
                presenter.searchbyfilters(region, specialization, service);
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

    public void showSearchViewFilters(String region, String specialization, String service) {
        Intent intent = new Intent(this, DentistSearchActivity.class);
        intent.putExtra("region", region);
        intent.putExtra("specialization", specialization);
        intent.putExtra("service", service);
        startActivityForResult(intent, 1);
    }
}