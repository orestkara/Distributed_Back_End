DROP DATABASE leaseholds;
CREATE DATABASE leaseholds;
\c leaseholds

DROP TABLE authorities CASCADE;
DROP TABLE users CASCADE;
DROP TABLE house CASCADE;
DROP TABLE contract CASCADE;
DROP TABLE "user" CASCADE;



CREATE TABLE IF NOT EXISTS "user"(
                                     tin VARCHAR(9) NOT NULL UNIQUE,
                                     first_name VARCHAR(50),
                                     last_name VARCHAR(50),
                                     email VARCHAR(50) NOT NULL,
                                     username VARCHAR(50) NOT NULL,
                                     "password" VARCHAR(80) NOT NULL,
                                     "enabled" BOOLEAN NOT NULL,
                                     phone_number VARCHAR(10),
                                     CONSTRAINT pk_user PRIMARY KEY (username)

);


CREATE TABLE IF NOT EXISTS house(
                                    house_id INTEGER NOT NULL,
                                    house_description VARCHAR(255),
                                    rent_details VARCHAR(255),
                                    id_electricity VARCHAR(15) NOT NULL UNIQUE,
                                    house_size INTEGER,
                                    bedrooms INTEGER,
                                    owner_tin VARCHAR(9) NOT NULL,
                                    CONSTRAINT pk_house PRIMARY KEY (house_id),
                                    CONSTRAINT  tin  FOREIGN KEY(owner_tin) REFERENCES "user"(tin)

);


CREATE TABLE IF NOT EXISTS Contract(
                                       contract_id INTEGER NOT NULL,
                                       submission_date VARCHAR(20),
                                       tenant_name VARCHAR(100),
                                       tenant_tin VARCHAR(9) NOT NULL,
                                       email VARCHAR(50) NOT NULL,
                                       phone_number VARCHAR(10),
                                       electricity_id VARCHAR(15) NOT NULL UNIQUE,
                                       special_terms VARCHAR(255),
                                       rental_period VARCHAR(21),
                                       approved INTEGER NOT NULL,
                                       payment INTEGER,
                                       CONSTRAINT pk_contract PRIMARY KEY (contract_id),
                                       CONSTRAINT  fk_contract1  FOREIGN KEY(tenant_tin) REFERENCES "user"(tin),
                                       CONSTRAINT  fk_contract2  FOREIGN KEY(electricity_id) REFERENCES House(id_electricity)

);

CREATE TABLE IF NOT EXISTS users (
                                     username VARCHAR(50) NOT NULL,
                                     "password" VARCHAR(80) NOT NULL,
                                     "enabled" BOOLEAN NOT NULL,
                                     PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS authorities(
                                          username varchar(50) NOT NULL,
                                          authority varchar(50) NOT NULL,
                                          UNIQUE (username, authority),
                                          PRIMARY KEY (username),
                                          CONSTRAINT fk_authorities1 FOREIGN KEY (username) REFERENCES users (username),
                                          CONSTRAINT fk_authorities2 FOREIGN KEY (username) REFERENCES "user" (username)
);

