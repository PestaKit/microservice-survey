

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

Then launch IntelliJ IDEA, open the project in the folder "spring-server" that contains the survey API and run it.
You will be able to manually test your own requests with tis API on the following interface: <http://localhost:8080/api/swagger-ui.html#/questions-api-controller>.

Then if you want to execute some tests on the api-server, you can open the "survey-specs" folder that contains all the tests and run it with IntelliJ IDEA by doing a right click on the project and select "Run" then "All tests".



## Authors
Julien Brêchet, Adrien Marco, Ali Miladi and Dany Tchente


## Acknowledgments

Starting template: Olivier Liechti

