package com.example.efarmoghgiaodontiatrous;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GuestMenuActivity extends AppCompatActivity implements GuestMenuView{
    private GuestMenuPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       presenter= new GuestMenuPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_menu);
        findViewById(R.id.search_dentist_by_name).setOnClickListener(new View.OnClickListener() {
            String lastname=findViewById(R.id.lastname).toString();
            String firstname=findViewById(R.id.firstname).toString();
            public void onClick(View v) {
                presenter.onSearchDentistByName(lastname,firstname);
            }
        });
    }

    public void searchDentistByName(String Lastname,String Firstname){
    };

}
