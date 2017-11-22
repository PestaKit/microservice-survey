#-----------------------------------------------------------------------------------------------------------------------

Feature: questions

  Background:
    Given there is a Survey server

  #1 #adrien
  Scenario: post a question and get it by specifying the id
    Given I have a correct id that exists because I posted a question
    When I GET it to the /questions/id_question endpoint
    Then I receive a 200 status code
    And The getted question and the posted question are the same

    #2 #adrien #REVOIR LE CODE STATUS AVEC ALI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  Scenario: get a given question by specifying a wrong id
    Given I have a wrong id
    When I GET it to the /questions/id_question endpoint
    Then I receive a 400 status code


  #3 #adrien #TEST PERTINANT?????????????????????????????????????????????????????????????????????
  Scenario: get all the questions
    When I GET it to the /questions endpoint
    Then I receive a 200 status code


  #4 #adrien #REVOIR LE CODE STATUS AVEC ALI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  Scenario: create a question with empty payload
    Given I have a question with empty payload
    When I POST it to the /questions endpoint
    Then I receive a 400 status code


  #5 #adrien #TEST PERTINANT?????????????????????????????????????????????????????????????????????
  Scenario: create a question with full payload
    Given I have a question with full payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code


    #6 #adrien #TEST PERTINANT???????????????????????ON POURRAIT FAIRE POUR LES AUTRES ATTRIBUTS????????????????????????
  Scenario: create a question with missing enabled attribute in payload
    Given I have a question with missing enabled attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 400 status code
