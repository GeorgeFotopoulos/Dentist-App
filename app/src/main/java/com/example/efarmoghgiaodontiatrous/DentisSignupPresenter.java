package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;

import java.util.List;

public class DentisSignupPresenter {

    private DentistSignupView view;

    /**
     * Αρχικοποιεί τον Presenter.
     *
     * @param view Ένα instance του view
     */
    public DentisSignupPresenter(DentistSignupView view) {
        this.view = view;
    }
    String[] getSpecializationList(){
        SpecializationDAOMemory sp=new SpecializationDAOMemory();
        String out[]=new String[sp.findAll().size()];
        List<Specialization>spec=sp.findAll();
        for(int i=0; i<spec.size();i++){
            out[i]=spec.get(i).getSpecializationName();
        }
        return out;
    }

    public String[] getService() {
        ServiceDAOMemory sp=new ServiceDAOMemory();
        String out[]=new String[sp.findAll().size()];
        List<Service>spec=sp.findAll();
        for(int i=0; i<spec.size();i++){
            out[i]=spec.get(i).getServiceName();
        }
        return out;
    }
}
