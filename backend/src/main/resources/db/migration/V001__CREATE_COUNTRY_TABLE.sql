CREATE TABLE country (
  country_id bigint PRIMARY KEY NOT NULL,
  iso char(2) NOT NULL,
  name varchar(80) NOT NULL,
  nice_name varchar(80) NOT NULL,
  iso3 char(3) DEFAULT NULL,
  num_code int(6) DEFAULT NULL,
  phone_code int(5) NOT NULL
);