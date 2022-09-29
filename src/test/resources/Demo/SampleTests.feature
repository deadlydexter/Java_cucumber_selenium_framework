Feature: Test Tagged Hooks
 
@First
Scenario: This is First Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step
 
@Run @NON-UI
Scenario: This is Second Scenario non-ui
	Given this is the first step one
	When this is the second step two
	Then this is the third step three


@Run @UI
Scenario: As a user I should be able to login with Valida credentials
	Given user is on the LoginPage
	And user enters valid username and password
	And user clicks on Login button
	Then user should land on the HomePage