# ⚡ Quick Start Guide - Get Testing in 5 Minutes!

New to API testing? Follow these simple steps to run your first test in under 5 minutes!

---

## 📋 Before You Start

Make sure you have:
- ☑️ Java 11+ installed
- ☑️ Maven installed
- ☑️ A code editor (VS Code, IntelliJ, or Eclipse)

**Check installations:**
```bash
java -version    # Should show Java 11+
mvn -version     # Should show Maven 3.8+
```

---

## 🚀 Step 1: Get the Code

```bash
# Clone the repository
git clone https://github.com/yourusername/APIverse.git

# Navigate into the project
cd APIverse
```

---

## 📦 Step 2: Install Dependencies

```bash
# This will download all required libraries
mvn clean install
```

⏱️ This might take 2-3 minutes on first run.

---

## 🧪 Step 3: Run Your First Test

```bash
# Run all tests
mvn test
```

You should see output like:
```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 🎉 Step 4: View Test Results

Open the test report in your browser:
```
test-output/index.html
```

You'll see:
- ✅ Tests passed/failed
- ⏱️ Execution time
- 📊 Detailed results

---

## 📝 Step 5: Understand Your First Test

Open `src/test/java/Days01/SimpleAPITest.java`:

```java
@Test
void getUsers() {
    given()                          // SETUP: Prepare the request

    .when()                          // ACTION: Make the API call
        .get("https://reqres.in/api/users?page=2")

    .then()                          // VERIFY: Check the response
        .statusCode(200)             // Status should be 200 (OK)
        .body("page", equalTo(2))    // Page number should be 2
        .log().all();                // Show all details
}
```

**What this test does:**
1. Sends a GET request to fetch users (page 2)
2. Checks if the response status is 200 (success)
3. Verifies that the page number in response is 2
4. Logs all response details

---

## 🎯 Step 6: Try It Yourself!

### Challenge 1: Modify the Test
Change the page number to 1:
```java
.get("https://reqres.in/api/users?page=1")
// and
.body("page", equalTo(1))
```

Run again: `mvn test`

### Challenge 2: Add More Validations
Add these checks:
```java
.body("per_page", equalTo(6))
.body("data", hasSize(6))
```

### Challenge 3: Test a Different Endpoint
Try getting a single user:
```java
@Test
void getSingleUser() {
    given()
    .when()
        .get("https://reqres.in/api/users/2")
    .then()
        .statusCode(200)
        .body("data.id", equalTo(2))
        .body("data.first_name", notNullValue())
        .log().all();
}
```

---

## 🆘 Troubleshooting

### Tests Won't Run?
```bash
# Try this:
mvn clean compile
mvn test
```

### Dependencies Not Downloading?
```bash
# Force update:
mvn clean install -U
```

### Java Version Wrong?
```bash
# Check your JAVA_HOME
echo $JAVA_HOME

# On Mac/Linux, set it:
export JAVA_HOME=/path/to/java11

# On Windows:
set JAVA_HOME=C:\path\to\java11
```

---

## 📚 What's Next?

Now that you've run your first test, here's what to learn next:

### Option 1: Follow the Full Learning Path
Read the [Complete Learning Guide](LEARNING_GUIDE.md) for:
- Day-by-day tutorials
- Detailed explanations
- Hands-on exercises
- Advanced topics

### Option 2: Explore the API
Visit [https://reqres.in/](https://reqres.in/) to see:
- Available endpoints
- Request/response examples
- Status codes
- Sample data

### Option 3: Read the README
Check [README.md](README.md) for:
- Project structure
- All features
- Configuration options
- Best practices

---

## 🎓 Common Terms Explained

| Term | What It Means | Example |
|------|---------------|---------|
| **API** | Way for apps to communicate | Weather app gets data from weather API |
| **GET** | Retrieve data | Get user list |
| **POST** | Create new data | Create new user |
| **Status Code** | Response result indicator | 200 = success, 404 = not found |
| **JSON** | Data format | `{"name": "John", "age": 30}` |
| **Endpoint** | API URL | `/api/users` |
| **Request** | Data you send to API | User details to create |
| **Response** | Data API sends back | Created user with ID |

---

## 💡 Quick Tips

1. **Read Error Messages** - They usually tell you exactly what's wrong
2. **Start Simple** - Don't try to test everything at once
3. **Use .log().all()** - See full request/response details
4. **Check Documentation** - ReqRes.in has great API docs
5. **Practice Daily** - Even 15 minutes helps
6. **Ask Questions** - Community is here to help!

---

## 🎯 Your First 3 Tasks

Complete these to solidify your learning:

### ✅ Task 1: GET Request
Create a test that:
- Gets user with ID 1
- Validates the email address
- Checks the first name

### ✅ Task 2: POST Request
Create a test that:
- Creates a new user
- Validates status code is 201
- Checks created user has an ID

### ✅ Task 3: Chained Test
Create a test that:
- Creates a user (POST)
- Retrieves that user (GET)
- Updates the user (PUT)

---

## 🌟 Success Checklist

After this guide, you should be able to:
- [ ] Run tests using Maven
- [ ] Understand Given-When-Then pattern
- [ ] Make GET requests
- [ ] Validate status codes
- [ ] Validate response body
- [ ] Read test reports
- [ ] Modify existing tests
- [ ] Create simple new tests

---

## 🚀 You're Ready!

Congratulations! You've successfully:
- ✅ Set up your environment
- ✅ Run your first API test
- ✅ Understood the test structure
- ✅ Learned basic validations

**Next Step:** Open [LEARNING_GUIDE.md](LEARNING_GUIDE.md) and start Day 1!

---

## 📞 Need Help?

- **Stuck?** Check the [Troubleshooting section](README.md#-troubleshooting)
- **Questions?** Open a GitHub issue
- **Want to learn more?** Read the [Learning Guide](LEARNING_GUIDE.md)

---

<div align="center">

### 🎉 Happy Testing!

You're now an API tester! Keep practicing and building your skills.

**Remember:** Every expert was once a beginner. Keep going! 💪

[⬆ Back to Top](#-quick-start-guide---get-testing-in-5-minutes)

</div>
