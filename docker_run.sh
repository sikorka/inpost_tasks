#!/bin/bash

if [ "$#" -lt 2 ]
then
  echo "Use this script once inpota container is running and your grid is up. "
  echo
  echo "usage: ./docker_run.sh <inpota docker container ID or name>"
  echo "                       <environment name> [optional: cucumber filter tags]"
  echo "examples:"
  echo "       ./docker_run.sh practical_moser prod"
  echo "       ./docker_run.sh practical_moser prod @gui"
  exit 1
fi

docker exec $1 bash -c "./mvnw clean test --fail-at-end -D environment=$2 -D grid=http://host.docker.internal:4444 -D cucumber-filter-tags=$3"

timestamp=$(date +%Y%m%d_%H%M%S)

mkdir -p ./docker/results/api/$2/$timestamp
docker cp $1:inpost-api-tests/target ./docker/results/api/$2/$timestamp
docker cp $1:inpost-api-tests/logs ./docker/results/api/$2/$timestamp
mkdir -p ./docker/results/gui/$2/$timestamp
docker cp $1:inpost-ui-tests/target ./docker/results/gui/$2/$timestamp
docker cp $1:inpost-ui-tests/logs ./docker/results/gui/$2/$timestamp

open ./docker/results/api/$2/$timestamp/target/cucumber.html
open ./docker/results/gui/$2/$timestamp/target/cucumber.html