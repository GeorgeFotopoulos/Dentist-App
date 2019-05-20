package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

public class RequestAppointmentActivity extends AppCompatActivity implements RequestAppointmentView {
    SimpleCalendar dateOfAppointment = null;
    RequestAppointmentPresenter Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Presenter = new RequestAppointmentPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_appointment);
        Intent intent = getIntent();

        CalendarView calender = (CalendarView) findViewById(R.id.DateOfAppointment);
        // extract search criteria from intent
        String DentistID = intent.getStringExtra("DentistID");
        final Dentist D = Presenter.updateDentInfoText(DentistID);
        System.out.println(D.getLastName());
        TextView DentInfo = (TextView) findViewById(R.id.dentistInfo);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                dateOfAppointment = new SimpleCalendar(year, month, dayOfMonth);
            }
        });
        DentInfo.setText(D.getLastName() + " " + D.getFirstName() + "\n" + D.getInfirmaryLocation().getCity() + " " + D.getInfirmaryLocation().getStreet() + " " + D.getInfirmaryLocation().getNumber() + "\nEmail." + D.getEmail());
        findViewById(R.id.submitAppointmentRequest).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SimpleCalendar AppDate = dateOfAppointment;
                String Time = ((EditText) findViewById(R.id.AppointmentTime)).getText().toString();
                String Lastname = ((EditText) findViewById(R.id.lastname)).getText().toString();
                String Firstname = ((EditText) findViewById(R.id.firstname)).getText().toString();
                String Tel = ((EditText) findViewById(R.id.ContactNum)).getText().toString();
                Presenter.reqAppointment(D, AppDate, Time, Tel, Lastname, Firstname);
            }
        });
    }

    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }

    public void success(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
