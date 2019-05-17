package com.example.efarmoghgiaodontiatrous;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

public class DentistSearchActivity extends AppCompatActivity implements ItemSelectionListener<Dentist>, DentistSearchView {
    RecyclerView recyclerView;
    private DentistAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DentistSearchPresenter bookSearchPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_search);
    }

    @Override
    public void onItemSelected(Dentist item) {

    }
}
