package ru.job4j.lyambda;

import java.util.Objects;

public class Address implements Comparable<Address> {
    private String city;
    private String street;
    private int home;
    private int apartment;

    @Override
    public int compareTo(Address address) {
        return this.city.compareTo(address.city);
    }

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
    public String getCity() {
        return this.city;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(city, address.city);
    }
    @Override
    public int hashCode() {

        return Objects.hash(city);
    }
    @Override
    public String toString() {
        return "city " + city;
    }
}
