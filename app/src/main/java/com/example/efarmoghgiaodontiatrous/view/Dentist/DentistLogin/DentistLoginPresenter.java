package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistLogin;


import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

public class DentistLoginPresenter {
    private DentistLoginView view;

    public DentistLoginPresenter(DentistLoginView view) {
        this.view = view;
    }

    public Dentist onValid(String email, String password) {
        DentistDAOMemory ddao = new DentistDAOMemory();

        if(ddao.findByEmail(email) != null){
            if(password.equals(ddao.findByEmail(email).getPassword())){
                return ddao.findByEmail(email);
            }
        }
        return null;

    }

    public String onResult(String email){
        DentistDAOMemory ddao = new DentistDAOMemory();

        if(ddao.findByEmail(email) == null){
            return "This Account doesn't exist!";
        }
        return "Wrong Password.Try Again!";
    }
}
