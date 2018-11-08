#!/usr/bin/env bash
docker build -t ricardojob/banco ./postgres
docker run -p 5433:5432  --name banco  -d ricardojob/banco 
mvn clean package
docker build -t ricardojob/app .
docker run -p 8082:8080 --name app --link banco:host-banco -d  -v $(pwd)/apps:/usr/local/tomcat/testes ricardojob/app 

