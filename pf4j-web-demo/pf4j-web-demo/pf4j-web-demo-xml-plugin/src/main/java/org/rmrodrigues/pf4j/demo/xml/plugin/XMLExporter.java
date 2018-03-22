/**
 * 
 */
package org.rmrodrigues.pf4j.demo.xml.plugin;

import java.util.List;

import org.rmrodrigues.pf4j.demo.api.ExporterBase;
import org.rmrodrigues.pf4j.demo.api.model.Person;

import ro.fortsoft.pf4j.Extension;

import com.thoughtworks.xstream.XStream;

/**
 * The Class XMLExporter.
 *
 * @author rmrodrigues
 */
@Extension
public class XMLExporter extends ExporterBase {

	/** The Constant NAME. */
	private static final String NAME = "XML";
	
	/** The Constant CONTENTTYPE. */
	private static final String CONTENTTYPE = "application/xml";

	/**
	 * Instantiates a new xML exporter.
	 */
	public XMLExporter() {
		super(NAME, CONTENTTYPE);
	}

	/* (non-Javadoc)
	 * @see org.rmrodrigues.pf4j.demo.api.ExporterBase#export(org.rmrodrigues.pf4j.demo.api.model.Person)
	 */
	public byte[] export(Person person) {
		XStream xstream = new XStream();
		xstream.alias("person", Person.class);
		String xml = xstream.toXML(person);
		return xml.getBytes();

	}

	/* (non-Javadoc)
	 * @see org.rmrodrigues.pf4j.demo.api.ExporterBase#export(java.util.List)
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
