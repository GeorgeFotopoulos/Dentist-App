package com.example.efarmoghgiaodontiatrous.view.AndroidUtil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.List;

public class DentistAdapter extends RecyclerView.Adapter<DentistAdapter.ViewHolder> {
    private List<Dentist> itemList;

    private ItemSelectionListener<Dentist> dentSelectionListener;

    public DentistAdapter(List<Dentist> myDataset) {
        itemList = myDataset;
    }

    /**
     * Set a listener to be notified of book selection (click on the TextView)
     *
     * @param dentSelectionListener
     */
    public void setDentistSelectionListener(ItemSelectionListener<Dentist> dentSelectionListener) {
        this.dentSelectionListener = dentSelectionListener;
    }

    @Override
    public DentistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_dentist_result, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Dentist dentAtPosition = itemList.get(position);

        holder.txtDentist.setText("Name: " + dentAtPosition.getLastName() + " " + dentAtPosition.getFirstName() + "\nLocation: " + dentAtPosition.getInfirmaryLocation().print() + "\nEmail: " + dentAtPosition.getEmail() + " \nContact Number: " + dentAtPosition.getTelephoneNo() + "\nProviding Services: " + dentAtPosition.printServices() + "\nSpecializations: " + dentAtPosition.printSpecializations());
        holder.btnSelectDentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dentSelectionListener != null) {
                    dentSelectionListener.onItemSelected(dentAtPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewGroup listItem;
        public TextView txtDentist;
        public Button btnSelectDentist;

        public ViewHolder(ViewGroup v) {
            super(v);
            listItem = v;
            txtDentist = listItem.findViewById(R.id.txt_dentist_info);
            btnSelectDentist = listItem.findViewById(R.id.btn_select_dentist);
        }
    }
}