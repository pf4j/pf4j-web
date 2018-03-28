# pf4j-web-demo

The main goal of this application is to demonstrate how simple is to develop a modular web application using [https://github.com/decebals/pf4j](https://github.com/decebals/pf4j)

## Application Goal
As a DEMO, this Web Application cantains a list of person data that can be downloaded in varios formats such as:
* COSTUM (pf4j-web-demo-costom-plugin)
* CSV (pf4j-web-demo-csv-plugin)
* JSON (pf4j-web-demo-json-plugin)
* XML (pf4j-web-demo-xml-plugin)

Each plugin provides two methods, one to download a single person object and another to download an array os persons.

## Demo
See the DEMO: [http://pf4jdemo-rmrodrigues.rhcloud.com/](http://pf4jdemo-rmrodrigues.rhcloud.com/)



## Project Structure
* pf4j-web-demo/ (Maven Project)
  *   pf4j-web-demo-api -> This project contains all needed classes to develop a plugin.
  *   pf4j-web-demo-app -> This is the web application project.
  *   pf4j-web-demo-costum-plugin -> This plugin allows users to download person data in a costum format.
  *   pf4j-web-demo-csv-plugin    -> This plugin allows users to download person data in a CSV format. 
  *   pf4j-web-demo-json-plugin    -> This plugin allows users to download person data in a JSON format.
  *   pf4j-web-demo-xml-plugin    -> This plugin allows users to download person data in a XML format.
* Plugins/ (Contains the plugins)
