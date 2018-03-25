/*
 * Copyright 2012-present the original author or authors.
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
package org.pf4j.demo.json.plugin;

import java.lang.reflect.Type;
import java.util.List;

import org.pf4j.demo.api.ExporterBase;
import org.pf4j.demo.api.model.Person;

import org.pf4j.Extension;

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
	 * @see org.pf4j.demo.api.ExporterBase#export(org.pf4j.demo.api.model.Person)
	 */
	public byte[] export(Person person) {
		Gson gson = new Gson();

		return gson.toJson(person).toString().getBytes();

	}
	
	
	/* (non-Javadoc)
	 * @see org.pf4j.demo.api.ExporterBase#export(java.util.List)
	 */
	public byte[] export(List<Person> personList) {
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Person>>() {}.getType();
		return gson.toJson(personList,listType).toString().getBytes();

	}


}
