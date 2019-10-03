DROP TABLE IF EXISTS MyPet;
 
CREATE TABLE IF NOT EXISTS CONTATOS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  breed VARCHAR(250) NOT NULL,
  url_image VARCHAR(1000) NOT NULL,
  description LONGTEXT
);
 
CREATE TABLE IF NOT EXISTS USERS (
	
	id int AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(250) NOT NULL,
	email VARCHAR(250) NOT NULL,
	password VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS ADDRESS (
	
	id int AUTO_INCREMENT PRIMARY KEY,
	street VARCHAR(250) NOT NULL,
	country VARCHAR(250) NOT NULL,
	district VARCHAR(250) NOT NULL,
	complements VARCHAR(250) NOT NULL,
	number VARCHAR(250) NOT NULL,
	state VARCHAR(250) NOT NULL,
	city VARCHAR(250) NOT NULL
);


INSERT INTO ADDRESS (id, street, country, district, complements, number, state, city) VALUES 
(1, 'Rua Augusta', 'Brasil', 'Jardins', 'Prédio', '1992', 'SP', 'São Paulo');

INSERT INTO USERS (id, name, email, password, user_type, address_id) VALUES 
(1, 'Hussein', 'hussein@mypets.com.br', '123qwe', 'ADMIN', 1);
 
INSERT INTO CONTATOS (id, name, age, breed, url_image, description, vaccinated, disease, pet_size, pet_recommended_to, coat_length, color, blood_type) 
VALUES
  (1, 'Juninho', 2, 'Labrador', 'https://www.clubeparacachorros.com.br/wp-content/uploads/2018/06/labrador-comportamento-1280x720.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',  true, false, 'XL', 'KIDS', 'MEDIUM', 'Black', 'DEA 1.1'),
  (2, 'Pitter', 4, 'PitBull', 'https://www.petlove.com.br/images/breeds/193221/profile/original/pitbull-p.jpg?1532539293', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',  true, false, 'XL', 'KIDS', 'MEDIUM', 'Black', 'DEA 1.1'),
  (3, 'Cacau', 1, 'Pastor Alemão', 'https://tudosobrecachorros.com.br/wp-content/uploads/pastor-alemao-01.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',  true, false, 'XL', 'KIDS', 'MEDIUM', 'Black', 'DEA 1.1');