

drop schema airplane2;
create schema airplane2;
use airplane2;
CREATE TABLE Customer (
  customer_id INT AUTO_INCREMENT NOT NULL,
  customer_name VARCHAR(255),
  customer_status VARCHAR(255),
  total_customer_mileage INT,
  PRIMARY KEY (customer_id)
);

CREATE TABLE flight (
  flight_id INT AUTO_INCREMENT NOT NULL,
  flight_number VARCHAR(255),
  aircraft VARCHAR(255),
  total_aircraft_seats INT,
  flight_mileage INT,
  PRIMARY KEY (flight_id)
);

CREATE TABLE flight_booking (
  booking_id INT AUTO_INCREMENT NOT NULL,
  customer_id INT,
  flight_id INT,
  PRIMARY KEY (booking_id),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
);


INSERT INTO Customer (customer_name, customer_status, total_customer_mileage) VALUES
('Agustine Riviera', 'Silver', 115235),
('Alaina Sepulvida', 'None', 6008),
('Tom Jones', 'Gold', 205767),
('Sam Rio', 'None', 2653),
('Jessica James', 'Silver', 127656),
('Ana Janco', 'Silver', 136773),
('Jennifer Cortez', 'Gold', 300582),
('Christian Janco', 'Silver', 14642);


INSERT INTO flight (flight_number, aircraft, total_aircraft_seats, flight_mileage) VALUES
('DL143', 'Boeing 747', 400, 135),
('DL122', 'Airbus A330', 236, 4370),
('DL53', 'Boeing 777', 264, 2078),
('DL222', 'Boeing 777', 264, 1765),
('DL37', 'Boeing 747', 400, 531);


INSERT INTO flight_booking (customer_id, flight_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(3, 3),
(4, 1),
(3, 4),
(5, 1),
(6, 4),
(7, 4),
(5, 2),
(4, 5),
(8, 4);



select * from customer;
select * from flight;
select * from flight_booking;







