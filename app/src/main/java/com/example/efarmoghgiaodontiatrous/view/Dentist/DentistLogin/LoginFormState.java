package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistLogin;

import android.support.annotation.Nullable;

/**
 * Data validation state of the DentistLogin form.
 */
class LoginFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private String passwordError;
    private boolean isDataValid;

    LoginFormState(@Nullable Integer usernameError, @Nullable String passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    String getPasswordError() {
        return passwordError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}
