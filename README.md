# Satellite Event Tracker

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Testing](#testing)
- [Docker Setup](#docker-setup)
- [License](#license)
- [Contact](#contact)

## Introduction
**Satellite Event Tracker** is a Java-based application designed to manage and track satellite events. This application allows users to create, read, and retrieve events associated with different satellites, providing an efficient way to handle event data.

## Features
- Create new satellite events
- Retrieve events by satellite name
- List all events

## Tech Stack
- Java 17
- Spring Boot 3.3.1
- Hibernate / JPA
- MySQL
- Maven
- Docker

## Requirements
- Java 17 or higher
- Maven 3.6.3 or higher
- MySQL 8.0 or higher
- Docker (for containerization)

## Installation
To install and run this project, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/Samiys/Satellite-Event-Tracker.git
   cd Satellite-Event-Tracker
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Set up the MySQL database:
   ```sql
   CREATE DATABASE event_tracker;
   ```

4. Update the database configuration in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/event_tracker
   spring.datasource.username=root
   spring.datasource.password=secret
   ```

## Usage
To start the application, run the following command:
```bash
mvn spring-boot:run
```

## Example

Create a new event
```bash
curl -X POST http://localhost:7000/api/events -H "Content-Type: application/json" -d '{"date":"2023-07-20T10:00:00","description":"Event Description","priority":"High","satelliteName":"SAT-1"}'
```

Get all events
```bash
curl http://localhost:7000/api/events
```

Get events by satellite name
```bash
curl http://localhost:7000/api/events/findBySatelliteName?satelliteName=SAT-1
````

## Configuration
Configuration options can be set in the `src/main/resources/application.properties` file.

## Testing
To run tests, use the following command:

```bash
mvn test
```

## Docker Setup
To set up and run the application using Docker, follow these steps:

1. Build and run the Docker containers:
   ```bash
   docker-compose up --build
   ```

2. The application will be accessible at `http://localhost:7000`.

## License
This project is licensed under the MIT License.

## Contact
For any questions or inquiries, please contact at **samiys005@gmail.com**