#!/bin/bash
cd spring-server
mvn clean install
cd ../images/survey-server
docker build --rm -t pestakit/surveys .