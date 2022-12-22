Feature:  View location of confirmed leaks
          As a pipeline monitor
          I want to view the location of all confirmed leaks visually
          So that I have a clear visual overview of all the leaks

          #Persona
          #Paulina - pipeline monitor

Rule: There should be at least one confirmed leak
      @UI
      Scenario: All locations of confirmed leaks are shown
        Given there is at least one confirmed leak
        When Paulina views the confirmed leaks
        Then the visual representation should include a marker for each leak

      @UI
      Scenario: A message is shown when there are no confirmed leaks
        Given there are no confirmed leaks
        When Paulina views the confirmed leaks
        Then she should see a message indicating that there are no confirmed leaks

Rule: Location should be a GPS coordinate
      @UI
      Scenario: All locations of confirmed leaks are shown
        Given the location of each confirmed leak is a GPS coordinate
        When Paulina views the confirmed leaks
        Then the visual representation should include a marker for each leak with a label indicating the location
