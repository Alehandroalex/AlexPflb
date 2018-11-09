#Feature: Creating letter
#
#  Background: prepare for scenario
#    Given go to "https://mail.yandex.ru/"
#    And click button enter
#    And write login "kotikovartur"
#    And write password to field "kotikov123"
#    And click button enter to mail
#
#  Scenario: Create new letter
#    When click button write letter
#    Then write email recipient "arendapirojkov@gmail.com"
#    And write message subject topic "Just for test"
#    And write text "Body of letter"