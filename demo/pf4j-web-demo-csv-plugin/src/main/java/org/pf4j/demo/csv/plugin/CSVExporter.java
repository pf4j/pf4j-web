/*
 * Copyright (C) 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pf4j.demo.csv.plugin;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsefa.Serializer;
import org.jsefa.csv.CsvIOFactory;
import org.pf4j.demo.api.ExporterBase;
import org.pf4j.demo.api.model.Person;
import org.pf4j.demo.csv.plugin.model.PersonCSV;

import org.pf4j.Extension;

/**
 * The Class CSVExporter.
 *
 * @author rmrodrigues
 */
@Extension
public class CSVExporter extends ExporterBase {

    /**
     * The Constant NAME.
     */
    private static final String NAME = "CSV";

    /**
     * The Constant CONTENTTYPE.
     */
    private static final String CONTENTTYPE = "application/CSV";

    /**
     * Instantiates a new cSV exporter.
     */
    public CSVExporter() {
        super(NAME, CONTENTTYPE);
    }


    /** (non-Javadoc)
     * @see org.pf4j.demo.api.ExporterBase#export(org.pf4j.demo.api.model.Person)
     */
    public byte[] export(Person person) {
        PersonCSV personCSV = mapPerson(person);

        Serializer serializer = CsvIOFactory.createFactory(PersonCSV.class)
                .createSerializer();
        StringWriter writer = new StringWriter();
        serializer.open(writer);
        serializer.write(personCSV);
        serializer.close(true);
        return writer.toString().getBytes();

    }

    /** (non-Javadoc)
     * @see org.pf4j.demo.api.ExporterBase#export(java.util.List)
     */
    public byte[] export(List<Person> person) {
        List<PersonCSV> personCSVList = mapPerson(person);

        Serializer serializer = CsvIOFactory.createFactory(PersonCSV.class)
                .createSerializer();
        StringWriter writer = new StringWriter();
        serializer.open(writer);
        for (PersonCSV personCSV : personCSVList) {
            serializer.write(personCSV);
        }

        serializer.close(true);
        return writer.toString().getBytes();

    }

    /**
     * Map person.
     *
     * @param personList the person list
     * @return the list
     */
    private List<PersonCSV> mapPerson(List<Person> personList) {
        List<PersonCSV> result = new ArrayList<PersonCSV>();
        for (Person curPerson : personList) {
            result.add(mapPerson(curPerson));
        }

        return result;
    }

    /**
     * Map person.
     *
     * @param person the person
     * @return the person csv
     */
    private PersonCSV mapPerson(Person person) {
        return new PersonCSV(person.getFirstName(), person.getLastName(),
                person.getAge(), person.getBirthdate(), person.getAddress());
    }

}
