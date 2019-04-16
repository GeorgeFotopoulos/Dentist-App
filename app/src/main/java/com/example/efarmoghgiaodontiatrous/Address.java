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

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }

        Address theAddress = (Address) other;
        if (!(street == null ? theAddress.street == null : street.equals(theAddress.street))) {
            return false;
        }
        if (!(number == null ? theAddress.number == null : number.equals(theAddress.number))) {
            return false;
        }
        if (!(city == null ? theAddress.city == null : city.equals(theAddress.city))) {
            return false;
        }
        if (!(zip == 0 ? theAddress.zip == 0 : zip == theAddress.zip)) {
            return false;
        }
        if (!(country == null ? theAddress.country == null : country.equals(theAddress.country))) {
            return false;
        }
        return true;
    }

}