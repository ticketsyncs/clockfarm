-- liquibase formatted sql

-- changeset abialiauski:1
CREATE SCHEMA IF NOT EXISTS ticket_syncs;

-- changeset abialiauski:2
CREATE TABLE IF NOT EXISTS ticket_syncs.user_account
(
    id       BIGSERIAL PRIMARY KEY,
    username CHARACTER VARYING(32) UNIQUE NOT NULL,
    password CHARACTER VARYING(256)       NOT NULL
);

-- changeset abialiauski:3
CREATE TABLE IF NOT EXISTS ticket_syncs.jira_creds
(
    id      BIGSERIAL PRIMARY KEY,
    email   CHARACTER VARYING(128)                           NOT NULL,
    domain  CHARACTER VARYING(256)                           NOT NULL,
    token   CHARACTER VARYING(256)                           NOT NULL,
    user_id BIGINT REFERENCES ticket_syncs.user_account (id) NOT NULL
);

-- changeset abialiauski:4
CREATE TABLE IF NOT EXISTS ticket_syncs.github_creds
(
    id      BIGSERIAL PRIMARY KEY,
    url     CHARACTER VARYING(256)                           NOT NULL,
    token   CHARACTER VARYING(256)                           NOT NULL,
    user_id BIGINT REFERENCES ticket_syncs.user_account (id) NOT NULL
);

-- changeset abialiauski:5
CREATE TABLE IF NOT EXISTS ticket_syncs.harvest_creds
(
    id       BIGSERIAL PRIMARY KEY,
    url      CHARACTER VARYING(256),
    login    CHARACTER VARYING(64)  NOT NULL,
    password CHARACTER VARYING(256) NOT NULL,
    user_id  BIGINT REFERENCES ticket_syncs.user_account (id)
);