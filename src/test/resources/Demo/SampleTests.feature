Feature: Test Tagged Hooks
 
@First @NON-UI
Scenario: This is First Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step
 
@Second	@NON-UI
Scenario: This is Second Scenario non-ui
	Given this is the first step one
	When this is the second step two
	Then this is the third step three
 
@Third	@UI
Scenario: This is Third Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step