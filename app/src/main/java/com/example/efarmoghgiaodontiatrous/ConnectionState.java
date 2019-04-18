package com.example.efarmoghgiaodontiatrous;

public enum ConnectionState {
    /**
     * Dentist is connected to his profile through the application's login()
     * function, therefore he has access to many of the app's functions.
     */
    CONNECTED,

    /**
     * Dentist is not yet connected to his profile through the application's login()
     * function, therefore he doesn't have access to some of the app's functions.
     */
    DISCONNECTED
}