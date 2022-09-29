Feature: Automated End2End Tests
  Description: This feature tests E2E scenario of a shopping website

  @UI @Third
  Scenario: user places an order by search an item
    Given user is on home page
    And choose to buy first item from search results
    And moves to checkout from cart
#    And enters "<customer>" Billings details on checkout page
#    And selects same delivery address
#    And selects mode of payment as "check"
#    And places the order
#    Then I see the order page with order number
