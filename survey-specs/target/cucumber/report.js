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
  "duration": 259487927,
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
  "duration": 585831401,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_id_endpoint()"
});
formatter.result({
  "duration": 21197944,
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
  "duration": 2212253,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.the_getted_question_and_the_posted_question_are_the_same()"
});
formatter.result({
  "duration": 121881,
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
  "duration": 5344389,
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
  "duration": 35496,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_id_endpoint()"
});
formatter.result({
  "duration": 19194813,
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
  "duration": 112473,
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
  "duration": 505914,
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
  "duration": 24879187,
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
  "duration": 97505,
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
  "duration": 546114,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 28,
      "value": "#4 #adrien #REVOIR LE CODE STATUS AVEC ALI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    }
  ],
  "line": 29,
  "name": "create a question with empty payload",
  "description": "",
  "id": "questions;create-a-question-with-empty-payload",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "I have a question with empty payload",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "I POST it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "I receive a 400 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_question_with_empty_payload()"
});
formatter.result({
  "duration": 32074,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 5926854,
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
  "duration": 99643,
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
  "duration": 558516,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 35,
      "value": "#5 #adrien #TEST PERTINANT?????????????????????????????????????????????????????????????????????"
    }
  ],
  "line": 36,
  "name": "create a question with full payload",
  "description": "",
  "id": "questions;create-a-question-with-full-payload",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 37,
  "name": "I have a question with full payload",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "I POST it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_question_with_full_payload()"
});
formatter.result({
  "duration": 42337,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 15131675,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 12
    }
  ],
  "location": "CreationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 99215,
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
  "duration": 546542,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 42,
      "value": "#6 #adrien #TEST PERTINANT???????????????????????ON POURRAIT FAIRE POUR LES AUTRES ATTRIBUTS????????????????????????"
    }
  ],
  "line": 43,
  "name": "create a question with missing enabled attribute in payload",
  "description": "",
  "id": "questions;create-a-question-with-missing-enabled-attribute-in-payload",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 44,
  "name": "I have a question with missing enabled attribute in payload",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "I POST it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I receive a 400 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_question_with_missing_enabled_attribute_in_payload()"
});
formatter.result({
  "duration": 35923,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 7724711,
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
  "duration": 143692,
  "status": "passed"
});
});