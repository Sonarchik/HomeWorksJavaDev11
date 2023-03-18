CREATE table  Client(
    id IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL,
    CONSTRAINT Ck_NAME_CLIENT_Length
    CHECK(char_length(NAME) >= 3 AND char_length(NAME) <= 200)
);

CREATE table Planet(
    id VARCHAR(50) PRIMARY KEY CHECK (id REGEXP '^[A-Z0-9]+$'),
    name VARCHAR NOT NULL,
    CONSTRAINT Ck_NAME_PLANET_Length
    CHECK(char_length(NAME) >= 1 AND char_length(NAME) <= 500)
);

CREATE TABLE Ticket (
    id IDENTITY PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    client_id INT NOT NULL,
    from_planet_id VARCHAR(50) NOT NULL,
    to_planet_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES Client(id) ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES Planet(id) ON DELETE CASCADE ,
    FOREIGN KEY (to_planet_id) REFERENCES Planet(id) ON DELETE CASCADE
);
