package io.pestakit.survey.api.spec.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.pestakit.survey.ApiException;
import io.pestakit.survey.ApiResponse;
import io.pestakit.survey.api.DefaultApi;
import io.pestakit.survey.api.dto.Question;
import io.pestakit.survey.api.spec.helpers.Environment;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class CreationSteps {

    private Environment environment;
    private DefaultApi api;

    Question question;

    private ApiResponse lastApiResponse;
    private ApiException lastApiException;
    private boolean lastApiCallThrewException;
    private int lastStatusCode;

    public CreationSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @Given("^there is a Survey server$")
    public void there_is_a_Survey_server() throws Throwable {
        assertNotNull(api);
    }

    @Given("^I have a question payload$")
    public void i_have_a_question_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
    }

    @When("^I POST it to the /questions endpoint$")
    public void i_POST_it_to_the_questions_endpoint() throws Throwable {
        try {
            lastApiResponse = api.createQuestionWithHttpInfo(question);
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }

    }

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        assertEquals(201, lastStatusCode);
    }

}
