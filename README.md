#Recipe Sharing Platform

This documentation provides an overview of the Recipe Sharing Platform API, explaining its functionality and usage.

API Endpoints:
1. Create User
Endpoint: POST /users
Description: Creates a new user in the system.
Request Body:
{
  "id": 1,
  "username": "exampleUser",
  "password": "examplePassword"
}

Response:
201 Created: User created successfully.
500 Internal Server Error: If there is an issue while creating the user.
2. Create Recipe
Endpoint: POST /recipes
Description: Creates a new recipe in the system.
Request Body:
{
  "id": 1,
  "title": "Example Recipe",
  "ingredients": ["Ingredient 1", "Ingredient 2"],
  "instructions": "Step 1: Do something..."
}
Response:
201 Created: Recipe created successfully.
500 Internal Server Error: If there is an issue while creating the recipe.
3. Get Recipes
Endpoint: GET /recipes
Description: Retrieves a list of all recipes in the system.
Response:
200 OK: List of recipes in JSON format.

[
  {
    "id": 1,
    "title": "Example Recipe",
    "ingredients": ["Ingredient 1", "Ingredient 2"],
    "instructions": "Step 1: Do something..."
  },
  {
    "id": 2,
    "title": "Another Recipe",
    "ingredients": ["Ingredient A", "Ingredient B"],
    "instructions": "Step 1: Do something else..."
  }
]
500 Internal Server Error: If there is an issue while retrieving recipes.

Error Handling:
The API handles exceptions using the StatusPages feature.
If there is an exception (StatusPageException),
the API responds with the appropriate HTTP status code and a relevant error message.

Technologies Used:
Ktor: Ktor is used as the web framework for building the API.
Content Negotiation: Content negotiation is enabled to support JSON responses.
StatusPages: StatusPages feature is utilized for handling exceptions and returning appropriate error responses.
Jackson: Jackson is used for JSON serialization and deserialization.

How to Run the API:
Ensure that Kotlin and the required dependencies are installed on your system.
Open the terminal and navigate to the project directory.
Run the following command to start the server:
kotlinc -include-runtime -d app.jar main.kt
java -jar app.jar
The server will start on port 8080.
