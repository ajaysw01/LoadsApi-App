
# Loads API

This Spring Boot application provides RESTful endpoints for managing transportation loads. It supports CRUD operations including adding, retrieving, updating, and deleting load details.

## API Endpoints

### POST /load

**Description**: Adds a new load to the system.

**Request Body:**

```json
{
    "loadingPoint": "delhi",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": "1",
    "weight": "100",
    "comment": "",
    "shipperId": "550e8400-e29b-41d4-a716-446655440000",
    "date": "2024-07-25"
}
```

**Responses:**

- `200 OK` - Load details added successfully
- `400 Bad Request` - ShipperId is required

### GET /load

**Description**: Retrieves all loads associated with a specific shipper ID.

**Query Parameters:**

- `shipperId` (UUID): The UUID of the shipper whose loads you want to retrieve.

**Responses:**

- `200 OK` - List of loads with the specified shipperId
- `204 No Content` - No loads found for the provided shipperId

### GET /load/{loadId}

**Description**: Retrieves a specific load by its ID.

**URL Parameters:**

- `loadId` (Long): The ID of the load to retrieve.

**Responses:**

- `200 OK` - Details of the load with the specified ID
- `404 Not Found` - Load not found

### PUT /load/{loadId}

**Description**: Updates an existing load.

**URL Parameters:**

- `loadId` (Long): The ID of the load to update.

**Request Body:**

```json
{
    "loadingPoint": "alwar",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": "1",
    "weight": "100",
    "comment": "",
    "date": "2024-07-25",
    "shipperId": "550e8400-e29b-41d4-a716-446655440000"
}
```

**Responses:**

- `200 OK` - Load details updated successfully
- `400 Bad Request` - ShipperId is required
- `404 Not Found` - Load not found

### DELETE /load/{loadId}

**Description**: Deletes a load from the system.

**URL Parameters:**

- `loadId` (Long): The ID of the load to delete.

**Responses:**

- `200 OK` - Load deleted successfully
- `404 Not Found` - Load not found

## Setup and Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/loads-api.git
   cd loads-api
   ```

2. **Update Configuration:**

   Modify the `application.properties` file to configure your database and other settings.

3. **Build the Project:**

   ```bash
   ./mvnw clean install
   ```

4. **Run the Application:**

   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`.

## Testing the API

To test the API endpoints, you can use Postman. Import the provided collection into Postman for easy testing of all endpoints.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any issues or questions, please reach out to [ajaysw45@gmail.com](mailto:ajaysw45@gmail.com).
``
