CREATE TABLE gift (
id bigint PRIMARY KEY,
name varchar(100) NOT NULL,
width real NOT NULL CHECK (width > 0),
height real NOT NULL CHECK (height > 0),
weight real NOT NULL CHECK (width > 0),
price real NOT NULL CHECK (price > 0)
);

CREATE TABLE box (
id bigint PRIMARY KEY,
address varchar(100) NOT NULL,
gift_id bigint NOT NULL,

CONSTRAINT fk_gift FOREIGN KEY (gift_id)
REFERENCES gift (id)
);

INSERT INTO gift VALUES (0, 'Videogame', 	0.1, 0.1, 	0.2, 40);
INSERT INTO gift VALUES (1, 'Xbox One', 	0.5, 0.5,	2.8, 499);
INSERT INTO gift VALUES (2, 'Toy car', 		0.1, 0.1,	0.3, 20);
INSERT INTO gift VALUES (3, 'Toy snake', 	0.1, 0.1,	0.1, 3);
INSERT INTO gift VALUES (4, 'Lolly bomb', 	10.0, 10.0,	500, 9999);

INSERT INTO box VALUES (0, 'Samara', 0);
INSERT INTO box VALUES (1, 'Moscow', 1);
INSERT INTO box VALUES (2, 'St. Petesburg', 2);
INSERT INTO box VALUES (3, 'London', 3);
INSERT INTO box VALUES (4, 'Habarovsk', 0);
INSERT INTO box VALUES (5, 'Moscow', 1);
INSERT INTO box VALUES (6, 'Berlin', 4);