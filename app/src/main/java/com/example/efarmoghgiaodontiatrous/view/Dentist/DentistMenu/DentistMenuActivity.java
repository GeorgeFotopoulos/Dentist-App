package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.efarmoghgiaodontiatrous.DentistAppointmentManagementActivity;
import com.example.efarmoghgiaodontiatrous.DentistAppointmentManagementPresenter;
import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.ui.login.DentistLoginActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount.DentistUpdateAccountActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewHistory.DentistViewHistoryActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile.DentistViewProfileActivity;

public class DentistMenuActivity extends AppCompatActivity implements DentistMenuView {
    private DentistMenuPresenter presenter;
    private String Dentist_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presenter = new DentistMenuPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_menu);
        Intent intent = getIntent();
        Dentist_ID = intent.getStringExtra("Logged-In User");

        findViewById(R.id.btn_view_profile).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onViewProfile();
            }
        });

        findViewById(R.id.btn_update_account).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onUpdateAccount();
            }
        });

        findViewById(R.id.btn_view_client_history).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onViewClientHistory();
            }
        });

        findViewById(R.id.btn_appointment_management).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onAppointmentManagement();
            }
        });

        findViewById(R.id.btn_view_statistics).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onViewStatistics();
            }
        });

        findViewById(R.id.btn_view_appointment_schedule).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onViewAppointmentSchedule();
            }
        });

        findViewById(R.id.btn_record_provided_service).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onRecordProvidedService();
            }
        });


    }

    public void viewProfile(){
        Intent intent = new Intent(DentistMenuActivity.this, DentistViewProfileActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void updateAccount(){
        Intent intent = new Intent(DentistMenuActivity.this, DentistUpdateAccountActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void viewClientHistory(){
        Intent intent = new Intent(DentistMenuActivity.this, DentistViewHistoryActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void appointmentManagement(){
        Intent intent = new Intent(DentistMenuActivity.this, DentistAppointmentManagementActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void viewStatistics(){
        Intent intent = new Intent(DentistMenuActivity.this, DentistLoginActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void viewAppointmentSchedule(){
        Intent intent = new Intent(DentistMenuActivity.this, DentistLoginActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void recordProvidedService(){
        Intent intent = new Intent(DentistMenuActivity.this, DentistLoginActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

}
