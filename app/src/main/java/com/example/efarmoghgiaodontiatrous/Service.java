package com.example.efarmoghgiaodontiatrous;

public class Service {
    private String serviceName, serviceID;

    public Service() {
    }

    public Service(String serviceName, String serviceID) {
        this.serviceName = serviceName;
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
}