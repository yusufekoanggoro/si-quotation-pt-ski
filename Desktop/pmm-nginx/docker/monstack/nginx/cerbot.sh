#!/bin/sh
docker-compose exec -T letsencrypt \
  sh -c "export PATH=$PATH:/usr/local/bin && \
         certbot renew --webroot -w /usr/share/nginx/html --quiet && \
         docker kill -s HUP nginx"
