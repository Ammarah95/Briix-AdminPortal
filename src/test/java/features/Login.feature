Feature: Login Functionality

  @validLogin
  Scenario: Verify the login functionality with valid credentials
    Given User is on login page
    When User provide a valid credentials "Ammarah@transformhub.com" "Test@1234"
    Then User should be landed on OTP verification page
    When User provide the OTP
    Then Verify the user successfully logged in and landed on dashboard

  @validLogin
  Scenario: Verify the login functionality with invalid OTP
    Given User is on login page
    When User provide a valid credentials "Ammarah@transformhub.com" "Test@1234"
    Then User should be landed on OTP verification page
    When User provide the OTP
    Then Verify the user successfully logged in and landed on dashboard

  @invalidLogin
  Scenario Outline: Email and Password Validation for Login
    Given User is on login page
    When User provide a valid credentials "<email>" "<password>"
    Then Verify the message "<message>"

    Examples: 
      | email                   | password | message                                                                                                                             |
      |                         |          | Field can't be empty!                                                                                                               |
      | abc                     |   123333 | Email id is not valid!                                                                                                              |
      | abc@mail7.io            |          | Field can't be empty!                                                                                                               |
      | amarah@transformhub.com | password | Password is not in valid format. Please use combination of capital, small letters,numbers and special characters with min length 8. |
