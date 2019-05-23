package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.ListViewItemCheckboxBaseAdapter;
import com.example.efarmoghgiaodontiatrous.ListViewItemDTO;
import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class DentistAppointmentManagementActivity extends AppCompatActivity implements DentistAppointmentManagementView {
    String[] itemTextArr;
    List<String> SelectedAppointments;
    private DentistAppointmentManagementPresenter presenter;
    String Dentist_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SelectedAppointments = new ArrayList<>();
        presenter = new DentistAppointmentManagementPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_appointment_management);
        Intent intent = getIntent();
        Dentist_ID = intent.getStringExtra("ID");
        final ListView listViewWithCheckbox = findViewById(R.id.list_view_with_checkbox);
        // Initiate listview data.
        final List<ListViewItemDTO> initItemListSpec = this.getInitViewItemDtoList();
        // Create a custom list view adapter with checkbox control.
        ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListSpec);

        listViewDataAdapter.notifyDataSetChanged();
        // Set data adapter to list view.
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
                    SelectedAppointments.remove(itemDto.getItemText());
                } else {
                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                    if (!SelectedAppointments.contains(itemDto.getItemText())) {
                        SelectedAppointments.add(itemDto.getItemText());
                    }
                }
                //Toast.makeText(getApplicationContext(), "select item text : " + itemDto.getItemText(), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.accept_apointment).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SelectedAppointments.size() > 0) {
                    presenter.AcceptAppointments(Dentist_ID, SelectedAppointments);
                    itemTextArr = presenter.getAppointments(Dentist_ID, AppointmentState.PENDING);
                    finish();
                    Intent intent = new Intent(DentistAppointmentManagementActivity.this, DentistAppointmentManagementActivity.class);
                    intent.putExtra("ID",Dentist_ID);
                    startActivity(intent);
                    // listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListSpec);
                }
            }
        });
        findViewById(R.id.decline_appointment).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SelectedAppointments.size() > 0) {
                    presenter.DeclineAppointments(Dentist_ID, SelectedAppointments);
                    itemTextArr = presenter.getAppointments(Dentist_ID, AppointmentState.PENDING);
                    finish();
                    Intent intent = new Intent(DentistAppointmentManagementActivity.this, DentistAppointmentManagementActivity.class);
                    intent.putExtra("ID",Dentist_ID);
                    startActivity(intent);

                }
                // listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListSpec);
            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(DentistAppointmentManagementActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User",Dentist_ID);
        startActivity(intent);
    }

    public void jobDone(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private List<ListViewItemDTO> getInitViewItemDtoList() {
        itemTextArr = presenter.getAppointments(Dentist_ID, AppointmentState.PENDING);
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
