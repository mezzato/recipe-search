package org.recipesearch.hibernatesearch.po;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.lambico.po.hibernate.EntityBase;

@javax.persistence.Entity()
public class Person extends EntityBase {

	private org.recipesearch.core.po.Person person;

    /** Creates a new instance of Person */
    public Person() {
    	this.person = new org.recipesearch.core.po.Person();
    }

    public String getFirstName() {
        return this.person.getFirstName();
    }

    public void setFirstName(String firstName) {
        this.person.setFirstName(firstName);
    }

    public String getLastName() {
    	return this.person.getLastName();
    }

    public void setLastName(String lastName) {
    	this.person.setLastName(lastName);
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return this.person.getBirthDate();
    }

    public void setBirthDate(Date birthDate) {
    	this.person.setBirthDate(birthDate);
    }

    @Override
	public String toString() {
        return this.person.toString();
    }
}