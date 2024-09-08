Feature: verifying user search product module of flipkart
@ak
  Scenario Outline: Login flipkart using valid credentials
    Given User is on flipkart page
    When User clicks login button
    Then User enters phone number "<Phone>"
    When User enters valid OTP
    Then User should verify login sucess msg "Rathindar"
    And User is giving data in searchbox "<Data>"
    Then User should select the watch
    When User should add to cart and place the order
    Then User should add new address "<name>","<mobileno>","<pincode>","<locality>","<address>","<city>" and "<state>"
    And User should verify email and continue
    Then User should Logout

    Examples: 
      | Phone      | Data  | name      | mobileno   | pincode | locality           | address                   | city     | state      |
      | 8883791319 | watch | Rathindar | 8883791319 |  637404 | pattathaiyankuttai | 7/3a,Reddypudur, Namakkal | Namakkal | Tamil Nadu |
