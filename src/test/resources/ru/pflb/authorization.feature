Feature: Authorization

  Background: prepare for scenario
    Given go to "https://mail.yandex.ru/"
    And click button enter

  Scenario: Authorization
    When write login "kotikovartur"
    And write password "kotikov123"
    And click button enter to mail
    Then user's login should be "kotikovartur"
    When click to user avatar
    And click exit services Yandex
    Then login "kotikovartur" missing on screen
