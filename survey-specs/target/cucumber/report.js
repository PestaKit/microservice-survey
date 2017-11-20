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
  "duration": 226503417,
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
  "name": "I compare the getted value with the posted value",
  "keyword": "And "
});
formatter.match({
  "location": "CreationSteps.i_have_a_correct_id_that_exists_because_i_posted_a_question()"
});
formatter.result({
  "duration": 1097974204,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_GET_it_to_the_questions_id_endpoint()"
});
formatter.result({
  "duration": 78240975,
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
  "duration": 3016670,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_compare_the_getted_value_with_the_posted_value()"
});
formatter.result({
  "duration": 127013,
  "status": "passed"
});
});