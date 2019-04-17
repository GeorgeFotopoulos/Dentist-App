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

    public Address(String street, String number, String city, String country, int zip) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
        this.zip = zip;
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

    @Override
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

    @Override
    public int hashCode() {
        if (street == null && number == null && city == null && zip == 0 && country == null) {
            return 0;
        }
        int result = 0;
        result = street == null ? result : 13 * result + street.hashCode();
        result = number == null ? result : 13 * result + number.hashCode();
        result = city == null ? result : 13 * result + city.hashCode();
        result = zip == 0 ? result : 13 * result + zip;
        result = country == null ? result : 13 * result + country.hashCode();
        return result;
    }
}