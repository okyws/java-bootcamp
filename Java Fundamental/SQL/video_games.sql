--Script to create and populate the video games database

--Ensures & characters are not prompted when the script is run

--Create tables
CREATE TABLE platform (
	id SMALLINT PRIMARY KEY,
	platform_name VARCHAR(50)
);

CREATE TABLE genre (
	id SMALLINT PRIMARY KEY,
	genre_name VARCHAR(50)
);

CREATE TABLE publisher (
	id SMALLINT PRIMARY KEY,
	publisher_name VARCHAR(100)
);

CREATE TABLE region (
	id SMALLINT PRIMARY KEY,
	region_name VARCHAR(50)
);

CREATE TABLE game (
	id SMALLINT PRIMARY KEY,
	genre_id SMALLINT,
	game_name VARCHAR(200),
	CONSTRAINT fk_gm_gen FOREIGN KEY (genre_id) REFERENCES genre(id)
);

CREATE TABLE game_publisher (
	id SMALLINT PRIMARY KEY,
	game_id SMALLINT,
	publisher_id SMALLINT,
	CONSTRAINT fk_gpu_gam FOREIGN KEY (game_id) REFERENCES game(id),
	CONSTRAINT fk_gpu_pub FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);

CREATE TABLE game_platform (
	id SMALLINT PRIMARY KEY,
	game_publisher_id SMALLINT,
	platform_id SMALLINT,
	release_year SMALLINT,
	CONSTRAINT fk_gpl_gp FOREIGN KEY (game_publisher_id) REFERENCES game_publisher(id),
	CONSTRAINT fk_gpl_pla FOREIGN KEY (platform_id) REFERENCES platform(id)
);

CREATE TABLE region_sales (
	region_id SMALLINT,
	game_platform_id SMALLINT,
	num_sales NUMERIC(5, 2),
    CONSTRAINT fk_rs_gp FOREIGN KEY (game_platform_id) REFERENCES game_platform(id),
	CONSTRAINT fk_rs_reg FOREIGN KEY (region_id) REFERENCES region(id)
);

INSERT INTO genre (id, genre_name)
VALUES (1,'Action'),
(2,'Adventure'),
(3,'Fighting'),
(4,'Misc'),
(5,'Platform'),
(6,'Puzzle'),
(7,'Racing'),
(8,'Role-Playing'),
(9,'Shooter'),
(10,'Simulation'),
(11,'Sports'),
(12,'Strategy');

INSERT INTO platform (id, platform_name)
VALUES (1,'Wii'),
(2,'PS3'),
(3,'X360'),
(4,'DS'),
(5,'PSP');


INSERT INTO publisher (id, publisher_name)
VALUES (1,'Bandai Namco'),
(2,'Natsume'),
(3,'Take-Two'),
(4,'From-Software'),
(5,'D3 Publishers'),
(6,'Sony Interactive Entertainment'),
(7,'Activision'),
(8,'Bethesda'),
(9,'Criterion Games'),
(10,'Nintendo');

INSERT INTO region (id, region_name)
VALUES (1,'North America'),
(2,'Europe'),
(3,'Japan'),
(4,'Other');


INSERT INTO game (id, genre_id, game_name) VALUES (1,3,'Dragon Ball Z Tenkaichi Tag Team');
INSERT INTO game (id, genre_id, game_name) VALUES (2,3,'Street Fighters 4');
INSERT INTO game (id, genre_id, game_name) VALUES (3,7,'Need for Speed: Most Wanted (2012)');
INSERT INTO game (id, genre_id, game_name) VALUES (4,9,'GTA V');
INSERT INTO game (id, genre_id, game_name) VALUES (5,8,'TES V: Skyrim');
INSERT INTO game (id, genre_id, game_name) VALUES (6,9,'Call of Duty Modern Warfare');
INSERT INTO game (id, genre_id, game_name) VALUES (7,5,'NEW Super Mario.Bros');
INSERT INTO game (id, genre_id, game_name) VALUES (8,5,'Ben 10 Galactic Racing');
INSERT INTO game (id, genre_id, game_name) VALUES (9,2,'God of War Chain of Olympus');

INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (1,1,1);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (2,2,1);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (3,3,9);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (4,4,3);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (5,5,8);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (6,6,7);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (7,7,10);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (8,8,5);
INSERT INTO game_publisher (id, game_id, publisher_id) VALUES (9,9,6);

INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (1,1,5,2010);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (2,2,2,2008);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (3,3,2,2012);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (4,4,3,2013);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (5,5,2,2011);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (6,6,3,2007);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (7,7,4,2006);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (8,8,4,2011);
INSERT INTO game_platform (id, game_publisher_id, platform_id, release_year) VALUES (9,9,5,2008);

INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (1,1,3.50);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (3,2,1.43);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (2,3,8.51);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (1,4,15.27);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (1,5,11.48);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (2,6,10.34);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (3,7,9.99);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (1,8,2.36);
INSERT INTO region_sales (region_id, game_platform_id, num_sales) VALUES (1,9,12.17);
