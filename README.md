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

## Database Schema

### Customer Table
| Column Name  | Data Type  | Constraints |
|-------------|-----------|-------------|
| customer_id | BIGINT    | PRIMARY KEY, AUTO_INCREMENT |
| name        | VARCHAR   | NOT NULL |
| phone_no    | VARCHAR(10) | NOT NULL |
| address     | VARCHAR   | NOT NULL |
| points      | INT       | TRANSIENT (Not stored in DB) |


### Transaction Table
| Column Name    | Data Type  | Constraints |
|---------------|-----------|-------------|
| transaction_id | BIGINT    | PRIMARY KEY, AUTO_INCREMENT |
| customer_id    | BIGINT    | FOREIGN KEY (References `Customer.customer_id`), NOT NULL |
| product_name   | VARCHAR   | NOT NULL |
| amount         | DOUBLE    | NOT NULL, POSITIVE VALUE |
| date          | DATE      | NOT NULL, PAST OR PRESENT |
