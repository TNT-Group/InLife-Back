DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS chats;

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

CREATE TABLE IF NOT EXISTS messages (
    id bigserial NOT NULL,
    message varchar(255) NOT NULL,
    user_id BIGINT NOT NULL,
    chat_id BIGINT NOT NULL,
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE NOT NULL,
    status varchar(20) NOT NULL DEFAULT 'ACTIVE',
    CONSTRAINT messages_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS chats (
    id bigserial NOT NULL,
    first_user_id BIGINT NOT NULL,
    second_user_id BIGINT NOT NULL,
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE NOT NULL,
    status varchar(20) NOT NULL DEFAULT 'ACTIVE',
    CONSTRAINT chats_pkey PRIMARY KEY (id)
);