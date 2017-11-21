# DefaultApi

All URIs are relative to *https://localhost/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createQuestion**](DefaultApi.md#createQuestion) | **POST** /questions | 
[**createSurvey**](DefaultApi.md#createSurvey) | **POST** /surveys | 
[**findQuestionById**](DefaultApi.md#findQuestionById) | **GET** /questions/{id_question} | 
[**findSurveyById**](DefaultApi.md#findSurveyById) | **GET** /surveys/{id_survey} | 
[**getAllQuestions**](DefaultApi.md#getAllQuestions) | **GET** /questions | All the questions
[**getAllSurveys**](DefaultApi.md#getAllSurveys) | **GET** /surveys | 


<a name="createQuestion"></a>
# **createQuestion**
> createQuestion(question)



Create a question

### Example
```java
// Import classes:
//import io.pestakit.survey.ApiException;
//import io.pestakit.survey.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Question question = new Question(); // Question | The question to be created
try {
    apiInstance.createQuestion(question);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createQuestion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **question** | [**Question**](Question.md)| The question to be created |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="createSurvey"></a>
# **createSurvey**
> createSurvey(idSurvey)



Create a survey

### Example
```java
// Import classes:
//import io.pestakit.survey.ApiException;
//import io.pestakit.survey.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Survey idSurvey = new Survey(); // Survey | The survey to be created
try {
    apiInstance.createSurvey(idSurvey);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createSurvey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idSurvey** | [**Survey**](Survey.md)| The survey to be created |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="findQuestionById"></a>
# **findQuestionById**
> Question findQuestionById(idQuestion)



Returns the identified question

### Example
```java
// Import classes:
//import io.pestakit.survey.ApiException;
//import io.pestakit.survey.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Long idQuestion = 789L; // Long | ID of question to fetch
try {
    Question result = apiInstance.findQuestionById(idQuestion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findQuestionById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idQuestion** | **Long**| ID of question to fetch |

### Return type

[**Question**](Question.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findSurveyById"></a>
# **findSurveyById**
> Survey findSurveyById(idSurvey)



Returns the identified survey

### Example
```java
// Import classes:
//import io.pestakit.survey.ApiException;
//import io.pestakit.survey.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Long idSurvey = 789L; // Long | ID of survey to fetch
try {
    Survey result = apiInstance.findSurveyById(idSurvey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findSurveyById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idSurvey** | **Long**| ID of survey to fetch |

### Return type

[**Survey**](Survey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllQuestions"></a>
# **getAllQuestions**
> List&lt;Question&gt; getAllQuestions()

All the questions

### Example
```java
// Import classes:
//import io.pestakit.survey.ApiException;
//import io.pestakit.survey.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<Question> result = apiInstance.getAllQuestions();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getAllQuestions");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Question&gt;**](Question.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllSurveys"></a>
# **getAllSurveys**
> Survey getAllSurveys()



Returns the identified survey

### Example
```java
// Import classes:
//import io.pestakit.survey.ApiException;
//import io.pestakit.survey.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    Survey result = apiInstance.getAllSurveys();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getAllSurveys");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Survey**](Survey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

