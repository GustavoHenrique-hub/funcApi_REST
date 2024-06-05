FROM mysql:latest

# Variáveis de ambiente
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=funcdb

# Copia o script de migração para dentro do container
# (O MySQL executa automaticamente os scripts em /docker-entrypoint-initdb.d/)
COPY /src/main/resources/migrations/create_all.sql /docker-entrypoint-initdb.d/
