package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewSchedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;

public class ViewScheduleActivity extends AppCompatActivity implements ViewScheduleView {
    ViewSchedulePresenter presenter;
    private String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");

        presenter = new ViewSchedulePresenter(this);

        TextView welcome = findViewById(R.id.welcome);
        welcome.setText(presenter.onWelcome(ID));

        TextView appoint = findViewById(R.id.appoint);
        appoint.setText(presenter.onSchedule(ID));


    }
}
