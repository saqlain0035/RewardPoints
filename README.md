# RewardPoints
The project gives the total reward points earned according to the requirements provided by each customer and also it provides the reward points earned in a particular month of all the customers.
## Features
- Add customer details
- Add transaction details
- Get reward points earned for all customer
- Get reward points earned for all customer of a particular month
## Technology Used
- Spring Boot
- Spring Data JPA
- SQL Database
- Mokito for Testing
## API Endpoints
### Add Customer
- URL: localhost:8080/customer
- Method: POST
- Content-type: application/json
- Request Body:

  {
  
    "name": "Saqlain Ashraf",
  
    "phoneNo": "0000000000",
  
    "address": "Sector 1, Airoli, Navi Mumbai"

}

