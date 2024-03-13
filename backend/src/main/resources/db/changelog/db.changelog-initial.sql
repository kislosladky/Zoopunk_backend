--changeset me:id1

DROP TABLE IF EXISTS users;

CREATE TABLE users (
        id              UUID PRIMARY KEY NOT NULL,
        firstname       TEXT,
        lastname        TEXT,
        nickname        TEXT,
        age             INTEGER,
        image           TEXT
);

DROP TABLE IF EXISTS quizprogress;

CREATE TABLE quizprogress (
        userid          UUID,
        quizid          UUID,
        quizresult      INTEGER
);


DROP TABLE IF EXISTS animals;
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

DROP TABLE IF EXISTS quizzes;
CREATE TABLE quizzes (
        id              UUID PRIMARY KEY NOT NULL,
        achievementsid  UUID,
        quizcontent     JSON
);

DROP TABLE IF EXISTS achievements;
CREATE TABLE achievements (
    userid              UUID,
    id                  UUID,
    title               TEXT,
    description         TEXT,
    pointsfordone       INTEGER,
    done                INTEGER
);