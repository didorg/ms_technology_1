# Microservices application   
### Java 8, Spring Boot 2.2.6, Hibernate, PostgreSQL  
#### &&:  
- Store configuration details on cloud using **CloudConfig**. 
- **Load balance** requests between microservices using **Ribbon**.  
- **Discover services** in cloud using **Eureka**. 
  - Ribbon with Eureka.  
- **Increase resilience** through **Hystrix** 
  - Circuit Breaker pattern, Fail Silent approach. 
- Use **asynchronous communication** to improve performance. 
  - hystrix-javanica: Asynchronous Execution.  
- Create a **API gateway** using **Zuul**. 
  - Zuul and Ribbon. 
  - Zuul and Hystrix.
  - Cookies and **Sensitive Headers**.  
  [official reference]   
- Simplify **REST calls** through **Feign**.   
Implemented only to get `restaurant-ms`. **RestTemplate** is still used to get `customer-ms`.
- **Monitor microservices** through Turbine, **Sleuth and Zipkin**.  
  - **Zipkin** (docker run -d -p 9411:9411 openzipkin/zipkin).   
  https://github.com/openzipkin/zipkin.
- **Secure Config**. 
  - **Spring Basic Authentication** Securing Cloud Config Server. 
  - **Encrypt** the sensitive values using Postman(Basic Auth and the value to encrypt), you need the key in the cloud-config-server.       
    - disable CSRF in cloud-config-server to /encrypt & /decrypt  
    - https://github.com/spring-cloud/spring-cloud-config/issues/934#issuecomment-398740472 
  
****************
**CloudConfig**  
- [ms-config]
- [github-spring-cloud-config-server]
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

[ms-config]:https://github.com/didorg/ms-config
[github-spring-cloud-config-server]:https://github.com/didorg/github-spring-cloud-config-server
[official reference]:https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.2.2.RELEASE/reference/html/#cookies-and-sensitive-headers
