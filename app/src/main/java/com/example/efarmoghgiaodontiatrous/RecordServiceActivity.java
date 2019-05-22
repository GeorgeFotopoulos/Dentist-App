package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup.DentistSignupActivity;

import java.util.ArrayList;
import java.util.List;

public class RecordServiceActivity extends AppCompatActivity implements RecordServiceView {
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
        final List<String> tempServices = new ArrayList<>();
        presenter = new RecordServicePresenter(this);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");

        final ListView listViewWithCheckbox = findViewById(R.id.list_view_with_checkbox2);
        final List<ListViewItemDTO> initItemListServ = this.getInitViewItemDtoListServ();
        final ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListServ);
        listViewDataAdapter.notifyDataSetChanged();
        listViewWithCheckbox.setAdapter(listViewDataAdapter);

        listViewWithCheckbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                // Get user selected item.
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
                Client client = presenter.onSearchClient(AMKA);

                if(client == null){
                    TextView result = findViewById(R.id.search_res);
                    result.setText("There's no client with this number! \n Create a Client's Card!");
                    onShowForm();
                }else{
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

                if(onCheckValid()){
                    presenter.onCreate(new SimpleCalendar(year, month, day),fname, lname, phone, mail, amka, tempServices, ID, comments);
                    saved();
                }else{
                    notSaved();
                }

            }
        });

    }

    private void saved(){
        Intent intent = new Intent(RecordServiceActivity.this, DentistMenuActivity.class);
        Toast.makeText(getBaseContext(), "Record Successful!!", Toast.LENGTH_LONG).show();
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }

    private void notSaved(){
        Toast.makeText(getBaseContext(), "Record Failed, try again!", Toast.LENGTH_LONG).show();
        findViewById(R.id.btn_update).setEnabled(true);
    }
    private boolean onCheckValid(){
        comments = ((EditText) findViewById(R.id.in_com)).getText().toString();
        fname = ((EditText) findViewById(R.id.in_fname)).getText().toString();
        lname = ((EditText) findViewById(R.id.in_lname)).getText().toString();
        phone = ((EditText) findViewById(R.id.in_phone)).getText().toString();
        mail = ((EditText) findViewById(R.id.in_mail)).getText().toString();
        amka = ((EditText) findViewById(R.id.in_amka)).getText().toString();
        day = Integer.parseInt(((EditText) findViewById(R.id.in_day)).getText().toString());
        month = Integer.parseInt(((EditText) findViewById(R.id.in_month)).getText().toString());
        year = Integer.parseInt(((EditText) findViewById(R.id.in_year)).getText().toString());
        if(fname != "" && lname != "" && phone != "" && mail != "" && amka != "" && day != 0 && month != 0 && year != 0){
            return true;
        }
        Toast.makeText(getApplicationContext(), "Fill all the boxes! " , Toast.LENGTH_SHORT).show();
        return false;

    }

    private void onShowForm(){
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

    public void onFillForm(Client client){
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
    }

    private List<ListViewItemDTO> getInitViewItemDtoListServ() {
        String[] itemTextArr = presenter.getService();
        List<ListViewItemDTO> ret = new ArrayList<ListViewItemDTO>();
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
