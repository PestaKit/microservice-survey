#-----------------------------------------------------------------------------------------------------------------------
Feature: Creation of questions

  Background:
    Given there is a Survey server

  Scenario: create a question with full payload
    Given I have a question with full payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code
#-----------------------------------------------------------------------------------------------------------------------


  Scenario: create a question with empty payload
    Given I have a question with empty payload
    When I POST it to the /questions endpoint
    Then I receive a 500 status code