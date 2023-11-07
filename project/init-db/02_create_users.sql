CREATE ROLE users_admin WITH LOGIN PASSWORD 'users_password';
CREATE ROLE activities_admin WITH LOGIN PASSWORD 'activities_password';
CREATE ROLE tasks_admin WITH LOGIN PASSWORD 'tasks_password';

GRANT ALL PRIVILEGES ON DATABASE users TO users_admin;
GRANT ALL PRIVILEGES ON DATABASE activities TO activities_admin;
GRANT ALL PRIVILEGES ON DATABASE tasks TO tasks_admin;
