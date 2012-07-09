package org.recipesearch.hibernatesearch.po;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.lambico.po.hibernate.EntityBase;

@javax.persistence.Entity()
public class Person extends EntityBase {

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

    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
	public String toString() {
        return this.firstName + " " + this.lastName + " (" + this.birthDate + ")";
    }
}