Feature:	Login
			As a employee
			I want to be able to login
			So I have access to the system

			#Persona
			#Peter - KCC
			#Petra - Technician
			
Rule:	email address cannot be empty

	@UI
	Scenario: an employee can log in successfully
		Given employee has an opportunity to fill in their email
		When Peter fills in "peter.peterson@gmail.com"
		Then Peter should be able to log into the system

	@UI
	Scenario: a message is shown that email and password are not correct
		Given employee has opportunity to fill in their email
		When Peter doesn't fill in an email address
		Then a message should be shown that email and password are not correct
		
Rule:	password cannot be empty

	@UI
	Scenario: an employee can log in successfully
		Given employee has an opportunity to fill in their password
		When Petra fills in "peter.peterson@gmail.com"
		Then Peter should be able to log into the system

	@UI
	Scenario: a message is shown that email and password are not correct
		Given employee has opportunity to fill in their email
		When Peter doesn't fill in an email address
		Then a message should be shown that email and password are not correct
