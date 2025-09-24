# USER MANAGEMENT SYSTEM
A complete **User Management System** built with **JAVA EE (JAX-RS)**, **TOMCAT 11**, and **POSTGRESQL**. It uses **DOCKER COMPOSE** for database + pgAdmin, and provides REST APIs for full CRUD operations.

## PREREQUISITES
- Install **OPENJDK 21**
- Install **APACHE TOMCAT 11**
- Install **DOCKER & DOCKER COMPOSE**

## SETUP INSTRUCTIONS
docker compose up -d
PGADMIN → http://localhost:5050  
Username: sami.cse.1112@gmail.com  
Password: admin123  
Run SQL from db.txt (included below).  
Default login: admin@example.com / admin123

## DOCKER-COMPOSE.YAML

## DATABASE INITIALIZATION (db.txt)
CREATE TABLE users (
id SERIAL PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(150) UNIQUE NOT NULL,
password VARCHAR(150) NOT NULL
);
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Admin', 'User', 'admin@example.com', 'admin123');

## PROJECT STRUCTURE
project-root/
│── src/                  
│── db.txt                
│── docker-compose.yaml   
│── README.md

## API ENDPOINTS
Base URL → http://localhost:7000/action/users

### GET ALL USERS
curl -X GET http://localhost:7000/action/users -H "Accept: application/json"
RESPONSE:
[
{"id":1,"firstName":"Samiul","lastName":"Arafin","email":"sami.arafin@gmail.com","password":"sami123"}
]

### CREATE A NEW USER
curl -X POST http://localhost:7000/action/users \
-H "Content-Type: application/json" \
-d '{"firstName":"Samiul","lastName":"Arafin","email":"sami.arafin@gmail.com","password":"sami123"}'
RESPONSE:
{"id":2,"firstName":"Samiul","lastName":"Arafin","email":"sami.arafin@gmail.com","message":"User created successfully"}

### UPDATE A USER
curl -X PUT http://localhost:7000/action/users/2 \
-H "Content-Type: application/json" \
-d '{"firstName":"MdSamiul","lastName":"Arafinn","email":"arafin@gmail.com","password":"newpassword123"}'
RESPONSE:
{"id":2,"firstName":"MdSamiul","lastName":"Arafinn","email":"arafin@gmail.com","message":"User updated successfully"}

### DELETE A USER
curl -X DELETE http://localhost:7000/action/users/2
RESPONSE:
{"message":"User deleted successfully"}

### TEST ECHO ENDPOINT
curl -X GET http://localhost:7000/action/users/echo/123 -H "Accept: application/json"
RESPONSE:
{"echo":"123"}

## SUMMARY
✔️ Run with DOCKER COMPOSE  
✔️ Manage DB with PGADMIN  
✔️ Default login → admin@example.com / admin123  
✔️ CRUD APIs + Echo endpoint  
✔️ Database schema included inside README  
