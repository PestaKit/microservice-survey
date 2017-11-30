package io.pestakit.survey.api.spec.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.pestakit.survey.ApiException;
import io.pestakit.survey.ApiResponse;
import io.pestakit.survey.api.DefaultApi;
import io.pestakit.survey.api.dto.*;
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


    private SurveyRef surveyRefGetted;
    private ArrayList usedAttributesOfQuestions = new ArrayList();
    private ArrayList questionIdAttributesOfQuestions = new ArrayList();
    private long lastUsedAttributeValue;
    private long surveyId;
    private Survey survey;
    private Question question;
    private Object location;
    private long questionId;
    private Question questionPosted;
    private Question questionGetted;
    private Survey surveyPosted;
    private ArrayList<Question> listOfAllQuestions;
    private ArrayList<SurveyRef> listOfAllSurveysRef;
    private int lastQuantityOfQuestions;
    private int lastQuantityOfSurveys;
    private ArrayList<String> questionsUrls;

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

    @Given("^I have getted all the surveys and I know the number of surveys")
    public void i_have_getted_all_the_surveys_and_I_know_the_number_of_surveys() throws Throwable {
        i_GET_it_to_the_surveys_endpoint();
        lastQuantityOfSurveys = listOfAllSurveysRef.size();
    }


    @Given("^there is a Survey server$")
    public void there_is_a_Survey_server() throws Throwable {
        assertNotNull(api);
    }

    @Given("^I have an id that does not exist for the questions")
    public void i_have_an_id_that_does_not_exist_for_the_questions() throws Throwable {
        questionId = -1;
    }

    @Given("^I have an id that does not exist for the surveys$")
    public void i_have_an_id_that_does_not_exist_for_the_surveys() throws Throwable {
        surveyId = -1;
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

    @Given("^I have a survey with missing title attribute in payload$")
    public void i_have_a_survey_with_missing_title_attribute_in_payload() throws Throwable {
        survey = new Survey();
        i_POST_questions_successively_to_the_questions_endpoint(3);
        survey.setQuestionURLs(questionsUrls);
    }

    @Given("^I have a survey with missing questuionUrls attribute in payload$")
    public void i_have_a_survey_with_missing_questuionUrls_attribute_in_payload() throws Throwable {
        survey = new Survey();
        survey.setTitle("survey test");
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

    // Add by Julien et Dany
    @Given("^I have a disabled question with full payload$")
    public void i_have_a_disabled_question_with_full_payload() throws Throwable {
        question = new Question();
        question.setTitle("test1");
        question.setEnabled(0);
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


    @Given("^I have a survey with full payload and questions that exist$")
    public void i_have_a_survey_with_full_payload_and_questions_that_exist() throws Throwable {
        survey = new Survey();
        i_POST_questions_successively_to_the_questions_endpoint(3);
        survey.setQuestionURLs(questionsUrls);
        survey.setTitle("survey test1");
    }

    // Add by Julien et Dany
    @Given("^I have a survey with full payload and a disabled question$")
    public void i_have_a_survey_with_full_payload_and_a_disabled_question() throws Throwable {
        survey = new Survey();
        i_POST_a_disabled_question_to_the_questions_endpoint();
        survey.setQuestionURLs(questionsUrls);
        survey.setTitle("survey test1");
    }

    @Given("^I have a survey with full payload and questions that does not exist$")
    public void i_have_a_survey_with_full_payload_and_questions_that_does_not_exist() throws Throwable {
        survey = new Survey();
        survey.getQuestionURLs().add("http://localhost/api/questions/-1");
        survey.getQuestionURLs().add("http://localhost/api/questions/-2");
        survey.getQuestionURLs().add("http://localhost/api/questions/-3");
        survey.setTitle("survey test1");
    }

    @Given("^I have a survey with full payload but with one of the questions that has a bad url$")
    public void i_have_a_survey_with_full_payload_but_with_one_of_the_questions_that_has_a_bad_url() throws Throwable {
        i_have_a_survey_with_full_payload_and_questions_that_exist();
        //we add a bad url
        survey.getQuestionURLs().add("http://localhost/questions/1");
    }


    @Given("^I have a question with empty payload$")
    public void i_have_a_question_with_empty_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
    }

    @Given("^I have a survey with empty payload$")
    public void i_have_a_survey_with_empty_payload() throws Throwable {
        survey = new Survey();
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
        i_have_a_survey_with_full_payload_and_questions_that_exist();
        i_POST_it_to_the_surveys_endpoint();
        assertEquals(201, lastStatusCode);
        String locationStr = location.toString();
        String idStr = locationStr.substring(locationStr.lastIndexOf('/') + 1);
        idStr = idStr.substring(0, idStr.length() - 1);
        surveyId = Integer.parseInt(idStr);
    }

    @Given("^I have posted a survey with a question wich I know the value of the used attribute$")
    public void i_have_posted_a_survey_with_a_question_wich_i_know_the_value_of_the_used_attribute() throws Throwable {
        i_have_a_survey_with_full_payload_and_questions_that_exist();
        lastUsedAttributeValue = (Integer)usedAttributesOfQuestions.get(0);
        questionId = (long)questionIdAttributesOfQuestions.get(0);
        i_POST_it_to_the_surveys_endpoint();
    }

    // Add by Dany
    @Given("I have a question with one choice in choices attribute in payload")
    public void I_have_a_question_with_one_choice_in_choices_attribute_in_payload() throws Throwable{
        question = new Question();
        question.setTitle("test1");
        question.setEnabled(1);
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("option1");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);
        question.setChoices(choiceList);

    }

//----------------------------------------------------------------------------------------------------------------------
    @When("^I POST (\\d+) questions successively to the /questions endpoint$")
    public void i_POST_questions_successively_to_the_questions_endpoint(int numberOfPosts) throws Throwable {
        i_have_a_question_with_full_payload();
        questionsUrls = new ArrayList<>();
        for(int i = 0; i < numberOfPosts; i++){
            i_POST_it_to_the_questions_endpoint();
            StringBuilder realLocation = new StringBuilder(location.toString());
            realLocation.deleteCharAt(0);
            realLocation.deleteCharAt(realLocation.length()-1);
            questionsUrls.add(realLocation.toString());
            assertEquals(201, lastStatusCode);
        }
    }

    // Add by Dany and Julien
    // demander au prof pour l'assert dans une etape intermediaire
    @When("^I POST a disabled question to the /questions endpoint$")
    public void i_POST_a_disabled_question_to_the_questions_endpoint() throws Throwable {
        i_have_a_disabled_question_with_full_payload();
        questionsUrls = new ArrayList<>();
        i_POST_it_to_the_questions_endpoint();
        StringBuilder realLocation = new StringBuilder(location.toString());
        realLocation.deleteCharAt(0);
        realLocation.deleteCharAt(realLocation.length()-1);
        questionsUrls.add(realLocation.toString());

    }
    // Add by Dany and Julien
    @When("^I POST a survey with a disabled question to the /surveys endpoint$")
    public void i_POST_a_survey_with_a_disabled_question_to_the_surveys_endpoint() throws Throwable {
        i_have_a_survey_with_full_payload_and_a_disabled_question();
        i_POST_it_to_the_surveys_endpoint();
    }

    @When("^I POST (\\d+) surveys successively to the /surveys endpoint$")
    public void i_POST_surveys_successively_to_the_surveys_endpoint(int numberOfPosts) throws Throwable {
        i_have_a_survey_with_full_payload_and_questions_that_exist();
        for(int i = 0; i < numberOfPosts; i++){
            i_POST_it_to_the_surveys_endpoint();
        }
        assertEquals(201, lastStatusCode);
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
            usedAttributesOfQuestions.add(question.getUsed());
            String locationStr = location.toString();
            String idStr = locationStr.substring(locationStr.lastIndexOf('/') + 1);
            idStr = idStr.substring(0, idStr.length() - 1);
            questionId = Integer.parseInt(idStr);
            questionIdAttributesOfQuestions.add(questionId);
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


    @When("^I GET it to the /surveys endpoint$")
    public void i_GET_it_to_the_surveys_endpoint() throws Throwable {
        try {
            lastApiResponse = api.getAllSurveysWithHttpInfo();
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            listOfAllSurveysRef = (ArrayList<SurveyRef>)lastApiResponse.getData();
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
            //surveyGetted = (Survey) lastApiResponse.getData();
            surveyRefGetted = (SurveyRef)lastApiResponse.getData();
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }

    // add by Dany
    // I used the same method from Adri
//----------------------------------------------------------------------------------------------------------------------
    @Then("^the difference of questions is (\\d+) when I get again all the questions$")
    public void the_difference_of_questions_is_theGoodDifVariable_when_i_get_again_all_the_questions(int numberOfPosts) throws Throwable {
        i_GET_it_to_the_questions_endpoint();
        assertEquals(lastQuantityOfQuestions+numberOfPosts, listOfAllQuestions.size());
    }

    @Then("^the difference of surveys is (\\d+) when I get again all the surveys")
    public void the_difference_of_surveys_is_theGoodDifVariable_when_i_get_again_all_the_surveys(int numberOfPosts) throws Throwable {
        i_GET_it_to_the_surveys_endpoint();
        assertEquals(lastQuantityOfSurveys+numberOfPosts, listOfAllSurveysRef.size());
    }

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int statusCode) throws Throwable {
        assertEquals(statusCode, lastStatusCode);
    }

    @Then("^the value of the used attribute has been incremented$")
    public void the_value_of_the_used_attribute_has_been_incremented() throws Throwable {
        assertEquals((long)questionGetted.getUsed(), lastUsedAttributeValue+1);
    }

    @And("^The getted question and the posted question are the same$")
    public void the_getted_question_and_the_posted_question_are_the_same() throws Throwable {
        assertEquals(questionPosted, questionGetted);
    }

    @And("^The getted survey and the posted survey have the same title and question urls$")
    public void the_getted_survey_and_the_posted_survey_have_the_same_title_and_question_urls() throws Throwable {
        assertEquals(surveyPosted, toSurvey(surveyRefGetted));
    }


    @And("^The response is a table$")
    public void the_response_is_a_table() throws Throwable {
        String response = lastApiResponse.getData().toString();
        char firstChar = response.charAt(0);
        char lastChar = response.charAt(response.length()-1);
        assertEquals(firstChar, '[');
        assertEquals(lastChar, ']');
    }


    @And("^I cannnot GET those given questions because they were not created$")
    public void i_cannnot_GET_those_given_questions_because_they_were_not_created() throws Throwable {
        questionId = -1;
        i_GET_it_to_the_questions_id_endpoint();
        assertEquals(404, lastStatusCode);

        questionId = -2;
        i_GET_it_to_the_questions_id_endpoint();
        assertEquals(404, lastStatusCode);

        questionId = -3;
        i_GET_it_to_the_questions_id_endpoint();
        assertEquals(404, lastStatusCode);
    }

    @And("^the used attribute value is zero$")
    public void the_used_attribute_value_is_zero() throws Throwable {
        assertEquals((long)questionGetted.getUsed(), 0);
    }


//----------------------------------------OTHERS------------------------------------------------------------------------
    public Survey toSurvey(SurveyRef surveyRef) {
        Survey survey = new Survey();
        ArrayList<String> questionUrls= new ArrayList<>();
        for (QuestionRef questionRef:surveyRef.getQuestionRefs()) {
            String questionUrl = questionRef.getSelf();
            questionUrls.add(questionUrl);
        }
        survey.setTitle(surveyRef.getTitle());
        survey.setQuestionURLs(questionUrls);
        return survey;
    }
}
