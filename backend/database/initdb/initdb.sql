CREATE TABLE USERS (
    ID BIGINT           PRIMARY KEY NOT NULL,
    FIRST_NAME          TEXT,
    LAST_NAME           TEXT,
    NICKNAME            TEXT,
    AGE                 INTEGER,
    QUIZ_PROGRESS       JSON
);

CREATE TABLE ANIMALS (
      ID BIGINT         PRIMARY KEY NOT NULL,
      SPECIES           TEXT,
      NAME              TEXT,
      DESCRIPTION       JSON
);