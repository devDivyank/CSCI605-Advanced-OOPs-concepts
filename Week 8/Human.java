package com.rit.hw.assignment8B;
import java.util.Date;

public class Human implements Comparable<Human>{
    Date dateOfBirth;
    String firstName;
    String lastName;

    public Human(Date dateOfBirth, String firstName, String lastName){
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + this.lastName;
    }

    @Override
    public int compareTo(Human o) {
        if (this.dateOfBirth.compareTo(o.dateOfBirth) != 0) {
            return this.dateOfBirth.compareTo(o.dateOfBirth);
        } else if (this.firstName.compareTo(o.firstName) != 0) {
            return this.firstName.compareTo(o.firstName);
        } else {
            return this.lastName.compareTo(o.lastName);
        }
    }
}