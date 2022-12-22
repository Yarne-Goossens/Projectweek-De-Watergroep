Feature:  Complete a service opdracht
          As a technician
          I want to complete a service opdracht
          In order to close a serivce opdracht

          #Persona
          #Petra - Technician

Rule: Technician can only close their own service opdracht
      @UI
      Scenario: Service opdracht is finalised when technician closes their own service opdracht
        Given the tehcnician finished work on their own service opdracht
        When Petra closes their serice opdracht
        Then Petra should be able to close the service opdracht

      @UI
      Scenario: a message is shown when a technician tries to close another technician their service opdracht
        Given an overview of all service opdrachten
        When Petra closes the service opdracht of another technician
        Then a message  is shown that a technician can only close their own service opdrachten


Rule: Closing date for the service opdracht should be the date of the current day
      @UI
      Scenario: Service opdracht is finalised when completion date matches the current date
        Given Current date is "22-12-2022"
        When Petra fills in "22-12-2022" for closing date
        Then Petra should be able to close the service opdracht

      @UI
      Scenario: a message is shown when a closing date does not match the current date
        Given Current date is "22-12-2022"
        When Petra fills in "05-05-2023" for closing date
        Then a message is shown that a closing date needs to match the current date