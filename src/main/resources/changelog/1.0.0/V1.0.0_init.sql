--DROP SCHEMA IF EXISTS general CASCADE;

CREATE SCHEMA IF NOT EXISTS general;

--UTILS SCHEMA

CREATE TABLE general.bot_state
(
    id varchar NOT NULL,
    bot_state varchar NOT NULL,
    CONSTRAINT pk_bot_state
        PRIMARY KEY (id)
);



