Feature: Testing Yandex mail

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter
    And write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail

  @One
  Scenario: Save letter to draft
    Given create letter "letter001"
    And add letter's "letter001" recipient "arendapirojkov@gmail.com"
    And set letter's "letter001" topic to "First scenario: Save letter to draft"
    And set letter's "letter001" body to "Body of first letter"
    When open drafts' page
    And wait for appearance of letter "letter001"
    Then should be letter "letter001"
    When open the letter "letter001"
    Then recipients should be as in "letter001"
    And topic should be as in "letter001"
    And body should be as in "letter001"



    When close the letter
    And delete the letter

  Scenario: sending letter
    Given create letter "letter001"
    And add letter's "letter001" recipient "arendapirojkov@gmail.com"
    And set letter's "letter001" topic to "Second scenario: Save letter to draft"
    And set letter's "letter001" body to "Body of first letter"
    And click button send
    Then appears text "Письмо отправлено"
    When click button send letters
    Then recipient should starts with "arendapirojkov@gmail.com"
    And topic should starts with "Second scenario: sending letter"
    And body should starts with "Body of second letter"
    And delete the letter