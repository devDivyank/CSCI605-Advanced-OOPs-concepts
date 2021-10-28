package com.rit.hw.assignment8B;

public class Address implements Comparable<Address>{
    int houseNumber;
    String streetName;
    String nameOfTown;
    String state;
    int zipCode;

    public Address(int houseNumber, String streetName, String nameOfTown, String state, int zipCode){
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.nameOfTown = nameOfTown;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return this.streetName;
    }

    @Override
    public int compareTo(Address o) {
        if (Integer.valueOf(this.houseNumber).compareTo(Integer.valueOf(o.houseNumber)) != 0) {
            return Integer.valueOf(this.houseNumber).compareTo(Integer.valueOf(o.houseNumber));
        } else if (this.streetName.compareTo(o.streetName) != 0) {
            return this.streetName.compareTo(o.streetName);
        } else if (this.nameOfTown.compareTo(o.nameOfTown) != 0) {
            return this.nameOfTown.compareTo(o.nameOfTown);
        } else if (this.state.compareTo(o.state) != 0) {
            return this.state.compareTo(o.state);
        } else {
            return Integer.valueOf(this.zipCode).compareTo(Integer.valueOf(o.zipCode));
        }
    }
}
