package com.example.efarmoghgiaodontiatrous;

public class Client {
    private String firstName, lastName, telephoneNo, email, AMKA;

    public Client() {
    }

    public Client(Client client){
        this.setFirstName(client.getFirstName());
        this.setLastName(client.getLastName());
        this.setTelephoneNo(client.getTelephoneNo());
        this.setEmail(client.getEmail());
        this.setAMKA(client.getAMKA());
    }

    public Client(String firstName, String lastName, String telephoneNo, String email, String AMKA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.email = email;
        this.AMKA = AMKA;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAMKA() {
        return AMKA;
    }

    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return AMKA.equals(client.AMKA);
    }

    @Override
    public int hashCode() {
        return AMKA.hashCode();
    }
}