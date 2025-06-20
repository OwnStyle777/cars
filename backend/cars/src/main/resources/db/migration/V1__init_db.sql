CREATE TABLE IF NOT EXISTS brand(
id INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS car_type(
id INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS car_model(
id INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR(255) NOT NULL,
years_period VARCHAR(255) NOT NULL,
car_type_id INTEGER NOT NULL,
brand_id INTEGER NOT NULL,
generation_type VARCHAR(255) NOT NULL,
FOREIGN KEY (car_type_id) REFERENCES car_type(id),
FOREIGN KEY (brand_id) REFERENCES brand(id)

);

CREATE TABLE IF NOT EXISTS engine(
id INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR(255) NOT NULL,
type VARCHAR(255) NOT NULL,
horsepower INTEGER NOT NULL,
car_model_id INTEGER NOT NULL,
FOREIGN KEY (car_model_id) REFERENCES car_model(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS car(
id INTEGER PRIMARY KEY AUTOINCREMENT,
vin VARCHAR(255) NOT NULL UNIQUE,
color VARCHAR(255) NOT NULL,
mileage INTEGER,
car_model_id INTEGER NOT NULL,
year_manufacture INTEGER NOT NULL,
license_plate VARCHAR(255) NOT NULL UNIQUE,
FOREIGN KEY (car_model_id) REFERENCES car_model(id) ON DELETE CASCADE

);

