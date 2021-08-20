Feature: Investment Functionality

Background:
		Given User is on login page by using "chrome"
    When User provide a valid credentials "elialeeza9029@gmail.com" "Test@123"
    Then User should be landed on OTP verification page
    When User provide the OTP
    
   @InvestFunctionality
  Scenario: Verify accept functionality
    Given User is on Investment page
    When User filtered out "Pending" status
    And Search the customer name "aniket"
    And User accept the investement 
    Then Verify the status of investment should be changed
    
    @InvestFunctionality1
  Scenario: Verify processed status
    Given User is on Investment page
    When User filtered out "Processed" status
    And Search the customer name "ammarah"
    Then Verify the status of investment should be changed
    
      @InvestFunctionality
  Scenario: Verify cancelled status
    Given User is on Investment page
    When User filtered out "Cancelled" status
    And Search the customer name "ammarah"
    Then Verify the status of investment should be changed
    
     @InvestFunctionality
  Scenario: Verify reject functionality
    Given User is on Investment page
    When User filtered out "Pending" status
    And Search the customer name "ammarah"
    And User reject the investement
    Then Verify the status of investment should be changed
   