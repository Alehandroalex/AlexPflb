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
    And topic should equals to "Just for test"
    And body should starts with "Body of letter"
    And delete letter

