DROP TABLE IF EXISTS pan_info;
DROP TABLE IF EXISTS black_list_pan;

CREATE TABLE pan_info (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  card_number VARCHAR(19) NOT NULL
);

CREATE TABLE black_list_pan (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  pan_info_id INT NOT NULL,
  trans_status CHAR(1) NOT NULL
);