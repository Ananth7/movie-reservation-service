CREATE DATABASE demo;

USE demo;

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY '' WITH GRANT OPTION;

CREATE TABLE users (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`name` varchar(250) NOT NULL,
`email` varchar(70) NOT NULL,
`phone_number` varchar(70) NULL ,
`is_admin` boolean DEFAULT 0,
 PRIMARY KEY (`id`),
 UNIQUE KEY `uk_users_email`(`email`),
 UNIQUE KEY `uk_users_phone_number` (`phone_number`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE cities (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`name` varchar(250) NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `uk_cities_name`(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE cinemas (
`id` bigint(19) NOT NULL AUTO_INCREMENT,
`uuid` varchar(40) NOT NULL,
`name` varchar(250) NOT NULL,
`city_id` varchar(40) NOT NULL,
`seats` bigint(10) NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `uk_cinemas_name_city_id`(`name`,`city_id`)
 -- CONSTRAINT `fk_cinemas_city_id` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`) ON DELETE CASCADE
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
 PRIMARY KEY (`id`)
 -- UNIQUE KEY `uk_shows_cinema_id_movie_id`(`cinema_id`,`movie_id`)
 -- CONSTRAINT `fk_shows_cinema_id` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`) ON DELETE CASCADE,
 -- CONSTRAINT `fk_shows_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE booked_seats (
    `id` bigint(19) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(40) NOT NULL,
    `show_id` bigint(19) NOT NULL,
    `seat_number` varchar(40) NOT NULL,
    `status` varchar(250) NULL,
 PRIMARY KEY (`id`),
 CONSTRAINT `fk_booked_seats_show_id` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON DELETE CASCADE
);

CREATE TABLE cinema_ownership (
    `id` bigint(19) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(40) NOT NULL,
    `cinema_id` varchar(40) NOT NULL,
    `user_id` varchar(40) NOT NULL,
     PRIMARY KEY (`id`)
    -- CONSTRAINT `fk_cinema_ownership_cinema_id` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`) ON DELETE CASCADE,
    -- CONSTRAINT `fk_cinema_ownership_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);