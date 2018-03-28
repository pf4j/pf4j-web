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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.pf4j.demo.api.ExporterBase;
import org.pf4j.demo.api.model.Person;
import org.pf4j.web.PluginManagerHolder;

import org.pf4j.PluginState;
import org.pf4j.PluginWrapper;

/**
 * The Class PluginsMBean.
 * 
 * @author rmrodrigues
 */
@ManagedBean(name = "pluginsMBean")
@SessionScoped
public class PluginsMBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7473027855852017369L;

	/**
	 * Gets the plugins.
	 * 
	 * @return the plugins
	 */
	public List<PluginWrapper> getPlugins() {
		return PluginManagerHolder.getPluginManager().getPlugins();
	}

	/**
	 * Checks if is active.
	 * 
	 * @param pluginWrapper
	 *            the plugin wrapper
	 * @return true, if is active
	 */
	public boolean isActive(PluginWrapper pluginWrapper) {
		return pluginWrapper.getPluginState().equals(PluginState.STARTED);

	}

	/**
	 * Disable.
	 * 
	 * @param pluginWrapper
	 *            the plugin wrapper
	 * @return the string
	 */
	public String disable(PluginWrapper pluginWrapper) {
		PluginManagerHolder.getPluginManager().stopPlugin(
				pluginWrapper.getPluginId());
		return "";
	}

	/**
	 * Delete.
	 * 
	 * @param pluginWrapper
	 *            the plugin wrapper
	 * @return the string
	 */
	public String delete(PluginWrapper pluginWrapper) {
		PluginManagerHolder.getPluginManager().deletePlugin(
				pluginWrapper.getPluginId());
		return "";
	}

	/**
	 * Enable.
	 * 
	 * @param pluginWrapper
	 *            the plugin wrapper
	 * @return the string
	 */
	public String enable(PluginWrapper pluginWrapper) {
		PluginManagerHolder.getPluginManager().enablePlugin(
				pluginWrapper.getPluginId());
		PluginManagerHolder.getPluginManager().startPlugin(
				pluginWrapper.getPluginId());
		return "";
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

	/** The uploaded file. */
	private UploadedFile uploadedFile;

	/**
	 * Submit.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void submit() throws IOException {
		String fileName = FilenameUtils.getName(uploadedFile.getName());
		String pluginsHome = System.getProperty("pf4j.pluginsDir", "plugins");
		byte[] bytes = uploadedFile.getBytes();
		FileOutputStream out = new FileOutputStream(pluginsHome + "/"
				+ fileName);
		out.write(bytes);
		out.close();
		String newPluginID = PluginManagerHolder.getPluginManager().loadPlugin(
				new File(pluginsHome + "/" + fileName).toPath());

		PluginManagerHolder.getPluginManager().enablePlugin(newPluginID);

		PluginManagerHolder.getPluginManager().startPlugin(newPluginID);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(String.format(
						"Plugin '%s'  successfully installed!", fileName)));
	}

	/**
	 * Gets the uploaded file.
	 * 
	 * @return the uploaded file
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * Sets the uploaded file.
	 * 
	 * @param uploadedFile
	 *            the new uploaded file
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
