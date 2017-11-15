$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("creation.feature");
formatter.feature({
  "line": 1,
  "name": "Creation of questions",
  "description": "",
  "id": "creation-of-questions",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "there is a Survey server",
  "keyword": "Given "
});
formatter.match({
  "location": "CreationSteps.there_is_a_Survey_server()"
});
formatter.result({
  "duration": 327834128,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "create a question",
  "description": "",
  "id": "creation-of-questions;create-a-question",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I have a question payload",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I POST it to the /questions endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "CreationSteps.i_have_a_question_payload()"
});
formatter.result({
  "duration": 342551,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_questions_endpoint()"
});
formatter.result({
  "duration": 853747406,
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
  "duration": 1802990,
  "error_message": "java.lang.AssertionError: expected:\u003c201\u003e but was:\u003c500\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat io.pestakit.survey.api.spec.steps.CreationSteps.i_receive_a_status_code(CreationSteps.java:64)\r\n\tat ✽.Then I receive a 201 status code(creation.feature:9)\r\n",
  "status": "failed"
});
});