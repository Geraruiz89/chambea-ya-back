docker stop chambea-ya-back
docker rm chambea-ya-back

docker pull ghcr.io/geraruiz89/chambea-ya-back

docker run -d \
--name=chambea-ya-back \
--restart=unless-stopped \
-p8085:8080 \
ghcr.io/geraruiz89/chambea-ya-back
