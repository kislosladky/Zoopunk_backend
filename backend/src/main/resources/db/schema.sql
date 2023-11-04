CREATE TABLE users (
        id              UUID PRIMARY KEY NOT NULL,
        firstName       TEXT,
        lastName        TEXT,
        nickname        TEXT,
        age             INTEGER,
        quizProgress    JSON
);

CREATE TABLE animals (
        id              UUID PRIMARY KEY NOT NULL,
        species         TEXT,
        name            TEXT,
        description     JSON
);

CREATE TABLE quizzes (
        id              UUID PRIMARY KEY NOT NULL,
        quizContent     JSON
);