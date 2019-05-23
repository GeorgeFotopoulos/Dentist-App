package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement.DentistAppointmentManagementActivity;
import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.view.Dentist.RecordService.RecordServiceActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.ViewSchedule.ViewScheduleActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics.ViewStatisticsActivity;
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
        finish();
        Intent intent = new Intent(DentistMenuActivity.this, DentistViewProfileActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void updateAccount(){
        finish();
        Intent intent = new Intent(DentistMenuActivity.this, DentistUpdateAccountActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void viewClientHistory(){
        finish();
        Intent intent = new Intent(DentistMenuActivity.this, DentistViewHistoryActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void appointmentManagement(){
        finish();
        Intent intent = new Intent(DentistMenuActivity.this, DentistAppointmentManagementActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void viewStatistics(){
        finish();
        Intent intent = new Intent(DentistMenuActivity.this, ViewStatisticsActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void viewAppointmentSchedule(){
        finish();
        Intent intent = new Intent(DentistMenuActivity.this, ViewScheduleActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

    public void recordProvidedService(){
        finish();
        Intent intent = new Intent(DentistMenuActivity.this, RecordServiceActivity.class);
        intent.putExtra("ID",Dentist_ID);
        startActivity(intent);
    }

}
