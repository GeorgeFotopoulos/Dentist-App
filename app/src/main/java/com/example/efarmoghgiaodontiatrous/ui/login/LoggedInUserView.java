package com.example.efarmoghgiaodontiatrous.ui.login;

import com.example.efarmoghgiaodontiatrous.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(Dentist dentist) {
        this.displayName = dentist.getLastName();
    }

    String getDisplayName() {
        return displayName;
    }
}
