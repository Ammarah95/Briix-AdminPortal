Feature: Property Trading Functionality

  Background: 
    Given User is on login page by using "chrome"
    When User provide a valid credentials "elialeeza9029@gmail.com" "Test@123"
    Then User should be landed on OTP verification page
    When User provide the OTP

  @PropertyTrading
  Scenario Outline: Verify  functionality
    Given User is on Property Trading page
    When User filtered out the status "<status>" 
    Then Verify the status "<status>"
    When User change the assignee name "<assigneeName>"
    And Click on "<details>"
    Then Verify the details of property

    Examples: 
      | status         | assigneeName | details            |
      | Pending        | Ammarah      | Peoperty Details   |
      | Pending        | Ammarah      | Manage Transaction |
      | Cancel         | Ammarah      | Peoperty Details   |
      | Cancel         | Ammarah      | Manage Transaction |
      | Completed      | Ammarah      | Peoperty Details   |
      | Completed      | Ammarah      | Manage Transaction |
      | All            | Ammarah      | Peoperty Details   |
      | All            | Ammarah      | Manage Transaction |
      | Assigned to me | Ammarah      | Peoperty Details   |
      | Assigned to me | Ammarah      | Manage Transaction |
      | Unassigned     | Ammarah      | Peoperty Details   |
      | Unassigned     | Ammarah      | Manage Transaction |
      
      
      
      
