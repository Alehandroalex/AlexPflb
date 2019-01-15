Feature: Creating letter

  Background: prepare for scenario
    Given login to mail

  @SmokeTest
  Scenario: Create new letter
    When create letter "letter001"
    And add letter's "letter001" recipient "arendapirojkov@gmail.com"
    And add letter's "letter001" recipient "arendapirojkov2@gmail.com"
    And set letter's "letter001" topic to "Scenario: create new letter"
    And set letter's "letter001" body to "Body of first letter"
    Then recipients in editor should be as in "letter001"