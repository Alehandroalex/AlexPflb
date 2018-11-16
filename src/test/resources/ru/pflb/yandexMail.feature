Feature: Testing Yandex mail

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter
    And write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail

  Scenario: Authorization
    Then login "kotikovartur" appears near avatar

  Scenario: Create new letter
    When click button write letter
    Then write email recipient "arendapirojkov@gmail.com"
    And write message subject topic "Just for test"
    And write text "Body of letter"

  Scenario: Save letter to draft
    When click button write letter
    And write email recipient "arendapirojkov@gmail.com"
    And write message subject topic "Just for test"
    And write text "Body of letter"
    And click button draft
    Then recipient starts with "arendapirojkov"
    And topic equals to "Just for test"
    And body starts with "Body of letter"
    And click checkbox and click remove

