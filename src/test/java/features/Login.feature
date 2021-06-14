Feature: Login Functionality

  @validLogin
  Scenario: Verify the login functionality with valid credentials
  Given User is on login page
  When User provide a valid credentials Ammarah@transformhub.com Test@1234
  Then User should be landed on OTP verification page 
  When User provide the OTP
  Then Verify the user successfully logged in and landed on dashboard

 