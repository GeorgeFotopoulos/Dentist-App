package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

public class RequestAppointmentPresenter {
    RequestAppointmentView view;

    public RequestAppointmentPresenter(RequestAppointmentView view) {
        this.view = view;
    }

    Dentist updateDentInfoText(String ID){
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();
        Dentist D = dDAOMemory.find(ID);
        return D;
    }

    public void reqAppointment(Dentist D, SimpleCalendar calendar, String Time,String Tel,String Lastname,String Firstname){
        if(D==null){
            view.showError("An error occured try again Later");
            return;
        }
        else if(calendar==null){
            view.showError("You have to select a day at the calendar !");
            return;
        }
        else if(Time==null||Time.equals("")){
            view.showError("You have to select a time");
            return;
        }
        else if(Tel.equals("")){
            view.showError("You have to give a valid Number,in which the doctor will contact you to approve your appointment");
            return;
        }
        else if(Lastname.equals("")){
            view.showError("You have to give a Last Name ");
            return;
        }

        try{
            String hour=new StringBuilder().append(Time.charAt(0)).append(Time.charAt(1)).toString();
            if(Time.charAt(0)=='0'&& Time.charAt(1)!='9' ) {
                view.showError("Wrong Time format. Should be of format \"hh:00\" or \"hh:30\" ");
                return;
            }
            int Apphour=Integer.parseInt(hour);
            if(Apphour>21 ){
                view.showError("Wrong Time format. Should be of format \"hh:00\" or \"hh:30\" ");
                return;
            }
            int appMinutes=Integer.parseInt(new StringBuilder().append(Time.charAt(3)).append(Time.charAt(4)).toString());
            if(appMinutes!=00&&appMinutes!=30){
                view.showError("Wrong Time format. Should be of format \"hh:00\" or \"hh:30\" ");
                return;
            }
            AppointmentDAOMemory DAO = new AppointmentDAOMemory();
            DAO.save(new Appointment(Firstname,Lastname,Tel,D,calendar,Apphour,appMinutes));
            view.success("Appointment request Submitted");

        }
        catch(Exception e){
            view.showError("Wrong Time format. Should be in format \"hh:00\" or \"hh:30\" ");
            return;
        }
    }
}
