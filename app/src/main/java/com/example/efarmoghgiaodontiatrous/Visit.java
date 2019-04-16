package com.example.efarmoghgiaodontiatrous;

import java.util.Date;

public class Visit {
    private Date dateOfVisit;
    private String comments;

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
}