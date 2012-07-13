package org.recipesearch.core.po;

import java.util.Date;

public class Person {

    private String firstName;
    private String lastName;
    private Date birthDate;

    /** Creates a new instance of Person */
    public Person() {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

	public String toString() {
        return this.firstName + " " + this.lastName + " (" + this.birthDate + ")";
    }
}