# Spring Boot Error Handling

## 📝 Table of Contents

- [Overview](#overview)
- [Error Handling Strategies](#error-handling-strategies)
  - [Service Layer Error Handling](#service-layer-error-handling)
  - [ErrorBody Class](#errorbody-class)
- [Validation](#validation)
- [Singleton Pattern Analogy](#singleton-pattern-analogy)
- [Usage](#usage)
- [Resources](#resources)
- [License](#license)

## Overview

This project is a Spring Boot application that demonstrates effective error handling strategies. It aims to manage errors gracefully and provide users with clear and consistent feedback. The README outlines the key strategies for error handling and uses the Singleton Pattern as an analogy for these concepts.

### Key Concepts

- **Centralized Error Management**: Ensures consistency and maintainability in error handling across the application.
- **Custom Error Responses**: Provides meaningful error messages and appropriate HTTP status codes.
- **Graceful Degradation**: Maintains smooth application functionality even when errors occur.

## Error Handling Strategies

### Service Layer Error Handling

Errors in the service layer are handled by managing exceptions related to business logic and data access. This includes input validation and exception management, ensuring that errors are transformed into user-friendly messages and managed effectively.

### ErrorBody Class

In this project, the `ErrorBody` class is designed to provide a structured error response that aids frontend engineers in understanding and handling errors. The class includes the following fields:

- **`code`**: An integer representing the error code, which helps identify the type of error.
- **`message`**: A string containing a user-friendly error message.
- **`description`**: A string providing additional details about the error, which assists in debugging and understanding the issue.
- **`currentTime`**: A timestamp indicating when the error occurred, useful for logging and tracking purposes.

By using the `ErrorBody` class, errors are communicated in a clear and consistent manner, facilitating better error handling and user experience on the frontend.

## Validation

Validation is applied to ensure that input data meets defined constraints. The project uses Jakarta Bean Validation annotations in the `StudentDto` and `AddressDto` classes to enforce these constraints:

- **AddressDto**:
  - Ensures that fields such as country, city, and street are not blank and have appropriate length constraints.
  - Validates that the building number is a positive integer.

- **StudentDto**:
  - Ensures that the name is not null and is within the specified length range.
  - Validates that the email is not blank and follows a valid email format.
  - Ensures that the age is within a specific range and is not null.

## Singleton Pattern Analogy

The Singleton Pattern ensures a single instance of a class and provides a global access point to it. This analogy is used to illustrate error handling strategies:

- **Single Instance**: Centralized error handling is akin to a Singleton's single instance, ensuring a unified error management approach.
- **Global Access Point**: Just as a Singleton provides global access to its instance, centralized error handling provides a unified method for error management.
- **Controlled Management**: Centralized error handling, like the Singleton Pattern, ensures consistent and controlled management of errors.

## Usage

To effectively implement error handling in your Spring Boot application:

- Implement service layer error handling for managing business logic exceptions and validation errors.
- Create and manage custom exceptions to handle specific error scenarios consistently.
- Apply validation annotations to ensure that DTOs (Data Transfer Objects) meet required constraints.
- Utilize the `ErrorBody` class to provide structured and informative error responses to frontend engineers.

## Resources

- [Spring Boot Documentation - Error Handling](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-error-handling)
- [Singleton Pattern - Wikipedia](https://en.wikipedia.org/wiki/Singleton_pattern)
- [Effective Java - Item 2: Consider implementing a Singleton pattern](https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997)
