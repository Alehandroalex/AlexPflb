Feature: Authorization

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter

  Scenario: Authorization
    When write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail
    Then login "kotikovartur" appears near avatar
