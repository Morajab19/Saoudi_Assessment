Feature: guest can manage his cart by adding items and checkout
  Background:
    Given initiate guest checkout feature

  Scenario: guest add product to his/her cart and checkout
    When guest enters the product name "Apple Macbook"
    And Clicks on search button
    When Guest scrolls to Apple MacBook Pro 13-inch and clicks Add to cart Button
    And enters quantity of "2" and click on ADD TO CART Button and open cart
    And guest confirm the terms and click checkout button
    And choose to continue as a guest
    And type the first name "Mohammed", last name "Rajab", and the email "moRajab@gmail.com"
    And selects the country "Egypt", city "Cairo", address1 "El Nozha", zip "12345", number "01559950234" and  click Continue
    And selects the next day air shipping methode and click continue
    And selects the check payment method and click continue
    And checks the order email "moRRRRajjab@gmail.com", number "01559950234" and click confirm
    Then the guest order is placed successfully
