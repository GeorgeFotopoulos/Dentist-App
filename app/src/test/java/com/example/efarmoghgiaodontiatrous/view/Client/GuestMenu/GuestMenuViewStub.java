package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

public class GuestMenuViewStub implements GuestMenuView {
    private String msg, lastName, firstName, region, specialization, service;

    @Override
    public void showError(String msg) {
        this.msg = msg;
    }

    @Override
    public void showSearchView(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public void showSearchViewFilters(String region, String specialization, String service) {
        this.region = region;
        this.specialization = specialization;
        this.service = service;
    }

    public String getMsg() {
        return msg;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRegion() {
        return region;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getService() {
        return service;
    }
}