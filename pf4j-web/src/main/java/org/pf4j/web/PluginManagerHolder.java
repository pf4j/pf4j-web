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
