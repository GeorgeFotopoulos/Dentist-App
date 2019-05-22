package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DentistAppointmentManagementActivity extends AppCompatActivity implements DentistAppointmentManagementView {

    List<String> SelectedAppointments;
    private DentistAppointmentManagementPresenter presenter;
    String Dentist_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SelectedAppointments = new ArrayList<>();
        presenter= new DentistAppointmentManagementPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_appointment_management);
        Intent intent = getIntent();
        Dentist_ID = intent.getStringExtra("Logged-In User");
        final ListView listViewWithCheckbox = findViewById(R.id.list_view_with_checkbox);
        // Initiate listview data.
        final List<ListViewItemDTO> initItemListSpec = this.getInitViewItemDtoList();
        // Create a custom list view adapter with checkbox control.
        final ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListSpec);

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


    }

    private List<ListViewItemDTO> getInitViewItemDtoList() {
        String[] itemTextArr = presenter.getAppointments(Dentist_ID);
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
