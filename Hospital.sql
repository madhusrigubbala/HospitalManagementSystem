create database HospitalManagementSystem;
use HospitalManagementSystem;

create table doctors(
    id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255) NOT NULL
      );

create table patients(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) ,
    age INT,
    gender VARCHAR(255) 
      );
	create table IF NOT EXISTS appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL
);
CREATE TABLE ward (
    ward_id INT AUTO_INCREMENT PRIMARY KEY,
    ward_name VARCHAR(50) NOT NULL
);
INSERT INTO ward (ward_name) VALUES ('General Ward'), ('ICU');

CREATE TABLE beds (
    bed_id INT  PRIMARY KEY,
    ward_id INT,
    occupied BOOLEAN DEFAULT false,
    patient_id INT
);
INSERT INTO beds (bed_id,ward_id, occupied, patient_id) VALUES (12,1, false, NULL);
INSERT INTO beds (bed_id,ward_id, occupied, patient_id) VALUES (13,2, false, NULL);
INSERT INTO beds (bed_id,ward_id, occupied, patient_id) VALUES (14,3, false, NULL);
INSERT INTO beds (bed_id,ward_id, occupied, patient_id) VALUES (15,4, false, NULL);
INSERT INTO beds (bed_id,ward_id, occupied, patient_id) VALUES (16,5, false, NULL);


CREATE TABLE  medications (
    medication_id INT PRIMARY KEY,
    prescription_id INT,
    medication_name VARCHAR(255),
    quantity INT
);
INSERT INTO medications (medication_id, prescription_id, medication_name, quantity)
VALUES
    (1, 123, 'Paracetamol', 50),
    (2, 124, 'Aspirin', 30),
    (3, 125, 'Ibuprofen', 40);
CREATE TABLE inventory (
    medication_id INT PRIMARY KEY,
    quantity INT
);
INSERT INTO inventory (medication_id, quantity)
VALUES
    (1, 50),
    (2, 30),
    (3, 40);
CREATE TABLE lab_tests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    test_name VARCHAR(255),
    status VARCHAR(50),
    result TEXT
);
CREATE TABLE invoices (
    invoice_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    total_amount DOUBLE,
    paid BOOLEAN
);
CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT,
    amount DOUBLE,
    payment_date DATE
);
select * from patients;
select * from appointments;
select * from doctors;
select * from beds;
select * from ward;
select * from medications;
select * from inventory;
select * from lab_tests;
select * from invoices;
select * from payments;



