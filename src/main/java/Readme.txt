Steps For Springboot Crud Opperation


Step 1 : 	Open Spring Tool Suite
		Click on File 
		then Click On New and Select Other
		Then Select Spring Boot inside that Select Spring Starter Project 
		And Click On Next

Step 2 :	New Spring Starter Project
		Inside That 
		Change Name Of The Project 
		And Give Same Name to the Artifact
		Type : Maven
		Java Version : Any (8)
		Language: Java
		Packaging : Jar
		Group : com.anyName
		package : com.anyName
		
		Press NEXT -->

		Add Dependencies
		1. Spring Web
		2. Spring Data Jpa
		3. mySQl Driver
		Press FINISH --->And starting to Downloading All Dependincies

Step 3 : Open Porm.xml --> add MySQL dependency 
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
    			<groupId>mysql</groupId>
    			<artifactId>mysql-connector-java</artifactId>
    			<version>8.0.29</version>
		</dependency>

Step 4 : Open src/main/resourse
		click on application.properties -- ( Add Database realetaed information )
		
		spring.datasource.url= jdbc:mysql://localhost:3306/EmpDb
		spring.datasource.username= root
		spring.datasource.password= Ynhd@0077
		spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
		spring.jpa.hibernate.ddl-auto=none


Step 5 : Create DataBase and  table in MySQl WorkBench

		create database IF NOT exists EmpDb;

		use EmpDb;

		## Drop table if exist Employee;

		Create table Employee(
			empid bigint Not Null auto_increment,
    			emp_name varchar(50) default null,
    			emp_salary float default null,
    			emp_age integer default null,
    			emp_city varchar(50) default null,
    			primary key(empid)
		);

		select * from Employee;


Step 6 : Creat Packages
		
		1. Creat a package --> com.empCrudDemo.model
				create class --> Employee.Java  


		
		2. Creat a package --> com.empCrudDemo.controllers 
				create class --> EmployeeController.Java  

		3. Creat a package --> com.empCrudDemo.repository 
				create interface --> EmployeeRepository.Java  








