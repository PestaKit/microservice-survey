#-------------------------------------------------QUESTIONS-------------------------------------------------------------

Feature: api surveys

  Background:
    Given there is a Survey server

  #1
  Scenario: post a question and get it by specifying the id
    Given I have a correct id that exists because I posted a question
    When I GET it to the /questions/id_question endpoint
    Then I receive a 200 status code
    And The getted question and the posted question are the same

    #2
  Scenario: get a given question by specifying a wrong id
    Given I have a wrong id
    When I GET it to the /questions/id_question endpoint
    Then I receive a 404 status code


  #3
  Scenario: get all the questions
    When I GET it to the /questions endpoint
    Then I receive a 200 status code
    And The response is a table


  #4
  Scenario: create a question with empty payload
    Given I have a question with empty payload
    When I POST it to the /questions endpoint
    Then I receive a 400 status code


  #5
  Scenario: create a question with full payload
    Given I have a question with full payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code


  #6
  Scenario: create a question with missing enabled attribute in payload
    Given I have a question with missing enabled attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 400 status code

   #7
  Scenario: create a question with missing title attribute in payload
    Given I have a question with missing title attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 400 status code


   #8
  Scenario: create a question with missing used attribute in payload
    Given I have a question with missing used attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code


   #9
  Scenario: create a question with missing choices attribute in payload
    Given I have a question with missing choices attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 400 status code


  #10
  Scenario: get all questions, count them, post some (variable value) more questions and get again all the questions to notice de difference
    Given I have getted all the questions and I know the number of questions
    When I POST 2 questions successively to the /questions endpoint
    Then the difference of questions is 2 when I get again all the questions


#----------------------------------------------SURVEYS------------------------------------------------------------------


  #1
  Scenario: create a survey with full payload
    Given I have a survey with full payload
    When I POST it to the /surveys endpoint
    Then I receive a 201 status code

  #2
  Scenario: create a survey with empty payload
    Given I have a survey with empty payload
    When I POST it to the /surveys endpoint
    Then I receive a 400 status code

  #3
  Scenario: create a survey with missing title attribute in payload
    Given I have a survey with missing title attribute in payload
    When I POST it to the /surveys endpoint
    Then I receive a 400 status code

  #4
  Scenario: create a survey with missing questuionUrls attribute in payload
    Given I have a survey with missing questuionUrls attribute in payload
    When I POST it to the /surveys endpoint
    Then I receive a 400 status code

  #5
  #Scenario: post a survey and get it by specifying the id
    #Given I have a correct id that exists because I posted a survey
    #When I GET it to the /surveys/id_survey endpoint
    #Then I receive a 200 status code
    #And The getted survey and the posted survey are the same