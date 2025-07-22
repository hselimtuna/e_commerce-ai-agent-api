FROM postgres:15-alpine

MAINTAINER Halil Selim Tuna <hselimtuna@gmail.com>

RUN apk add --no-cache \
    postgresql-contrib \
    && rm -rf /var/cache/apk/*

EXPOSE 5432
