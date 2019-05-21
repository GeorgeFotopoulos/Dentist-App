package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.ui.login.DentistLoginActivity;

public class DentistViewProfileActivity extends AppCompatActivity implements DentistViewProfileView {

    private DentistViewProfilePresenter presenter;
    private String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_view_profile);

        presenter = new DentistViewProfilePresenter(this);

        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");
        TextView profile = findViewById(R.id.dentist_info);

        profile.setText(presenter.onShowProfile(ID));

        findViewById(R.id.btn_update_account).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onUpdateAccount();
            }
        });
    }


    @Override
    public String showProfile(String ID) {
        return null;
    }

    public void updateAccount(){
        Intent intent = new Intent(DentistViewProfileActivity.this, DentistUpdateAccountActivity.class);
        intent.putExtra("ID",ID);
        startActivity(intent);
    }
}
