Feature:  Create new service opdracht from existing service opdracht
          As a technician
          I want to make a new service opdracht from an existing service opdracht
          So that I can make a new service opdracht for another technician

          #Persona
          #Petra - technician

Rule: Service opdracht should exist
      @UI
      Scenario: New service opdracht is created from existing service opdracht
        Given the service opdracht with ID 123 exists
        When Petra creates a new service opdracht from the existing service opdracht with ID 123
        Then Petra should be able to create a new service opdracht that is connected to the existing service opdracht with ID 123

      @UI
      Scenario: a message is shown when creating a new service opdracht from an existing service opdracht that doesn't exist
        Given no existing service opdracht with ID 522 exists
        When Petra creates a new service opdracht for service opdracht with ID 522
        Then a message is shown that there must be an existing service opdracht to create a connected service opdracht

Rule: Location from old service opdracht should be kept
      @UI
      Scenario: Create new service opdracht from existing service opdracht with location off existing service opdracht
        Given the service opdracht with location "Geldenaaksebaan 335 3001 Haasrode"
        When Petra creates a new service opdracht with the same address of old service opdracht
        Then the location of the new service opdracht should be "Geldenaaksebaan 335 3001 Haasrode"

      @UI
      Scenario: a message is shown
        Given the service opdracht with ID 123 exists
        And the location of the service opdracht is "456 Main Street"
        When I try to create a new service opdracht from the existing service opdracht
        Then I should see an error message indicating that the location