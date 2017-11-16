# DefaultApi

All URIs are relative to *https://localhost/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createQuestion**](DefaultApi.md#createQuestion) | **POST** /questions | 
[**findQuestionById**](DefaultApi.md#findQuestionById) | **GET** /questions/{id_question} | 
[**questionsGet**](DefaultApi.md#questionsGet) | **GET** /questions | All the questions


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

<a name="questionsGet"></a>
# **questionsGet**
> List&lt;Question&gt; questionsGet()

All the questions

### Example
```java
// Import classes:
//import io.pestakit.survey.ApiException;
//import io.pestakit.survey.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<Question> result = apiInstance.questionsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#questionsGet");
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

