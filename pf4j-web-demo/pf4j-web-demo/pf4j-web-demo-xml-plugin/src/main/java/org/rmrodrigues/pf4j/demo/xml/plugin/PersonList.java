/**
 * 
 */
package org.rmrodrigues.pf4j.demo.xml.plugin;

import java.util.List;

import org.rmrodrigues.pf4j.demo.api.model.Person;

/**
 * The Class PersonList.
 * 
 * @author rmrodrigues
 */
public class PersonList {

	/** The list. */
	private List<Person> list;

	/**
	 * Instantiates a new person list.
	 * 
	 * @param listIN
	 *            the list in
	 */
	public PersonList(List<Person> listIN) {
		this.list = listIN;
	}

}