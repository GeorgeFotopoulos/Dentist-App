package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

public class DentistViewProfilePresenter {

    private DentistViewProfileView view;

    public DentistViewProfilePresenter(DentistViewProfileView view) {
        this.view = view;
    }

    public void onUpdateAccount(){
        view.updateAccount();
    }

    public String onShowProfile(String ID){

        DentistDAOMemory dentist = new DentistDAOMemory();

        Dentist d = dentist.find(ID);

        return "ID: #"+ID+" \n"+ " \n Name: "+d.getLastName()+" "+d.getFirstName()+" \n"+" \n E-mail: "+d.getEmail()+" \n"+" \n License Number: "+d.getExerciseLicense()+" \n"+" \n Address: "+ d.getInfirmaryLocation().print() +" \n"+" \n Phone: "+d.getTelephoneNo()+" \n"+" \n University: "+d.getUniversityAttended()+" \n"+" \n Services: "+d.printServices()+" \n"+" \n Specializations: "+d.printSpecializations()+" \n"+" \n"+"Years of Experience: "+d.getTimeOfExperience();
    }
}
