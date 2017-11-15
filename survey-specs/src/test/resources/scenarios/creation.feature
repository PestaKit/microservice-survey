Feature: Creation of questions

  Background:
    Given there is a Survey server

  Scenario: create a question
    Given I have a question payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code