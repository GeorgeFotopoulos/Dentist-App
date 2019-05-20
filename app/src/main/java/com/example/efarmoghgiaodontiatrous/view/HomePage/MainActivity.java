package com.example.efarmoghgiaodontiatrous.view.HomePage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.efarmoghgiaodontiatrous.DentistMenuActivity;
import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.ui.login.DentistLoginActivity;
import com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu.GuestMenuActivity;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
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

        findViewById(R.id.TEST_BUTTON).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onTestMenu();
            }
        });
    }

    public void dentistMenu() {
        Intent intent = new Intent(MainActivity.this, DentistLoginActivity.class);
        startActivity(intent);
    }

    public void guestMenu() {
        Intent intent = new Intent(MainActivity.this, GuestMenuActivity.class);
        startActivity(intent);
    }

    public void testMenu() {
        Intent intent = new Intent(MainActivity.this, DentistMenuActivity.class);
        startActivity(intent);
    }
}
