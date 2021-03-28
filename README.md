## Description
* This repository consists a backend service written in Sprintboot (version 2.4.4) and Java 11 (version 11.0.9). Gradle (version 6.8.3) is uded as a build tool
* The development environment was as follows:
- Operating System: Windows 10
- Postman is ued to the API endpoints 
- Mongo DB docker image has been used to store the data 
- Development IDE: Intellij IDEA community edition

## Choices made:
* I took the liberty to rename some keys in the json files to be more compliant to suggest naming standard in java and spring boot - in a real project scenario I would like to get it clarified with technical product owner and the team
* I found that the provided `products.json` file did not have `price` key/attribute - I would discuss that in a technical refinement session if it were a real life project
* I have some questions about removal of product functionality - hence I made an assumption and chose to remove the product. In real life project I would like to verify the assumptions.
* What can be picked in next few iterations:
- Unit tests - I implemented the unit tests for Controller level, which can be enhanced
- Handling the exceptions can be done in more robust and more sophisticated way
- I only implemented basic authentication, if business requires some other form of authentication that can be implemented
- This code is not peer reviewed - any feedback/improvement ideas from peer review needs to be addressed too

## How to run the backened service?
From JAR:
1. Clone the git repository and go to the root folder
2. Start the Mongo DB docker container using the following command-
`docker-compose -f docker-compose.yml up -d`
3. Run the JAR file, using-
`java -jar warehouse-backend\build\libs\warehouse-backend-0.0.1-SNAPSHOT.jar`

From source code: (Gradle and Java need to be installed in the host system)
1. Clone the git repository and go to the root folder
2. Start the Mongo DB docker container using the following command-
`docker-compose -f docker-compose.yml up -d`
3. Go to `warehouse-backend` folder and build the project using
`gradle build` or from an IDE please run the `WarehouseBackendApplication.java` file 


## How to run unit tests?
The unit tests are in the `WarehouseBackendApplicationTests.java` file. To run the unit tests -
1. Go to `warehouse-backend` folder and run the tests using
`gradle test` or using an IDE please run the `WarehouseBackendApplicationTests.java` file 

