#pf4j-web


 Web module for pf4j. The main goal of this module is allows developers use pf4j in web applications.
 
## How to use
  
### Maven
Define the pf4j-web dependency in your pom.xml:

```xml

<dependency>
			<groupId>org.rmrodrigues.pf4j.web</groupId>
			<artifactId>pf4j-web</artifactId>
			<version>1.0.0</version>
</dependency>

```

### Web.xml configuration
It's necessary to define a listener class in your web.xml:


```xml

<listener>
		<listener-class>org.rmrodrigues.pf4j.web.PluginManagerInitializer</listener-class>
</listener>

```

### Plugin's home
Is possible to define a custom folder for the plugin's home. So, in this cases it's necessary to a context-param in your web.xml with param name "*pf4j.pluginsDir*".

```xml

<context-param>
		<param-name>pf4j.pluginsDir</param-name>
		<param-value>/Users/rmrodrigues/git/pf4j-web-demo/plugins</param-value>
</context-param>
	
```

## PF4J Documentation
For a more detailed documentation related the core of pf4j please visit:[https://github.com/decebals/pf4j](https://github.com/decebals/pf4j) 

##Demo
Visit the demo here: [https://github.com/rmrodrigues/pf4j-web-demo](https://github.com/rmrodrigues/pf4j-web-demo)

## License
Copyright 2014 Rui Rodrigues
This software is under [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0).
## Suggestions
Any suggestions are  welcome.
