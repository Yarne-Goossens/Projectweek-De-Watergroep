Feature:  Leak report details
          As a user
          I want to view the details of a leak report
          In order to view all information of a leak

          #Persona
          #Peter - Klant Contact Centrum
          #Petra - Technician

Rule: Description should be editable
      @UI
      Scenario: Description is edited when editing the description
        Given the description is "the leak is very wet"
        When Peter changes the description to "the leak is in the middle of a field"
        Then Peter should be able to edit the description

      @UI
      Scenario: Description is not edited when no changes are made
        Given the description is "the leak is in the middle of a field"
        When Peter doesn't change the description
        Then Description should be unchanged

Rule: Address of leak should be editable and be filled in
      @UI
      Scenario: Address of leak is changed when editing the address of the leak
        Given the address of leak is "Diestsestraat 2, 300 Leuven"
        When Petra changes the address to "Diestsestraat 2, 3000 Leuven"
        Then Petra should be able to change the address

      @UI
      Scenario: No changes to address of leak when no changes are made
        Given the address of leak is "Diestsestraat 2, 300 Leuven"
        When Petra changes the address to "Diestsestraat 2, 3000 Leuven"
        Then Petra should be able to change the address

      @UI
      Scenario: A message is shown that address of leak cannot be empty when no address is filled in
        Given the address of leak is "Diestsestraat 2, 300 Leuven"
        When Petra changes the address of leak to ""
        Then a message should be shown that address of leak cannot be empty

Rule: last name cannot be changed
      @UI
      Scenario: last name is unchanged
        Given last name is "Davidson"
        When Petra fills in "Janssens" for last name
        Then last name should remain "Davidson"

Rule: first name cannot be changed
      @UI
      Scenario: first name is unchanged
        Given first name is "David"
        When Petra fills in "Jan" for first name
        Then first name should remain "David"

Rule: email cannot be changed
      @UI
      Scenario: email is unchanged
        Given email is "david.davidson@gmail.com"
        When Petra fills in "jan.janssens@gmail.com" for email
        Then email should remain "david.davidson@gmail.com"
