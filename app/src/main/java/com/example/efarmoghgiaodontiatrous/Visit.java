package com.example.efarmoghgiaodontiatrous;

import java.util.HashSet;
import java.util.Set;

public class Visit {
    private SimpleCalendar dateOfVisit;
    private String comments;
    private Dentist dentist;
    private Client client;
    private Set<Service> services = new HashSet<>();

    public Visit() {
    }

    public Visit(SimpleCalendar dateOfVisit, String comments, Dentist dentist, Client client, Set<Service> services) {
        this.dateOfVisit = dateOfVisit;
        this.comments = comments;
        this.dentist = dentist;
        this.client = client;
        this.services = services;
    }

    public SimpleCalendar getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(SimpleCalendar dateOfVisit) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (!dateOfVisit.equals(visit.dateOfVisit)) return false;
        if (!comments.equals(visit.comments)) return false;
        if (!dentist.equals(visit.dentist)) return false;
        if (!client.equals(visit.client)) return false;
        return services.equals(visit.services);
    }

    @Override
    public int hashCode() {
        if (dateOfVisit == null && comments == null && dentist == null && client == null && services == null) {
            return 0;
        }
        int result = dateOfVisit.hashCode();
        result = 31 * result + comments.hashCode();
        result = 31 * result + dentist.hashCode();
        result = 31 * result + client.hashCode();
        result = 31 * result + services.hashCode();
        return result;
    }
}