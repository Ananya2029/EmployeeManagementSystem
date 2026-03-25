# Employee Record Management System

A console-based Employee Record Management System built using Java, JDBC, and MySQL. This project performs CRUD operations (Create, Read, Update, Delete) to manage employee data efficiently.

---

## 🚀 Features
- Add new employee records  
- View all employees  
- Update employee salary  
- Delete employee records  
- MySQL database integration using JDBC  

---

## 🛠️ Tech Stack
- Java (Core Java)
- JDBC
- MySQL
- Eclipse IDE

---

## 📂 Project Structure

EmployeeManagementSystem/
│
├── src/
│ ├── com.emp.main
│ ├── com.emp.dao
│ ├── com.emp.model
│ └── com.emp.util
│
├── lib/
│ └── mysql-connector-j.jar


---

## 🗄️ Database Setup
```sql
CREATE DATABASE empdb;

USE empdb;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50),
    salary DOUBLE
);
