# Golf Club Tournament & Membership API

This is a Spring Boot application for managing a golf club's members and tournaments. It supports creating, reading, updating, and deleting both members and tournaments, as well as associating members with specific tournaments. Integrated with a MySQL database and includes Docker support.

---

## Project Overview

- Built with Spring Boot
- RESTful API for Members and Tournaments
- MySQL database integration
- Docker support for running the app in a container
- Postman for testing

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Postman

---

##  Getting Started

### Prerequisites

- Java 21+
- MySQL installed and running on `localhost:3306`
- Maven
- Docker

---

## Database Setup

1. Open MySQL Workbench or your terminal
2. Create the database:

```sql
CREATE DATABASE GolfClub2025;

```
___

## Run Springboot Application

## Running with Docker

docker build -t golfclub2025 .
docker-compose up

---
# API Testing (Postman)

## Member Endpoints

### Create a member

POST http://localhost:8080/member

```
{
  "name": "John Doe",
  "address": "123 Golf Lane",
  "email": "john@example.com",
  "phoneNumber": "123-456-7890",
  "startDate": "2025-01-01",
  "membershipDuration": 12
}
```
### Get All Members

GET http://localhost:8080/member

### Get Member by ID

GET http://localhost:8080/member/1

### Update Member

PUT http://localhost:8080/member/1

### Delete Member

DELETE http://localhost:8080/member/1

---

## Tournament Endpoints
# Create a Tournament

POST http://localhost:8080/tournaments

```
{
  "startDate": "2025-07-01",
  "endDate": "2025-07-03",
  "location": "Golf Tourny 2025",
  "entryFee": 200.0,
  "cashPrize": 5000.0
}
```

### Get All Tournaments

GET http://localhost:8080/tournaments

### Get Tournament by ID

GET http://localhost:8080/tournaments/1

### Update Tournament

PUT http://localhost:8080/tournaments/1

### Delete Tournament

DELETE http://localhost:8080/tournaments/1

### Add Member to Tournament
PUT http://localhost:8080/tournaments/1/addMember/1

This will add the member with ID 1 to the tournament with ID 1

