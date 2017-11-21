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
  "duration": 244357536,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 7,
      "value": "#1 #adrien"
    }
  ],
  "line": 8,
  "name": "post a question and get it by specifying the id",
  "description": "",
  "id": "questions;post-a-question-and-get-it-by-specifying-the-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I have a correct id that exists because I posted a question",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I GET it to the /questions/id_question endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I receive a 200 status code",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "The getted question and the posted question are the same",
  "keyword": "And "
});
formatter.match({
  "location": "CreationSteps.i_have_a_correct_id_that_exists_because_i_posted_a_question()"
});
formatter.result({
  "duration": 921808205,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_id_endpoint()"
});
formatter.result({
  "duration": 18301017,
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
  "duration": 1619097,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.the_getted_question_and_the_posted_question_are_the_same()"
});
formatter.result({
  "duration": 68852,
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
  "duration": 684246,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 14,
      "value": "#2"
    }
  ],
  "line": 15,
  "name": "get a given question by specifying a wrong id",
  "description": "",
  "id": "questions;get-a-given-question-by-specifying-a-wrong-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "I have a wrong id",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I GET it to the /questions/id_question endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I receive a 500 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_wrong_id()"
});
formatter.result({
  "duration": 159942,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_id_endpoint()"
});
formatter.result({
  "duration": 16307723,
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
  "duration": 102209,
  "status": "passed"
});
});