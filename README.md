Library Management System (JDBC)
Overview

The Library Management System is a Java-based application developed using JDBC (Java Database Connectivity) to manage library operations efficiently. It allows users to manage books, issue and return books, and maintain student records.

This project is created for learning and practicing Java, JDBC, and database management concepts.

Features

Add new books
View all books
Issue books to students
Return books
Delete book records
Search books by ID or name
Manage student details
Simple console-based interface

Technologies Used

Java
JDBC (Java Database Connectivity)
MySQL Database
IDE (Eclipse / IntelliJ IDEA / VS Code)

Database Setup
Install MySQL and open MySQL Workbench or terminal.
Create database:
CREATE DATABASE library_db;
USE library_db;

Create tables:

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(100)
);

CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    book_id INT,
    issue_date DATE,
    return_date DATE,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);
JDBC Configuration

Update your database credentials inside DBConnection.java:

String url = "jdbc:mysql://localhost:3306/library_db";
String user = "root";
String password = "your_password";

How to Run
Clone the repository:
git clone https://github.com/your-username/library-management-system.git
Open the project in your IDE.
Add MySQL Connector JAR file to the project.
Run Main.java.

Sample Operations

Add Book
View Books
Issue Book
Return Book
Delete Book
Add Student

Learning Outcomes

Understanding JDBC concepts
CRUD operations using Java
Database design and relationships
Handling real-world library operations
