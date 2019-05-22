package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.List;

public class DentistAppointmentManagementPresenter {

    private final DentistAppointmentManagementView view;

    DentistAppointmentManagementPresenter(DentistAppointmentManagementView view){
        this.view=view;
    }

    public String[] getAppointments(String ID, AppointmentState State) {
        AppointmentDAOMemory aDAO=new AppointmentDAOMemory();
        DentistDAOMemory dDAO=new DentistDAOMemory();
        Dentist tempDent=dDAO.find(ID);

        return aDAO.findtoString(tempDent,State);
    }

    public void AcceptAppointments(String ID,List<String> selectedAppointments) {
        DentistDAOMemory dDAO=new DentistDAOMemory();
        Dentist tempDent=dDAO.find(ID);
        AppointmentDAOMemory aDAO=new AppointmentDAOMemory();
        List<Appointment> allapp=aDAO.findAll();

        for(int i=0;i<selectedAppointments.size();i++){
            String [] dateParts = selectedAppointments.get(i).split("/");
            String day = dateParts[0];
            String month = dateParts[1];
            String year = dateParts[2];
            int simpleday=Integer.parseInt(day);
            int simplemonth=Integer.parseInt(month);
            int simpleyear = Integer.parseInt(dateParts[2].charAt(0)+""+dateParts[2].charAt(1)+""+dateParts[2].charAt(2)+""+dateParts[2].charAt(3));
            System.out.println(simplemonth==simpleyear);
            String [] takeparts = selectedAppointments.get(i).split(" ");
            String fullTime=takeparts[1];
            String hours=fullTime.charAt(0)+""+fullTime.charAt(1);
            int shours=Integer.parseInt(hours);
            String minutes=fullTime.charAt(3)+""+fullTime.charAt(4);
            int sminutes=Integer.parseInt(minutes);
            System.out.println(shours==sminutes);
            for(int j=0;j<allapp.size();j++){
                if(tempDent.equals(allapp.get(j).getDentist())&&allapp.get(j).getBookDate().equals(new SimpleCalendar(simpleyear,simplemonth,simpleday))&&shours==Integer.parseInt(allapp.get(j).getHour())&&sminutes==Integer.parseInt(allapp.get(j).getMinutes())){
                    allapp.get(j).setState(AppointmentState.ACCEPTED);
                    aDAO.save(allapp.get(j));

                    break;
                }
            }
            view.jobDone("Appointments Added To your Agenda as Accepted");
        }


    }


    public void DeclineAppointments(String ID,List<String> selectedAppointments) {
        DentistDAOMemory dDAO=new DentistDAOMemory();
        Dentist tempDent=dDAO.find(ID);
        AppointmentDAOMemory aDAO=new AppointmentDAOMemory();
        List<Appointment> allapp=aDAO.findAll();

        for(int i=0;i<selectedAppointments.size();i++){
            String [] dateParts = selectedAppointments.get(i).split("/");
            String day = dateParts[0];
            String month = dateParts[1];
            String year = dateParts[2];
            int simpleday=Integer.parseInt(day);
            int simplemonth=Integer.parseInt(month);
            int simpleyear = Integer.parseInt(dateParts[2].charAt(0)+""+dateParts[2].charAt(1)+""+dateParts[2].charAt(2)+""+dateParts[2].charAt(3));
            System.out.println(simplemonth==simpleyear);
            String [] takeparts = selectedAppointments.get(i).split(" ");
            String fullTime=takeparts[1];
            String hours=fullTime.charAt(0)+""+fullTime.charAt(1);
            int shours=Integer.parseInt(hours);
            String minutes=fullTime.charAt(3)+""+fullTime.charAt(4);
            int sminutes=Integer.parseInt(minutes);
            System.out.println(shours==sminutes);
            for(int j=0;j<allapp.size();j++){
                if(tempDent.equals(allapp.get(j).getDentist())&&allapp.get(j).getBookDate().equals(new SimpleCalendar(simpleyear,simplemonth,simpleday))&&shours==Integer.parseInt(allapp.get(j).getHour())&&sminutes==Integer.parseInt(allapp.get(j).getMinutes())){
                    aDAO.delete(allapp.get(j));
                    break;
                }
            }
        }
        view.jobDone("Appointments Were Rejected");
    }

}
