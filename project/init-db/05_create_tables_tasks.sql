\c tasks;
CREATE TABLE IF NOT EXISTS tasks_table (
    id SERIAL PRIMARY KEY,
    subject VARCHAR(255) NOT NULL,
    detailed_description TEXT,
    priority VARCHAR(50) CHECK (priority IN ('Low', 'Normal', 'High')) NOT NULL,
    start_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_date TIMESTAMP WITHOUT TIME ZONE,
    estimated_hours INT,
    actual_hours INT,
    activity_id INT
);