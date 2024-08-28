
# Node Management API

## Overview

This project is a simple Spring Boot application that provides an API for managing nodes. It includes custom validation logic implemented in the service layer to ensure that certain fields, such as `nodeId` and `nodeName`, do not contain invalid characters or null values.

## Features

- Add a new node with validation to ensure that the `nodeId` and `nodeName` are not null and do not contain special characters.
- Custom error handling to return meaningful messages in the response.

## Technologies Used

- Java 11
- Spring Boot
- Hibernate/JPA
- Maven

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   ├── example/
│   │   │   │   ├── NodeManagementApplication.java  # Main application class
│   │   │   │   ├── controller/
│   │   │   │   │   └── NodeController.java         # REST Controller
│   │   │   │   ├── exception/
│   │   │   │   │   └── ValidationException.java    # Custom Validation Exception
│   │   │   │   ├── model/
│   │   │   │   │   └── Node.java                   # Entity class
│   │   │   │   ├── repository/
│   │   │   │   │   └── NodeRepository.java         # Repository Interface
│   │   │   │   └── service/
│   │   │   │       └── NodeService.java            # Service Class with validation logic
│   └── resources/
│       └── application.properties                  # Configuration file
└── test/
    └── java/                                       # Test files
```

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven 3.6+
- An IDE like IntelliJ IDEA or Eclipse
- A database (e.g., H2, MySQL)

### Setting Up the Project

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/node-management-api.git
   cd node-management-api
   ```

2. **Configure the Database:**

   Update the `src/main/resources/application.properties` file with your database configuration. For example:

   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the Project:**

   Use Maven to build the project:

   ```bash
   mvn clean install
   ```

4. **Run the Application:**

   You can run the application using Maven:

   ```bash
   mvn spring-boot:run
   ```

   Or by running the `NodeManagementApplication` class directly from your IDE.

## API Endpoints

### Add a New Node

- **URL:** `/api/nodes/add`
- **Method:** `POST`
- **Content-Type:** `application/json`
- **Request Body:**

  ```json
  {
    "nodeId": "T300_016",
    "nodeName": "Node Name Example",
    "description": "This is an optional description.",
    "memo": "This is an optional memo.",
    "nodeType": "Type1",
    "parentNodeGroupName": "Group Name",
    "parentNodeGroupId": "Group ID",
    "parentNodeGroup": "Parent Group"
  }
  ```

- **Response:**

  - **Success Response:**

    ```json
    {
      "id": 1,
      "nodeId": "T300_016",
      "nodeName": "Node Name Example",
      "description": "This is an optional description.",
      "memo": "This is an optional memo.",
      "nodeType": "Type1",
      "parentNodeGroupName": "Group Name",
      "parentNodeGroupId": "Group ID",
      "parentNodeGroup": "Parent Group"
    }
    ```

  - **Error Response:**

    ```json
    {
      "field": "Node ID",
      "message": "Node ID contains invalid characters"
    }
    ```

### Error Handling

If the validation fails, the API will return an HTTP 400 response with a JSON object containing the field name and the error message.

## Testing

To run tests, use the following Maven command:

```bash
mvn test
```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
