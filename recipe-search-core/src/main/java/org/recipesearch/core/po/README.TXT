
In this directory you will add classes containing the persitent entities
of you application.

For example (from the basicWebApp example):

// Copyright 2006-2007 The Parancoe Team
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package org.parancoe.basicWebApp.po;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.parancoe.persistence.po.hibernate.EntityBase;
import org.parancoe.util.BaseConf;
import org.springmodules.validation.bean.conf.loader.annotation.handler.InThePast;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

@javax.persistence.Entity()
public class Person extends EntityBase {
   
    private boolean test = BaseConf.isDevelopment();
    
    @NotBlank
    @Length(min=2, max=7, applyIf="test == true")
    private String firstName;
    
    @NotBlank
    @Length(min=2, max=10)
    private String lastName;
    
    @NotNull
    @InThePast
    private Date birthDate;

    /** Creates a new instance of Person */
    public Person() {
    }

    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public void setTest(boolean test){
        this.test = test;
    }
    
    public boolean isTest(){
        return test;
    }
    
    public String toString() {
        return firstName + " " + lastName + " nato il " +  birthDate ;
    }
}
