Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the “Initial home page”
    And I search for “Thinking in Java”
    And I am redirected to a “Search Page”
    And Search results contain the following products
      | Thinking in Java         |
      | Thinking Java Part I      |
      | Core Java Professional    |