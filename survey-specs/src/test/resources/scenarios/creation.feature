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
  Scenario: get a given question with an id that does not exist
    Given I have an id that does not exist for the questions
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


  #11
  Scenario: create a new question with a default value for the used attribute
    Given I have a correct id that exists because I posted a question
    And I GET it to the /questions/id_question endpoint
    Then I receive a 200 status code
    And the used attribute value is zero


#----------------------------------------------SURVEYS------------------------------------------------------------------


  #1
  Scenario: create a survey with full payload
    Given I have a survey with full payload and questions that exist
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
  Scenario: get a given survey with an id that does not exist
    Given I have an id that does not exist for the surveys
    When I GET it to the /surveys/id_survey endpoint
    Then I receive a 404 status code

  #6
  Scenario: get all the surveys
    When I GET it to the /surveys endpoint
    Then I receive a 200 status code
    And The response is a table

  #7
  Scenario: create a survey with full payload but with questions that does not exist
    Given I have a survey with full payload and questions that does not exist
    When I POST it to the /surveys endpoint
    Then I receive a 400 status code
    And I cannnot GET those given questions because they were not created

  #8
  Scenario: get all surveys, count them, post some (variable value) more surveys and get again all the surveys to notice de difference
    Given I have getted all the surveys and I know the number of surveys
    When I POST 2 surveys successively to the /surveys endpoint
    Then the difference of surveys is 2 when I get again all the surveys

   #9
  Scenario: create a survey with full payload but with one of the questions that has a bad url, then survey not created
    Given I have a survey with full payload but with one of the questions that has a bad url
    When I POST it to the /surveys endpoint
    Then I receive a 400 status code

  #10
  Scenario: create a survey with a question which the used attribute must be incremented
    Given I have posted a survey with a question wich I know the value of the used attribute
    When I GET it to the /questions/id_question endpoint
    Then the value of the used attribute has been incremented


  #11
  Scenario: post a survey and get it by specifying the id
    Given I have a correct id that exists because I posted a survey
    When I GET it to the /surveys/id_survey endpoint
    Then I receive a 200 status code
    And The getted survey and the posted survey are the same