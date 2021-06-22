FROM postgres:13.3-alpine
COPY psql_scripts/init-schema.sql /docker-entrypoint-initdb.d/
