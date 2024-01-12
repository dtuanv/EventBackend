# Event Management Spring Backend - CRUD Operations

Welcome to the Event Management Spring Backend! This backend system is designed to handle the CRUD (Create, Read, Update, Delete) operations for event management, providing a robust and scalable solution for organizing and managing events.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
  - [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Event CRUD Operations:** Implement Create, Read, Update, and Delete operations for events.
- **Data Persistence:** Utilize Spring Data JPA to interact with the database for efficient data storage and retrieval.
- **User Authentication:** Securely authenticate users to control access to event management features.
- **Exception Handling:** Implement a robust exception handling mechanism to provide meaningful error responses.
- **RESTful API:** Design a RESTful API for seamless integration with frontend applications.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Gradle
- PostgreSQL
### Installation

1. Clone the repository:
   ```
   git clone https://github.com/dtuanv/EventBackend.git
3. Navigate to the project directory:
   ```
   cd eventBackend
4. Build the project:
   ```
   gradle build
## Configuration

Configure the database connection in `src/main/resources/application.properties`.

## Usage

### API Endpoints

#### Event Endpoints:

- **POST /saveEvent:** Create a new event.
- **GET /getEvents:** Get a list of all events.
- **GET /getEventById/{eventId}:** Get details of a specific event.
- **PUT/POST /saveEvent:** Update information for a specific event.
- **DELETE /deleteEventBy/{eventId}:** Delete a specific event.


### Error Handling

Exception handling is in place to provide meaningful error responses. Refer to the API documentation for specific error details.

## Contributing

Contributions are welcome! Please follow the [contribution guidelines](CONTRIBUTING.md) when submitting pull requests.

## License

This project is licensed under the MIT License.
