CREATE TABLE aupair (
  aupair_id VARCHAR(50) PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(70) NOT NULL,
  date_of_birth DATE,
  email VARCHAR(60) UNIQUE NOT NULL,
  password VARCHAR(60) NOT NULL,
  picture VARCHAR(255),
  country_of_origin_id INTEGER REFERENCES country(id),  -- Foreign Key to country
  state_of_origin VARCHAR(255),
  city_of_origin VARCHAR(255),
  aupair_country_id INTEGER REFERENCES country(id),  -- Foreign Key to country
  aupair_city VARCHAR(255)
);
