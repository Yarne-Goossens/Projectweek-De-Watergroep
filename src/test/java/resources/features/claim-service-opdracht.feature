Feature: Claim a service opdracht
          As a technician
          I want to be able to claim a service opdracht
          In order to have the service opdracht for myself

          #Persona
          #Petra - technician
Rule:
      @UI
      Scenario: Claim a service opdracht that does not have a technician
        Given the service opdracht with ID 123 is available
        When Peter claims the service opdracht
        Then the service opdracht should be associated with Peter his account
        And the service opdracht should not be listed as available

Rule:
      @UI
      Scenario: Claim a service opdracht that does not have an end date
        Given the service opdracht with ID 456 is available
        When Peter claims the service opdracht
        Then the service opdracht should be associated with Peter his account
        And the service opdracht should not be listed as available