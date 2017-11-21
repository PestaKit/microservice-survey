$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("creation.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#-----------------------------------------------------------------------------------------------------------------------"
    }
  ],
  "line": 3,
  "name": "questions",
  "description": "",
  "id": "questions",
  "keyword": "Feature"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "there is a Survey server",
  "keyword": "Given "
});
formatter.match({
  "location": "CreationSteps.there_is_a_Survey_server()"
});
formatter.result({
  "duration": 183223997,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 8,
      "value": "#1 #adrien"
    }
  ],
  "line": 9,
  "name": "post a question and get it by specifying the id",
  "description": "",
  "id": "questions;post-a-question-and-get-it-by-specifying-the-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I have a correct id that exists because I posted a question",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I GET it to the /questions/id_question endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I receive a 200 status code",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "The getted question and the posted question are the same",
  "keyword": "And "
});
formatter.match({
  "location": "CreationSteps.i_have_a_correct_id_that_exists_because_i_posted_a_question()"
});
formatter.result({
  "duration": 538617138,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_id_endpoint()"
});
formatter.result({
  "duration": 16250417,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 12
    }
  ],
  "location": "CreationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 1599853,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.the_getted_question_and_the_posted_question_are_the_same()"
});
formatter.result({
  "duration": 133428,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "there is a Survey server",
  "keyword": "Given "
});
formatter.match({
  "location": "CreationSteps.there_is_a_Survey_server()"
});
formatter.result({
  "duration": 3387446,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 15,
      "value": "#2 #adrien #REVOIR LE CODE STATUS AVEC ALI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    }
  ],
  "line": 16,
  "name": "get a given question by specifying a wrong id",
  "description": "",
  "id": "questions;get-a-given-question-by-specifying-a-wrong-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "I have a wrong id",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "I GET it to the /questions/id_question endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I receive a 500 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_wrong_id()"
});
formatter.result({
  "duration": 39344,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_id_endpoint()"
});
formatter.result({
  "duration": 14362753,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 12
    }
  ],
  "location": "CreationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 86386,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "there is a Survey server",
  "keyword": "Given "
});
formatter.match({
  "location": "CreationSteps.there_is_a_Survey_server()"
});
formatter.result({
  "duration": 485387,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 22,
      "value": "#3 #adrien #TEST PERTINANT?????????????????????????????????????????????????????????????????????"
    }
  ],
  "line": 23,
  "name": "get all the questions",
  "description": "",
  "id": "questions;get-all-the-questions",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "I GET it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "I receive a 200 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 40710932,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 12
    }
  ],
  "location": "CreationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 115039,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "there is a Survey server",
  "keyword": "Given "
});
formatter.match({
  "location": "CreationSteps.there_is_a_Survey_server()"
});
formatter.result({
  "duration": 627796,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 29,
      "value": "#4 #adrien #REVOIR LE CODE STATUS AVEC ALI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    }
  ],
  "line": 30,
  "name": "create a question with empty payload",
  "description": "",
  "id": "questions;create-a-question-with-empty-payload",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "I have a question with empty payload",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "I POST it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "I receive a 400 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_question_with_empty_payload()"
});
formatter.result({
  "duration": 47042,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 8108317,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 12
    }
  ],
  "location": "CreationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 107341,
  "status": "passed"
});
});