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
      | FREE          | 84,38 € |
    And I click ‘Checkout’ button on ‘Basket’ page
    And I checkout as a new customer with email "test@user.com" and "123123123" phone number
    And I fill delivery address information manually:
      | Full name   | Delivery country | Address line 1   | Address line 2     | Town/City | Country/State | Postcode |
      | John Newman | Canada           | Random address 1 | Random addresses 2 | Kyiv      | Random state  | 123      |
    And "Please enter your card number" message displayed once click on Buy Now button
    And ‘Delivery Adress’ is the same as Payment checkbox is enabled
    And I enter my card details
      | Card Type        | Visa           |
      | Name On Card     | RandomName     |
      | cardNumber       | 41111111111111 |
      | Expiry Date      | 2023           |
      | Expiry Month     | 03             |
      | Cvv              | 123            |
      | ExpiryDateMMY/YY | 0225           |







