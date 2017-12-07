

# microservice-survey

A surveys microservice for AMT course 2017

## Getting Started

Clone the whole project.

### Prerequisites

You first have to install docker and have the last version of IntelliJ IDEA Ultimate (2017.2.5 here).


## Deployment

Open the docker terminal and go to the "topology-amt" folder. There is a file called "docker-compose.yml". 

Enter the line command : docker-compose up --build.

It will build and run all the images with the good configuration (phpmyadmin and mysql).
Then open your web browser and and go to the following url if you want to administrate the Data Base: <http://192.168.99.100:6060/>. The username is "root" and the pasword "adminpw".
Attention: at this moment, you just have a database that is running and not the server with the API.

To launch this server, you have to launch IntelliJ IDEA, open the project in the folder "spring-server" that contains the survey API and run it.
You will be able to manually test your own requests with tis API on the following interface: <http://localhost:8080/api/swagger-ui.html#/questions-api-controller>.

Then if you want to execute some tests on the api-server, you can open the "survey-specs" folder that contains all the tests and run it with IntelliJ IDEA by doing a right click on the project and select "Run" then "All tests".



## Authors
Julien Brêchet, Adrien Marco, Ali Miladi and Dany Tchente


## Acknowledgments

Starting template: Olivier Liechti

## API Utilisation warnings and global operation
Here are some rules about the utilisation of the API if you want to use it to develop your web application:

- When you create some questions, there are independent and unique. Then you can link it to a survey that is unique too. So if you want, for example, to send the same survey each week to a group of people, it means you have to create each week a new and unique survey which contains the same linked questions as the previous week.

- If you are interested to check the answers to the questions of a survey, you have to know that the answer is an independent object that is in relation with: the id of the user who give an answer, the id of the survey that contains the question, the id of the answered question, the choice he selected and the time. So if want to collect the answers for a particular user between different surveys that contain the same questions (like the given example), you have to search for all answers which contain the same user id and question id because you know the surveys id are not the same.

- Do not forget that, every time a user give an answer to a question, an object (type: answer) can be immediately created to save the answer. Because of the time attribute of an answer,  a user can change of mind when he is completing a survey. You will be able to know if more than one answer was given to a question (for the same survey and the same user). Then you can, for example, just consider the latest answer by consulting the time attribute.

- The choices belong to a question and are not linked even if we store it in the database. The choice is hard coded in the question. For example, if a choice is called "banana", you will find in the database as many choices "banana" (with different Id's) as we have questions with the "banana" choice.

- A survey does not implement the notion of open/close. It means that a survey is accessible on every time, we can't open or close a survey.

- Each choice of a response has is position. This position starts with the index 1 and must be incremental.



