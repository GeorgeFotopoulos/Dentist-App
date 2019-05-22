package com.example.efarmoghgiaodontiatrous.domain;

public class Service {
    private String serviceName, serviceID;
    private static int ID = 1;

    /**
     * Default Constructor.
     */
    public Service() {
        this.serviceID = ID + "";
        ID++;
    }

    /**
     * Service constructor where another Service object is given as parameter and its fields are copied.
     *
     * @param service Service object whose values are getting copied to the other Service object
     */
    public Service(Service service) {
        this.serviceName = service.serviceName;
        this.serviceID = ID+"";
        ID++;
    }

    /**
     * Service constructor where all values are given as parameters.
     *
     * @param serviceName Service's name
     */
    public Service(String serviceName) {
        this.serviceName = serviceName;
        this.serviceID = ID+"";
        ID++;
    }

    /**
     * Returns Service's name.
     *
     * @return Service's name
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets Service's name.
     *
     * @param serviceName Service's name
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Returns Service's ID.
     *
     * @return Service's ID
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * Sets Service's ID.
     *
     * @param serviceID Service's ID
     */
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