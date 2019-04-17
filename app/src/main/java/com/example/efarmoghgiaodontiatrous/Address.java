package com.example.efarmoghgiaodontiatrous;

public class Address {
    private String street, number, city, country = "Greece";
    private int zip;

    public Address() {
    }

    public Address(Address address) {
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.zip = address.getZipCode();
        this.country = address.getCountry();
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getCity() {
        return city;
    }

    public void setZipCode(int zipcode) {
        this.zip = zipcode;
    }

    public int getZipCode() {
        return zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (zip != address.zip) return false;
        if (!street.equals(address.street)) return false;
        if (!number.equals(address.number)) return false;
        if (!city.equals(address.city)) return false;
        return country.equals(address.country);
    }

    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + zip;
        return result;
    }
}