DROP TABLE IF EXISTS MyPet;
 
CREATE TABLE IF NOT EXISTS CONTACT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  breed VARCHAR(250) NOT NULL,
  url_image VARCHAR(1000) NOT NULL
);
 
INSERT INTO contact (id, name, age, breed, url_image) VALUES
  (1, 'Juninho', 2, 'Labrador', 'https://www.clubeparacachorros.com.br/wp-content/uploads/2018/06/labrador-comportamento-1280x720.jpg'),
  (2, 'Pitter', 4, 'PitBull', 'https://www.petlove.com.br/images/breeds/193221/profile/original/pitbull-p.jpg?1532539293'),
  (3, 'Cacau', 1, 'Pastor Alemão', 'https://tudosobrecachorros.com.br/wp-content/uploads/pastor-alemao-01.jpg');