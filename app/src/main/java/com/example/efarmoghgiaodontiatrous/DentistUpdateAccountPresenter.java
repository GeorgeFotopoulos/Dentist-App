package com.example.efarmoghgiaodontiatrous;


import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

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

}
