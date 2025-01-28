# Airline Reservation Program

This project is an Airline Reservation Program that allows users to search for airline tickets based on destinations and book tickets seamlessly. It is a backend application built using Spring Boot and connected to a MySQL database. The project is designed using the Singleton design pattern and follows a 3-tier architecture style for clear separation of concerns and maintainability.

## Features

### Implemented:
Search Tickets:
- Users can query the database for available tickets by destination.
  
Book Tickets:
- Users can reserve airline tickets, and the booking information is stored in the MySQL database.
  
API Testing:
- APIs are tested using Postman, allowing seamless debugging and validation of the application's functionality.

### Upcoming Improvements:
- Implement a user authentication system to secure ticket bookings.
- Add a feature to update or cancel bookings.
- Provide advanced search options like filtering by price, flight date, and airlines.

## Technologies Used

- Java: Core language for development.
- Spring Boot: Framework used to build RESTful APIs and handle application logic.
- MySQL: Database for storing ticket and reservation information.
- Postman: For testing and validating the REST APIs.
- Gradle: Build tool to manage project dependencies.


## Installation

Clone the Repository:
```
git clone https://github.com/your-username/airline-reservation.git  
cd airline-reservation
```

Set Up the Database:
```
spring.datasource.url=jdbc:mysql://localhost:3306/airline_reservation  
spring.datasource.username=your-username  
spring.datasource.password=your-password
```

Test with Postman:
- manually test endpoints.

## Future Improvements

- Adding front-end to this program.
- More defined search features.

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![mysql](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

