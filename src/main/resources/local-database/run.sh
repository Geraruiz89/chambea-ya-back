RUTA=/Users/garellano/Desktop/development/desarrollo-ejercicio/src/main/resources/local-database
 
docker run -d \
-p 3307:3306 \
--name data \
-v $RUTA/data:/var/lib/mysql \
-v $RUTA/scripts:/scripts \
-e MYSQL_ROOT_PASSWORD=garellano \
mariadb

