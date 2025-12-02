🚀 Blog Management System – Spring Boot + JWT + Redis + MySQL
<p align="center"> <img src="https://img.shields.io/badge/Java-17-orange" /> <img src="https://img.shields.io/badge/SpringBoot-3.x-brightgreen" /> <img src="https://img.shields.io/badge/MySQL-Database-blue" /> <img src="https://img.shields.io/badge/Redis-Cache-red" /> <img src="https://img.shields.io/badge/Status-Active-success" /> </p>

A high-performance Blog Backend System built with Spring Boot, featuring JWT authentication, role-based authorization, Redis caching, pagination, sorting, DTO mapping, and enterprise-grade architecture.

This backend is built like a real production-level system, optimized for speed, scalability, and clean maintainable code.

🌟 Key Features
🔐 1. Secure Authentication & Authorization

JWT-based Login & User Authentication

Role-based Access Control

Security Filters & Token Validation

📝 2. Full Blog CRUD System

Create / Update / Delete Posts

Manage Users & Categories

DTO responses for clean API output

⚡ 3. Redis Caching Integration

Caches frequently accessed data

Boosts performance significantly

Reduces MySQL server load

Faster API responses

📊 4. Pagination & Sorting

Optimized API listing

Faster large dataset handling

🛡 5. Exception Handling

Global exception handler using @RestControllerAdvice

Elegant & consistent error messages

🧼 6. Validation Layer

Built-in validation using:

@Valid  
@NotEmpty  
@Size  
@Email  


Ensures clean & safe request bodies.

🧱 Tech Stack
Layer	Technology
Backend	Spring Boot 3.x
Security	Spring Security + JWT
Database	MySQL
Caching	Redis
ORM	Hibernate / JPA
Mapping	ModelMapper
Build Tool	Maven
Tools	Postman, Git, GitHub
📁 Project Structure
src/
 ├── controller        # REST Controllers
 ├── service           # Business Logic Layer
 ├── repository        # Data Access Layer
 ├── security          # JWT, Filters, Configurations
 ├── payload           # DTOs + Request/Response POJOs
 ├── entity            # JPA Entities
 ├── exceptions        # Global Exception Handler + Custom Exceptions
 └── config            # App Configurations

🔄 High-Level Architecture
🔹 Request → Controller → Service → Repository → DB → Response
🔹 Request → Secured Route → JWT Filter → Token Validation → Continue
🔹 Request to Cached API → Redis Cache → Return Faster Response
🧠 API Workflow Diagram
               ┌──────────────┐
               │   Client      │
               └──────┬───────┘
                      │
                      ▼
            ┌────────────────────┐
            │   JWT Login API    │
            └────────┬──────────┘
                     │ Generates Token
                     ▼
        ┌────────────────────────────┐
        │  Client sends JWT in Header│
        └─────────────┬─────────────┘
                      │
                      ▼
      ┌──────────────────────────────────┐
      │ Spring Security + JWT Filter     │
      └──────────────────┬──────────────┘
                         │Valid Token?
                 ┌───────┴─────────┐
                 │                 │
                 ▼                 ▼
      ┌──────────────────┐   ┌──────────────┐
      │ Allowed Request   │   │ 401 Unauthorized │
      └──────────────────┘   └──────────────┘
