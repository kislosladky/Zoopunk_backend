ALTER TABLE users
    RENAME COLUMN nickname TO username;
ALTER TABLE users
    ADD COLUMN role TEXT,
    ADD COLUMN password TEXT,
    ADD COLUMN email TEXT;