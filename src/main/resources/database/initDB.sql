DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
	id bigserial NOT NULL,
	username varchar(50) NOT NULL,
	"password" varchar(255) NOT NULL,
	email varchar(255) NOT NULL UNIQUE,
	role_name varchar(20) NOT NULL DEFAULT 'USER',
	status varchar(20) NOT NULL DEFAULT 'ACTIVE',
	first_name varchar(50),
	last_name varchar(100),
	CONSTRAINT users_pkey PRIMARY KEY (id)
);