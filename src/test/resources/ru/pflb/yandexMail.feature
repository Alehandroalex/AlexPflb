Feature: Testing Yandex mail

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter
    And write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail
    And click button write letter
    And write email recipient "arendapirojkov@gmail.com"
    And write message subject topic "Just for test"
    And write text "Body of letter"

  Scenario: Save letter to draft
    And click button draft
    Then recipient should starts with "arendapirojkov"
    And topic should starts with "Just for test"
    And body should starts with "Body of letter"
    Then open the letter
    When recipient equals to "arendapirojkov@gmail.com"
    And topic equals to "Just for test"
    And body equals to "Body of letter"
    Then Close letter
    And delete letter

  Scenario: sending letter
    When click button send
    Then appears text "Письмо отправлено"
    When click button send letters
    Then recipient should starts with "arendapirojkov"
    And topic should starts with "Just for test"
    And body should starts with "Body of letter"
    And delete letter


