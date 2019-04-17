package com.example.efarmoghgiaodontiatrous;

import java.util.Calendar;

public class SystemDate {

    protected SystemDate() {
    }

    private static SimpleCalendar stub;

    protected static void setStub(SimpleCalendar stubDate) {
        stub = stubDate;
    }

    protected static void removeStub() {
        stub = null;
    }

    public static SimpleCalendar now() {
        return stub == null ? new SimpleCalendar(Calendar.getInstance()) : stub;
    }
}