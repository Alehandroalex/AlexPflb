Feature: Authorization

  Scenario: Authorization
    When login to mail
    Then user's login should be correct
    When exit from user account
    Then should appears the text "Завести почту"