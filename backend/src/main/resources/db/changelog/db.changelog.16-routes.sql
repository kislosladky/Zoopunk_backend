CREATE TABLE routes (
    id              UUID PRIMARY KEY NOT NULL,
    name            TEXT,
    description     TEXT
    waypoints       JSON
);

INSERT INTO routes (id, name, description, waypoints)
    VALUES ('881d3e79-490a-4115-ad7b-8ff2ba47ef4b', 'Зоопарк за час', 'Подойдет, если пришел немного погулять',
    '[{"coordinates": {"latitude": 55.05602, "longitude": 82.88658}, "id": "8a63ea8b-e23a-46a6-ed16-e6fab9e71c54", "name": "Герой"},{"coordinates": {"latitude": 55.05625, "longitude": 82.88534}, "id": "8a537a87-6a3a-4ba1-ad16-e8fab9871c54", "name": "Каркуша"},{"coordinates": {"latitude": 55.05501, "longitude": 82.88083}, "id": "85557a87-6a2a-4ba1-ad16-e8f9b9871c54", "name": "Хью Джекман"},{"coordinates": {"latitude": 55.05574, "longitude": 82.87795}, "id": "8a537a8b-623a-4ba1-ed16-e8fab9e71c54", "name": "Бима"},{"coordinates": {"latitude": 55.05639, "longitude": 82.87997}, "id": "8a63ea81-1231-16a6-ed16-e6fab9e71c54", "name": "Курва"},{"coordinates": {"latitude": 55.05668, "longitude": 82.88854},}]');