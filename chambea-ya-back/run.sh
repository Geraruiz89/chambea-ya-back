docker stop segundo-examen
docker rm segundo-examen

docker pull ghcr.io/geraruiz89/chambea-ya-back

docker run -d \
--name=chambea-ya-back \
--restart=unless-stopped \
-p9090:8080 \
ghcr.io/geraruiz89/chambea-ya-back
