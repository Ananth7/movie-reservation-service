CREATE DATABASE demo1;

USE demo1;

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY '' WITH GRANT OPTION;

CREATE TABLE users (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`name` varchar(250) NOT NULL,
`email` varchar(70) NOT NULL,
`phone_number` varchar(70) NULL ,
`is_admin` boolean DEFAULT 0,
 PRIMARY KEY (`id`),
 UNIQUE KEY (`uuid`),
 UNIQUE KEY `uk_users_email`(`email`),
 UNIQUE KEY `uk_users_phone_number` (`phone_number`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE cities (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`name` varchar(250) NOT NULL,
 PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uuid`(`uuid`),
 UNIQUE KEY `uk_cities_name`(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE cinemas (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`name` varchar(250) NOT NULL,
`city_id` varchar(40) NOT NULL,
`seats` bigint(10) NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `uk_uuid`(`uuid`),
 UNIQUE KEY `uk_cinemas_name_city_id`(`name`,`city_id`),
  CONSTRAINT `fk_cinemas_city_id` FOREIGN KEY (`city_id`) REFERENCES `cities` (`uuid`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE movies (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`name` varchar(250) NOT NULL,
`duration` bigint(19) NOT NULL,
`genre` varchar(250) NULL ,
`rating` varchar(10) NOT NULL,
`poster_url` varchar(250) NULL ,
`trailer_url` varchar(250) NULL ,
`plot` varchar(2500) NOT NULL ,
 PRIMARY KEY (`id`),
 UNIQUE KEY `uk_uuid`(`uuid`),
 UNIQUE KEY `uk_movies_name`(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE shows (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`movie_id` varchar(40) NOT NULL,
`cinema_id` varchar(40) NOT NULL,
`start_time` DATETIME NOT NULL,
`end_time` DATETIME NOT NULL,
`show_date` DATETIME NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `uk_uuid`(`uuid`),
 CONSTRAINT `fk_shows_cinema_id` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`uuid`) ON DELETE CASCADE,
 CONSTRAINT `fk_shows_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`uuid`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


create table booking (
    `id` bigint(19) NOT NULL AUTO_INCREMENT,
    `booking_id` varchar(40) NOT NULL,
    `user_id` varchar(40) NOT NULL,
    `status` varchar(40) NOT NULL,
     PRIMARY KEY (`id`),
     UNIQUE KEY `uk_bookingid`(`booking_id`),
     CONSTRAINT `fk_booking_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`uuid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE booked_seats (
    `id` bigint(19) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(40) NOT NULL,
    `show_id` varchar(40) NOT NULL,
    `seat_number` varchar(4) NOT NULL,
    `booking_id` varchar(40) NULL,
 PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uuid`(`uuid`),
  UNIQUE KEY `uk_booked_seats_show_id_seat_number`(`show_id`, `seat_number`),
  CONSTRAINT `fk_booked_seats_show_id` FOREIGN KEY (`show_id`) REFERENCES `shows` (`uuid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE cinema_ownership (
    `id` bigint(19) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(40) NOT NULL,
    `cinema_id` varchar(40) NOT NULL,
    `user_id` varchar(40) NOT NULL,
     PRIMARY KEY (`id`),
      UNIQUE KEY `uk_uuid`(`uuid`),
     CONSTRAINT `fk_cinema_ownership_cinema_id` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`uuid`) ON DELETE CASCADE,
     CONSTRAINT `fk_cinema_ownership_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`uuid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/users.csv' INTO TABLE  users FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;  
LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/cities.csv' INTO TABLE  cities FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS; 
LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/cinemas.csv'  INTO TABLE cinemas FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS; 
LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/movies.csv' INTO TABLE movies FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS; 
LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/shows.csv' INTO TABLE shows FIELDS TERMINATED BY ',' ENCLOSED BY '"'LINES TERMINATED BY '\n' IGNORE 1 ROWS; 
LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/booking.csv' INTO TABLE booking FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS; 
LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/booked_seats.csv' INTO TABLE booked_seats FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS; 
LOAD DATA LOCAL INFILE '/Users/anantrao/Documents/demo/cinema_ownership.csv' INTO TABLE cinema_ownership FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS; 
