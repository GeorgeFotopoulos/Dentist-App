package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivityPresenter presenter = new MainActivityPresenter(this);

        findViewById(R.id.Guest_Button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onGuestMenu();
            }
        });

        findViewById(R.id.Dentist_Button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onDentistMenu();
            }
        });
    }

    public void dentistMenu(){};

    public void guestMenu(){
        Intent intent = new Intent(MainActivity.this, GuestMenuActivity.class);
        startActivity(intent);
    };
}
