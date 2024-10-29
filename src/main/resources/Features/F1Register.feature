Feature: User Login in the website

  Scenario: User Login with valid data
    Given user navigates to Login page
    When user enter username "standard_user" and enter password "secret_sauce"
    And user click login
    Then a div containing text: Swag Labs is visible.



  Scenario: User Login with invalid data
    Given user navigates to Login page
    When user enter username "dsdfdfdfd" and enter password "11555578"
    Then a div with clas containing a message Epic sadface: Username and password do not match any user in this service is visible.