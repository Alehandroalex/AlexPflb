Feature: Testing Yandex mail

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter
    And write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail

    @One
  Scenario: Save letter to draft
    And click button write letter
    And write email recipient "arendapirojkov@gmail.com"
    And write message subject topic "First scenario: Save letter to draft"
    And write text "Body of letter"
    And click button draft
    Then recipient should starts with "arendapirojkov"
    And topic should starts with "First scenario"
    And body should starts with "Body of letter"
    Then open the letter with topic ""
    When recipient equals to "arendapirojkov@gmail.com"
    And topic should equals to "Just for test"
    And body should equals to "Body of letter"
    When close letter
    And delete letter

  Scenario: sending letter
    When click button write letter
    And write email recipient "arendapirojkov@gmail.com"
    And write message subject topic "Second scenario: sending letter"
    And write text "Body of letter"
    And click button send
    Then appears text "Письмо отправлено"
    When click button send letters
    Then recipient should starts with "arendapirojkov"
    And topic should starts with "Second scenario"
    And body should starts with "Body of letter"
    And delete letter