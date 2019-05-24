package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistLogin;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

public class DentistLoginPresenter {
    protected DentistLoginView view;

    public DentistLoginPresenter(DentistLoginView view) {
        this.view = view;
    }

    public Dentist onValid(String email, String password) {
        DentistDAOMemory dentistDao = new DentistDAOMemory();
        if (dentistDao.findByEmail(email) != null) {
            if (password.equals(dentistDao.findByEmail(email).getPassword())) {
                return dentistDao.findByEmail(email);
            }
        }
        return null;
    }

    public String onResult(String email) {
        DentistDAOMemory dentistDao = new DentistDAOMemory();
        if (dentistDao.findByEmail(email) == null) {
            return "Invalid input on the E-mail field!";
        }
        return "Invalid input on the Password field!";
    }
}