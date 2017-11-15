$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("creation.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#-----------------------------------------------------------------------------------------------------------------------"
    }
  ],
  "line": 2,
  "name": "Creation of questions",
  "description": "",
  "id": "creation-of-questions",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "there is a Survey server",
  "keyword": "Given "
});
formatter.match({
  "location": "CreationSteps.there_is_a_Survey_server()"
});
formatter.result({
  "duration": 185180671,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "create a question with full payload",
  "description": "",
  "id": "creation-of-questions;create-a-question-with-full-payload",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I have a question with full payload",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I POST it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_question_with_full_payload()"
});
formatter.result({
  "duration": 4029786,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 1256989793,
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
  "duration": 2238342,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "there is a Survey server",
  "keyword": "Given "
});
formatter.match({
  "location": "CreationSteps.there_is_a_Survey_server()"
});
formatter.result({
  "duration": 701353,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 11,
      "value": "#-----------------------------------------------------------------------------------------------------------------------"
    }
  ],
  "line": 14,
  "name": "create a question with empty payload",
  "description": "",
  "id": "creation-of-questions;create-a-question-with-empty-payload",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I have a question with empty payload",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I POST it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I receive a 500 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_question_with_empty_payload()"
});
formatter.result({
  "duration": 43621,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 20269525,
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
  "duration": 657732,
  "error_message": "java.lang.AssertionError: expected:\u003c201\u003e but was:\u003c500\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat io.pestakit.survey.api.spec.steps.CreationSteps.i_receive_a_status_code(CreationSteps.java:87)\r\n\tat ✽.Then I receive a 500 status code(creation.feature:17)\r\n",
  "status": "failed"
});
});