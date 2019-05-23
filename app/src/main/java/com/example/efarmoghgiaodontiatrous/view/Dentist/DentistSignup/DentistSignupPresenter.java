package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;

import java.util.List;

public class DentistSignupPresenter {

    protected DentistSignupView view;

    /**
     * Αρχικοποιεί τον Presenter.
     *
     * @param view Ένα instance του view
     */
    public DentistSignupPresenter(DentistSignupView view) {
        this.view = view;
    }

    public String[] getSpecializationList() {
        SpecializationDAOMemory sp = new SpecializationDAOMemory();
        String out[] = new String[sp.findAll().size()];
        List<Specialization> spec = sp.findAll();
        for (int i = 0; i < spec.size(); i++) {
            out[i] = spec.get(i).getSpecializationName();
        }
        return out;
    }

    public String[] getService() {
        ServiceDAOMemory sp = new ServiceDAOMemory();
        String out[] = new String[sp.findAll().size()];
        List<Service> spec = sp.findAll();
        for (int i = 0; i < spec.size(); i++) {
            out[i] = spec.get(i).getServiceName();
        }
        return out;
    }

    public void saveDentist(Dentist d) {
        DentistDAOMemory DAO = new DentistDAOMemory();
        DAO.save(d);
    }

    public String getDentistSize() {
        DentistDAOMemory DAO = new DentistDAOMemory();
        return (DAO.findAll().size() + "");
    }

    public void addSpecializations(List<String> tempSpecialization,Dentist dentist) {
        SpecializationDAOMemory DAO = new SpecializationDAOMemory();
        List<Specialization> temp = DAO.findAll();
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < tempSpecialization.size(); j++) {
                if (tempSpecialization.get(j).equals(temp.get(i).getSpecializationName())) {
                    dentist.addSpecialization(temp.get(i));
                    break;
                }
            }
        }
    }

    public void addServices(List<String> tempServices,Dentist dentist) {
        ServiceDAOMemory DAO = new ServiceDAOMemory();
        List<Service> temp = DAO.findAll();
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < tempServices.size(); j++) {
                if (tempServices.get(j).equals(temp.get(i).getServiceName())) {
                    dentist.addService(temp.get(i));
                    break;
                }
            }
        }
    }
}