CREATE TABLE USERS (
        UUID              BIGINT PRIMARY KEY NOT NULL,
        FIRST_NAME      TEXT,
        LAST_NAME       TEXT,
        NICKNAME        TEXT,
        AGE             INTEGER,
        QUIZ_PROGRESS   JSON
);

CREATE TABLE ANIMALS (
        UUID              BIGINT PRIMARY KEY NOT NULL,
        SPECIES         TEXT,
        NAME            TEXT,
        DESCRIPTION     JSON
);

CREATE TABLE QUIZZES (
        UUID              BIGINT PRIMARY KEY NOT NULL,
        QUIZ_CONTENT    JSON
);