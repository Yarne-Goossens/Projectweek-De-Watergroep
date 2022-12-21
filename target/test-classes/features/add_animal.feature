Feature: Add Animal
  As a user
  I want to register the date of a new animal
  So that I may get an update on its name, kind and behaviour

  # Personas
  # Joske - user

  Rule: Food must be greater than or equal to zero units

    Scenario: The animal is added when the food it consumes is greater than zero
      Given Joske has chosen to add a new animal
      When Joske registers 9 as the amount of food
      Then the animal should be added to the overview of animals

    Scenario Outline: An error messages is shown if the food the animal consumes is equal to or less than zero
      Given Joske has chosen to add a new animal
      When Joske registers <food> as the amount of food
      Then an error message should be shown

      Examples:
      | food |
      | 0    |
      |-5    |
