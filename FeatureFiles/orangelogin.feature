Feature: This feature will contain Login page tests 
	
	@scenariowithoutDatatable
	Scenario: Login Functionality Validation
    When I open OrangeHRMS URL on "ChromeBrowser"
    And I enter "Admin" in usernameField
    And I enter "admin123" in passwordField
    When I click Login Button
    Then I Should see Welcome Link on Home Page
    When I close the browser