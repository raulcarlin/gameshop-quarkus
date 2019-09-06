docker run --name mariaDB -v ~/Development/db/mariadb:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mariadb

sh gradlew quarkusDev