# RESTful Spring API with JUnit tests

This is a RESTful service build with Spring Boot.

## About this Service

This service is a simple product RESTful API that performs 
CRUD operations on an in-memory H2 database.

Here are some notes about this application:
- Uses the Spring Framework
- Integration tests with JUnit and JSONAssert
- Uses H2 in-memory database

## Todo

- Add Swagger API documentation
- Make tests independent of each other. Right now, 
  if one test breaks it can cause others to break too,
  this violates good testing practices
  

## Endpoints

### 1. Create Product



***Endpoint:***

```bash
Method: POST
Accept: application/json
Content-Type: application/json
URL: http://localhost:8080/api/products/
```



***Body:***

```js        
{
    "title": "Konsole",
    "name": "PlayStation 5",
    "description": "Dieses Produkt kann man mit einem Einhorn oder Wahlweise mit einem Yeti oder Bigfoot vergleichen."
}
```



### 2. Delete By Id



***Endpoint:***

```bash
Method: DELETE
URL: http://localhost:8080/api/products/1
```



### 3. Delete Products



***Endpoint:***

```bash
Method: DELETE
URL: http://localhost:8080/api/products/
```



### 4. Get Products



***Endpoint:***

```bash
Method: GET
URL: http://localhost:8080/api/products/
```



### 5. Get Products By Id



***Endpoint:***

```bash
Method: GET
URL: http://localhost:8080/api/products/1
```



### 6. Update Product



***Endpoint:***

```bash
Method: PUT
Accept: application/json
Content-Type: application/json
URL: http://localhost:8080/api/products/
```



***Body:***

```js        
    {
        "id": 1,
        "title": "Konsole",
        "name": "PlayStation 4",
        "description": "Bam."
    }
```

