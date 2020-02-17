Feature: Initial page As web user I want to navigate into PhpTravels and look into blog page
 
  @Test
  Scenario: As a web user i want to navigate PHPTravels blog page
		Given The user is in home page
		When The user go to Blog page
		Then The Blog page is displayed