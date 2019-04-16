package com.example.efarmoghgiaodontiatrous;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Visit {
    private Date dateOfVisit;
    private String comments;
    private Dentist dentist;
    private Client client;
    private Set<Service> services = new HashSet<>();

    public Visit() {
    }

    public Visit(Date dateOfVisit, String comments, Dentist dentist, Client client, Set<Service> services) {
        this.dateOfVisit = dateOfVisit;
        this.comments = comments;
        this.dentist = dentist;
        this.client = client;
        this.services = services;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Service> getServices() {
        return new HashSet<>(services);
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}