## Description
* This repository consists a backend service written in Springboot (version 2.4.4) and Java 11 (version 11.0.9). Gradle (version 6.8.3) is used as a build tool
* The development environment was as follows:
    - Operating System: Windows 10
    - Postman is ued to test the API endpoints 
    - Mongo DB docker image has been used to store the data
    - Development IDE: Intellij IDEA community edition


## How to run the backend service?
<b>From source code:<b> (Gradle and Java need to be installed in the host system)
1. Clone the git repository and go to the root folder
2. Start the Mongo DB docker container using the following command (the docker daemon needs to be started before)-
`docker-compose -f docker-compose.yml up -d`
3. Go to `warehouse-backend` folder and run the project using
`gradle run` or from an IDE please run the `WarehouseBackendApplication.java` file
4. By default the backend service will run on port 8080, to modify it change the port in `application.yaml` file under `warehouse-backend` folder   

<b>From JAR:<b>
1. Clone the git repository and go to the root folder
2. Start the Mongo DB docker container using the following command-
`docker-compose -f docker-compose.yml up -d`
3. Run the JAR file, using-
`java -jar warehouse-backend\build\libs\warehouse-backend-0.0.1-SNAPSHOT.jar`
4. By default the backend service will run on port 8080, to modify it change the port in `application.yaml` file under `warehouse-backend` folder, rebuild and re-run the jar

## How to run unit tests?
The unit tests are in the `WarehouseBackendApplicationTests.java` file. To run the unit tests -
1. Go to `warehouse-backend` folder and run the tests using
`gradle test` or using an IDE please run the `WarehouseBackendApplicationTests.java` file

## How to run Postman tests?
The backend service needs to be up and running before the tests are run.
1. Launch Postman and import the `local.postman_environment.json` (available in `warehouse-backend` folder in the repository) environment
2. Import the collection `Warehouse.postman_collection.json` (available in `warehouse-backend` folder in the repository)
3. Choose the environment configured in step 1
4. The tests need to have a data set up, hence please run -
`Load articles` and `Load products` requests first
