# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.pestakit.survey.*;
import io.pestakit.survey.auth.*;
import io.pestakit.survey.model.*;
import io.pestakit.survey.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        
        DefaultApi apiInstance = new DefaultApi();
        Question question = new Question(); // Question | The question to be created
        try {
            apiInstance.createQuestion(question);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#createQuestion");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**createQuestion**](docs/DefaultApi.md#createQuestion) | **POST** /questions | 
*DefaultApi* | [**createSurvey**](docs/DefaultApi.md#createSurvey) | **POST** /surveys | 
*DefaultApi* | [**findQuestionById**](docs/DefaultApi.md#findQuestionById) | **GET** /questions/{id_question} | 
*DefaultApi* | [**findSurveyById**](docs/DefaultApi.md#findSurveyById) | **GET** /surveys/{id_survey} | 
*DefaultApi* | [**getAllQuestions**](docs/DefaultApi.md#getAllQuestions) | **GET** /questions | All the questions
*DefaultApi* | [**getAllSurveys**](docs/DefaultApi.md#getAllSurveys) | **GET** /surveys | 


## Documentation for Models

 - [Choice](docs/Choice.md)
 - [Error](docs/Error.md)
 - [Question](docs/Question.md)
 - [Survey](docs/Survey.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



