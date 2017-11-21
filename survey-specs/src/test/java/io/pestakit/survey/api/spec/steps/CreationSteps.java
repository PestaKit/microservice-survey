package io.pestakit.survey.api.spec.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.pestakit.survey.ApiException;
import io.pestakit.survey.ApiResponse;
import io.pestakit.survey.api.DefaultApi;
import io.pestakit.survey.api.dto.Choice;
import io.pestakit.survey.api.dto.Question;
import io.pestakit.survey.api.spec.helpers.Environment;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class CreationSteps {

    private Environment environment;
    private DefaultApi api;

    Object id;
    Question question;
    Object location;
    long questionId;
    Question questionPosted;
    Question questionGetted;
    ArrayList<Question> listOfAllQuestions;

    private ApiResponse lastApiResponse;
    private ApiException lastApiException;
    private boolean lastApiCallThrewException;
    private int lastStatusCode;

    public CreationSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }
    //------------------------------------------------------------------------------------------------------------------
    @Given("^there is a Survey server$")
    public void there_is_a_Survey_server() throws Throwable {
        assertNotNull(api);
    }

    @Given("^I have a wrong id$")
    public void i_have_a_wrong_id() throws Throwable {
        questionId = -1;
    }


    @Given("^I have a question with missing enabled attribute in payload$")
    public void i_have_a_question_with_missing_enabled_attribute_in_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test2");
        //question.setEnabled(1);
        question.setUsed(0);
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("otpion1");
        Choice choice2 = new Choice();
        choice2.setPosition(2);
        choice2.setText("option2");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);choiceList.add(choice2);
        question.setChoices(choiceList);
    }

    @Given("^I have a question with full payload$")
    public void i_have_a_question_with_full_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test1");
        question.setEnabled(1);
        question.setUsed(0);
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("pomme");
        Choice choice2 = new Choice();
        choice2.setPosition(2);
        choice2.setText("banane");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);choiceList.add(choice2);
        question.setChoices(choiceList);
    }


    @Given("^I have a question with empty payload$")
    public void i_have_a_question_with_empty_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
    }

    @Given("^I have a correct id that exists because I posted a question$")
    public void i_have_a_correct_id_that_exists_because_i_posted_a_question() throws Throwable {
        i_have_a_question_with_full_payload();
        i_POST_it_to_the_questions_endpoint();
        String locationStr = location.toString();
        String idStr = locationStr.substring(locationStr.lastIndexOf('/') + 1);
        idStr = idStr.substring(0, idStr.length() - 1);
        questionId = Integer.parseInt(idStr);
    }

//----------------------------------------------------------------------------------------------------------------------

    @When("^I POST it to the /questions endpoint$")
    public void i_POST_it_to_the_questions_endpoint() throws Throwable {
        try {
            lastApiResponse = api.createQuestionWithHttpInfo(question);
            questionPosted = question;
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            location = lastApiResponse.getHeaders().get("Location");
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }



    @When("^I GET it to the /questions endpoint$")
    public void i_GET_it_to_the_questions_endpoint() throws Throwable {
        try {
            lastApiResponse = api.getAllQuestionsWithHttpInfo();
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            listOfAllQuestions = (ArrayList<Question>)lastApiResponse.getData();
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }


    @When("^I GET it to the /questions/id_question endpoint$")
    public void i_GET_it_to_the_questions_id_endpoint() throws Throwable {
        try {
            lastApiResponse = api.findQuestionByIdWithHttpInfo(questionId);
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            questionGetted = (Question)lastApiResponse.getData();
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int statusCode) throws Throwable {
        assertEquals(statusCode, lastStatusCode);
    }

    @And("^The getted question and the posted question are the same$")
    public void the_getted_question_and_the_posted_question_are_the_same() throws Throwable {
        assertEquals(questionPosted, questionGetted);
    }


}
