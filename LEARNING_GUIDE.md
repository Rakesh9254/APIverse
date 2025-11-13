# 🎓 APIverse - Complete Learning Guide

Welcome to the APIverse Learning Guide! This comprehensive tutorial will take you from beginner to advanced in REST API automation testing using REST Assured.

---

## 📚 Table of Contents

1. [Getting Started](#-getting-started)
2. [Understanding REST APIs](#-understanding-rest-apis)
3. [Day-by-Day Learning Path](#-day-by-day-learning-path)
4. [Hands-On Exercises](#-hands-on-exercises)
5. [Best Practices](#-best-practices)
6. [Common Mistakes to Avoid](#-common-mistakes-to-avoid)
7. [Advanced Topics](#-advanced-topics)
8. [Quiz & Challenges](#-quiz--challenges)

---

## 🚀 Getting Started

### What You'll Learn
By the end of this guide, you will be able to:
- ✅ Understand REST API fundamentals
- ✅ Write automated API tests using REST Assured
- ✅ Validate responses (status codes, headers, body)
- ✅ Handle authentication and authorization
- ✅ Implement test frameworks and design patterns
- ✅ Generate professional test reports

### Prerequisites Knowledge
- Basic Java programming (variables, methods, classes)
- Understanding of HTTP protocol (helpful but not required)
- Familiarity with JSON format
- Basic command line usage

---

## 🌐 Understanding REST APIs

### What is an API?
**API** (Application Programming Interface) is a way for different software applications to communicate with each other.

**Real-world analogy:**
Think of a restaurant:
- **You (Client)** → Make a request (order food)
- **Waiter (API)** → Takes your request to the kitchen
- **Kitchen (Server)** → Prepares your order
- **Waiter (API)** → Brings back your food (response)

### What is REST?
**REST** (Representational State Transfer) is an architectural style for designing networked applications.

**Key Principles:**
1. **Stateless** - Each request contains all information needed
2. **Client-Server** - Separation of concerns
3. **Uniform Interface** - Consistent way to interact
4. **Resource-Based** - Everything is a resource (users, products, etc.)

### HTTP Methods (CRUD Operations)

| HTTP Method | CRUD Operation | Purpose | Example |
|-------------|----------------|---------|---------|
| **GET** | Read | Retrieve data | Get user list |
| **POST** | Create | Create new resource | Create new user |
| **PUT** | Update | Update entire resource | Update user details |
| **PATCH** | Update | Update partial resource | Update user email only |
| **DELETE** | Delete | Remove resource | Delete user |

### HTTP Status Codes

| Code Range | Meaning | Examples |
|------------|---------|----------|
| **2xx** | Success | 200 (OK), 201 (Created), 204 (No Content) |
| **3xx** | Redirection | 301 (Moved), 304 (Not Modified) |
| **4xx** | Client Error | 400 (Bad Request), 401 (Unauthorized), 404 (Not Found) |
| **5xx** | Server Error | 500 (Internal Server Error), 503 (Service Unavailable) |

### Understanding JSON
JSON (JavaScript Object Notation) is the most common data format for APIs.

**Example JSON:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "active": true,
  "roles": ["admin", "user"]
}
```

---

## 📅 Day-by-Day Learning Path

### 🔰 Week 1: Fundamentals

#### Day 1: Environment Setup & First Test

**Goals:**
- Set up development environment
- Run your first API test
- Understand test structure

**Step 1: Verify Java Installation**
```bash
java -version
# Should show Java 11 or higher
```

**Step 2: Verify Maven Installation**
```bash
mvn -version
```

**Step 3: Clone and Setup Project**
```bash
git clone https://github.com/yourusername/APIverse.git
cd APIverse
mvn clean install
```

**Step 4: Run Your First Test**
```bash
mvn test -Dtest=SimpleAPITest
```

**Step 5: Understand the Test**
Open `src/test/java/Days01/SimpleAPITest.java`:

```java
@Test
void getUsers() {
    given()                           // Given: Setup/Preconditions

    .when()                          // When: Action to perform
        .get("https://reqres.in/api/users?page=2")

    .then()                          // Then: Expected results
        .statusCode(200)
        .body("page", equalTo(2))
        .log().all();
}
```

**Exercise:**
1. Change the page number to 1
2. Verify the test passes with statusCode 200
3. Add validation for "per_page" field

---

#### Day 2: GET Requests Deep Dive

**Goals:**
- Master GET request syntax
- Extract data from responses
- Use query parameters

**Concept: Query Parameters**
```
https://reqres.in/api/users?page=2&per_page=5
                           ↑ query parameters
```

**Example 1: Simple GET**
```java
@Test
void getSingleUser() {
    given()

    .when()
        .get("https://reqres.in/api/users/2")

    .then()
        .statusCode(200)
        .body("data.id", equalTo(2))
        .body("data.first_name", equalTo("Janet"))
        .log().body();
}
```

**Example 2: GET with Parameters**
```java
@Test
void getUsersWithParams() {
    given()
        .queryParam("page", 2)
        .queryParam("per_page", 5)

    .when()
        .get("https://reqres.in/api/users")

    .then()
        .statusCode(200)
        .body("page", equalTo(2))
        .body("per_page", equalTo(5));
}
```

**Example 3: Extract Response Data**
```java
@Test
void extractUserName() {
    String firstName = given()
    .when()
        .get("https://reqres.in/api/users/2")
    .then()
        .statusCode(200)
        .extract()
        .jsonPath().getString("data.first_name");

    System.out.println("User name: " + firstName);
    assertEquals("Janet", firstName);
}
```

**Exercises:**
1. Create a test to get user with ID 5
2. Validate the email field in the response
3. Extract and print the avatar URL
4. Create a test that validates the "support" object in response

---

#### Day 3: POST Requests - Creating Data

**Goals:**
- Understand POST requests
- Send JSON request body
- Validate created resources

**Example 1: Basic POST Request**
```java
@Test
void createUser() {
    String requestBody = """
        {
            "name": "John Doe",
            "job": "QA Engineer"
        }
        """;

    given()
        .contentType(ContentType.JSON)
        .body(requestBody)

    .when()
        .post("https://reqres.in/api/users")

    .then()
        .statusCode(201)                    // 201 = Created
        .body("name", equalTo("John Doe"))
        .body("job", equalTo("QA Engineer"))
        .body("id", notNullValue())         // ID should be generated
        .body("createdAt", notNullValue())
        .log().all();
}
```

**Example 2: Using HashMap for Request Body**
```java
@Test
void createUserWithHashMap() {
    Map<String, String> user = new HashMap<>();
    user.put("name", "Jane Smith");
    user.put("job", "Developer");

    given()
        .contentType(ContentType.JSON)
        .body(user)

    .when()
        .post("https://reqres.in/api/users")

    .then()
        .statusCode(201)
        .body("name", equalTo("Jane Smith"));
}
```

**Example 3: Extract Created User ID**
```java
@Test
void createAndExtractUserId() {
    String requestBody = """
        {
            "name": "Alex Johnson",
            "job": "Tester"
        }
        """;

    int userId = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
    .when()
        .post("https://reqres.in/api/users")
    .then()
        .statusCode(201)
        .extract()
        .jsonPath().getInt("id");

    System.out.println("Created user with ID: " + userId);
}
```

**Exercises:**
1. Create a user with your own name and job title
2. Validate that createdAt timestamp is present
3. Extract and store the created user's ID
4. Try creating a user with missing fields (what happens?)

---

#### Day 4: PUT & PATCH Requests - Updating Data

**Goals:**
- Understand difference between PUT and PATCH
- Update existing resources
- Validate update operations

**PUT vs PATCH:**
- **PUT**: Replace entire resource
- **PATCH**: Update specific fields only

**Example 1: PUT Request (Full Update)**
```java
@Test
void updateUserPUT() {
    String requestBody = """
        {
            "name": "John Updated",
            "job": "Senior QA Engineer"
        }
        """;

    given()
        .contentType(ContentType.JSON)
        .body(requestBody)

    .when()
        .put("https://reqres.in/api/users/2")

    .then()
        .statusCode(200)
        .body("name", equalTo("John Updated"))
        .body("job", equalTo("Senior QA Engineer"))
        .body("updatedAt", notNullValue())
        .log().all();
}
```

**Example 2: PATCH Request (Partial Update)**
```java
@Test
void updateUserPATCH() {
    String requestBody = """
        {
            "job": "Lead QA Engineer"
        }
        """;

    given()
        .contentType(ContentType.JSON)
        .body(requestBody)

    .when()
        .patch("https://reqres.in/api/users/2")

    .then()
        .statusCode(200)
        .body("job", equalTo("Lead QA Engineer"))
        .body("updatedAt", notNullValue());
}
```

**Exercises:**
1. Update user with ID 3 using PUT
2. Update only the job field using PATCH
3. Compare response times between PUT and PATCH
4. Validate the updatedAt timestamp format

---

#### Day 5: DELETE Requests

**Goals:**
- Perform DELETE operations
- Validate successful deletion
- Handle edge cases

**Example 1: Simple DELETE**
```java
@Test
void deleteUser() {
    given()

    .when()
        .delete("https://reqres.in/api/users/2")

    .then()
        .statusCode(204)    // 204 = No Content (successful deletion)
        .log().all();
}
```

**Example 2: Delete and Verify**
```java
@Test
void deleteAndVerify() {
    int userId = 5;

    // Delete user
    given()
    .when()
        .delete("https://reqres.in/api/users/" + userId)
    .then()
        .statusCode(204);

    // Try to get deleted user (should fail or return 404)
    given()
    .when()
        .get("https://reqres.in/api/users/" + userId)
    .then()
        .statusCode(404);  // User not found
}
```

**Exercises:**
1. Delete user with ID 10
2. Create a user, then delete it
3. Try to delete a non-existent user (what status code?)

---

### 🔥 Week 2: Intermediate Concepts

#### Day 6: Headers & Cookies

**Goals:**
- Work with request/response headers
- Handle cookies
- Set custom headers

**Example 1: Request Headers**
```java
@Test
void requestWithHeaders() {
    given()
        .header("Content-Type", "application/json")
        .header("Accept", "application/json")
        .header("User-Agent", "RestAssured-Testing")

    .when()
        .get("https://reqres.in/api/users")

    .then()
        .statusCode(200)
        .header("Content-Type", containsString("application/json"))
        .log().headers();
}
```

**Example 2: Validate Response Headers**
```java
@Test
void validateResponseHeaders() {
    given()
    .when()
        .get("https://reqres.in/api/users/1")
    .then()
        .statusCode(200)
        .header("Content-Type", "application/json; charset=utf-8")
        .header("Connection", notNullValue())
        .time(lessThan(2000L));  // Response time < 2 seconds
}
```

**Exercises:**
1. Add custom headers to your requests
2. Validate Content-Type header in responses
3. Check response time for all endpoints
4. Extract and print all response headers

---

#### Day 7: Authentication

**Goals:**
- Implement Basic Authentication
- Use Bearer Token authentication
- Handle API keys

**Example 1: Basic Authentication**
```java
@Test
void basicAuth() {
    given()
        .auth().basic("username", "password")

    .when()
        .get("https://api.example.com/secure")

    .then()
        .statusCode(200);
}
```

**Example 2: Bearer Token**
```java
@Test
void bearerToken() {
    String token = "your-api-token-here";

    given()
        .header("Authorization", "Bearer " + token)

    .when()
        .get("https://api.example.com/protected")

    .then()
        .statusCode(200);
}
```

**Example 3: API Key Authentication**
```java
@Test
void apiKeyAuth() {
    given()
        .queryParam("api_key", "your-api-key")
        // OR
        .header("X-API-Key", "your-api-key")

    .when()
        .get("https://api.example.com/data")

    .then()
        .statusCode(200);
}
```

---

#### Day 8: Response Validation Deep Dive

**Goals:**
- Master JSON path expressions
- Validate nested objects
- Validate arrays

**Example 1: Validate Nested JSON**
```java
@Test
void validateNestedJson() {
    given()
    .when()
        .get("https://reqres.in/api/users/2")
    .then()
        .statusCode(200)
        .body("data.id", equalTo(2))
        .body("data.first_name", equalTo("Janet"))
        .body("data.email", containsString("@reqres.in"))
        .body("support.url", notNullValue())
        .body("support.text", containsString("support"));
}
```

**Example 2: Validate Arrays**
```java
@Test
void validateArrays() {
    given()
    .when()
        .get("https://reqres.in/api/users?page=1")
    .then()
        .statusCode(200)
        .body("data", hasSize(6))                          // Array has 6 elements
        .body("data[0].id", equalTo(1))                   // First element
        .body("data[-1].id", equalTo(6))                  // Last element
        .body("data.id", hasItems(1, 2, 3))               // Contains these IDs
        .body("data.first_name", everyItem(notNullValue())); // All have first_name
}
```

**Example 3: Complex Validations**
```java
@Test
void complexValidations() {
    given()
    .when()
        .get("https://reqres.in/api/users?page=2")
    .then()
        .statusCode(200)
        .body("page", equalTo(2))
        .body("per_page", greaterThan(0))
        .body("total", greaterThanOrEqualTo(12))
        .body("data.email", everyItem(containsString("@")))
        .body("data.avatar", everyItem(startsWith("https")));
}
```

---

### 🎯 Week 3: Advanced Topics

#### Day 9: Test Chaining & Dependencies

**Example: Create, Retrieve, Update, Delete Flow**
```java
public class UserCRUDTest {
    private static int createdUserId;

    @Test(priority = 1)
    void createUser() {
        createdUserId = given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Test User\", \"job\": \"Tester\" }")
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .extract().jsonPath().getInt("id");

        System.out.println("Created user with ID: " + createdUserId);
    }

    @Test(priority = 2, dependsOnMethods = "createUser")
    void getCreatedUser() {
        given()
        .when()
            .get("https://reqres.in/api/users/" + createdUserId)
        .then()
            .statusCode(200);
    }

    @Test(priority = 3, dependsOnMethods = "getCreatedUser")
    void updateUser() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Updated User\", \"job\": \"Senior Tester\" }")
        .when()
            .put("https://reqres.in/api/users/" + createdUserId)
        .then()
            .statusCode(200);
    }

    @Test(priority = 4, dependsOnMethods = "updateUser")
    void deleteUser() {
        given()
        .when()
            .delete("https://reqres.in/api/users/" + createdUserId)
        .then()
            .statusCode(204);
    }
}
```

---

## 🎯 Hands-On Exercises

### Exercise Set 1: Basics
1. Get list of users and validate total count
2. Create 3 different users with different jobs
3. Update a user's name and verify the change
4. Delete a user and confirm deletion

### Exercise Set 2: Intermediate
1. Extract all user emails from page 1
2. Validate that all avatars start with "https"
3. Create a user and store the ID for later use
4. Check response time is under 2 seconds

### Exercise Set 3: Advanced
1. Create a complete CRUD test suite
2. Implement test data management
3. Add detailed logging and reporting
4. Handle error scenarios (404, 400, etc.)

---

## ✅ Best Practices

### 1. Test Organization
```java
// Good: Descriptive test names
@Test
void shouldReturnUser WhenValidIdProvided() { }

// Bad: Generic names
@Test
void test1() { }
```

### 2. Assertions
```java
// Good: Multiple specific assertions
.then()
    .statusCode(200)
    .body("name", equalTo("John"))
    .body("email", containsString("@"));

// Bad: Only checking status code
.then()
    .statusCode(200);
```

### 3. Test Data
```java
// Good: Use constants or config files
private static final String BASE_URL = "https://reqres.in/api";
private static final String USER_NAME = "Test User";

// Bad: Hardcoded values everywhere
.get("https://reqres.in/api/users")
```

### 4. Logging
```java
// Use appropriate logging levels
.log().all()        // Development
.log().ifError()    // Production
.log().ifValidationFails()  // CI/CD
```

---

## ⚠️ Common Mistakes to Avoid

1. **Not checking status codes** - Always validate expected status code
2. **Hardcoding test data** - Use variables and configuration
3. **No error handling** - Handle edge cases and failures
4. **Poor test names** - Use descriptive, readable names
5. **Not using assertions** - Don't just check status code
6. **Ignoring response time** - Performance matters
7. **Not cleaning up** - Delete created test data

---

## 🎓 Quiz & Challenges

### Quiz 1: Fundamentals
1. What HTTP method is used to create a resource?
2. What status code indicates successful creation?
3. What's the difference between PUT and PATCH?
4. How do you extract data from a JSON response?

### Challenge 1: Build Your Own Test Suite
Create a test suite that:
- Tests at least 5 different endpoints
- Includes all CRUD operations
- Has proper validations
- Generates reports
- Handles errors gracefully

### Challenge 2: Real API Testing
Choose a public API and:
- Write complete test coverage
- Document your test strategy
- Create reusable components
- Implement CI/CD

---

## 🎉 Conclusion

Congratulations on completing the APIverse Learning Guide! You now have the knowledge to:
- Write comprehensive API tests
- Validate responses effectively
- Handle authentication
- Design test frameworks
- Follow best practices

### Next Steps:
1. Practice with different APIs
2. Contribute to open-source projects
3. Learn about performance testing
4. Explore CI/CD integration
5. Share your knowledge with others

### Keep Learning!
- Join API testing communities
- Read blogs and articles
- Watch tutorial videos
- Practice daily
- Build your own projects

---

## 📬 Need Help?

- Check the [main README](README.md)
- Open an issue on GitHub
- Join our community discussions
- Follow best practices documentation

**Happy Testing! 🚀**

---

<div align="center">

Made with ❤️ for aspiring API automation engineers

[⬆ Back to Top](#-apiverse---complete-learning-guide)

</div>
