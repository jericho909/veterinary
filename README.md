# Veterinary Management System

Welcome to the Veterinary Management System project! This project aims to provide a comprehensive API for managing a veterinary clinic's operations. Developed using Java Spring Boot, the system offers functionalities for registering veterinary doctors, managing appointments, recording vaccinations, and more.

## Features

### 1. Management of Animals and Customers

-   Create, read, update, and delete operations for animals and customers.
-   Endpoints for filtering animals and customers by name.

### 2. Management of Administered Vaccines

-   Record vaccines administered to animals with their start and end dates of protection.
-   Validation to prevent adding a new vaccine if the same type of vaccine has not reached its protection end date yet.
-   Endpoint to list all vaccine records for a specific animal based on its ID.
-   Endpoint to list animals whose vaccine protection end date is approaching within a specified date range.

### 3. Appointment Management

-   Schedule appointments for vaccinations and examinations, specifying both the date and time.
-   Validation to check the availability of doctors on the specified date and time during appointment creation.
-   CRUD operations for managing appointments, including updating, viewing, and deleting.
-   Endpoints to filter appointments by date range and doctor or by date range and animal.

### 4. Management of Veterinary Doctors

-   Register, update, view, and delete veterinary doctors.
-   CRUD operations for managing doctors' available dates.


## Technologies Used

-   Java Spring Boot
-   Spring Web
-   Spring Data JPA
-   PostgreSQL or MySQL

## Getting Started

1.  Clone the repository to your local machine.
2.  Configure your database settings in the application.properties file.
3.  Run the application and navigate to the provided API documentation to explore the endpoints.