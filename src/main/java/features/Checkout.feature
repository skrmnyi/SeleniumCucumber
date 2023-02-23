Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the "Initial home page"
    And I search for "Thinking in Java"
    And I am redirected to a "Search Page"
    And Search results contain the following products
      | Thinking in Java       |
      | Thinking Java Part I   |
      | Core Java Professional |
    And I apply the following search filters
      | Price range  | 30 € +         |
      | Availability | In Stock (5)   |
      | Language     | English (17)   |
      | Format       | Paperback (22) |
    And I click "Add to basket" button for a product with the name "Thinking in Java"
    And I select "Basket / Checkout" in the basket pop-up
    And I am redirected to the "Basket Page"
    And Basket order summary is as following:
      | Delivery cost | Total   |
      | FREE          | 84,68 € |
    And I click ‘Checkout’ button on ‘Basket’ page
    And I checkout as a new customer with email test@user.com
    And Checkout order summary is as following:
      | Sub-Total | Delivery | Vat   | Total |
      | 63.75     | FREE     | 0, 00 | 63.75 |
    And I fill felivery adress information manually:
      | Full name | Delivery country | Address line 1   | Adress line       | Town/City | Country/State | Postcode |
      | John      | Ukraine          | Random address 1 | Random addresss 2 | Kyiv      | Randrom state | 123      |
    And ‘Payment’ section is disabled for editing
    When I press ‘Continue to payment’ button on checkout
    And ‘Delivery Adress’ and ‘Billing Address’ sections are disabled for editing
    And I enter my card details
      | Card Type    | Visa           |
      | Name On Card | RandomName     |
      | cardNumber   | 41111111111111 |
      | Expiry Year  | 2023           |
      | Expiry Month | 03             |
      | Cvv          | 123            |




