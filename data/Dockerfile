FROM postgres:9-alpine
LABEL MAINTAINER="arthuraz.1990@gmail.com"

COPY ./init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432