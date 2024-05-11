Feature: user can manage his cart by adding items
  Background:
    Given initiate add item to cart feature

  Scenario: user add product to his/her cart
    When user enters the product name "Apple Macbook"
    And Click on search button
    When user scrolls to Apple MacBook Pro 13-inch and clicks Add to cart Button
    And enter quantity of "2" and click on ADD TO CART Button and open cart
    Then the product "Apple MacBook Pro 13-inch" is added successfully to the cart