# :airplane: Welcome to [Airline Reservation Simulator](https://airline-res-simulator.herokuapp.com/)! :airplane:	

#### (*Flight Reservation System v2.0*) started life as: [Flight Reservation System](https://github.com/HarryDulaney/Flight-Reservation-System), a capstone assignment for my Application Programming II class Junior year in college, but I have gradually continued building onto it over the years. 
## Here's the criteria from the original project:
### Primary Goal:
- Build a flight reservation system from scratch.

### Functional Requirements:
- Code should be written in Java and at least in four different classes (files).
- At least 3 concepts of Encapsulation, Inheritance, Polymorphism or Composition should be utilized.
- Implement at least one abstract class and one interface.
- Code should be properly commented.
- Application should not crash and exception handling should be implemented in every section of the code.
- The database programming part should be done using JDBC.
- Oracle, MySQL, PostgreSQL or SQL server can be used as RDBMS (Choosing any other RDBMS is an automatic failure).

### Acceptance Criteria:
-	Upon start of the application, the user should see a splash screen
-	The Main menu gives the option to the user to register or login
-	Login requires username and password
-	Registration requires information such as first name, last name, address, zip, state, username, password, email, SSN and a security question for password recovery.
-	User can login using username and password (Should register first if not a member)
-	You should enable user to retrieve his password knowing the username with the security question.
-	There should be two types of users. Admin and customer. The admin has more privileges regarding this application.
-	After login into application a customer should be able to:
       - Search flight database for flights based on different criteria such as from city/ to 
       city/ date and time of flight etc.
       - Be able to book a flight and add that to his account.
       - Be able to delete a flight from his account.
       - Customer should not be able to book same flight more than once.
       - If there is a conflict about date and time of a flight, application should warn the 
       customer about this and should not let user book the conflicting flight.     
       - Application should keep track of number of passengers booked at each flight and 
       should not let a user book the flight if it is full.  

-	An admin should be able to do all customer activities in addition to be able to add, update or delete a flight.
-	User should be able to logout and upon login; previously booked reservation should be there in his/her account. 
-	 You should always provide an option in any case to go back to Main Menu.
-	Overall the application should be functional in most parts considering the requirements mentioned above.   
