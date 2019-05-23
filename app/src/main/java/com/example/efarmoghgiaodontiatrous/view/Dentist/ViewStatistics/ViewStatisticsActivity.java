package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;

public class ViewStatisticsActivity extends AppCompatActivity implements ViewStatisticsView {

    protected ViewStatisticsPresenter presenter;
    private String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_statistics);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");

        presenter = new ViewStatisticsPresenter(this);

        TextView welcome = findViewById(R.id.welcome);
        welcome.setText(presenter.onWelcome(ID));

        TextView result = findViewById(R.id.result);
        result.setText(presenter.onStats(ID));

    }
}
