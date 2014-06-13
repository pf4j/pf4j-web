/**
 * 
 */
package org.rmrodrigues.pf4j.web;

import java.io.File;

import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.PluginManager;

/**
 * The Class PluginManagerHolder.
 * 
 * @author rmrodrigues
 */
public class PluginManagerHolder {

	/** The plugin manager. */
	private static PluginManager pluginManager = null;

	/**
	 * Inits the.
	 * 
	 * @param pluginsHome
	 *            the plugins home
	 */
	public static void init(String pluginsHome) {
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
		return pluginManager;
	}

}
