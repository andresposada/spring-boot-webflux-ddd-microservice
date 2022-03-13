#!/bin/bash

docker stop ddd-db && docker rm ddd-db
docker run \
  --name ddd-db \
  -p 3307:3306 \
  -e MYSQL_ROOT_PASSWORD=mysqlpass \
  -e MYSQL_DATABASE=ddd-db \
  -d mysql:8.0