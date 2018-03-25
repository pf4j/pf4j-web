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
package org.pf4j.demo.api;

import java.util.List;

import org.pf4j.demo.api.model.Person;

import org.pf4j.ExtensionPoint;

/**
 * The Class ExporterBase.
 *
 * @author rmrodrigues
 */
public abstract class ExporterBase implements ExtensionPoint {

	/** The name. */
	private String name;

	/** The content type. */
	private String contentType;

	/**
	 * Instantiates a new exporter base.
	 *
	 * @param name the name
	 * @param contentType the content type
	 */
	public ExporterBase(String name, String contentType) {
		this.name = name;
		this.contentType = contentType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.rmrodrigues.pf4j.demo.api.PluginBase#getName()
	 */
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType the new content type
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rmrodrigues.pf4j.demo.api.PluginBase#export(org.rmrodrigues.pf4j.
	 * demo.api.model.Person)
	 */
	/**
	 * Export.
	 *
	 * @param person the person
	 * @return the byte[]
	 */
	public abstract byte[] export(Person person);
	
	
	/**
	 * Export.
	 *
	 * @param persons the persons
	 * @return the byte[]
	 */
	public abstract byte[] export(List<Person> persons);

}
