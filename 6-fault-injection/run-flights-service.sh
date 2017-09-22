#!/usr/bin/env bash

mkdir -p log
java -jar flights-service.jar &> log/flights-service.out &

while [ $(curl -sL -w "%{http_code}\\n" "http://localhost:8081/management/health" -o /dev/null) != "200" ] 
do 
echo "waiting for service to start"
sleep 1
done
echo "service started"
