Feature: Testing Yandex mail

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter
    And write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail

  Scenario: Save letter to draft
    And click button write letter
    And write email recipient "arendapirojkov@gmail.com"
    And write message subject topic "First scenario: Save letter to draft"
    And write text "Body of first letter"
    And click button draft
    Then recipient should starts with "arendapirojkov@gmail.com"
    And topic should starts with "First scenario: Save letter to draft"
    And body should starts with "Body of first letter"
    Then open the letter with topic "First scenario: Save letter to draft"
    When recipient should equals to "arendapirojkov@gmail.com"
    And topic should equals to "First scenario: Save letter to draft"
    And body should equals to "Body of first letter"
    When close the letter
    And delete the letter

  Scenario: sending letter
    When click button write letter
    And write email recipient "arendapirojkov@gmail.com"
    And write message subject topic "Second scenario: sending letter"
    And write text "Body of second letter"
    And click button send
    Then appears text "Письмо отправлено"
    When click button send letters
    Then recipient should starts with "arendapirojkov@gmail.com"
    And topic should starts with "Second scenario: sending letter"
    And body should starts with "Body of second letter"
    And delete the letter