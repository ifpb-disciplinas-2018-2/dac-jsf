#!/usr/bin/env bash
docker kill app
docker rm app
docker rmi ricardojob/app
docker kill banco
docker rm banco
docker rmi ricardojob/banco

# docker rmi -f $(docker image ls ricardojob/* -q)
# docker kill $(docker container ls -a -q)
# docker rm banco
# docker rm app
