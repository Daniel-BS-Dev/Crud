# Crud

## Ferramentas utilizadas

   * JDK 11
   * STS
   * Postman
   * Git
   * Versão do maven 2.4.4
   
## Modelo Conceitual
![crud - Copia](https://user-images.githubusercontent.com/81425846/143029111-c36c0ece-12ce-4ec4-962a-8168b0577323.png)

## Dependências maven:

```java
    <dependency>
	      <groupId>org.springframework.boot</groupId>
	      <artifactId>spring-boot-starter-web</artifactId>
   </dependency>

   <dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>

  <dependency>
	   <groupId>com.h2database</groupId>
	   <artifactId>h2</artifactId>
	   <scope>runtime</scope>
  </dependency>

  <dependency>
	   <groupId>org.postgresql</groupId>
	   <artifactId>postgresql</artifactId>
	   <scope>runtime</scope>
  </dependency>

  <dependency>
	  <groupId>org.springframework.boot</groupId>
	  <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>

  <dependency>
	  <groupId>org.springframework.boot</groupId>
	  <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  
  
   ``````````
   
   
   
   
## Arquivos de configuração:

   ### application.properties
   
          spring.profiles.active=test

          spring.jpa.open-in-view=false
   
   ### application-test.properties
   
         spring.datasource.url=jdbc:h2:mem:testdb
         spring.datasource.username=sa
         spring.datasource.password=

         spring.h2.console.enabled=true
         spring.h2.console.path=/h2-console
  
  
      
Daniel Benedito da Silva

Email: danielbenedito263@gmail.com
