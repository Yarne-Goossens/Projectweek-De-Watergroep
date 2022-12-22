Feature:  Create service assignment
          As a KCC employee
          I want to create a service assignment
          In order to create a new service assignment from a leak report

          #Persona
          #Peter - Klant Contact Centrum

Rule: Type should be filled in
      @UI
      Scenario: service assignment is created when 1 type is filled in
        Given KCC employee has the opportunity to fill in a service type
        When Peter fills in "Evaluatie ter plaatse" as service type
        Then Peter should be able to create a service assignment

      @UI
      Scenario: a message is shown when not filling in a service type
        Given KCC  employee has the opportunity to fill in a service type
        When Peter doesn't fill in a service type
        Then a message should be shown that 1 service type must be filled in

      @UI
      Scenario: a message is shown when more than 1 service type is filled in
        Given KCC employee has the opportunity to fill in a service type
        When Peter fills in "Evaluatie ter plaatse" and "Lekherstel"
        Then a message should be shown that only 1 service type must be filled in

Rule: Service assignment creation date should be date of today and cannot be empty
      @UI
      Scenario: service assignment is created when date filled in is the date of today
        Given KCC employee has the opportunity to fill in a service type
        When Peter fills in "Evaluatie ter plaatse" as service type
        Then Peter should be able to create a service assignment

      @UI
      Scenario: a message is shown when not filling in a service type
        Given KCC employee has the opportunity to fill in a service type
        When Peter doesn't fill in a service type
        Then a message should be shown that 1 service type must be filled in

      @UI
      Scenario: a message is shown when more than 1 service type is filled in
        Given KCC employee has the opportunity to fill in a service type
        When Peter fills in "Evaluatie ter plaatse" and "Lekherstel"
        Then a message should be shown that only 1 service type must be filled in

Rule: Technician should be empty
      @UI
      Scenario: Service assignment is created when technician isn't filled in
        Given KCC employee has the opportunity to fill in technician
        When Peter doesn't fill in a technician
        Then Peter should be able to create a service assignment

      @UI
      Scenario: a message is shown when filling in a technician
        Given KCC employee has the opportunity to fill in a tehcnician
        When Peter fills in "Petra" for technician
        Then a message should be shown that only a technician can assign technicians to a service assignment

  
Rule: Completion date should be empty
      @UI
      Scenario: Service assignment is created when completion of service assignment date isn't filled in
        Given KCC employee has the opportunity to fill in completion date
        When Peter doesn't fill in a completion date 
        Then Peter should be able to create a service assignment
    
      @UI
      Scenario: a message is shown when filling in a completion date for service assignment
        Given KCC employee has the opportunity to fill in a tehcnician
        When Peter fills in "Petra" for technician
        Then a message should be shown that only a technician can assign technicians to a service assignment
