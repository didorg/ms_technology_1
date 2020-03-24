# ms_technology_1
##### Microservices apps that use the following technology:  
`Java 1.8, Spring Boot, Hibernate, PostgreSQL:`  
##### &&:  
- Store configuration details on cloud using **CloudConfig**
- **Load balance** requests between microservices using **Ribbon**
- **Discover services** in cloud using **Eureka**
- **Increase resilience** through **Hystrix**
- Use asynchronous communication to improve performance
- Create a **API gateway** using **Zuul**
- Simplify **REST calls** through **Feign**
- **Secure microservices** using **OAuth** through **Spring Cloud Security**
- **Monitor microservices** through Turbine, **Sleuth and Zipkin**

- restaurant-ms
- customer-ms
- order-ms   

resturant (id, restaurantName, restaurantLocation)  
customer (id, customerName, customerLocation)  
order (id, orderNumber, restaurantId, customerId, createdAt)  

A customer -> places an order -> to a restaurant  

Suppose you are a driver and this is what you received to deliver an order to a client:
```
order {
	- id
	- orderNumber
	- createdAt
	- customer {
	  - id
	  - customerName
	  - customerLocation
	}
	- restaurant {
	  - id
	  - restaurantName
	  - restaurantLocation
        }
 }
``` 

Basically you need to go to the restaurant location, pick up the order and deliver it to the customer location
