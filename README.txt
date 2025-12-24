# Gym Management System 🏋️‍♂️

A robust and scalable management application built with **Java Swing**. This project demonstrates a professional approach to software development by implementing a **3-Tier Architecture** and providing support for multiple database environments.

---

## 🏗 Architectural Overview
To ensure clean code, maintainability, and separation of concerns, the project is structured into three distinct layers:

1.  **Presentation Layer (UI):** Developed using Java Swing to provide an intuitive and user-friendly interface for gym administrators.
2.  **Business Logic Layer (BLL):** Contains the core functional logic, validation rules, and data processing.
3.  **Data Access Layer (DAL):** Implements the DAO (Data Access Object) pattern to abstract and encapsulate all interactions with the database.

---

## 💾 Multi-Database Support
One of the key features of this project is its flexibility. I have developed and maintained two separate versions of the database backend:

* **MySQL Version:** Optimized for standard server-based environments using MySQL Workbench.
* **Java DB (Derby) Version:** An embedded version created specifically for portability and seamless execution within the NetBeans IDE environment without external dependencies.

---

## 🚀 Key Features
* **Member Management:** Full CRUD operations for gym members, including membership duration tracking.
* **Coach Administration:** Manage coach profiles and track years of professional experience.
* **Financial Tracking:** Integrated payment system to monitor member contributions and payment dates.
* **Relational Integrity:** A well-structured schema ensuring consistent relationships between Members, Coaches, and Payments.

---

## 🛠 Technical Challenges & Solutions
* **Cross-DB Compatibility:** Overcame the challenge of differing SQL syntaxes (e.g., Auto-increment vs. Identity columns) between MySQL and Derby through strategic code refactoring.
* **Architecture Decoupling:** Successfully separated the UI from the database logic, allowing for easier updates and testing of the business rules.
* **Exception Handling:** Implemented comprehensive SQL error handling to ensure system stability during database migrations.

---

## 🛠 Technologies Used
* **Language:** Java (JDK 8+)
* **UI Framework:** Java Swing
* **Databases:** MySQL & Java DB (Derby)
* **Architecture:** 3-Tier (Presentation, Business, Data)
* **IDE:** NetBeans

---

## 🏁 How to Run
1.  **For MySQL:** Import the provided `.sql` file into your MySQL server and update the connection string.
2.  **For Derby:** Simply open the project in NetBeans, go to the **Services** tab, start **Java DB**, and run the application.