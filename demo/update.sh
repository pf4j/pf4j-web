#!/bin/sh
#Build
mvn clean package

# create the plugins folder
rm -fr ../plugins
mkdir ../plugins

# copy artifacts to plugins folder
cp pf4j-web-demo-csv-plugin/target/*.zip ../plugins/
cp pf4j-web-demo-json-plugin/target/*.zip ../plugins/
cp pf4j-web-demo-xml-plugin/target/*.zip ../plugins/
