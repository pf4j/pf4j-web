package org.rmrodrigues.pf4j.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.fortsoft.pf4j.PluginManager;

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
