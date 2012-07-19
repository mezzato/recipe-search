package org.recipesearch.hibernatesearch.po;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.lucene.document.DateTools;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
import org.lambico.po.hibernate.EntityBase;

@javax.persistence.Entity()
@Indexed
public class Person extends SearchableEntityBase {

	private transient org.recipesearch.core.po.Person person;

	@Transient
	public org.recipesearch.core.po.Person getPersonCore() {
		return this.person;
	}

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

	@Field
	public String getLastName() {
		return this.person.getLastName();
	}

	public void setLastName(String lastName) {
		this.person.setLastName(lastName);
	}

	@Transient
	public String getBirthDateAsString() {
		String date = DateTools.dateToString(this.person.getBirthDate(), DateTools.Resolution.DAY);
		return date;
	}
	
	@Field(index=Index.UN_TOKENIZED)
	@DateBridge(resolution=Resolution.DAY)
	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		Date date = this.person.getBirthDate();
		return date;
	}

	public void setBirthDate(Date birthDate) {
		this.person.setBirthDate(birthDate);
	}

	@Override
	public String toString() {
		return this.person.toString();
	}
}