@newsComments
Feature: Ability to comment news

  Scenario: Commenting news as logged in user
    Given I am a standard logged in user
    When I visit BBC news
    And I open the first commentable news
    Then I can see input field for commenting

  Scenario: Commenting news as logged in user
    Given I visit BBC news
    When I open the first commentable news
    Then I can see signIn prompt
    #Then Application does not show that email has been sent.
    # TODO - the below step is not be implemented because feature is still not available
    # And Application shows an error message "Invalid Email"