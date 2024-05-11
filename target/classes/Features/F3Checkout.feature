Feature: Create order
  @User
  Scenario: user enters valid info and the cart has at least one item
    Given initiate checkout
    When user navigates to cart page
    And user confirm the terms and click checkout button
    And select the country "Egypt", city "Cairo", address1 "El Nozha", zip "12345", number "01559950234" and  click Continue
    And select the next day air shipping methode and click continue
    And select the check payment method and click continue
    And check the order email "MohammedR@gmail.com", number "01559950234" and click confirm
    Then the order is placed successfully
