Feature:  Report a leak
          As a user
          I want to be able to report a leak
          In order to report a leak in the pipeline

          #Persona
          #Pierre - civilian
          #Peter - Klant Contact Centrum

Rule: Email must be valid
      @UI
      Scenario: A user can report a leak when provided email is valid
        Given the user has the opportunity to fill in their email
        When Pierre fills in "Pierre.Steen@gmail.com" for email
        Then Pierre should be able to report the leak

      @UI
      Scenario: A message is shown when provided email is not valid
        Given the user has the opportunity to fill in their email
        When Pierre fills in "Pierre.Steen" for email
        Then A message should be shown that email must be valid

Rule: Email must be filled in
      @UI
      Scenario: A user can report a leak when email is filled in
        Given the user has the opportunity to fill in their email
        When Pierre fills in "Pierre.Steen@gmail.com" for email
        Then Pierre should be able to report the leak

      @UI
      Scenario: A message is shown when no email is filled in
        Given the user has the opportunity to fill in their email
        When Pierre doesn't fill in an email address
        Then A message should be shown that email must be filled in

Rule: Last name must be filled in
      @UI
      Scenario: A user can report a leak when last name is filled in
        Given the user has the opportunity to fill in their last name
        When Pierre fills in "Steen" for last name
        Then Pierre should be able to report the leak

      @UI
      Scenario: A message is shown when no last name is filled in
        Given the user has the opportunity to fill in their last name
        When Pierre doesn't fill in a last name
        Then A message should be shown that last name must be filled in

Rule: First name must be filled in
      @UI
      Scenario: A user can report a leak when first name is filled in
        Given the user has the opportunity to fill in their first name
        When Pierre fills in "Pierre" for first name
        Then Pierre should be able to report the leak

      @UI
      Scenario: A message is shown when no first name is filled in
        Given the user has the opportunity to fill in their first name
        When Pierre doesn't fill in a first name
        Then A message should be shown that first name must be filled in

Rule: Location of leak must be filled in
      @UI
      Scenario: A user can report a leak when location of leak is filled in
        Given the user has the opportunity to fill in the location of the leak
        When Pierre fills in "Diestsestraat 1 3000 Leuven" for location of leak
        Then Pierre should be able to report the leak

      @UI
      Scenario: A message is shown when no location of leak is filled in
        Given the user has the opportunity to fill in the location of the leak
        When Pierre doesn't fill in a location of leak
        Then A message should be shown that location of leak must be filled in

Rule: Extra information may be added
      @UI
      Scenario: A user can report a leak when extra information is added
        Given the user has the opportunity to fill in extra information
        When Pierre fills in "the leak is very wet" for extra information
        Then Pierre should be able to report the leak

      @UI
      Scenario: A user can report a leak when no extra information is added
        Given the user has the opportunity to fill in extra information
        When Pierre doesn't fill in extra information
        Then Pierre should be able to report the leak
