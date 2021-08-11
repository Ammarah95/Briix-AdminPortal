Feature: Investment Functionality

Background:
		Given User is on login page
    When User provide a valid credentials "elialeeza9029@gmail.com" "Test@123"
    Then User should be landed on OTP verification page
    When User provide the OTP
    
   @AcceptFunctionality
  Scenario: Verify Accept functionality
    Given User is on Investment page
    When User filtered out "Pending" status
    And Search the customer name "amit"
    And User accept the investement 
    Then Verify the status of investment should be changed
   