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
- Response:
  {
  
    "customerId": 52,
  
    "name": "Saqlain Ashraf",
  
    "phoneNo": "0000000000",
  
    "address": "Sector 1, Airoli, Navi Mumbai",
  
    "points": 0
  
}
### Add Transaction
- URL: localhost:8080/transaction
- Method: POST
- Content-type: application/json
- Request:
  
  {
  
    "customerId": 1,
  
    "productName": "Chair",
  
    "amount": 1200,
  
    "date": "2024-02-01"
  
}
- Response:

  Data Inserted Sucessfully

### Get all Points
- URL: localhost:8080/allPoints
- Method: GET
- Content-type: application/json
- Response:
  
  [
  
    {
        "customerId": 1,
        "name": "Saqlain Ashraf",
        "phoneNo": "7870508183",
        "address": "Sector 1, Airoli, Navi Mumbai",
        "points": 184900
    },
    {
        "customerId": 3,
        "name": "Rohit",
        "phoneNo": "0000000000",
        "address": "Sector 1, Airoli, Navi Mumbai",
        "points": 2560
    },
    {
        "customerId": 52,
        "name": "Saqlain Ashraf",
        "phoneNo": "0000000000",
        "address": "Sector 1, Airoli, Navi Mumbai",
        "points": 0
    }
]
