CREATE DATABASE CASESTUDY;

\c casestudy


CREATE TABLE IF NOT EXISTS PROJECT(
    HASH        INT     NOT NULL,
    ID          INT     NOT NULL,
    NAME        TEXT    NOT NULL, 
    DESCRIPTION TEXT    NULL,

    PRIMARY KEY(ID),
    UNIQUE(NAME)
    );

CREATE TABLE IF NOT EXISTS USERS(
    HASH        INT         NOT NULL,
    FIRST_NAME  TEXT        NOT NULL, 
    LAST_NAME   TEXT        NOT NULL, 
    ROLE        TEXT        NOT NULL, 
    SALT        BYTEA     NOT NULL, 
    PASSWORD    BYTEA    NOT NULL, 
    LOGIN_NAME  TEXT        NOT NULL, 
    EMAIL       TEXT        NOT NULL, 

    PRIMARY KEY(LOGIN_NAME), 
    CHECK(ROLE IN ('ADMIN', 'USER'))
    );

CREATE TABLE IF NOT EXISTS PROJECT_MEMBERS(
    HASH                INT     NOT NULL,
    USER_LOGIN_NAME     TEXT    NOT NULL, 
    PROJECT_ID        INT    NOT NULL, 
    ROLE                TEXT    NOT NULL,

    PRIMARY KEY(USER_LOGIN_NAME, PROJECT_ID), 
    FOREIGN KEY(USER_LOGIN_NAME)    REFERENCES USERS(LOGIN_NAME),
    FOREIGN KEY(PROJECT_ID) REFERENCES PROJECT(ID),
    CHECK(ROLE IN ('MEMBER', 'LEADER'))
    );

CREATE TABLE IF NOT EXISTS PROJECT_PHASES(
    HASH            INT     NOT NULL,
    ID              INT     NOT NULL,
    PROJECT_ID    INT    NOT NULL, 
    NAME            TEXT    NOT NULL, 

    PRIMARY KEY(ID),
    UNIQUE(PROJECT_ID, NAME),
    FOREIGN KEY(PROJECT_ID) REFERENCES PROJECT(ID)
    );

CREATE TABLE IF NOT EXISTS ACTIVITY(
    HASH            INT         NOT NULL,
    ID              SERIAL      NOT NULL, 
    PROJECT_PHASE_ID INT        NOT NULL,
    PROJECT_ID      INT         NOT NULL,
    USER_LOGIN_NAME TEXT        NOT NULL,
    DESCRIPTION     TEXT        NOT NULL, 
    START_TIME      TIMESTAMP   NOT NULL, 
    END_TIME        TIMESTAMP   NOT NULL, 
    COMMENTS        TEXT        NULL, 

    PRIMARY KEY(ID),
    FOREIGN KEY(PROJECT_ID, USER_LOGIN_NAME) REFERENCES PROJECT_MEMBERS(PROJECT_ID, USER_LOGIN_NAME),
    FOREIGN KEY(PROJECT_ID, PROJECT_PHASE_ID) REFERENCES PROJECT_PHASES(PROJECT_ID, ID)
    );

