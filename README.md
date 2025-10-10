# Spring Boot Mockito Demo Example

This is a simple Spring Boot project that demonstrates how to use **Mockito** for unit testing. It covers mocking dependencies, writing service layer tests, and basic controller testing using `@Mock`, `@InjectMocks`, and `@WebMvcTest`.

## 📦 Project Structure 

```
mockito-demo-example/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.example.mockitodemo/
│   │           ├── controller/
│   │           ├── service/
│   │           ├── repository/
│   │           └── model/
│   └── test/
│       └── java/
│           └── com.example.mockitodemo/
│               ├── service/
│               └── controller/
├── pom.xml
└── README.md

````

## 🧰 Technologies Used

- Java 17+ (or 11+ depending on your setup)
- Spring Boot
- JUnit 5
- Mockito
- Maven

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 17 or newer
- Maven 3.6+
- An IDE (e.g., IntelliJ IDEA, Eclipse)

### Clone the Repository

```bash
git clone https://github.com/your-username/mockito-demo-example.git
cd mockito-demo-example
````

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application should start on `http://localhost:8080`.

## 🧪 Running Tests

To run unit tests:

```bash
mvn test
```

Mockito is used to mock dependencies in service and controller tests to isolate the unit being tested.

### Example Test Features

* Mocking repository calls in service tests.
* Verifying service logic.
* Controller tests with `@WebMvcTest` and mocked services.

## 📁 Example Test Class

```java
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindUserById() {
        User mockUser = new User(1L, "John Doe");
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        User result = userService.findById(1L);

        assertEquals("John Doe", result.getName());
    }
}
```

## ✅ Best Practices Covered

* Writing clean unit tests
* Mocking dependencies for isolation
* Verifying behavior with `Mockito.verify()`
