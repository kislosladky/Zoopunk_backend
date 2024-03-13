ALTER TABLE achievements
DROP COLUMN userid, DROP COLUMN done;

DROP TABLE IF EXISTS achievementsprogress;
CREATE TABLE achievementsprogress (
    userid              UUID,
    id                  UUID
);