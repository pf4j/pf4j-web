/**
 * 
 */
package org.pf4j.web;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;

/**
 * The Class PluginManagerHolder.
 * 
 * @author rmrodrigues
 */
public class PluginManagerHolder {

	/** The plugin manager. */
	private static PluginManager pluginManager = null;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(PluginManagerHolder.class);

	/**
	 * Inits the.
	 * 
	 * @param pluginsHome
	 *            the plugins home
	 */
	static void init(String pluginsHome) {
		if (pluginsHome != null) {
			pluginManager = new DefaultPluginManager(new File(pluginsHome));
		} else {
			pluginManager = new DefaultPluginManager();
		}

	}

	/**
	 * Gets the plugin manager.
	 * 
	 * @return the plugin manager
	 */
	public static PluginManager getPluginManager() {
		if (pluginManager == null) {
			logger.error("pf4j-web: you must add the PluginManagerInitializer in web.xml.");
			logger.error("pf4j-web: See more details: https://github.com/rmrodrigues/pf4j-web");
			throw new RuntimeException(
					"You must add the PluginManagerInitializer in web.xml.\nSee more details: https://github.com/rmrodrigues/pf4j-web");
		}
		return pluginManager;
	}

}
