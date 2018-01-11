package io.pestakit.survey.api.spec.steps;

import com.google.gson.Gson;
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
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class CreationSteps {

    private Environment environment;
    private DefaultApi api;

    private Answer answer;
    private SurveyRef surveyRefGetted;
    private ArrayList usedAttributesOfQuestions = new ArrayList();
    private ArrayList questionIdAttributesOfQuestions = new ArrayList();
    private ArrayList answerIdAttributesOfAnswers = new ArrayList();
    private ArrayList<Question> succesivePostedQuestions = new ArrayList();
    private ArrayList<Answer> succesivePostedAnswers = new ArrayList();
    private long lastUsedAttributeValue;
    private long surveyId;
    private Survey survey;
    private Question question;
    private Object location;
    private long questionId;
    private long answerId;
    private Answer answerPosted;
    private Answer answerGetted;
    private Question questionPosted;
    private Question questionGetted;
    private Survey surveyPosted;
    private ArrayList<Answer> listOfAllAnswers;
    private ArrayList<Question> listOfAllQuestions;
    private ArrayList<SurveyRef> listOfAllSurveysRef;
    private int lastQuantityOfAnswers;
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
    @Given("^I have a question where a text choice is missing$")
    public void i_have_a_question_where_a_text_choice_is_missing() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test");
        question.setUsed(0);
        question.setEnabled(1);
        question.setAllowMultipleChoices(1);
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("");
        Choice choice2 = new Choice();
        choice2.setPosition(2);
        choice2.setText("option2");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);choiceList.add(choice2);
        question.setChoices(choiceList);
    }


    @Given("^I have a question where a position index for the choices is not unique$")
    public void i_have_a_question_where_a_position_index_for_the_choices_is_not_unique() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test");
        question.setUsed(0);
        question.setEnabled(1);
        question.setAllowMultipleChoices(1);
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("otpion1");
        Choice choice2 = new Choice();
        choice2.setPosition(1);
        choice2.setText("option2");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);choiceList.add(choice2);
        question.setChoices(choiceList);
    }



    @Given("^I have a question where a position index is missing for the choices$")
    public void i_have_a_question_where_a_position_index_is_missing_for_the_choices() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test");
        question.setUsed(0);
        question.setEnabled(1);
        question.setAllowMultipleChoices(1);
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("otpion1");
        Choice choice2 = new Choice();
        choice2.setPosition(3);
        choice2.setText("option2");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);choiceList.add(choice2);
        question.setChoices(choiceList);
    }



    @Given("^I have a question where the first position of the choices starts with 0$")
    public void i_have_a_question_where_the_first_position_of_the_choices_starts_with_0() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        question.setTitle("test");
        question.setUsed(0);
        question.setEnabled(1);
        question.setAllowMultipleChoices(1);
        Choice choice1 = new Choice();
        choice1.setPosition(0);
        choice1.setText("otpion1");
        Choice choice2 = new Choice();
        choice2.setPosition(1);
        choice2.setText("option2");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);choiceList.add(choice2);
        question.setChoices(choiceList);
    }


    @Given("^I have getted all the questions and I know the number of questions$")
    public void i_have_getted_all_the_questions_and_I_know_the_number_of_questions() throws Throwable {
        i_GET_it_to_the_questions_endpoint();
        lastQuantityOfQuestions = listOfAllQuestions.size();
    }

    @Given("^I have getted all the answers and I know the number of answers")
    public void i_have_getted_all_the_answers_and_I_know_the_number_of_answers() throws Throwable {
        i_GET_it_to_the_answers_endpoint();
        assertEquals(200, lastStatusCode);
        lastQuantityOfAnswers = listOfAllAnswers.size();
        int test =2;
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
        question.setAllowMultipleChoices(1);
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
        question.setAllowMultipleChoices(1);
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
        question.setAllowMultipleChoices(1);
        question.setUsed(0);
    }

    @Given("^I have a question with missing title attribute in payload$")
    public void i_have_a_question_with_missing_title_attribute_in_payload() throws Throwable {
        question = new io.pestakit.survey.api.dto.Question();
        //question.setTitle("test2");
        question.setEnabled(1);
        question.setAllowMultipleChoices(1);
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
        question.setAllowMultipleChoices(1);
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

    @Given("^I have a single choice question with full payload$")
    public void i_have_a_single_choice_question_with_full_payload() throws Throwable {
        question = new Question();
        question.setTitle("test1");
        question.setEnabled(1);
        question.setUsed(0);
        question.setAllowMultipleChoices(0);
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

    @Given("^I have an answer with full payload$")
    public void i_have_an_answer_with_full_payload() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //we take all the choices of the first question of the survey to simulate the answer
        //it means the user checked all the boxes for example
        answer.setChoices(succesivePostedQuestions.get(0).getChoices());
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }

    @Given("^I have an answer with full payload and only one choice per question$")
    public void i_have_an_answer_with_full_payload_and_only_one_choice_per_question() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //we take all the choices of the first question of the survey to simulate the answer
        //it means the user checked the first box for example
        List<Choice> choices = new ArrayList();
        choices.add(succesivePostedQuestions.get(0).getChoices().get(0));
        answer.setChoices(choices);
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }


    @Given("^I have an answer where the choices are not specified$")
    public void i_have_an_answer_where_the_choices_are_not_specified() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }


    @Given("^I have an answer where the questionId does not exists$")
    public void i_have_an_answer_where_the_questionId_does_not_exists() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //we take all the choices of the first question of the survey to simulate the answer
        //it means the user checked all the boxes for example
        answer.setChoices(succesivePostedQuestions.get(0).getChoices());
        //bad questionId
        Long badId = 0L;
        answer.setIdQuestion(badId);
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }


    @Given("^I have an answer where a choice position is missing$")
    public void i_have_an_answer_where_a_choice_position_is_missing() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //no choice position but good text choice
        Choice choice1 = new Choice();
        choice1.setText(succesivePostedQuestions.get(0).getChoices().get(0).getText());
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);;
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }


    @Given("^I have an answer where a choice text is missing$")
    public void i_have_an_answer_where_a_choice_text_is_missing() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //no choice text but good position choice
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);;
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }



    @Given("^I have an answer where the surveyId does not exists$")
    public void i_have_an_answer_where_the_surveyId_does_not_exists() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //we take all the choices of the first question of the survey to simulate the answer
        //it means the user checked all the boxes for example
        answer.setChoices(succesivePostedQuestions.get(0).getChoices());
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        //bad survey id
        Long badId = 0L;
        answer.setIdSurvey(badId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }


    @Given("^I have an answer where the choice does not match with the question$")
    public void i_have_an_answer_where_the_choice_does_not_match_with_the_question() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //bad choices
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("bad1");
        Choice choice2 = new Choice();
        choice2.setPosition(2);
        choice2.setText("bad2");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);choiceList.add(choice2);
        answer.setChoices(choiceList);
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");
    }


    @Given("^I have an answer with missing timestamp in payload$")
    public void i_have_an_answer_with_missing_timestamp_in_payload() throws Throwable {
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey();
        answer = new Answer();
        //we take all the choices of the first question of the survey to simulate the answer
        //it means the user checked all the boxes for example
        answer.setChoices(succesivePostedQuestions.get(0).getChoices());
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
    }



    @Given("^I have a disabled question with full payload$")
    public void i_have_a_disabled_question_with_full_payload() throws Throwable {
        question = new Question();
        question.setTitle("test1");
        question.setEnabled(0);
        question.setUsed(0);
        question.setAllowMultipleChoices(1);
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

         
    @Given("^I have a survey with full payload and single choice questions that exist$")
    public void i_have_a_survey_with_full_payload_and_single_choice_questions_that_exist() throws Throwable {
        survey = new Survey();
        i_POST_single_choice_questions_successively_to_the_questions_endpoint(1);
        survey.setQuestionURLs(questionsUrls);
        survey.setTitle("survey test2");
    }


    @Given("^I have a survey with full payload and a disabled question$")
    public void i_have_a_survey_with_full_payload_and_a_disabled_question() throws Throwable {
        survey = new Survey();
        i_have_a_disabled_question_with_full_payload();
        questionsUrls = new ArrayList<>();
        i_POST_it_to_the_questions_endpoint();
        StringBuilder realLocation = new StringBuilder(location.toString());
        realLocation.deleteCharAt(0);
        realLocation.deleteCharAt(realLocation.length()-1);
        questionsUrls.add(realLocation.toString());
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


    @Given("^I have a correct id that exists because I posted an answer")
    public void i_have_a_correct_id_that_exists_because_i_posted_an_answer() throws Throwable {
        i_have_an_answer_with_full_payload();
        i_POST_it_to_the_answers_endpoint();
        /*i_have_a_question_with_full_payload();
        i_POST_it_to_the_questions_endpoint();
        String locationStr = location.toString();
        String idStr = locationStr.substring(locationStr.lastIndexOf('/') + 1);
        idStr = idStr.substring(0, idStr.length() - 1);
        questionId = Integer.parseInt(idStr);*/
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

         
    @Given("^I have a correct id that exists because I posted a survey with single choice questions")
    public void i_have_a_correct_id_that_exists_because_i_posted_a_survey_with_single_choice_questions() throws Throwable {
        i_have_a_survey_with_full_payload_and_single_choice_questions_that_exist();
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


    @Given("I have a question with one choice in choices attribute in payload")
    public void I_have_a_question_with_one_choice_in_choices_attribute_in_payload() throws Throwable{
        question = new Question();
        question.setTitle("test1");
        question.setEnabled(1);
        question.setAllowMultipleChoices(0);
        Choice choice1 = new Choice();
        choice1.setPosition(1);
        choice1.setText("option1");
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);
        question.setChoices(choiceList);

    }

         
    @Given("I have an answer with multiple choices in a single choice question")
    public void I_have_an_answer_with_multiple_choices_in_a_single_choice_question() throws Throwable{
        //we need first to create a Survey with questions and a user id (fake for the moment)
        i_have_a_correct_id_that_exists_because_i_posted_a_survey_with_single_choice_questions();
        answer = new Answer();
        //we take all the choices of the first question of the survey to simulate the answer
        //it means the user checked all the boxes for example
        answer.setChoices(succesivePostedQuestions.get(0).getChoices());
        answer.setIdQuestion((Long)questionIdAttributesOfQuestions.get(0));
        answer.setIdSurvey(surveyId);
        //fake user Id because we need the API of the other group
        Long userId = 1L;
        //answer.setIdUser(userId);
        //here is a valid syntax timestamp in string
        answer.setTimestamp("2017-12-13T09:39:10.582+01:00");

    }

//----------------------------------------------------------------------------------------------------------------------
    @When("^I POST (\\d+) questions successively to the /questions endpoint$")
    public void i_POST_questions_successively_to_the_questions_endpoint(int numberOfPosts) throws Throwable {
        i_have_a_question_with_full_payload();
        questionsUrls = new ArrayList<>();
        succesivePostedQuestions.clear();
        questionIdAttributesOfQuestions.clear();
        for(int i = 0; i < numberOfPosts; i++){
            i_POST_it_to_the_questions_endpoint();
            StringBuilder realLocation = new StringBuilder(location.toString());
            realLocation.deleteCharAt(0);
            realLocation.deleteCharAt(realLocation.length()-1);
            questionsUrls.add(realLocation.toString());
            assertEquals(201, lastStatusCode);
        }
    }
         
    @When("^I POST (\\d+) single choice questions successively to the /questions endpoint$")
    public void i_POST_single_choice_questions_successively_to_the_questions_endpoint(int numberOfPosts) throws Throwable {
        i_have_a_single_choice_question_with_full_payload();
        questionsUrls = new ArrayList<>();
        succesivePostedQuestions.clear();
        questionIdAttributesOfQuestions.clear();
        for(int i = 0; i < numberOfPosts; i++){
            i_POST_it_to_the_questions_endpoint();
            StringBuilder realLocation = new StringBuilder(location.toString());
            realLocation.deleteCharAt(0);
            realLocation.deleteCharAt(realLocation.length()-1);
            questionsUrls.add(realLocation.toString());
            assertEquals(201, lastStatusCode);
        }
    }


    @When("^I POST (\\d+) identical answers successively to the /answers endpoint$")
    public void i_POST_identical_answers_successively_to_the_answers_endpoint(int numberOfPosts) throws Throwable {

        i_have_an_answer_with_full_payload();
        succesivePostedAnswers.clear();
        answerIdAttributesOfAnswers.clear();

        for(int i = 0; i < numberOfPosts; i++){
            i_POST_it_to_the_answers_endpoint();
            assertEquals(201, lastStatusCode);
        }
    }


    @When("^I POST (\\d+) different answers successively to the /answers endpoint$")
    public void i_POST_two_different_answers_successively_to_the_answers_endpoint(int numberOfPosts) throws Throwable {

        succesivePostedAnswers.clear();
        answerIdAttributesOfAnswers.clear();

        for(int i = 0; i < numberOfPosts; i++){
            i_have_an_answer_with_full_payload();
            i_POST_it_to_the_answers_endpoint();
            assertEquals(201, lastStatusCode);
        }
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
            succesivePostedQuestions.add(question);
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }



    @When("^I POST it to the /answers endpoint$")
    public void i_POST_it_to_the_answers_endpoint() throws Throwable {
        try {
            lastApiResponse = api.createAnswerWithHttpInfo(answer);
            answerPosted = answer;
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            location = lastApiResponse.getHeaders().get("Location");
            String locationStr = location.toString();
            String idStr = locationStr.substring(locationStr.lastIndexOf('/') + 1);
            idStr = idStr.substring(0, idStr.length() - 1);
            answerId = Integer.parseInt(idStr);
            answerIdAttributesOfAnswers.add(answerId);
            succesivePostedAnswers.add(answer);
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


    @When("^I GET it to the /answers endpoint$")
    public void i_GET_it_to_the_answers_endpoint() throws Throwable {
        try {
            lastApiResponse = api.getAllSurveysWithHttpInfo();
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            listOfAllAnswers = (ArrayList<Answer>)lastApiResponse.getData();
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



    @When("^I GET it to the /answers/id_answer endpoint$")
    public void i_GET_it_to_the_answers_id_endpoint() throws Throwable {
        try {
            lastApiResponse = api.findAnswerByIdWithHttpInfo(answerId);
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            answerGetted = (Answer) lastApiResponse.getData();
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


//----------------------------------------------------------------------------------------------------------------------
    @Then("^the difference of questions is (\\d+) when I get again all the questions$")
    public void the_difference_of_questions_is_theGoodDifVariable_when_i_get_again_all_the_questions(int numberOfPosts) throws Throwable {
        i_GET_it_to_the_questions_endpoint();
        assertEquals(lastQuantityOfQuestions+numberOfPosts, listOfAllQuestions.size());
    }

    @Then("^the difference of answers is (\\d+) when I get again all the answers")
    public void the_difference_of_answers_is_theGoodDifVariable_when_i_get_again_all_the_answers(int numberOfPosts) throws Throwable {
        i_GET_it_to_the_answers_endpoint();
        assertEquals(lastQuantityOfAnswers+numberOfPosts, listOfAllAnswers.size());
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


    @And("^The getted answer and the posted answer are the same$")
    public void the_getted_answer_and_the_posted_answer_are_the_same() throws Throwable {
        assertEquals(answerPosted, answerGetted);
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


    @And("^The error message specifies it is a position error$")
    public void the_error_message_specifies_it_is_a_position_error() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        assertEquals("choices", erroneousFieldList.get(0).getFieldName());
        assertEquals("InvalidPositions", erroneousFieldList.get(0).getErrorCode());
    }



    @And("^The error message specifies the empty fields for the question$")
    public void the_error_message_specifies_the_empty_fields_for_the_question() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexTitle = findIndexOfError(erroneousFieldList, "title");
        int indexEnabled = findIndexOfError(erroneousFieldList, "enabled");
        int indexChoices = findIndexOfError(erroneousFieldList, "choices");

        if(indexTitle != -1) {
            assertEquals("title", erroneousFieldList.get(indexTitle).getFieldName());
            assertEquals("NotNull", erroneousFieldList.get(indexTitle).getErrorCode());
        }
        if(indexEnabled != -1) {
            assertEquals("enabled", erroneousFieldList.get(indexEnabled).getFieldName());
            assertEquals("NotNull", erroneousFieldList.get(indexEnabled).getErrorCode());
        }
        if(indexChoices != -1) {
            assertEquals("choices", erroneousFieldList.get(indexChoices).getFieldName());
            assertEquals("EmptyList", erroneousFieldList.get(indexChoices).getErrorCode());
        }
    }


    @And("^The error message specifies that a single choice is not possible$")
    public void the_error_message_specifies_that_a_single_choice_is_not_possible() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        assertEquals("choices", erroneousFieldList.get(0).getFieldName());
        assertEquals("ListWithASingleChoice", erroneousFieldList.get(0).getErrorCode());
    }

    @And("^The error message specifies there is a missing text$")
    public void the_error_message_specifies_there_is_a_missing_text() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        assertEquals("choices", erroneousFieldList.get(0).getFieldName());
        assertEquals("EmptyText", erroneousFieldList.get(0).getErrorCode());
    }


    @And("^The error message specifies there is a bad URL question$")
    public void the_error_message_specifies_there_is_a_bad_url_question() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        assertEquals("questionURLs", erroneousFieldList.get(0).getFieldName());
        assertEquals("BadURL", erroneousFieldList.get(0).getErrorCode());
    }


    @And("^The error message specifies the empty fields for the survey$")
    public void the_error_message_specifies_the_empty_fields_for_the_survey() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexTitle = findIndexOfError(erroneousFieldList, "title");
        int indexUrls = findIndexOfError(erroneousFieldList, "enabled");

        if(indexTitle != -1) {
            assertEquals("title", erroneousFieldList.get(indexTitle).getFieldName());
            assertEquals("NotNull", erroneousFieldList.get(indexTitle).getErrorCode());
        }
        if(indexUrls != -1) {
            assertEquals("questionURLs", erroneousFieldList.get(indexUrls).getFieldName());
            assertEquals("EmptyQuestionURLs", erroneousFieldList.get(indexUrls).getErrorCode());
        }
    }



    @And("^I have a default timestamp when I get this answer again$")
    public void i_have_a_default_timestamp_when_I_get_this_answer_again() throws Throwable {
        i_GET_it_to_the_answers_id_endpoint();
        assertNotSame("the default timestamp must not be empty","", answerGetted.getTimestamp());
    }


    @And("^The error message specifies it is a non existing question$")
    public void the_error_message_specifies_it_is_a_non_existing_question() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexIdQuestion = findIndexOfError(erroneousFieldList, "idQuestion");
        if(indexIdQuestion != -1) {
            assertEquals("idQuestion", erroneousFieldList.get(indexIdQuestion).getFieldName());
            assertEquals("NonExistingQuestion", erroneousFieldList.get(indexIdQuestion).getErrorCode());
        }
    }


    @And("^The error message specifies it is a non existing survey$")
    public void the_error_message_specifies_it_is_a_non_existing_survey() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexIdSurvey = findIndexOfError(erroneousFieldList, "idSurvey");
        if(indexIdSurvey != -1) {
            assertEquals("idSurvey", erroneousFieldList.get(indexIdSurvey).getFieldName());
            assertEquals("NonExistingSurvey", erroneousFieldList.get(indexIdSurvey).getErrorCode());
        }
    }


    @And("^The error message specifies it is a choice for non existing question$")
    public void the_error_message_specifies_it_is_a_choice_for_non_existing_question() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexChoices = findIndexOfError(erroneousFieldList, "choices");
        if(indexChoices != -1) {
            assertEquals("choices", erroneousFieldList.get(indexChoices).getFieldName());
            assertEquals("ChoicesForNonExistingQuestion", erroneousFieldList.get(indexChoices).getErrorCode());
        }
    }

    @And("^The error message specifies that the choices are not specified$")
    public void the_error_message_specifies_that_the_choices_are_not_specified() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexChoices = findIndexOfError(erroneousFieldList, "choices");
        if(indexChoices != -1) {
            assertEquals("choices", erroneousFieldList.get(indexChoices).getFieldName());
            assertEquals("EmptyList", erroneousFieldList.get(indexChoices).getErrorCode());
        }
    }


    @And("^The error message specifies that there is too much choices$")
    public void the_error_message_specifies_that_there_is_too_much_choices() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexChoices = findIndexOfError(erroneousFieldList, "choices");
        if(indexChoices != -1) {
            assertEquals("choices", erroneousFieldList.get(indexChoices).getFieldName());
            assertEquals("TooMuchChoices", erroneousFieldList.get(indexChoices).getErrorCode());
        }
    }

    @And("^The error message specifies that a choice text is missing$")
    public void the_error_message_specifies_that_a_choice_text_is_missing() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexChoices = findIndexOfError(erroneousFieldList, "choices[0].text");
        if(indexChoices != -1) {
            assertEquals("choices[0].text", erroneousFieldList.get(indexChoices).getFieldName());
            assertEquals("NotNull", erroneousFieldList.get(indexChoices).getErrorCode());
        }
    }


    @And("^The error message specifies that a choice position is missing$")
    public void the_error_message_specifies_that_a_choice_position_is_missing() throws Throwable {
        List<ErroneousField> erroneousFieldList = getErroneousFields();
        int indexChoices = findIndexOfError(erroneousFieldList, "choices[0].text");
        if(indexChoices != -1) {
            assertEquals("choices[0].position", erroneousFieldList.get(indexChoices).getFieldName());
            assertEquals("NotNull", erroneousFieldList.get(indexChoices).getErrorCode());
        }
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



    public List<ErroneousField> getErroneousFields(){
        String body = lastApiException.getResponseBody();
        io.pestakit.survey.api.dto.Error error = new Gson().fromJson(body, io.pestakit.survey.api.dto.Error.class);
        List<ErroneousField> ErroneousFieldslist = error.getFields();
        return ErroneousFieldslist;
    }


    public int findIndexOfError(List<ErroneousField> erroneousFieldList, String error){
        int index = -1;
        for (int i = 0; i < erroneousFieldList.size();i++) {
            if(erroneousFieldList.get(i).getFieldName().equals(error)){
                index = i;
            }
        }
        return index;
    }
}
