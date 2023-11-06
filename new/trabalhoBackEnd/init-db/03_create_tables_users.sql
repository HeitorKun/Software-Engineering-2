\c users;
CREATE TABLE IF NOT EXISTS user_table (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);