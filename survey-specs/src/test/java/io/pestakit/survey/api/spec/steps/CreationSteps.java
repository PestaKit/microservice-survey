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
import io.pestakit.survey.api.dto.Survey;
import io.pestakit.survey.api.spec.helpers.Environment;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class CreationSteps {

    private Environment environment;
    private DefaultApi api;

    long surveyId;
    Survey survey;
    Question question;
    Object location;
    long questionId;
    Question questionPosted;
    Question questionGetted;
    Survey surveyPosted;
    Survey surveyGetted;
    ArrayList<Question> listOfAllQuestions;
    int lastQuantityOfQuestions;
    ArrayList<String> questionsUrls;

    private ApiResponse lastApiResponse;
    private ApiException lastApiException;
    private boolean lastApiCallThrewException;
    private int lastStatusCode;

    public CreationSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }
    //------------------------------------------------------------------------------------------------------------------
    @Given("^I have getted all the questions and I know the number of questions$")
    public void i_have_getted_all_the_questions_and_I_know_the_number_of_questions() throws Throwable {
        i_GET_it_to_the_questions_endpoint();
        lastQuantityOfQuestions = listOfAllQuestions.size();
    }


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

    @Given("^I have a question with missing used attribute in payload$")
    public void i_have_a_question_with_missing_used_attribute_in_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test2");
        question.setEnabled(1);
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

    @Given("^I have a question with missing choices attribute in payload$")
    public void i_have_a_question_with_missing_choices_attribute_in_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test2");
        question.setEnabled(1);
        question.setUsed(0);
    }

    @Given("^I have a question with missing title attribute in payload$")
    public void i_have_a_question_with_missing_title_attribute_in_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        //question.setTitle("test2");
        question.setEnabled(1);
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

    @Given("^I have a survey with full payload$")
    public void i_have_a_survey_with_full_payload() throws Throwable {
        survey = new Survey();
        i_POST_questions_successively_to_the_questions_endpoint(3);
        survey.setQuestionURLs(questionsUrls);
        survey.setTitle("survey test1");
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

    @Given("^I have a correct id that exists because I posted a survey")
    public void i_have_a_correct_id_that_exists_because_i_posted_a_survey() throws Throwable {
        i_have_a_survey_with_full_payload();
        i_POST_it_to_the_surveys_endpoint();
        String locationStr = location.toString();
        String idStr = locationStr.substring(locationStr.lastIndexOf('/') + 1);
        idStr = idStr.substring(0, idStr.length() - 1);
        surveyId = Integer.parseInt(idStr);
    }

//----------------------------------------------------------------------------------------------------------------------
    @When("^I POST (\\d+) questions successively to the /questions endpoint$")
    public void i_POST_questions_successively_to_the_questions_endpoint(int numberOfPosts) throws Throwable {
        i_have_a_question_with_full_payload();
        questionsUrls = new ArrayList<>();
        for(int i = 0; i < numberOfPosts; i++){
            i_POST_it_to_the_questions_endpoint();
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            questionsUrls.add(location.toString());
        }
    }


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

    @When("^I POST it to the /surveys endpoint$")
    public void i_POST_it_to_the_surveys_endpoint() throws Throwable {
        try {
            lastApiResponse = api.createSurveyWithHttpInfo(survey);
            surveyPosted = survey;
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


    @When("^I GET it to the /surveys/id_survey endpoint$")
    public void i_GET_it_to_the_surveys_id_endpoint() throws Throwable {
        try {
            lastApiResponse = api.findSurveyByIdWithHttpInfo(surveyId);
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            surveyGetted = (Survey) lastApiResponse.getData();
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    @Then("^the difference of questions is (\\d+) when I get again all the questions$")
    public void the_difference_of_questions_is_theGoodDifVariable_when_i_get_again_all_the_questions(int numberOfPosts) throws Throwable {
        i_GET_it_to_the_questions_endpoint();
        assertEquals(lastQuantityOfQuestions+numberOfPosts, listOfAllQuestions.size());
    }

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int statusCode) throws Throwable {
        assertEquals(statusCode, lastStatusCode);
    }

    @And("^The getted question and the posted question are the same$")
    public void the_getted_question_and_the_posted_question_are_the_same() throws Throwable {
        assertEquals(questionPosted, questionGetted);
    }

    @And("^The getted survey and the posted survey are the same$")
    public void the_getted_survey_and_the_posted_survey_are_the_same() throws Throwable {
        assertEquals(surveyPosted, surveyGetted);
    }


    @And("^The response is a table$")
    public void the_response_is_a_table() throws Throwable {
        String response = lastApiResponse.getData().toString();
        char firstChar = response.charAt(0);
        char lastChar = response.charAt(response.length()-1);
        assertEquals(firstChar, '[');
        assertEquals(lastChar, ']');
    }

}
