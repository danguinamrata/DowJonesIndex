# DowJonesIndex
This is a simple RestAPI to query and maintain the Dow Jones Index stocks data.

### Setup Database
Data storage by this application is in mongoDB which is hosted through a docker container. 
For this project we use the [bitnami docker image](https://github.com/bitnami/bitnami-docker-mongodb).
The relevant Dockerfile and Docker-compose yaml can be found [here](https://github.com/danguinamrata/DowJonesIndex/tree/feature/WIP/src/main/resources/mongodb).
To build the image before running execute the following command in the above mentioned directory :
```
docker-compose up -d
```
Once image is composed, run 
```
docker run -p 27017:27017 -v "<storage_dir_path>:/bitnami/mongodb" -it bitnami/mongodb:latest
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
The application will be started with by default on the 8080 port.


## API calls and features

* ###\[GET\] /stocks/?stock=\<stock\>
      Lists the  stocks currently in the application database filtered by the <stock> value.
      The output is displayed in a JSON format

* ###\[POST\] /stocks
      This will insert a record into the application database.
      The record is provided in the request body in JSON format.    
      Sample JSON :-
      
        {
            "quarter": "3",
            "stock": "Namrata",
            "date": "1/7/2011",
            "open": "$15.82",
            "high": "$16.72",
            "low": "$15.78",
            "close": "$16.42",
            "volume": 239655616,
            "percent_change_price": 3.79267,
            "percent_change_volume_over_last_wk": 0,
            "previous_weeks_volume": null,
            "next_weeks_open": "$16.71",
            "next_weeks_close": "$15.97",
            "percent_change_next_weeks_price": -4.42849,
            "days_to_next_dividend": 26,
            "percent_return_next_dividend": 0.182704
        }
        
* ###\[GET\] & \[POST\] /uploadFile
  Bulk uploads a file containing mulitple records in the correct format to the application database.
  Use the Get request to be re-directed to the UI screen where you can upload a file to be bulk-inserted into the application.
  
      
      
