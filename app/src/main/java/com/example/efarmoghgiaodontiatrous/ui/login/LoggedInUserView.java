package com.example.efarmoghgiaodontiatrous.ui.login;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    private String ID;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(Dentist dentist) {
        this.displayName = dentist.getLastName();
        this.ID = dentist.getID();
    }

    String getDisplayName() {
        return displayName;
    }

    public String getID() {
        return this.ID;
    }
}
