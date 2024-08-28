
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
│   │   │   ├── nodeservice/
|   |   |   ├──node_backend/
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
   git clone https://github.com/subbu177/NodeManagementAPI.git
   cd node-management-api
   ```

2. **Configure the Database:**

   Update the `src/main/resources/application.properties` file with your database configuration. For example:

   ```properties
spring.application.name=node-backend
spring.datasource.url=jdbc:postgresql://localhost:5432/node
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
server.port=8081
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

- **URL:** `/api/nodes`
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

Get All Nodes
URL: /api/nodes

Method: GET

Response:

Success Response: HTTP 200 OK

[
    {
        "id": 1,
        "nodeId": "T300_001",
        "nodeName": "Node 1",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Transponder",
        "parentNodeGroupName": "Subgroup NE__1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 2,
        "nodeId": "T300_002",
        "nodeName": "Node 2",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Transponder",
        "parentNodeGroupName": "Subgroup NE__1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 3,
        "nodeId": "T300_003",
        "nodeName": "Node 3",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Transponder",
        "parentNodeGroupName": "Subgroup NE__1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 4,
        "nodeId": "T300_004",
        "nodeName": "Node 4",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Transponder",
        "parentNodeGroupName": "Subgroup NE__1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 5,
        "nodeId": "T300_005",
        "nodeName": "Node 5",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Transponder",
        "parentNodeGroupName": "Subgroup NE__1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 6,
        "nodeId": "T300_006",
        "nodeName": "Node 6",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Subgroup NE__2",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 7,
        "nodeId": "T300_007",
        "nodeName": "Node 7",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Subgroup NE__2",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 8,
        "nodeId": "T300_008",
        "nodeName": "Node 8",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Group 1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 9,
        "nodeId": "T300_009",
        "nodeName": "Node 9",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Group 1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 10,
        "nodeId": "T300_010",
        "nodeName": "Node 10",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Group 1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 11,
        "nodeId": "T300_011",
        "nodeName": "Node 11",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Group 1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 12,
        "nodeId": "T300_012",
        "nodeName": "Node 12",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Group 1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 13,
        "nodeId": "T300_013",
        "nodeName": "Node 13",
        "description": "Sample text",
        "memo": "Sample text",
        "nodeType": "Roadm",
        "parentNodeGroupName": "Group 1",
        "parentNodeGroupId": "Sample text",
        "parentNodeGroup": "Sample text"
    },
    {
        "id": 14,
        "nodeId": "T300_014",
        "nodeName": "Node 14",
        "description": "Valid description",
        "memo": "Valid memo",
        "nodeType": "Transponder",
        "parentNodeGroupName": "Group 2",
        "parentNodeGroupId": "Group_001",
        "parentNodeGroup": "Group_Description"
    },
    {
        "id": 15,
        "nodeId": "T300_015$",
        "nodeName": "Node 15",
        "description": "Valid description&",
        "memo": "Valid memo",
        "nodeType": "Transponder#",
        "parentNodeGroupName": "Group 2",
        "parentNodeGroupId": "Group_001",
        "parentNodeGroup": "Group_Description"
    },
    {
        "id": 16,
        "nodeId": "T300_015$",
        "nodeName": "Node 15",
        "description": "Valid description&",
        "memo": "Valid memo",
        "nodeType": "Transponder#",
        "parentNodeGroupName": "Group 2",
        "parentNodeGroupId": "Group_001",
        "parentNodeGroup": "Group_Description"
    },
    {
        "id": 17,
        "nodeId": "T300_016$",
        "nodeName": "Node 16",
        "description": "Valid description&",
        "memo": "Valid memo",
        "nodeType": "Transponder#",
        "parentNodeGroupName": "Group 2",
        "parentNodeGroupId": "Group_001",
        "parentNodeGroup": "Group_Description"
    },
    {
        "id": 18,
        "nodeId": "T300_015$",
        "nodeName": "Node 14",
        "description": "Valid description&",
        "memo": "Valid memo",
        "nodeType": "Transponder#",
        "parentNodeGroupName": "Group 2",
        "parentNodeGroupId": "Group_001",
        "parentNodeGroup": "Group_Description"
    }
]


## Testing

To run tests, use the following Maven command:

```bash
mvn test
```

