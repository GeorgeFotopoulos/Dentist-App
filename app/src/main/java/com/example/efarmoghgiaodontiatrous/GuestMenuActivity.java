package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GuestMenuActivity extends AppCompatActivity implements GuestMenuView{
    private GuestMenuPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       presenter= new GuestMenuPresenter(this);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_guest_menu);
        findViewById(R.id.search_dentist_by_name).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String lastname=((EditText) findViewById(R.id.lastname)).getText().toString();
                String firstname=((EditText) findViewById(R.id.firstname)).getText().toString();
                presenter.onSearchDentistByName(lastname,firstname);
            }
        });
    }

    public void searchDentistByName(String Lastname,String Firstname){
    };

}
