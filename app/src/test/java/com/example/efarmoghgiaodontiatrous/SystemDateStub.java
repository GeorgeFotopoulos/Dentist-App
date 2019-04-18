package com.example.efarmoghgiaodontiatrous;

public class SystemDateStub {
    public static void setStub(SimpleCalendar stub) {
        SystemDate.setStub(stub);
    }

    public static void reset() {
        SystemDate.removeStub();
    }
}