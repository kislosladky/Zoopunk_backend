--changeset me:id1
DROP TABLE users;
CREATE TABLE users (
        id              UUID PRIMARY KEY NOT NULL,
        firstname       TEXT,
        lastname        TEXT,
        nickname        TEXT,
        age             INTEGER,
        image           TEXT
);

DROP TABLE quizprogress;
CREATE TABLE quizprogress (
        userid          UUID,
        quizid          UUID,
        quizresult      INTEGER
);

DROP TABLE animals;
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

DROP TABLE quizzes;
CREATE TABLE quizzes (
        id              UUID PRIMARY KEY NOT NULL,
        achievementsid  UUID,
        quizcontent     JSON
);

DROP TABLE achievements;
CREATE TABLE achievements (
    userid              UUID,
    id                  UUID,
    title               TEXT,
    description         TEXT,
    pointsfordone       INTEGER,
    done                INTEGER
);