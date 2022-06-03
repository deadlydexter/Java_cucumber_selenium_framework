Feature: Test Tagged Hooks
 
@First @NON-UI
Scenario: This is First Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step
 
@Second	@NON-UI
Scenario: This is Second Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step
 
@Third	@UI
Scenario: This is Third Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step