package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewHistoryActivity extends AppCompatActivity implements ViewHistoryView{
    private ViewHistoryPresenter presenter;
    private String ID ;
    public String AMKA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        presenter = new ViewHistoryPresenter(this);
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
}
