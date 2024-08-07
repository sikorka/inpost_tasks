#!/bin/bash

if [ "$#" -lt 1 ]
then
  echo "Use this script once inpota container is running and your grid is up. "
  echo
  echo "usage: $0 <environment> [cucumber tags]"
  echo
  echo "examples:"
  echo "       $0 prod"
  echo "       $0 sandbox @gui"
  echo "       $0 sandboxpl @api"
  exit 1
fi

docker exec inpota bash -c "./mvnw clean test --fail-at-end -D environment=$1 -D grid=http://host.docker.internal:4444 -D cucumber.filter.tags=$2"

timestamp=$(date +%Y%m%d_%H%M%S)

mkdir -p ./docker/results/gui/$1/$timestamp
docker cp inpota:inpost-ui-tests/target ./docker/results/gui/$1/$timestamp
open ./docker/results/gui/$1/$timestamp/target/cucumber.html

mkdir -p ./docker/results/api/$1/$timestamp
docker cp inpota:inpost-api-tests/target ./docker/results/api/$1/$timestamp
open ./docker/results/api/$1/$timestamp/target/cucumber.html

