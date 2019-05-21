package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

public class DentistUpdateAccountActivity extends AppCompatActivity implements DentistUpdateAccountView{

    private DentistUpdateAccountPresenter presenter;
    private Dentist dentist;
    private String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_update_account);
        presenter = new DentistUpdateAccountPresenter(this);


        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");
        dentist = presenter.onLoggedInDentist(ID);

        TextView fname = findViewById(R.id.input_fname);
        fname.setText(dentist.getFirstName());

        TextView lname = findViewById(R.id.input_lname);
        lname.setText(dentist.getLastName());

        TextView mail = findViewById(R.id.input_email);
        mail.setText(dentist.getEmail());

        TextView pass = findViewById(R.id.input_password);
        pass.setText(dentist.getPassword());

        TextView phone = findViewById(R.id.input_phone);
        phone.setText(dentist.getTelephoneNo());

        TextView uni = findViewById(R.id.input_uni);
        uni.setText(dentist.getUniversityAttended());

        TextView street = findViewById(R.id.input_street);
        street.setText(dentist.getInfirmaryLocation().getStreet());

        TextView strno = findViewById(R.id.input_num);
        strno.setText(dentist.getInfirmaryLocation().getNumber());

        TextView zip = findViewById(R.id.input_zip);
        zip.setText(dentist.getInfirmaryLocation().getZipCode()+"");

        TextView city = findViewById(R.id.input_city);
        city.setText(dentist.getInfirmaryLocation().getCity());

        TextView country = findViewById(R.id.input_country);
        country.setText(dentist.getInfirmaryLocation().getCountry());

        TextView years = findViewById(R.id.input_years);
        years.setText(dentist.getTimeOfExperience()+"");

        TextView license = findViewById(R.id.input_license);
        license.setText(dentist.getExerciseLicense());

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dentist.setFirstName(((EditText) findViewById(R.id.input_fname)).getText().toString());
                dentist.setLastName(((EditText) findViewById(R.id.input_lname)).getText().toString());
                dentist.setEmail(((EditText) findViewById(R.id.input_email)).getText().toString());
                dentist.setPassword(((EditText) findViewById(R.id.input_password)).getText().toString());
                dentist.setTelephoneNo(((EditText) findViewById(R.id.input_phone)).getText().toString());
                dentist.setUniversityAttended(((EditText) findViewById(R.id.input_uni)).getText().toString());
                dentist.getInfirmaryLocation().setStreet(((EditText) findViewById(R.id.input_street)).getText().toString());
                dentist.getInfirmaryLocation().setNumber(((EditText) findViewById(R.id.input_num)).getText().toString());
                dentist.getInfirmaryLocation().setZipCode(Integer.parseInt(((EditText) findViewById(R.id.input_zip)).getText().toString()));
                dentist.getInfirmaryLocation().setCity(((EditText) findViewById(R.id.input_city)).getText().toString());
                dentist.getInfirmaryLocation().setCountry(((EditText) findViewById(R.id.input_country)).getText().toString());
                dentist.setTimeOfExperience(Integer.parseInt(((EditText) findViewById(R.id.input_years)).getText().toString()));
                dentist.setExerciseLicense(((EditText) findViewById(R.id.input_license)).getText().toString());

                presenter.onUpdate(dentist);
                presenter.onDentistMenu();
            }
        });

    }

    public void dentistMenu(){
        Toast.makeText(getApplicationContext(), "Update Successful!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(DentistUpdateAccountActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User",ID);
        startActivity(intent);
    }



    @Override
    public Dentist loggedInDentist(String ID) {
        return null;
    }
}
