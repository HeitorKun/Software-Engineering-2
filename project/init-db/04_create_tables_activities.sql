\c activities;
CREATE TABLE IF NOT EXISTS activities_table (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    state BOOLEAN NOT NULL DEFAULT FALSE,
    start_date TIMESTAMP WITHOUT TIME ZONE,
    end_date TIMESTAMP WITHOUT TIME ZONE,
    user_id INT 
);