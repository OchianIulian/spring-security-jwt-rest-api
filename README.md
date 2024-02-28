# spring-security-jwt-rest-api
Repository ul spring-security-jwt-rest-api contine un sistem de autentificare și un API pentru o aplicație web, implementat folosind JWT (JSON Web Tokens). Scopul principal al proiectului este de a oferi funcționalitate de autentificare securizată și scalabilă pentru utilizatori, utilizând tokenuri JWT pentru a gestiona sesiunile și autorizarea în aplicație.


## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Email Confirmation](#email-confirmation)
- [Built With](#built-with)
- [Contributing](#contributing)
- [License](#license)


## Features
1. Autentificare cu JWT: Utilizatorii sunt autentificați folosind JSON Web Tokens (JWT), un mecanism modern și sigur de autentificare stateless.
2. Confirmarea mailului prin trimiterea unui email cu un token de confirmare.
3. Spring Security: Aplicația utilizează Spring Security pentru gestionarea securității și a autentificării, asigurând protecția resurselor și a rutele API.
4. Diverse tipuri de utilizatori: Aplicația gestionează doi tipuri diferite de utilizatori, fiecare cu privilegii și acces specific la resursele API.
5. RESTful API: Interfețele de programare a aplicației sunt proiectate conform principiilor arhitecturii REST, oferind operații CRUD pentru resursele gestionate.
6. Configurabil și extensibil: Componentele aplicației sunt configurabile și extensibile, permițând adaptarea la cerințe specifice ale proiectelor.

### Todo:
Testare unitară și integrată: Aplicația include suite de teste unitare și integrate pentru a asigura funcționalitatea corectă și stabilitatea sistemului.


## Installation
To install and set up the project locally, follow these steps:

### Prerequisites
- Java Development Kit (JDK) 
- Apache Maven 
- MySQL (for database)

#### The project relies on the following dependencies, which will be automatically managed by Maven:

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL Driver
- JSON Web Token (JWT) Library
- Spring Mail (for email confirmation)

### Clone the repository:
Copy code
```
git clone https://github.com/OchianIulian/spring-security-jwt-rest-api.git
cd project-directory
```
### Create a database named jwt_security
``` 
CREATE DATABASE jwt_security;
```
### Open the project with your favorite IDEA and RUN

## Usage
To use the application, you can test the following endpoints in Postman or directly in your web browser.

Once the application is up and running, you can access it at http://localhost:8080.

## API Endpoints
List of available API endpoints with a brief description of each:
* Authentication endpoints:
  * Post
    - `/api/v1/auth/register`
    - `/api/v1/auth/authenticate`
  * Get  
    - `/api/v1/auth/confirm_email`
- Secured endpoints (after authentication):
  - Get
    - `/api/v1/demo-controller/hellomsg`
    - `/api/v1/demo-controller/current-user-details`
    - `/api/v1/demo-controller/current-email`
    - `/api/v1/demo-controller/is-locked`
    - `/api/v1/demo-controller/is-expired`
    - `/api/v1/demo-controller/is-enabled`
  - Delete
    - `/api/v1/demo-controller/delete`

  
## Authentication
  Authentication in the project relies on JWT token authentication. 
  Users obtain JWT tokens by logging in, which are then sent with requests
  to access protected endpoints. 
## Email Confirmation
  An email confirmation process is also
  implemented. Tokens expire and can be refreshed. This ensures secure and
  stateless authentication for users.

## Built With
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Web
- JWT API (io.jsonwebtoken:jjwt-api:0.11.5)
- JWT Implementation (io.jsonwebtoken:jjwt-impl:0.11.5)
- JWT Jackson (io.jsonwebtoken:jjwt-jackson:0.11.5)
- MySQL Connector (com.mysql:mysql-connector-j)
- Lombok (org.projectlombok:lombok)
- Spring Boot Starter Test
- Spring Security Test
- Spring Boot Starter Mail

## Authors
OchianIulian