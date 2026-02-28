# 🔗 URL Shortener

A backend URL Shortener application built using **Java (Spring Boot)** and **MySQL** that converts long URLs into short, shareable links and tracks the number of visits.

This project demonstrates **REST API design, database integration, unique ID generation, and redirection handling**, making it ideal for backend and full-stack portfolios.

---

## 🚀 Features

- Generate unique short URLs
- Redirect short URLs to original URLs
- Track number of clicks per URL
- RESTful API architecture
- MySQL database persistence
- Base62 encoding for short URL generation

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven
- **API Style:** REST

---

## 📁 Project Structure

url-shortener

│

├── pom.xml

│

├── src/main/java/com/urlshortener

│ ├── UrlShortenerApplication.java

│ │

│ ├── controller

│ │ └── UrlController.java

│ │

│ ├── service

│ │ ├── UrlService.java

│ │ └── UrlServiceImpl.java

│ │

│ ├── repository

│ │ └── UrlRepository.java

│ │

│ ├── model

│ │ └── Url.java

│ │

│ └── util

│ └── Base62Encoder.java

│

└── src/main/resources

└── application.properties

---

## 🗄️ Database Setup

Create a MySQL database:

```sql
CREATE DATABASE url_shortener_db;
```

Update database credentials in application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```
Tables are automatically created using Hibernate (JPA).

---

▶️ How to Run the Project

1. Clone the repository
```bash
git clone https://github.com/your-username/url-shortener.git
```

2. Open the project in VS Code / IntelliJ

3. Start MySQL server

4. Update database credentials

5. Run the Spring Boot application
```bash
mvn spring-boot:run
```

6. Server starts on:
```bash
http://localhost:8080
```
