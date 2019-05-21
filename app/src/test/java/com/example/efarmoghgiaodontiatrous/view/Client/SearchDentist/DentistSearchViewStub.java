package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

public class DentistSearchViewStub implements DentistSearchView{
    private Dentist requestAppointmentResult;

    @Override
    public void requestAppointment(Dentist item) {
        this.requestAppointmentResult = item;
    }

    public Dentist getRequestAppointment() {
        return requestAppointmentResult;
    }
}