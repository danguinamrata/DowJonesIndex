# DowJonesIndex
This is a simple RestAPI to query and maintain the Dow Jones Index stocks data.

### Setup Database
Data storage by this application is in mongoDB which is hosted through a docker container. 
The relevant Dockerfile and Docker-compose yaml can be found [here](/main/resources/mongodb).
To build the image before running execute the following command in that repo :
```
docker-compose up -d
```
Once image is composed, run 
```
docker run -p 27017:27017 -v "<storage_dir_path>" -it bitnami/mongodb:latest
```
The mongoDb docker container will be initialized. All mongoDB data will be persisted to the 
storage directory you mention for the -v flag above *(<storage_dir_path>)*

### Start Application
At the application directory level , you can run a clean install to build the application JAR
```
mvn clean install

```

This will create a JAR file of the application which can be executed as a normal JAR file. 

```
java -jar DowJonesIndex-1.0-SNAPSHOT.jar
``` 



