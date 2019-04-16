package com.example.efarmoghgiaodontiatrous;

public enum AppointmentState {
    /**
     * Appointment has yet to be accepted or declined by the Dentist.
     */
    PENDING,

    /**
     * Appointment was accepted by the Dentist.
     */
    ACCEPTED,

    /**
     * Appointment was declined by the Dentist.
     */
    DECLINED
}
