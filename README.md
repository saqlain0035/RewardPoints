# RewardPoints
The project gives the total reward points earned according to the requirements provided by each customer and also it provides the reward points earned in a particular month of all the customers.
## Features
- Add customer details
- Add transaction details
- Get reward points earned for all customer
- Get reward points earned for all customer of a particular month
## Technology Used
- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- SQL Database
## API Endpoints

| API URL             | Method | Description                          |
|---------------------|--------|--------------------------------------|
| `/customer`        | POST   | Add a new customer                  |
| `/transaction`     | POST   | Add a new transaction               |
| `/points`          | GET    | Get total points for all customers  |
| `/points/monthly`  | GET    | Get monthly points for all customers|
