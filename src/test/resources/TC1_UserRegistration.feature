Feature: verifying user login module of flipkart

  
  Scenario Outline: Login flipkart using valid credentials
    Given User is on flipkart page
    When User clicks login button
    Then User enters phone number "<Phone>"
    When User enters valid OTP
    Then User should verify login sucess msg "Rathindar"

    Examples: 
      | Phone      |
      | 8883791319 |
