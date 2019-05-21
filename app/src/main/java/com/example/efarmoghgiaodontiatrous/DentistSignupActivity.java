package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.Address;

import static java.lang.Integer.parseInt;

public class DentistSignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_signup);

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


        // TODO: Implement your own signup logic here.

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                    }
                }, 3000);
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

        DentistDAOMemory dentist = new DentistDAOMemory();

        findViewById(R.id.btn_update).setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
        Dentist d = new Dentist(firstName, lastName, phone, email, license, uni, new Address(street, strno, city, country, zip), years, password);
        dentist.save(d);

        Toast.makeText(getBaseContext(), "Sign Up Successful!!", Toast.LENGTH_LONG).show();
        dentistMenu(d.getID());
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


    public void dentistMenu(String ID) {
        Intent intent = new Intent(DentistSignupActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }
}