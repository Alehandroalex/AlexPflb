Feature: Creating letter

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter
    And write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail

  Scenario: Create new letter
    Then create letter "letter001"
    And add letter's "letter001" recipient "arendapirojkov@gmail.com"
    And set letter's "letter001" topic to "Scenario: create new letter"
    And set letter's "letter001" body to "Body of first letter"
