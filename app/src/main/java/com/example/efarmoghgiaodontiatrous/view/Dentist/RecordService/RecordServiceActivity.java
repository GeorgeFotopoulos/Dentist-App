package com.example.efarmoghgiaodontiatrous.view.Dentist.RecordService;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.ListViewItemCheckboxBaseAdapter;
import com.example.efarmoghgiaodontiatrous.ListViewItemDTO;
import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class RecordServiceActivity extends AppCompatActivity implements RecordServiceView {
    private final List<String> tempServices = new ArrayList<>();
    protected RecordServicePresenter presenter;
    protected String ID;
    private String AMKA;
    private Client client;
    private String fname;
    private String lname;
    private String phone;
    private String mail;
    private String amka;
    private String comments;
    private int day;
    private int month;
    private int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_service);
        presenter = new RecordServicePresenter(this);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");

        final ListView listViewWithCheckbox = findViewById(R.id.list_view_with_checkbox2);
        final List<ListViewItemDTO> initItemListServ = this.getInitViewItemDtoListServ();
        ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListServ);

        listViewDataAdapter.notifyDataSetChanged();
        listViewWithCheckbox.setAdapter(listViewDataAdapter);

        listViewWithCheckbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);

                ListViewItemDTO itemDto = (ListViewItemDTO) itemObject;

                CheckBox itemCheckbox = view.findViewById(R.id.list_view_item_checkbox);

                if (itemDto.isChecked()) {
                    itemCheckbox.setChecked(false);
                    itemDto.setChecked(false);
                    tempServices.remove(itemDto.getItemText());
                } else {
                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                    if (!tempServices.contains(itemDto.getItemText())) {
                        tempServices.add(itemDto.getItemText());
                    }
                }
            }
        });

        findViewById(R.id.btn_search_client).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AMKA = ((EditText) findViewById(R.id.amka)).getText().toString();
                client = presenter.onSearchClient(AMKA);

                if (client == null) {
                    TextView result = findViewById(R.id.search_res);
                    result.setText("There's no client with this number! \n Create a Client's Card!");
                    onFillForm(client);
                    onShowForm();
                } else {
                    TextView result = findViewById(R.id.search_res);
                    result.setText("Client Found!");
                    onFillForm(client);
                    onShowForm();
                }


            }
        });

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSave();
            }
        });
    }

    public void toSave() {
        if (!onCheckValid()) {
            notSaved();
            return;
        }
        findViewById(R.id.btn_save).setEnabled(false);
        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        presenter.onCreate(new SimpleCalendar(year, month, day), fname, lname, phone, mail, amka, tempServices, ID, comments);
                        saved();
                    }
                }, 1000);
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(RecordServiceActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }

    private void saved() {
        finish();
        Intent intent = new Intent(RecordServiceActivity.this, DentistMenuActivity.class);
        Toast.makeText(getBaseContext(), "Record Successful!", Toast.LENGTH_LONG).show();
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }

    private void notSaved() {
        findViewById(R.id.btn_save).setEnabled(true);
    }

    private boolean onCheckValid() {
        comments = ((EditText) findViewById(R.id.in_com)).getText().toString();
        fname = ((EditText) findViewById(R.id.in_fname)).getText().toString();
        lname = ((EditText) findViewById(R.id.in_lname)).getText().toString();
        phone = ((EditText) findViewById(R.id.in_phone)).getText().toString();
        mail = ((EditText) findViewById(R.id.in_mail)).getText().toString();
        amka = ((EditText) findViewById(R.id.in_amka)).getText().toString();
        try {
            day = Integer.parseInt(((EditText) findViewById(R.id.in_day)).getText().toString());
        } catch (NumberFormatException e) {
            day = -1;
        }
        try {
            month = Integer.parseInt(((EditText) findViewById(R.id.in_month)).getText().toString());
        } catch (NumberFormatException e) {
            month = -1;
        }
        try {
            year = Integer.parseInt(((EditText) findViewById(R.id.in_year)).getText().toString());
        } catch (NumberFormatException e) {
            year = -1;
        }
        if (fname.equals("") && (!lname.equals("") && !phone.equals("") && !mail.equals("") && !amka.equals("") && day != -1 && month != -1 && year != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The First Name field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (lname.equals("") && (!fname.equals("") && !phone.equals("") && !mail.equals("") && !amka.equals("") && day != -1 && month != -1 && year != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The Last Name field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (phone.equals("") && (!lname.equals("") && !fname.equals("") && !mail.equals("") && !amka.equals("") && day != -1 && month != -1 && year != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The Contact Number field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mail.equals("") && (!lname.equals("") && !fname.equals("") && !phone.equals("") && !amka.equals("") && day != -1 && month != -1 && year != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The E-mail field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (amka.equals("") && (!lname.equals("") && !fname.equals("") && !phone.equals("") && !mail.equals("") && day != -1 && month != -1 && year != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The AMKA field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (day == -1 && (!lname.equals("") && !fname.equals("") && !phone.equals("") && !mail.equals("") && !amka.equals("") && month != -1 && year != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The Day field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (month == -1 && (!lname.equals("") && !fname.equals("") && !phone.equals("") && !mail.equals("") && !amka.equals("") && day != -1 && year != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The Month field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (year == -1 && (!lname.equals("") && !fname.equals("") && !phone.equals("") && !mail.equals("") && !amka.equals("") && day != -1 && month != -1 && !tempServices.isEmpty())) {
            Toast.makeText(getApplicationContext(), "The Year field is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (tempServices.isEmpty() && (!lname.equals("") && !fname.equals("") && !phone.equals("") && !mail.equals("") && !amka.equals("") && day != -1 && month != -1 && year != -1)) {
            Toast.makeText(getApplicationContext(), "Selecting Provided Service(s) is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (fname.equals("") || lname.equals("") || phone.equals("") || mail.equals("") || amka.equals("") || day == -1 || month == -1 || year == -1 || tempServices.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill in all the data!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void onShowForm() {
        findViewById(R.id.in_com).setVisibility(View.VISIBLE);
        findViewById(R.id.search_res).setVisibility(View.VISIBLE);
        findViewById(R.id.textView19).setVisibility(View.VISIBLE);
        findViewById(R.id.textView20).setVisibility(View.VISIBLE);
        findViewById(R.id.textView23).setVisibility(View.VISIBLE);
        findViewById(R.id.textView21).setVisibility(View.VISIBLE);
        findViewById(R.id.textView27).setVisibility(View.VISIBLE);
        findViewById(R.id.textView29).setVisibility(View.VISIBLE);
        findViewById(R.id.textView30).setVisibility(View.VISIBLE);
        findViewById(R.id.textView31).setVisibility(View.VISIBLE);
        findViewById(R.id.in_fname).setVisibility(View.VISIBLE);
        findViewById(R.id.in_lname).setVisibility(View.VISIBLE);
        findViewById(R.id.in_phone).setVisibility(View.VISIBLE);
        findViewById(R.id.in_mail).setVisibility(View.VISIBLE);
        findViewById(R.id.in_amka).setVisibility(View.VISIBLE);
        findViewById(R.id.in_day).setVisibility(View.VISIBLE);
        findViewById(R.id.in_month).setVisibility(View.VISIBLE);
        findViewById(R.id.in_year).setVisibility(View.VISIBLE);
        TextView amka = findViewById(R.id.in_amka);
        amka.setText(AMKA);
        findViewById(R.id.in_fname).setVisibility(View.VISIBLE);
        findViewById(R.id.list_view_with_checkbox2).setVisibility(View.VISIBLE);
        findViewById(R.id.textView16).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_save).setVisibility(View.VISIBLE);
    }

    public void onFillForm(Client client) {
        if (client != null) {
            TextView fname = findViewById(R.id.in_fname);
            fname.setText(client.getFirstName());
            fname.setKeyListener(null);

            TextView lname = findViewById(R.id.in_lname);
            lname.setText(client.getLastName());
            lname.setKeyListener(null);

            TextView phone = findViewById(R.id.in_phone);
            phone.setText(client.getTelephoneNo());
            phone.setKeyListener(null);

            TextView mail = findViewById(R.id.in_mail);
            mail.setText(client.getEmail());
            mail.setKeyListener(null);
        } else {
            TextView fname = findViewById(R.id.in_fname);
            fname.setText("");

            TextView lname = findViewById(R.id.in_lname);
            lname.setText("");

            TextView phone = findViewById(R.id.in_phone);
            phone.setText("");

            TextView mail = findViewById(R.id.in_mail);
            mail.setText("");
        }

        TextView day = findViewById(R.id.in_day);
        day.setText("");

        TextView month = findViewById(R.id.in_month);
        month.setText("");

        TextView year = findViewById(R.id.in_year);
        year.setText("");

        TextView comments = findViewById(R.id.in_com);
        comments.setText("");

        TextView amka = findViewById(R.id.in_amka);
        amka.setText(AMKA);
        amka.setKeyListener(null);
    }

    private List<ListViewItemDTO> getInitViewItemDtoListServ() {
        String[] itemTextArr = presenter.getService();
        List<ListViewItemDTO> ret = new ArrayList<>();
        int length = itemTextArr.length;

        for (int i = 0; i < length; i++) {
            String itemText = itemTextArr[i];

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(false);
            dto.setItemText(itemText);

            ret.add(dto);
        }
        return ret;
    }
}