# APIverse - REST Assured API Automation Framework

![Java](https://img.shields.io/badge/Java-11+-orange?style=flat&logo=java)
![REST Assured](https://img.shields.io/badge/REST%20Assured-5.3.0-green?style=flat)
![TestNG](https://img.shields.io/badge/TestNG-7.7.1-red?style=flat)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue?style=flat&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

A comprehensive REST API automation testing framework built with REST Assured, TestNG, and Maven. This project demonstrates BDD-style API testing with complete CRUD operations, response validation, and professional test organization.

> **Perfect for Learning!** This repository is designed as a hands-on learning resource for anyone wanting to master REST API automation testing. Follow along with clear examples and detailed explanations.

---

## 📋 Table of Contents

- [About](#-about)
- [Features](#-features)
- [Technologies](#️-technologies)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Project Structure](#-project-structure)
- [Quick Start Guide](#-quick-start-guide)
- [Running Tests](#-running-tests)
- [Test Scenarios](#-test-scenarios)
- [Key Concepts](#-key-concepts)
- [Learning Path](#-learning-path)
- [Code Examples](#-code-examples)
- [Reports](#-reports)
- [Troubleshooting](#-troubleshooting)
- [Contributing](#-contributing)
- [Learning Resources](#-learning-resources)
- [Contact](#-contact)

---

## 🚀 About

APIverse is a REST Assured automation framework designed to test RESTful APIs efficiently. It follows the **BDD (Behavior Driven Development)** approach using the **Given-When-Then** pattern, making tests readable and maintainable.

### What I Built:
- ✅ Complete API automation framework from scratch
- ✅ Automated all HTTP methods (GET, POST, PUT, DELETE)
- ✅ Dynamic data handling with JSONPath
- ✅ Test dependencies and chaining
- ✅ Request/Response validation
- ✅ Professional project structure with Maven

### Why This Project?
- 🎓 **Learn by doing** - Real-world API testing scenarios
- 📚 **Well-documented** - Every section explained clearly
- 🔧 **Production-ready** - Industry-standard practices
- 🚀 **Easy to extend** - Add your own test cases easily

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| **BDD Style** | Given-When-Then approach for readable tests |
| **CRUD Operations** | Complete Create, Read, Update, Delete automation |
| **Response Validation** | Status codes, headers, and JSON body validation |
| **Dynamic Data** | Extract and reuse data across tests |
| **Test Chaining** | Dependencies between tests using TestNG |
| **Logging** | Detailed request/response logging |
| **Maven Integration** | Easy dependency management |
| **TestNG Reports** | Built-in HTML test reports |

---

## 🛠️ Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 11+ | Programming Language |
| **REST Assured** | 5.3.0 | API Testing Library |
| **TestNG** | 7.7.1 | Test Framework |
| **Maven** | 3.8+ | Build & Dependency Management |
| **Hamcrest** | 2.2 | Assertion Matchers |
| **JSON Path** | 5.3.0 | JSON Response Parsing |

---

## 📦 Prerequisites

Before running this project, ensure you have:

### Required:
- **Java JDK 11+**
  ```bash
  # Check Java version
  java -version
  ```

- **Maven 3.8+**
  ```bash
  # Check Maven version
  mvn -version
  ```

### Optional but Recommended:
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code
- **Postman**: For manual API testing and comparison
- **Git**: For version control

### Install Java (if not installed):
**Windows:**
1. Download from [Oracle](https://www.oracle.com/java/technologies/downloads/)
2. Run installer and add to PATH

**Mac:**
```bash
brew install openjdk@11
```

**Linux:**
```bash
sudo apt update
sudo apt install openjdk-11-jdk
```

### Install Maven (if not installed):
**Windows:**
1. Download from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract and add bin directory to PATH

**Mac:**
```bash
brew install maven
```

**Linux:**
```bash
sudo apt update
sudo apt install maven
```

---

## 🗂️ Project Structure

```
APIverse/
│
├── src/
│   └── test/
│       └── java/
│           └── Days01/
│               └── SimpleAPITest.java      # Basic API test examples
│
├── test-output/                            # TestNG generated reports
├── pom.xml                                 # Maven configuration
├── testng.xml                              # TestNG suite configuration
└── README.md                               # This file
```

### Understanding the Structure:
- **src/test/java**: Contains all test classes
- **Days01**: Organized by learning modules/days
- **test-output**: Auto-generated test reports
- **pom.xml**: Maven dependencies and plugins

---

## 🚀 Quick Start Guide

### Step 1: Clone the Repository
```bash
git clone https://github.com/yourusername/APIverse.git
cd APIverse
```

### Step 2: Install Dependencies
```bash
mvn clean install
```
This command will:
- Download all required dependencies
- Compile the test code
- Run initial setup

### Step 3: Run Your First Test
```bash
mvn test
```

### Step 4: View the Report
After running tests, open:
```
test-output/index.html
```

---

## 🧪 Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn test -Dtest=SimpleAPITest
```

### Run with TestNG XML
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run from IDE
1. Right-click on test class
2. Select "Run as TestNG Test"

---

## 📝 Test Scenarios

This framework tests the **ReqRes API** (https://reqres.in), which provides:

| Scenario | HTTP Method | Endpoint | Purpose |
|----------|------------|----------|---------|
| Get Users | GET | `/api/users?page=2` | Retrieve user list |
| Get Single User | GET | `/api/users/{id}` | Get specific user details |
| Create User | POST | `/api/users` | Create new user |
| Update User | PUT | `/api/users/{id}` | Update existing user |
| Delete User | DELETE | `/api/users/{id}` | Remove user |

---

## 💡 Key Concepts

### 1. BDD-Style Testing (Given-When-Then)

REST Assured uses a fluent API that reads like natural language:

```java
given()                          // Setup/Preconditions
    .contentType("application/json")
    .body(requestBody)

.when()                          // Action/HTTP Method
    .post("https://reqres.in/api/users")

.then()                          // Assertions/Validations
    .statusCode(201)
    .body("name", equalTo("John"));
```

### 2. Request Specification
Reusable request configurations:
- Base URI
- Headers
- Authentication
- Request body

### 3. Response Validation
Multiple validation types:
- Status code validation
- Header validation
- JSON body validation
- Schema validation

### 4. JSON Path
Extract data from JSON responses:
```java
String name = response.jsonPath().getString("data.first_name");
```

---

## 🎓 Learning Path

### Beginner Level
1. ✅ **Day 1**: Setup environment & run first test
2. ✅ **Day 2**: Understanding GET requests
3. ✅ **Day 3**: POST requests & creating data
4. ✅ **Day 4**: PUT/PATCH requests & updating data
5. ✅ **Day 5**: DELETE requests

### Intermediate Level
6. ⏳ **Day 6**: Query parameters & path parameters
7. ⏳ **Day 7**: Request & response headers
8. ⏳ **Day 8**: Authentication (Basic, Bearer, OAuth)
9. ⏳ **Day 9**: JSON Schema validation
10. ⏳ **Day 10**: Data-driven testing with TestNG

### Advanced Level
11. ⏳ **Day 11**: Request/Response specifications
12. ⏳ **Day 12**: Serialization & Deserialization
13. ⏳ **Day 13**: Framework design patterns
14. ⏳ **Day 14**: CI/CD integration
15. ⏳ **Day 15**: Performance & load testing

---

## 📚 Code Examples

### Example 1: Simple GET Request

```java
@Test
void getUsers() {
    given()

    .when()
        .get("https://reqres.in/api/users?page=2")

    .then()
        .statusCode(200)
        .body("page", equalTo(2))
        .log().all();
}
```

**What this does:**
- Sends GET request to fetch users
- Validates status code is 200 (OK)
- Validates page number in response
- Logs entire response

### Example 2: POST Request (Create User)

```java
@Test
void createUser() {
    String requestBody = "{\n" +
        "  \"name\": \"John Doe\",\n" +
        "  \"job\": \"QA Engineer\"\n" +
        "}";

    given()
        .contentType(ContentType.JSON)
        .body(requestBody)

    .when()
        .post("https://reqres.in/api/users")

    .then()
        .statusCode(201)
        .body("name", equalTo("John Doe"))
        .body("job", equalTo("QA Engineer"))
        .log().body();
}
```

**What this does:**
- Defines JSON request body
- Sets content type header
- Sends POST request to create user
- Validates status code is 201 (Created)
- Validates response contains correct data

### Example 3: Dynamic Data Extraction

```java
@Test
void extractAndReuseData() {
    // Create user and extract ID
    int userId = given()
        .contentType(ContentType.JSON)
        .body("{ \"name\": \"Jane\", \"job\": \"Developer\" }")
    .when()
        .post("https://reqres.in/api/users")
    .then()
        .statusCode(201)
        .extract()
        .jsonPath().getInt("id");

    // Use extracted ID in another request
    given()
    .when()
        .get("https://reqres.in/api/users/" + userId)
    .then()
        .statusCode(200)
        .log().all();
}
```

**What this does:**
- Creates a user via POST
- Extracts the user ID from response
- Uses that ID in a GET request
- Demonstrates test chaining

---

## 📊 Reports

### TestNG Reports
After running tests, TestNG generates HTML reports:

**Location:** `test-output/index.html`

**What you'll see:**
- ✅ Total tests passed/failed/skipped
- ⏱️ Execution time
- 📝 Detailed logs
- 📊 Charts and statistics

### Console Logs
REST Assured provides detailed logging:
```java
.log().all()        // Log everything
.log().body()       // Log response body only
.log().status()     // Log status code only
.log().headers()    // Log headers only
```

---

## 🔧 Troubleshooting

### Common Issues & Solutions

#### 1. Tests Not Running
**Problem:** Maven can't find tests
**Solution:**
```bash
# Ensure proper directory structure
mvn clean compile
mvn clean test
```

#### 2. Dependency Issues
**Problem:** Dependencies not downloading
**Solution:**
```bash
# Force update dependencies
mvn clean install -U
```

#### 3. Java Version Mismatch
**Problem:** Wrong Java version
**Solution:**
```bash
# Check version
java -version

# Set JAVA_HOME
export JAVA_HOME=/path/to/java11
```

#### 4. Connection Timeout
**Problem:** API not reachable
**Solution:**
```java
// Increase timeout in code
given()
    .config(RestAssuredConfig.config()
        .httpClient(HttpClientConfig.httpClientConfig()
            .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000)))
```

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

### How to Contribute:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Add your tests or improvements
4. Commit changes (`git commit -m 'Add some AmazingFeature'`)
5. Push to branch (`git push origin feature/AmazingFeature`)
6. Open a Pull Request

### Ideas for Contributions:
- Add more test scenarios
- Improve documentation
- Add authentication examples
- Create utility methods
- Add CI/CD configurations

---

## 📖 Learning Resources

### Official Documentation
- [REST Assured Docs](https://rest-assured.io/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Guide](https://maven.apache.org/guides/)

### Video Tutorials
- REST Assured tutorial on YouTube
- API Testing best practices
- TestNG framework tutorials

### Practice APIs
- [ReqRes](https://reqres.in/) - Used in this project
- [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
- [Restful-Booker](https://restful-booker.herokuapp.com/)
- [Swagger Petstore](https://petstore.swagger.io/)

### Recommended Reading
- "API Testing and Development with Postman"
- "REST API Design Best Practices"
- "Test Automation Patterns"

### Community
- Stack Overflow - [rest-assured tag](https://stackoverflow.com/questions/tagged/rest-assured)
- GitHub Discussions
- LinkedIn Learning courses

---

## 📬 Contact

**Project Maintainer:** Your Name

- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your Profile](https://linkedin.com/in/yourprofile)
- Email: your.email@example.com

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## ⭐ Star History

If you find this project helpful for learning, please give it a star! ⭐

---

## 🙏 Acknowledgments

- Thanks to [ReqRes.in](https://reqres.in) for providing a free test API
- REST Assured team for the amazing library
- All contributors and learners using this project

---

<div align="center">

### Happy Testing! 🚀

**Built with ❤️ for the API Testing Community**

[⬆ Back to Top](#apiverse---rest-assured-api-automation-framework)

</div>
