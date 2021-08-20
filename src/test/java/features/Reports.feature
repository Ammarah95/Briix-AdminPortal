Feature: Reports Functionality

  Background: 
    Given User is on login page by using "chrome"
    When User provide a valid credentials "elialeeza9029@gmail.com" "Test@123"
    When User provide a valid credentials "elialeeza9029@gmail.com" "Test@123"
    Then User should be landed on OTP verification page
    When User provide the OTP

  @ReportsFunctionality
  Scenario Outline: Verify download report functionality
    Given User is on Reports page
    When User select the option "<Report Type>"
    And Select from and to date "<FromDate>" "<ToDate>"
    And Click on download button
    Then Verify the data

    Examples: 
      | Report Type                    | FromDate   | ToDate     |
      | Property Transactions Report   | 08/12/2021 | 08/12/2021 |
      | Wallet Transactions Report     | 08/12/2021 | 08/12/2021 |
      | Loan Details Report            | 08/12/2021 | 08/12/2021 |
      | Trading and Settlement Report  | 08/12/2021 | 08/12/2021 |
      | Loan Repoyments Overdue Report | 08/12/2021 | 08/12/2021 |
