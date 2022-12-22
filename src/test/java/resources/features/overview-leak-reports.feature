Feature:  Overview leaks
          As a user
          I want to be able to view all leaks
          In order to view all the reported leaks

          #Persona
          #Peter - Klant Contact Centrum
          #Paulina - leiding monitoring

  Rule: There must be at least 1 leak reported
        @UI
        Scenario: A user can view overview of leaks when there is at least 1 leak reported
          Given there are 10 reported leaks
          When Peter checks the overview of all leaks
          Then Peter should be able to view all reported leaks

        @UI
        Scenario: A message is shown when there are no reported leaks
          Given there are no reported leaks
          When Peter checks the overview of all leaks
          Then A message should be shown that there are no reported leaks yet