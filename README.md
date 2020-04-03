# ms_technology_1
##### Microservices apps that use the following technology:  
`Java 1.8, Spring Boot, Hibernate, PostgreSQL:`  
##### &&:  
- Store configuration details on cloud using **CloudConfig**  (OK)
- **Load balance** requests between microservices using **Ribbon**  (OK)
- **Discover services** in cloud using **Eureka** (OK)
  - Ribbon with Eureka  (OK)
- **Increase resilience** through **Hystrix** (OK)
  - Circuit Breaker pattern, Fail Silent approach (OK)
- Use **asynchronous communication** to improve performance (OK)
  - hystrix-javanica: Asynchronous Execution  (OK)
- Create a **API gateway** using **Zuul** (OK)
  - Zuul and Ribbon (OK)
  - Zuul and Hystrix  (OK)
- Simplify **REST calls** through **Feign** (OK)  
Implemented only to get `restaurant-ms`. **RestTemplate** is still used to get `customer-ms`
- **Secure microservices** using **OAuth** through **Spring Cloud Security**        (PENDING)
- **Monitor microservices** through Turbine, **Sleuth and Zipkin**                  (PENDING)

****************
**CloudConfig**  
- ms-config
- github-spring-cloud-config-server
**************** 
**Services**   
- eureka-server  
- zuul-server
****************
**Microservices**    
- restaurant-ms
- customer-ms
- order-ms   
****************
resturant (id, restaurantName, restaurantLocation)  
customer (id, customerName, customerLocation)  
order (id, orderNumber, restaurantId, customerId, createdAt)  

A customer -> places an order -> to a restaurant  

Suppose you are a driver and this is what you received to deliver an order to a client:
```
{
    "id": "101001",
    "orderNumber": "Ord-Nro-1",
    "createdAt": "2020-03-29T01:30:19.396+0000",
    "customer": {
        "id": "101302",
        "customerName": "Dan Jav",
        "customerLocation": "345 Beautiful Rd, Mercerville, NJ"
    },
    "restaurant": {
        "id": "1102",
        "restaurantName": "Sabor Cubano",
        "restaurantLocation": "12 Beautiful Rd, Mercerville, NJ"
    }
}
``` 

Basically you need to go to the **restaurant location**, pick up the **order number** and deliver it to the **customer location**
