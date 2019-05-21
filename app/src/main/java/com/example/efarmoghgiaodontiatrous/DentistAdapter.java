package com.example.efarmoghgiaodontiatrous;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.List;

public class DentistAdapter extends RecyclerView.Adapter<DentistAdapter.ViewHolder> {
    private List<Dentist> itemList;

    private ItemSelectionListener<Dentist> dentSelectionListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
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
        // create a new view for the list
        ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_dentist_result, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // - get element from your dataset at this position
        final Dentist dentAtPosition = itemList.get(position);

        // - replace the contents of the view with data from the dataset item at this position
        holder.txtDentist.setText(dentAtPosition.getLastName() + " " + dentAtPosition.getFirstName() + "\n" + dentAtPosition.getInfirmaryLocation().print() + "\nEmail: " + dentAtPosition.getEmail() + " \nTel. " + dentAtPosition.getTelephoneNo() + "\nSpecializations: " + dentAtPosition.printSpecializations() + "\nProviding Services: " + dentAtPosition.printServices());
        holder.btnSelectDentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // notify the Activity of the selected book
                if (dentSelectionListener != null) {
                    dentSelectionListener.onItemSelected(dentAtPosition);
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
