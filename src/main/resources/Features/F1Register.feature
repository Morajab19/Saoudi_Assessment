Feature: User register in the website

  Scenario: User register with valid data
    Given user navigates to registration page
    When user choose gender "male" , enter firstname "Mohammed" and enter lastname "Rajab"
    And user enter date of birth day "2" month "10" year "1999"
    And user enter email "MohammedRaja@gmail.com" , password "Asdfgh" and confirm with "Asdfgh"
    And click on register button
    Then user is registered successfully message appears