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
package org.pf4j.demo.xml.plugin;

import java.util.List;

import org.pf4j.demo.api.ExporterBase;
import org.pf4j.demo.api.model.Person;

import org.pf4j.Extension;

import com.thoughtworks.xstream.XStream;

/**
 * The Class XMLExporter.
 *
 * @author rmrodrigues
 */
@Extension
public class XMLExporter extends ExporterBase {

    /**
     * The Constant NAME.
     */
    private static final String NAME = "XML";

    /**
     * The Constant CONTENTTYPE.
     */
    private static final String CONTENTTYPE = "application/xml";

    /**
     * Instantiates a new xML exporter.
     */
    public XMLExporter() {
        super(NAME, CONTENTTYPE);
    }

    /* (non-Javadoc)
	 * @see org.pf4j.demo.api.ExporterBase#export(org.pf4j.demo.api.model.Person)
     */
    public byte[] export(Person person) {
        XStream xstream = new XStream();
        xstream.alias("person", Person.class);
        String xml = xstream.toXML(person);
        return xml.getBytes();

    }

    /* (non-Javadoc)
	 * @see org.pf4j.demo.api.ExporterBase#export(java.util.List)
     */
    public byte[] export(List<Person> person) {
        PersonList personList = new PersonList(person);
        XStream xstream = new XStream();
        xstream.alias("person", Person.class);
        xstream.alias("persons", PersonList.class);
        xstream.addImplicitCollection(PersonList.class, "list");
        String xml = xstream.toXML(personList);
        return xml.getBytes();

    }

}
