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
package org.pf4j.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.pf4j.PluginManager;

/**
 * The Class PluginManagerInitializer.
 * 
 * @author rmrodrigues
 */
public class PluginManagerInitializer implements ServletContextListener {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(PluginManagerInitializer.class);

	/** The Constant CONST_CONFIG_PARAM_NAME. */
	private static final String CONST_CONFIG_PARAM_NAME = "pf4j.pluginsDir";

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.debug("contextDestroyed start.");
		logger.debug("get plugin manager");
		final PluginManager pluginManager = PluginManagerHolder
				.getPluginManager();

		logger.info("Stopping plugins...");
		pluginManager.stopPlugins();
		logger.info("Plugins stopped.");
		logger.debug("contextDestroyed end.");
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.debug("contextInitialized start.");
		logger.info("Initializing plugin manager.");
		PluginManagerHolder.init(getPluginsHome(servletContextEvent));

		final PluginManager pluginManager = PluginManagerHolder
				.getPluginManager();
		logger.info("Plugin Manager initialized.");
		logger.debug("Plugin Manager initialized.");
		pluginManager.loadPlugins();
		logger.debug("Plugins loaded.");
		logger.debug("contextInitialized end.");
	}

	/**
	 * Gets the plugins home.
	 * 
	 * @param servletContextEvent
	 *            the servlet context event
	 * @return the plugins home
	 */
	private String getPluginsHome(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		if (context != null) {
			return context.getInitParameter(CONST_CONFIG_PARAM_NAME);
		}
		return null;
	}

}
