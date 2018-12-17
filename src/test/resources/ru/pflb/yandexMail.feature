Feature: Testing Yandex mail

  Background: prepare for scenario
    Given login to mail

  Scenario: Save letter to draft
    Given create letter "letter001"
    And add letter's "letter001" recipient "arendapirojkov@gmail.com"
    And set letter's "letter001" topic to "First scenario: Save letter to draft"
    And set letter's "letter001" body to "Body of first letter"
    When open drafts' page
    And wait for appearance of letter "letter001"
    Then should be letter "letter001"
    When open the letter "letter001"
    Then recipients in editor should be as in "letter001"
    And topic in editor should be as in "letter001"
    And body in editor should be as in "letter001"
    When close the letter
    And delete the letter "letter001"

  @One
  Scenario: sending letter
    Given create letter "letter001"
    And add letter's "letter001" recipient "arendapirojkov@gmail.com"
    And set letter's "letter001" topic to "Second scenario: Sending letter"
    And set letter's "letter001" body to "Body of second letter"
    And send the letter
    Then should appears the text "Письмо отправлено."
    When open send's page
    And wait for appearance of letter "letter001"
    Then should be letter "letter001"
    When open the letter "letter001"
    Then recipients in viewer should be as in "letter001"
    And topic in viewer should be as in "letter001"
    And body in viewer should be as in "letter001"
    And delete the letter in viewer