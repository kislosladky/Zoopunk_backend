CREATE TABLE users (
        id              UUID PRIMARY KEY NOT NULL,
        firstname       TEXT,
        lastname        TEXT,
        nickname        TEXT,
        age             INTEGER,
        quizprogress    JSON
);

CREATE TABLE animals (
        id              UUID PRIMARY KEY NOT NULL,
        species         TEXT,
        name            TEXT,
        description     JSON
);

CREATE TABLE quizzes (
        id              UUID PRIMARY KEY NOT NULL,
        quizcontent     JSON
);