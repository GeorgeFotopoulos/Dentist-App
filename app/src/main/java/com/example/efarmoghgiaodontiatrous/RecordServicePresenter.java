package com.example.efarmoghgiaodontiatrous;

import android.widget.CalendarView;

import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecordServicePresenter {
    RecordServiceView view;
    public RecordServicePresenter(RecordServiceView view) {
        this.view=view;
    }

    public Client onSearchClient(String AMKA){
        ClientDAOMemory v = new ClientDAOMemory();
        Client client = v.find(AMKA);
        return client;

    }

    public void onCreate(SimpleCalendar calendar, String fname, String  lname, String  phone, String  mail, String  amka, List<String> services, String ID, String comments){
        DentistDAOMemory ddao = new DentistDAOMemory();
        VisitDAOMemory vdao = new VisitDAOMemory();
        ClientDAOMemory cdao = new ClientDAOMemory();
        ServiceDAOMemory sdao = new ServiceDAOMemory();
        List<Service> allServ = sdao.findAll();
        Set<Service> serv = new HashSet<>();


        for(int i=0; i<allServ.size(); i++){
            if(services.contains(allServ.get(i).getServiceName())){
                serv.add(allServ.get(i));
            }
        }

        if(onSearchClient(amka) != null){

            vdao.save(new Visit(calendar,comments,ddao.find(ID),onSearchClient(amka),serv));

        }else{

            Client c = new Client(fname, lname, phone, mail, amka);
            cdao.save(c);
            vdao.save(new Visit(calendar,comments,ddao.find(ID),c,serv));

        }
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
}
