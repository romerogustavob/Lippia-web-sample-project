Feature: Initial page As a web user I want to navigate PhpTravels web page and search a flight 
and complete the form.
	
  @Test
	Scenario: As a web user I want to navigate PHPTravel and search a flight
	  Given The user is in flight page
	  When The user search a flight
	  Then The page search a list of flights
	  
#este test case no me queda claro	  
	@TestB
	Scenario: As a web user I want to navigate PHPTravel and search a flight
	  Given The user is in flight page
	  When The user complete a flight form
	  Then The form flight fields are completed