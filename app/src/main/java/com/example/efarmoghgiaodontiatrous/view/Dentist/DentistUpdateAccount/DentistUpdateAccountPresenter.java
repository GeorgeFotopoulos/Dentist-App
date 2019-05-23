package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount;


import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;

import java.util.List;

public class DentistUpdateAccountPresenter {


    private DentistUpdateAccountView view;

    public DentistUpdateAccountPresenter(DentistUpdateAccountView view) {
        this.view = view;
    }

    public void onDentistMenu(){
        view.dentistMenu();
    }

    public void onUpdate(Dentist newAccount){
        DentistDAOMemory dao = new DentistDAOMemory();
        Dentist oldAccount = dao.find(newAccount.getID());
        dao.delete(oldAccount);
        dao.save(newAccount);
    }

    public Dentist onLoggedInDentist(String ID){
        DentistDAOMemory d = new DentistDAOMemory();
        return d.find(ID);
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
