Feature: Creating letter

  Background: prepare for scenario
    Given login to mail

  Scenario: Create new letter
    Then create letter "letter001"
    And add letter's "letter001" recipient "arendapirojkov@gmail.com"
    And set letter's "letter001" topic to "Scenario: create new letter"
    And set letter's "letter001" body to "Body of first letter"
