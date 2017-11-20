#-----------------------------------------------------------------------------------------------------------------------

Feature: questions

  Background:
    Given there is a Survey server
  #1 #adrien
  Scenario: post a question and get it by specifying the id
    Given I have a correct id that exists because I posted a question
    When I GET it to the /questions/id_question endpoint
    Then I receive a 200 status code
    And I compare the getted value with the posted value

##########LA SUITE EST A IMPLEMENTER, VOICI UNE IDEE GLOBALE DES TESTS A FAIRE (LES STATUS CODE NE SONT PAS TOUJOURS JUSTES)
    #2
  #Scenario: get a given question without specifying the id
    #Given I have a empty id
    #When I GET it to the /questions/{id_question} endpoint
    #Then I receive a 422 status code

  #3
  #Scenario: get a given question by specifying the id that does not exist (negative id for example)
    #Given I have a id that does not exists
    #When I GET it to the /questions/{id_question} endpoint
    #Then I receive a 422 status code

  #4
  #Scenario: get all the questions
    #When I GET it to the /questions endpoint
    #Then I receive a 201 status code

 #----------------------------------------------------------------------------------------------------------------------

  #5
  #Scenario: create a question with full payload
    #Given I have a question with full payload
    #When I POST it to the /questions endpoint
    #Then I receive a 201 status code
    #And I compare the getted value with the posted value

  #6
  #Scenario: create a question with empty payload
    #Given I have a question with empty payload
    #When I POST it to the /questions endpoint
    #Then I receive a 422 status code
#-----------------------------------------------------------------------------------------------------------------------

