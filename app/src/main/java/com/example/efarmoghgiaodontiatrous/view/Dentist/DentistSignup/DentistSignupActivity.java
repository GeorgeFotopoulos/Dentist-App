package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.ListViewItemCheckboxBaseAdapter;
import com.example.efarmoghgiaodontiatrous.ListViewItemDTO;
import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;
import com.example.efarmoghgiaodontiatrous.ui.login.DentistLoginActivity;
import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile.DentistViewProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class DentistSignupActivity extends AppCompatActivity implements DentistSignupView {
    private static final String TAG = "SignupActivity";
    List<String> tempSpecialization;
    List<String> tempServices;
    String ID;
    private DentistSignupPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        presenter = new DentistSignupPresenter(this);
        tempSpecialization = new ArrayList<>();
        tempServices = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_signup);

        final ListView listViewWithCheckbox = findViewById(R.id.list_view_with_checkbox);
        final ListView listViewWithCheckbox2 = findViewById(R.id.list_view_with_checkbox2);
        // Initiate listview data.
        final List<ListViewItemDTO> initItemListSpec = this.getInitViewItemDtoList();
        final List<ListViewItemDTO> initItemListServ = this.getInitViewItemDtoListServ();
        // Create a custom list view adapter with checkbox control.
        final ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListSpec);
        final ListViewItemCheckboxBaseAdapter listViewDataAdapter2 = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListServ);

        listViewDataAdapter.notifyDataSetChanged();
        listViewDataAdapter2.notifyDataSetChanged();

        // Set data adapter to list view.
        listViewWithCheckbox.setAdapter(listViewDataAdapter);
        listViewWithCheckbox2.setAdapter(listViewDataAdapter2);

        listViewWithCheckbox2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                // Get user selected item.
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);

                ListViewItemDTO itemDto = (ListViewItemDTO) itemObject;

                CheckBox itemCheckbox = view.findViewById(R.id.list_view_item_checkbox);

                if (itemDto.isChecked()) {
                    itemCheckbox.setChecked(false);
                    itemDto.setChecked(false);
                    tempServices.remove(itemDto.getItemText());
                } else {
                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                    if (!tempServices.contains(itemDto.getItemText())) {
                        tempServices.add(itemDto.getItemText());
                    }
                }
                //Toast.makeText(getApplicationContext(), "select item text : " + itemDto.getItemText(), Toast.LENGTH_SHORT).show();
            }
        });

        // When list view item is clicked.
        listViewWithCheckbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);

                ListViewItemDTO itemDto = (ListViewItemDTO) itemObject;

                CheckBox itemCheckbox = view.findViewById(R.id.list_view_item_checkbox);

                if (itemDto.isChecked()) {
                    itemCheckbox.setChecked(false);
                    itemDto.setChecked(false);
                    tempSpecialization.remove(itemDto.getItemText());
                } else {
                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                    if (!tempSpecialization.contains(itemDto.getItemText())) {
                        tempSpecialization.add(itemDto.getItemText());
                    }
                }
                //Toast.makeText(getApplicationContext(), "select item text : " + itemDto.getItemText(), Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(presenter.getDentistSize());
                signup();

            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        findViewById(R.id.btn_update).setEnabled(false);

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                    }
                }, 1000);
    }

    public void onSignupSuccess() {
        String firstName = ((EditText) findViewById(R.id.input_fname)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.input_lname)).getText().toString();
        String email = ((EditText) findViewById(R.id.input_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.input_password)).getText().toString();
        String phone = ((EditText) findViewById(R.id.input_phone)).getText().toString();
        String street = ((EditText) findViewById(R.id.input_street)).getText().toString();
        String strno = ((EditText) findViewById(R.id.input_num)).getText().toString();
        String city = ((EditText) findViewById(R.id.input_city)).getText().toString();
        int zip = Integer.parseInt(((EditText) findViewById(R.id.input_zip)).getText().toString());
        String country = ((EditText) findViewById(R.id.input_country)).getText().toString();
        String uni = ((EditText) findViewById(R.id.input_uni)).getText().toString();
        int years = Integer.parseInt(((EditText) findViewById(R.id.input_years)).getText().toString());
        String license = ((EditText) findViewById(R.id.input_license)).getText().toString();

        findViewById(R.id.btn_update).setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
        Dentist d = new Dentist(firstName, lastName, phone, email, license, uni, new Address(street, strno, city, country, zip), years, password);
        presenter.addSpecializations(tempSpecialization,d);
        presenter.addServices(tempServices,d);
        presenter.saveDentist(d);
        Toast.makeText(getBaseContext(), "Sign Up Successful!", Toast.LENGTH_LONG).show();
        dentistMenu();
    }

    public void save(String ID) {
        this.ID = ID;
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Sign Up Failed, try again!", Toast.LENGTH_LONG).show();
        findViewById(R.id.btn_update).setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = ((EditText) findViewById(R.id.input_fname)).getText().toString();
        String email = ((EditText) findViewById(R.id.input_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.input_password)).getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            ((EditText) findViewById(R.id.input_fname)).setError("at least 3 characters");
            valid = false;
        } else {
            ((EditText) findViewById(R.id.input_fname)).setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ((EditText) findViewById(R.id.input_email)).setError("enter a valid email address");
            valid = false;
        } else {
            ((EditText) findViewById(R.id.input_email)).setError(null);
        }

        if (password.isEmpty() || password.length() < 8) {
            ((EditText) findViewById(R.id.input_password)).setError("At least 8 characters");
            valid = false;
        } else {
            ((EditText) findViewById(R.id.input_password)).setError(null);
        }
        return valid;
    }

    private List<ListViewItemDTO> getInitViewItemDtoList() {
        String[] itemTextArr = presenter.getSpecializationList();
        List<ListViewItemDTO> ret = new ArrayList<ListViewItemDTO>();
        int length = itemTextArr.length;

        for (int i = 0; i < length; i++) {
            String itemText = itemTextArr[i];

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(false);
            dto.setItemText(itemText);

            ret.add(dto);
        }
        return ret;
    }

    private List<ListViewItemDTO> getInitViewItemDtoListServ() {
        String[] itemTextArr = presenter.getService();
        List<ListViewItemDTO> ret = new ArrayList<ListViewItemDTO>();
        int length = itemTextArr.length;

        for (int i = 0; i < length; i++) {
            String itemText = itemTextArr[i];

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(false);
            dto.setItemText(itemText);

            ret.add(dto);
        }
        return ret;
    }

    @Override
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DentistSignupActivity.this, DentistLoginActivity.class);
        startActivity(intent);
    }

    public void dentistMenu() {
        finish();
        Intent intent = new Intent(DentistSignupActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }
}