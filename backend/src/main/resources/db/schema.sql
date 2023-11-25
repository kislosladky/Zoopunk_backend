CREATE TABLE users (
        id              UUID PRIMARY KEY NOT NULL,
        firstname       TEXT,
        lastname        TEXT,
        nickname        TEXT,
        age             INTEGER,
        image           TEXT
);

CREATE TABLE quizprogress (
        userid          UUID,
        quizid          UUID,
        quizresult      INTEGER
);

CREATE TABLE animals (
        id              UUID PRIMARY KEY NOT NULL,
        name            TEXT,
        animalclass     TEXT,
        family          TEXT,
        species         TEXT,
        description     JSON,
        imgpath         TEXT,
        background      TEXT
);

CREATE TABLE quizzes (
        id              UUID PRIMARY KEY NOT NULL,
        achievementsid  UUID,
        quizcontent     JSON
);

CREATE TABLE achievements (
    userid              UUID,
    id                  UUID,
    title               TEXT,
    description         TEXT,
    pointsfordone       INTEGER,
    done                INTEGER
);