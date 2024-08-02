Feature: Create Tariff

  Background:
    Given the user is located at "https://supplysync.us/login"
    And the user logs in with "admin@codewise.com" and "codewise123"

  @tariff
  Scenario: User creates a new tariff
    Given the user is located at the Create Tariff page
    When the user creates a new tariff with the following details
      | branchName | tariffName | deliveryTime | typeOfDelivery | deliveryCost | region | coordinates | additionalInfo | isAvailable |
      | Nurgazy    | TestTariff | 24 hours     | City express   | 10.00        | Hawaii | 123, 456    | None           | true        |
    Then the tariff should be created successfully