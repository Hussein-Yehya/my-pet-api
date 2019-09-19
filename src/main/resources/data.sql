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

INSERT INTO USERS (id, name, email, password) VALUES (1, 'Hussein', 'hussein@mypets.com.br', '123qwe');
 
INSERT INTO CONTATOS (id, name, age, breed, url_image, description) VALUES
  (1, 'Juninho', 2, 'Labrador', 'https://www.clubeparacachorros.com.br/wp-content/uploads/2018/06/labrador-comportamento-1280x720.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
  (2, 'Pitter', 4, 'PitBull', 'https://www.petlove.com.br/images/breeds/193221/profile/original/pitbull-p.jpg?1532539293', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
  (3, 'Cacau', 1, 'Pastor Alemão', 'https://tudosobrecachorros.com.br/wp-content/uploads/pastor-alemao-01.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');