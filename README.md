# Quiz Application

This is a Spring Boot application for a quiz system where users can start a quiz session, get questions, submit answers, and retrieve results. The application uses an in-memory H2 database for data storage.

## Features
1. **Start Quiz:** Generates a unique session ID to identify the quiz session.
2. **Get Question:** Retrieves a question based on the session.
3. **Submit Answer:** Submits an answer with the question ID and answer ID.
4. **Get Result:** Returns the quiz results for the session.

## Requirements
- **Java**: 17 or higher
- **Maven**: 3.8.1 or higher
- **IDE**: IntelliJ IDEA, Eclipse, or any Java-supported IDE
- **REST Client**: Postman or any REST client to test the API endpoints

---

## Installation and Setup

### Step 1: Clone the Repository
Clone the repository to your local system:
```bash
  git clone <repository-url>
  cd quiz-application
```
 

## Configure the Application
This project uses H2 as an in-memory database. No additional configuration is required, but if you want to persist data or change the database, you can modify the application.properties file:

properties
Copy code
```bash
# application.properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

##  Build the Project
Run the following command to build the project:

```bash

mvn clean install
```

Step 4: Run the Application
Start the application using:

```bash

mvn spring-boot:run
```
The application will start on http://localhost:8080.

## API Endpoints
**1. Start the Quiz**
Endpoint:
POST /start

Description:
Generates a unique session ID for the quiz.

Response:

```bash
{
  "sessionId": "your-session-id"
}
```

**2. Get a Question**
Endpoint:
GET /question

Headers:

```bash
{
  "sessionId": "your-session-id"
}
```
Response:

```bash
{
  "questionId": 1,
  "question": "What is the capital of France?",
  "options": [
    { "optionId": 1, "optionText": "Paris" },
    { "optionId": 2, "optionText": "London" },
    { "optionId": 3, "optionText": "Berlin" }
  ]
}

```

**3. Submit an Answer**
Endpoint:
POST /answer

Headers:

```bash
{
  "sessionId": "your-session-id"
}
```
Body:

```bash
{
  "questionId": 1,
  "answerId": 1
}
```
Response:

```bash
{
  "message": "Answer submitted successfully"
}
```

**4. Get the Quiz Result**
Endpoint:
GET /result

Headers:

```bash
{
  "sessionId": "your-session-id"
}
```
Response:

```bash
{
  "score": 3,
  "totalQuestions": 5,
  "correctAnswers": 3
}
```
## Accessing the H2 Database

To view or debug the H2 database:

**Navigate to:**  
`http://localhost:8080/h2-console`

**Use the following credentials:**  
- **JDBC URL:** `jdbc:h2:mem:testdb`  
- **Username:** `sa`  
- **Password:** `password`  

---

## Testing the Application

You can use Postman or any REST client to test the API endpoints. Follow these steps:

1. **Start the quiz by calling `/start`.**  
2. **Use the returned `sessionId` in subsequent API calls as a header.**  
3. **Retrieve questions using `/question`.**  
4. **Submit answers using `/answer`.**  
5. **Retrieve the results using `/result`.**

---

## Technologies Used

1. **Spring Boot**: Backend framework.  
2. **H2 Database**: In-memory database.  
3. **Maven**: Build tool.  
4. **Java**: Programming language.  

