package com.example.efarmoghgiaodontiatrous;

public class Service {
    private String serviceName, serviceID;

    public Service() {
    }

    public Service(Service other){
        this.serviceName = other.serviceName;
        this.serviceID = other.serviceID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        return serviceID.equals(service.serviceID);
    }

    @Override
    public int hashCode() {
        if (serviceID == null) {
            return 0;
        }
        return serviceID.hashCode();
    }
}