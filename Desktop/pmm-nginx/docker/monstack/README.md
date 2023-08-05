Setup docker
```
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh
```

Copy pmm-data
```
docker create --volume /srv --name pmm-data percona/pmm-server:2 /bin/true
docker cp pmm-data:/srv/ ./pmm-server
```

docker-compose up -d

Change owner to root
```
docker-compose exec pmm-server bash -c "chown -R root:root /srv && chown -R pmm:pmm /srv/alertmanager && chown -R root:pmm /srv/clickhouse && chown -R grafana:grafana /srv/grafana && chown -R pmm:pmm /srv/logs && chown -R postgres:postgres /srv/postgres14 && chown -R pmm:pmm /srv/prometheus && chown -R pmm:pmm /srv/victoriametrics && chown -R postgres:postgres /srv/logs/postgresql14.log"
```

Set cert permission 
```
chmod -R 644 nginx/certs/.*.
```