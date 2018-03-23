/**
 * 
 */
package org.rmrodrigues.pf4j.demo.json.plugin;

import java.lang.reflect.Type;
import java.util.List;

import org.rmrodrigues.pf4j.demo.api.ExporterBase;
import org.rmrodrigues.pf4j.demo.api.model.Person;

import ro.fortsoft.pf4j.Extension;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The Class JSonExporter.
 *
 * @author rmrodrigues
 */
@Extension
public class JSonExporter extends ExporterBase {
	
	/** The Constant NAME. */
	private static final String NAME="JSON";
	
	/** The Constant CONTENTTYPE. */
	private static final String CONTENTTYPE="application/json";

	/**
	 * Instantiates a new j son exporter.
	 */
	public JSonExporter() {
		super(NAME,CONTENTTYPE);
	}

	/* (non-Javadoc)
	 * @see org.rmrodrigues.pf4j.demo.api.ExporterBase#export(org.rmrodrigues.pf4j.demo.api.model.Person)
	 */
	public byte[] export(Person person) {
		Gson gson = new Gson();

		return gson.toJson(person).toString().getBytes();

	}
	
	
	/* (non-Javadoc)
	 * @see org.rmrodrigues.pf4j.demo.api.ExporterBase#export(java.util.List)
	 */
	public byte[] export(List<Person> personList) {
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Person>>() {}.getType();
		return gson.toJson(personList,listType).toString().getBytes();

	}


}
