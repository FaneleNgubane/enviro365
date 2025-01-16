# Enviro365 Waste Sorting API

Enviro365 is a Spring Boot application that provides REST APIs for managing waste categories, disposal guidelines, and recycling tips. The application is designed to help users sort waste effectively and promote recycling.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
    - [Running Locally](#running-locally)
    - [Running with Docker](#running-with-docker)
- [API Endpoints](#api-endpoints)
  - [Waste Categories](#waste-categories)
  - [Disposal Guidelines](#disposal-guidelines)
  - [Recycling Tips](#recycling-tips)
- [Error Handling](#error-handling)
- [API Documentation](#api-documentation)
- [Running Tests](#running-tests)
- [CI/CD Pipeline](#cicd-pipeline)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Waste Categories**: Create, retrieve, update, and delete waste categories.
- **Disposal Guidelines**: Create, retrieve, update, and delete disposal guidelines.
- **Recycling Tips**: Create, retrieve, update, and delete recycling tips.
- **Error Handling**: Comprehensive error handling for runtime exceptions and validation errors.
- **API Documentation**: Swagger/OpenAPI documentation for easy integration.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Docker (for running with Docker)

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/enviro365.git
    cd enviro365
    ```

2. Build the project:
    ```sh
    mvn clean package
    ```

### Running the Application

#### Running Locally

1. Run the application:
    ```sh
    mvn spring-boot:run
    ```

2. Access the application at [http://localhost:8080](http://localhost:8080).

#### Running with Docker

1. Build the Docker image:
    ```sh
    docker build -t enviro365:latest .
    ```

2. Run the Docker container:
    ```sh
    docker run -p 8080:8080 enviro365:latest
    ```

3. Access the application at [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Waste Categories

- **Create Waste Category**
    ```http
    POST /api/waste-categories
    ```
    Request Body:
    ```json
    {
        "name": "Plastic",
        "description": "Plastic waste"
    }
    ```

- **Retrieve All Waste Categories**
    ```http
    GET /api/waste-categories
    ```

- **Retrieve Waste Category by ID**
    ```http
    GET /api/waste-categories/{id}
    ```

- **Update Waste Category**
    ```http
    PUT /api/waste-categories/{id}
    ```
    Request Body:
    ```json
    {
        "name": "Updated Plastic",
        "description": "Updated description"
    }
    ```

- **Delete Waste Category**
    ```http
    DELETE /api/waste-categories/{id}
    ```

### Disposal Guidelines

- **Create Disposal Guideline**
    ```http
    POST /api/disposal-guidelines
    ```
    Request Body:
    ```json
    {
        "guideline": "Dispose of plastic in the blue bin."
    }
    ```

- **Retrieve All Disposal Guidelines**
    ```http
    GET /api/disposal-guidelines
    ```

- **Retrieve Disposal Guideline by ID**
    ```http
    GET /api/disposal-guidelines/{id}
    ```

- **Update Disposal Guideline**
    ```http
    PUT /api/disposal-guidelines/{id}
    ```
    Request Body:
    ```json
    {
        "guideline": "Updated guideline"
    }
    ```

- **Delete Disposal Guideline**
    ```http
    DELETE /api/disposal-guidelines/{id}
    ```

### Recycling Tips

- **Create Recycling Tip**
    ```http
    POST /api/recycling-tips
    ```
    Request Body:
    ```json
    {
        "tip": "Rinse plastic containers before recycling."
    }
    ```

- **Retrieve All Recycling Tips**
    ```http
    GET /api/recycling-tips
    ```

- **Retrieve Recycling Tip by ID**
    ```http
    GET /api/recycling-tips/{id}
    ```

- **Update Recycling Tip**
    ```http
    PUT /api/recycling-tips/{id}
    ```
    Request Body:
    ```json
    {
        "tip": "Updated tip"
    }
    ```

- **Delete Recycling Tip**
    ```http
    DELETE /api/recycling-tips/{id}
    ```

## Error Handling

The application uses a global exception handler to manage runtime exceptions and validation errors. Errors are returned with appropriate HTTP status codes and messages.

## Running Tests

To run tests, use the following command:
```sh
mvn test
