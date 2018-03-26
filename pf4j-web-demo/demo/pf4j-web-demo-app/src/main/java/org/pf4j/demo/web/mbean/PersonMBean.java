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
package org.pf4j.demo.web.mbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.pf4j.demo.api.ExporterBase;
import org.pf4j.demo.api.model.Person;
import org.pf4j.web.PluginManagerHolder;

/**
 * The Class PersonMBean.
 * 
 * @author rmrodrigues
 */
@ManagedBean(name = "personMBean")
@SessionScoped
public class PersonMBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3314761395244493023L;

	/** The Constant personList. */
	private static final List<Person> personList = new ArrayList<Person>() {
		{
			add(new Person("Steve", "Jobs", 56, new Date(), "Palo Alto"));
			add(new Person("Mark", "Smidth", 16, new Date(), "New York"));
			add(new Person("Gustavo", "Martiez", 56, new Date(), "Boston"));
			add(new Person("Emilia", "Ortega", 54, new Date(), "Oporto"));
			add(new Person("Nora", "Scott", 75, new Date(), "Viana do Castelo"));
			add(new Person("Paul", "Walker", 30, new Date(), "Barcelona"));
			add(new Person("Michael", "James", 45, new Date(), "Braga"));
		}
	};

	/**
	 * Gets the person list.
	 * 
	 * @return the person list
	 */
	public List<Person> getPersonList() {
		return personList;
	}

	/**
	 * Download.
	 * 
	 * @param p
	 *            the p
	 * @param plugin
	 *            the plugin
	 * @return the string
	 */
	public String download(Person p, ExporterBase plugin) {

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) fc
				.getExternalContext().getResponse();
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();

			out.write(plugin.export(p));
			response.setContentType(plugin.getContentType());
			response.addHeader("Content-Disposition",
					"attachment; filename=\"Person\"");
			out.flush();
		} catch (IOException e1) {
		}
		try {
			if (out != null) {
				out.close();
			}
			FacesContext.getCurrentInstance().responseComplete();
		} catch (IOException e) {

		}

		return "";
	}

	/**
	 * Download all.
	 * 
	 * @param plugin
	 *            the plugin
	 * @return the string
	 */
	public String downloadAll(ExporterBase plugin) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) fc
				.getExternalContext().getResponse();
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();

			out.write(plugin.export(getPersonList()));
			response.setContentType(plugin.getContentType());
			response.addHeader("Content-Disposition",
					"attachment; filename=\"Person\"");
			out.flush();
		} catch (IOException e1) {
		}
		try {
			if (out != null) {
				out.close();
			}
			FacesContext.getCurrentInstance().responseComplete();
		} catch (IOException e) {

		}

		return "";
	}

	/**
	 * Gets the plugins.
	 * 
	 * @return the plugins
	 */
	public List<ExporterBase> getPlugins() {
		return PluginManagerHolder.getPluginManager().getExtensions(
				ExporterBase.class);
	}

}
