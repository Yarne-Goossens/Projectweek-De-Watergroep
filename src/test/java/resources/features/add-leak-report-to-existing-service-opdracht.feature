Feature:  Add leak report to existing service opdracht
          As a KCC employee
          I want to add a leak report to an existing service opdracht
          In order to add multiple reports to the same service opdracht

          #Persona
          #Peter - Klant Contact Centrum

Rule: Service opdracht should exist
      @UI
      Scenario: Leak report is added to service opdracht when service opdracht exists
        Given service opdracht with ID 7 exists
        When Peter adds the leak report with ID 13 to service opdracht with ID 7
        Then Peter should be able to add the leak report with ID 13 to service opdracht with ID 7
    
      @UI
      Scenario: a message is shown when service opdracht doesn't exist 
        Given there is no service opdracht
        When Peter adds the leak report to service opdracht
        Then a message is shown that a service opdracht must exist to add a leak report to it
    
  
Rule: Leak report should exist
      @UI
      Scenario: Leak report is added to service opdracht when leak report exists
        Given leak report with ID 13 and service opdracht with ID 7 exists
        When Peter adds leak report with ID 13 to service opdracht with ID 7
        Then Peter should be able to add the leak report with ID 13 to service opdracht with ID 7
    
      @UI
      Scenario: a message is shown when leak report doesn't exist
        Given there is no leak report
        When Peter adds the leak report to service opdracht
        Then a message is shown that a leak report must exist to add it to a service opdracht