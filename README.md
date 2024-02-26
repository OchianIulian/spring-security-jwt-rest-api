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
2. Spring Security: Aplicația utilizează Spring Security pentru gestionarea securității și a autentificării, asigurând protecția resurselor și a rutele API.
3. Diverse tipuri de utilizatori: Aplicația gestionează doi tipuri diferite de utilizatori, fiecare cu privilegii și acces specific la resursele API.
4. RESTful API: Interfețele de programare a aplicației sunt proiectate conform principiilor arhitecturii REST, oferind operații CRUD pentru resursele gestionate.
5. Documentație Swagger: Oferă documentație API generată automat cu ajutorul Swagger, pentru a facilita înțelegerea și utilizarea serviciilor expuse.
6. Testare unitară și integrată: Aplicația include suite de teste unitare și integrate pentru a asigura funcționalitatea corectă și stabilitatea sistemului.
7. Configurabil și extensibil: Componentele aplicației sunt configurabile și extensibile, permițând adaptarea la cerințe specifice ale proiectelor.


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
- `/endpoint1`: Description of what this endpoint does.
- `/endpoint2`: Description of what this endpoint does.
- ...

## Authentication
Explanation of how authentication works in the project, particularly focusing on JWT token authentication. Include details on how to obtain and use JWT tokens for authentication.

## Email Confirmation
Explanation of the email confirmation process, including how users can confirm their email addresses and the purpose of email confirmation in the project.

## Built With
- Java Spring Framework: Version X.X.X
- Other libraries or frameworks used in the project.

## Contributing
Guidelines for contributing to the project. Include information on how to report issues, submit feature requests, and contribute code.

## License
Information about the project's license. Specify the license type and provide a link to the full license text if applicable.
