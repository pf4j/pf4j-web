# pf4j-web

 Web module for pf4j. The main goal of this module is allows developers use pf4j in web applications.
 
## How to use
### Maven
Define the pf4j-web dependency in your pom.xml:

```xml

<dependency>
	<groupId>org.pf4j.web</groupId>
	<artifactId>pf4j-web</artifactId>
	<version>1.0.0</version>
</dependency>

```

### Web.xml configuration
It's necessary to define a listener class in your web.xml:


```xml

<listener>
	<listener-class>org.pf4j.web.PluginManagerInitializer</listener-class>
</listener>

```

### Plugin's home
It's possible to define a custom folder for the plugin's home. So, in this case it's necessary to add a context-param in your web.xml with param name "*pf4j.pluginsDir*". If that value is not defined, the plugins home will be created on the same directory of the executable file. For example, if you are using Apache Tomcat as application server, the plugins home will be created inside of the bin folder.

```xml

<context-param>
	<param-name>pf4j.pluginsDir</param-name>
	<param-value>/path/to/plugins</param-value>
</context-param>
	
```

## PF4J Documentation
For a more detailed documentation about pf4j core, please visit: [https://github.com/pf4j/pf4j](https://github.com/pf4j/pf4j) 

##Demo
Visit the demo here: [https://github.com/pf4j/pf4j-web/demo](https://github.com/pf4j/pf4j-web/demo)

# History
Initial version by [Rui Rodrigues](https://github.com/rmrodrigues)

## License
This software is under [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0).
## Suggestions
Any suggestions are  welcome.
