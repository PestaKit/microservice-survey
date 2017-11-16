#-----------------------------------------------------------------------------------------------------------------------

Feature: Getting questions

  Background:
    Given there is a Survey server
  #1
  Scenario: get a given question by specifying the id
    Given I have a correct id that exists
    When I GET it to the /questions/id_question endpoint
    Then I receive a 200 status code

