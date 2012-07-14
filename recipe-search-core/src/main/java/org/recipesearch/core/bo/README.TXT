
In this directory you will add classe containing the business logic of you application.

For example (from the basicWebApp example):

// Copyright 2006-2008 The Parancoe Team
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
package org.parancoe.basicWebApp.blo;

import org.parancoe.basicWebApp.po.Person;
import org.parancoe.basicWebApp.dao.PersonDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonBo {

    @Autowired
    private PersonDao dao;

    public void populateArchive() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Person> searches = null;
        searches = dao.findByFirstNameAndLastName("Mario", "Rossi");
        if (searches.isEmpty()) {
            Person p = new Person();
            p.setFirstName("Mario");
            p.setLastName("Rossi");
            p.setBirthDate(sdf.parse("25/04/1970"));
            dao.store(p);
        }
        searches = dao.findByFirstNameAndLastName("Francesca", "Verdi");
        if (searches.isEmpty()) {
            Person p = new Person();
            p.setFirstName("Francesca");
            p.setLastName("Verdi");
            p.setBirthDate(sdf.parse("30/08/1990"));
            dao.store(p);
        }
        searches = dao.findByFirstNameAndLastName("Giovanni", "Bianchi");
        if (searches.isEmpty()) {
            Person p = new Person();
            p.setFirstName("Giovanni");
            p.setLastName("Bianchi");
            p.setBirthDate(sdf.parse("15/03/1980"));
            dao.store(p);
        }
    }

    public Person retrievePerson(Long id) {
        return dao.read(id);
    }
}
