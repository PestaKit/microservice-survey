#-------------------------------------------------QUESTIONS-------------------------------------------------------------

Feature: api surveys

  Background:
    Given there is a Survey server

  #1
  Scenario: I can post a question and get it by specifying the id
    Given I have a correct id that exists because I posted a question
    When I GET it to the /questions/id_question endpoint
    Then I receive a 200 status code
    And The getted question and the posted question are the same

    #2
  Scenario: I can't get a given question with an id that does not exist
    Given I have an id that does not exist for the questions
    When I GET it to the /questions/id_question endpoint
    Then I receive a 404 status code


  #3
  Scenario: I can get all the questions and I receive a table
    When I GET it to the /questions endpoint
    Then I receive a 200 status code
    And The response is a table


  #4
  Scenario: I can't create a question with empty payload
    Given I have a question with empty payload
    When I POST it to the /questions endpoint
    Then I receive a 422 status code


  #5
  Scenario: I can create a question with full payload
    Given I have a question with full payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code


  #6
  Scenario: I can't create a question with missing enabled attribute in payload
    Given I have a question with missing enabled attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 422 status code

   #7
  Scenario: I can't create a question with missing title attribute in payload
    Given I have a question with missing title attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 422 status code


   #8
  Scenario: I can create a question with missing used attribute in payload
    Given I have a question with missing used attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code


   #9
  Scenario: I can't create a question with missing choices attribute in payload
    Given I have a question with missing choices attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 422 status code


  #10
  Scenario: I can get all questions, count them, post some (variable value) more questions and
            get again all the questions to notice de difference
    Given I have getted all the questions and I know the number of questions
    When I POST 2 questions successively to the /questions endpoint
    Then the difference of questions is 2 when I get again all the questions


  #11
  Scenario: I can create a new question with a default value for the used attribute
    Given I have a correct id that exists because I posted a question
    When I GET it to the /questions/id_question endpoint
    Then I receive a 200 status code
    And the used attribute value is zero

  #12 By Dany
  Scenario: I can't create a question with one choice in choices attribute in payload
    Given I have a question with one choice in choices attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 422 status code

  #13 By Dany and Julien
  Scenario: I can create a disabled question with full payload
    Given I have a disabled question with full payload
    When I POST it to the /questions endpoint
    Then I receive a 201 status code

#----------------------------------------------SURVEYS------------------------------------------------------------------


  #1
  Scenario: I can create a survey with full payload
    Given I have a survey with full payload and questions that exist
    When I POST it to the /surveys endpoint
    Then I receive a 201 status code

  #2
  Scenario: I can't create a survey with empty payload
    Given I have a survey with empty payload
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code

  #3
  Scenario: I can't create a survey with missing title attribute in payload
    Given I have a survey with missing title attribute in payload
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code

  #4
  Scenario: I can't create a survey with missing questuionUrls attribute in payload
    Given I have a survey with missing questuionUrls attribute in payload
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code

  #5
  Scenario: I can't get a given survey with an id that does not exist
    Given I have an id that does not exist for the surveys
    When I GET it to the /surveys/id_survey endpoint
    Then I receive a 404 status code

  #6
  Scenario: I can get all the surveys and receive a table
    When I GET it to the /surveys endpoint
    Then I receive a 200 status code
    And The response is a table

  #7
  Scenario: I can't create a survey with full payload but with questions that does not exist
    Given I have a survey with full payload and questions that does not exist
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code
    And I cannnot GET those given questions because they were not created

  #8
  Scenario: I can get all surveys, count them, post some (variable value) more surveys and get again all the surveys
            to notice de difference
    Given I have getted all the surveys and I know the number of surveys
    When I POST 2 surveys successively to the /surveys endpoint
    Then the difference of surveys is 2 when I get again all the surveys

   #9
  Scenario: I can't create a survey with full payload but with one of the questions that has a bad url,
            then survey not created
    Given I have a survey with full payload but with one of the questions that has a bad url
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code

  #10
  Scenario: I can create a survey with a question which the used attribute must be incremented
    Given I have posted a survey with a question wich I know the value of the used attribute
    When I GET it to the /questions/id_question endpoint
    Then the value of the used attribute has been incremented


  #11
  Scenario: I can post a survey and get it by specifying the id
    Given I have a correct id that exists because I posted a survey
    When I GET it to the /surveys/id_survey endpoint
    Then I receive a 200 status code
    And The getted survey and the posted survey have the same title and question urls


  #12 Add by Julien et Dany
  Scenario: I can't create a survey with disabled question
    Given I have a survey with full payload and a disabled question
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code

  #----------------------------------------------Custom Errors Questions------------------------------------------------
  #1
  Scenario: I can't post a question where the first position of the choices starts with 0
    Given I have a question where the first position of the choices starts with 0
    When I POST it to the /questions endpoint
    Then I receive a 422 status code
    And The error message specifies it is a position error

  #2
  Scenario: I can't post a question where a position index is missing for the choices
    Given I have a question where a position index is missing for the choices
    When I POST it to the /questions endpoint
    Then I receive a 422 status code
    And The error message specifies it is a position error

  #3
  Scenario: I can't post a question where all required fields are missing but I receive
            a customed error message
    Given I have a question with empty payload
    When I POST it to the /questions endpoint
    Then I receive a 422 status code
    And The error message specifies the empty fields for the question

  #4
  Scenario: I can't post a question where there is only one choice but I receive
            a custom error message
    Given I have a question with one choice in choices attribute in payload
    When I POST it to the /questions endpoint
    Then I receive a 422 status code
    And The error message specifies that a single choice is not possible


  #5
  Scenario: I can't post a question where a text choice is missing
    Given I have a question where a text choice is missing
    When I POST it to the /questions endpoint
    Then I receive a 422 status code
    And The error message specifies there is a missing text

  #----------------------------------------------Custom Errors Surveys--------------------------------------------------

  #1 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  # I can't post a Survey that contains a question (hard coding)
            #where the first position of the choices starts with 0, but I receive a custom error message
    #Given I have survey that contains a question where the first position of the choices starts with 0
    #When I POST it to the /surveys endpoint
    #Then I receive a 422 status code
    #And The error message specifies blblablablablbal


  #2 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  #Scenario: I can't post a Survey that contains a question (hard coding)
   #         where a position index is missing for the choices but I receive a custom error message
    #Given I have survey that contains a question where a position index is missing for the choices
    #When I POST it to the /surveys endpoint
    #Then I receive a 422 status code
    #And The error message specifies blblablablablbal



  #3 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  #Scenario: I can't post a Survey that contains a question (hard coding)
  #where all required fields are missing but I receive a customed error message
   # Given I have survey that contains a question where all required fields are missing
    #When I POST it to the /surveys endpoint
    #Then I receive a 422 status code
    #And The error message specifies blblablablablbal


  #4 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  #Scenario: I can't post a Survey that contains a question (hard coding)
  #where there is only one choice but I receive a custom error message
   # Given I have survey that contains a question where there is only one choice
    #When I POST it to the /surveys endpoint
    #Then I receive a 422 status code
    #And The error message specifies blblablablablbal
  

  #5 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  #Scenario: I can't post a Survey that contains a question (hard coding)
  #where a text choice is missing but I receive a custom error message
   # Given I have survey that contains a question where a text choice is missing
    #When I POST it to the /surveys endpoint
    #Then I receive a 422 status code
    #And The error message specifies blblablablablbal

  #6
  Scenario: I can't post a survey whith a bad URL question but a receive a custom error message
    Given I have a survey with full payload but with one of the questions that has a bad url
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code
    And The error message specifies there is a bad URL question

  #7
  Scenario: I can't post a survey whith empty fields but I receive a custom error message
    Given I have a survey with empty payload
    When I POST it to the /surveys endpoint
    Then I receive a 422 status code
    And The error message specifies the empty fields for the survey

  #8 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  #Scenario: I can't post a survey whith a doubled question url but I receive a custom error message
   # Given I have a survey with doubled questions
    #When I POST it to the /surveys endpoint
    #Then I receive a 422 status code
    #And The error message specifies blablablablabla

  #-------------------------------------------------ANSWERS-------------------------------------------------------------
   #1
  Scenario: I can create an answer with full payload
    Given I have an answer with full payload
    When I POST it to the /answers endpoint
    Then I receive a 201 status code


  #2 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!problème de timestamp à gérer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  #Scenario: I can post an answer and get it by specifying the id
   # Given I have a correct id that exists because I posted an answer
    #When I GET it to the /answers/id_answer endpoint
    #Then I receive a 200 status code
    #And The getted answer and the posted answer are the same


  #3
  Scenario: I can get all the answers and I receive a table
    When I GET it to the /answers endpoint
    Then I receive a 200 status code
    And The response is a table


  #4
  Scenario: If I create two identical answers, only one is considered
    Given I have getted all the answers and I know the number of answers
    When I POST 2 identical answers successively to the /answers endpoint
    Then the difference of answers is 1 when I get again all the answers


  #5
  Scenario: If I create two different answers, both are considered
    Given I have getted all the answers and I know the number of answers
    When I POST 2 different answers successively to the /answers endpoint
    Then the difference of answers is 2 when I get again all the answers


   #6
  Scenario: I can create an answer with missing timestamp in payload and get the default value
    Given I have an answer with missing timestamp in payload
    When I POST it to the /answers endpoint
    Then I receive a 201 status code
    And I have a default timestamp when I get this answer again

#----------------------------------------------Custom Errors Answers----------------------------------------------------
  #1
  Scenario: I can't post an answer where the questionId does not exists
    Given I have an answer where the questionId does not exists
    When I POST it to the /answers endpoint
    Then I receive a 422 status code
    And The error message specifies it is a non existent question

  #2 A IMPLEMENTER!!!!!!!!!!!!!!!!!!!!!!!!!l answer se crée quand meme si juste les choix ne correspondent pas à la question
  #Scenario: I can't post an answer where the choice does not match with the question
   # Given I have an answer where the choice does not match with the question
    #When I POST it to the /answers endpoint
    #Then I receive a 422 status code
    #And The error message specifies it is a choice for non existent question

  #3
  Scenario: I can't post an answer where the surveyId does not exists
    Given I have an answer where the surveyId does not exists
    When I POST it to the /answers endpoint
    Then I receive a 422 status code
    And The error message specifies it is a non existent survey

   #4
  Scenario: I can't post an answer where the choices are not specified
    Given I have an answer where the choices are not specified
    When I POST it to the /answers endpoint
    Then I receive a 422 status code
    And The error message specifies that the choices are not specified