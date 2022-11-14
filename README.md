# Flash-Go (Online Cab Booking Application)
REST API developed for an Online Cab Booking Application.This API handles an Admin and 2 different types of users(Customer and Driver) and performs all the fundamental CRUD operations of any Online Cab Booking Application platform with user validation at every step.
This project is developed by team of 5 Back-end Developers during project week in Masai School.

## Badges

![Badge](https://visitor-counter-badge.vercel.app/api/suranjanachary/glad-creator-1065)

## Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Validation
- MySQL
- Lambok
- Swagger Ui

## Modules
- Login Module
- Admin Module
- Customer Module
- Driver Management Module
- Cab Management Module
- Trip Booking Management Module

## Flash-Go

![CW_erd-Page-2](https://github.com/suranjanachary/glad-creator-1065/blob/main/FLASH-GO.png?raw=true)

## ER Diagram

![CW_erd-Page-1 drawio](https://github.com/suranjanachary/glad-creator-1065/blob/main/model%20class.png?raw=true)


## Service Interface

![CW_erd-Page-2](https://github.com/suranjanachary/glad-creator-1065/blob/main/service%20interface.png?raw=true)



## Features

- Customer, Driver and Admin authentication & validation with session UUID.
- Admin Features:
  - Admin can register, log in, log out, update and delete accounts
  - Admin have control over the entire application
  - Admin can manage Cab, Driver, and Booking
  - Admin can access the details of different customers, drivers and trip bookings
  - Only logged-in Admin can access all features of Admin
- Customer Features:
  - Customers can register themselves with the application, logging in and logout into the application
  - Customers can book cabs for the desired location from a specific location and can cancel the booked trip
  - Customers can update, or delete their accounts
  - Only logged-in users can access all customer features
- Driver Features:
  - Drivers can register themselves with the application, log in and log out into the application
  - Drivers can update the trip status
  - Drivers can update and delete their accounts
  - Only logged-in drivers can access all driver features

## Installation and Run

```
#changing the server port
server.port=8888
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/flashgodb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
#No handler found
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false
#swagger-ui
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
```

## API Root and Endpoint

```
https://localhost:8888/
```

```
http://localhost:8888/swagger-ui/
```

## Contributors

- [Suranjan Achary](https://github.com/suranjanachary)
- [Satadal Banerjee](https://github.com/SatadalBanerjee)
- [Saurav Kumar](https://github.com/sauravugi)
- [Sanket Wankhede](https://github.com/sank29)
- [Shubham Ganeshrao Ughade](https://github.com/shubhamughade)



