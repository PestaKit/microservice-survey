#!/bin/bash
echo "******************** Building the jar ********************"
cd spring-server
mvn clean install

cp target/swagger-spring-1.0.0.jar images/survey-server

echo "******************** Building the image ********************"
cd ../images/survey-server
docker build —rm -t pestakit/surveys .