Specific Only for test purposes:

Author: Luis Claudio Tavares


Used Tools

	MySQL Workbench 
	Eclipse SpringToolSuite4 - last
	MySQL Database - last - mysql  Ver 8.0.22 for Win64 on x86_64 (MySQL Community Server - GPL)
	Spring JPA
	Spring MVC
	Spring Security

	Plugins
		Spring Boot 2.1.2.RELEASE
		Spring 5.1.4.RELEASE
		Hibernate 5.3.7
		HikariCP 3.2.0 - https://github.com/brettwooldridge/HikariCP - https://github.com/brettwooldridge/HikariCP-benchmark
		mysql-connector-java:jar 8.0.13
		Maven 3
		Java 8

1- MySql Database - Shema Generate
	Create database HealthCare
	Choose Create schema HealthCare in Mysql
	/config/SchemaMySqlDatabase.sql
	
2- Configuring:
	* must configure, java8, maven classepath
	* Change user, password for application:
		/healthcare/src/main/resources/application.properties
		spring.datasource.username = root
		spring.datasource.password = password
	
3- Starter:	
	start.cmd
	
4- Enjoy application: 
	http://localhost:8080/


____________________________________________

TODO:
Future Releases:

- SPRING rest parameters
- SPRING cloud comunnicate
- SPRING security login acesses restriction
- coin operation
- backend ajax with json (react/outher)

