ALTER TABLE users
    RENAME COLUMN nickname TO username,
    ADD COLUMN role TEXT,
    ADD COLUMN password TEXT,
    ADD COLUMN email TEXT;