@basicTests
Feature: basicBarclay-workflow

	@us001
	Scenario: Successful Login with Valid Credentials
	Given User Launch needed website
	And Validated api response



	@datadriven
	Scenario Outline: Successful Login and validate different validations on same attributes on the basis of different data <key>
		Given User Launch needed website
		When User Clicked on Registered Customers More Info
		Then User Entered First Name
		And User Clicked on Search
		And Validated api response
		Examples:
		| key |
		| us002_orderOfVictoria |
		| us002_orderOfBrenda |

	@us003 @scripttag
	Scenario: Successful Login and script validation
		Given User Launch needed website
		And Validated nopCommerce script
		And Validated api response