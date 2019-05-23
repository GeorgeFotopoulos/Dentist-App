package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewHistory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;

public class DentistViewHistoryActivity extends AppCompatActivity implements DentistViewHistoryView {
    protected DentistViewHistoryPresenter presenter;
    protected String ID;
    private String AMKA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        presenter = new DentistViewHistoryPresenter(this);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView history = findViewById(R.id.history_info);
                AMKA = ((EditText) findViewById(R.id.input_amka)).getText().toString();
                history.setText(presenter.onHistoryBack(AMKA));
            }
        });
    }

    @Override
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DentistViewHistoryActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }
}