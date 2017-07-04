# Rentalcars Rest API for Technical Test Intake 2017
[![Build Status](https://travis-ci.org/LukeCollier/rentalcars-rest-api.svg?branch=master)](https://travis-ci.org/LukeCollier/rentalcars-rest-api)

## Part 1 Console Application
To use the console application goto the project directory and type `java -cp target/rentalcar-technical-test-1.0-SNAPSHOT-jar-with-dependencies com.rentalcars.app.ConsoleApplication` in the console of your choice.
![Proof of the working console application](images/console-proof.png =500x?raw=true)

## Part 2 API
Either run the bash script at `/target/universal/com-rentalcars-rest-api-1.0-SNAPSHOT/bin/com-rentalcars-rest-api`
or use the .bat file at `/target/universal/com-rentalcars-rest-api-1.0-SNAPSHOT/bin/com-rentalcars-rest-api.bat`
The server will attempt to run on port 9000 of the machine (localhost:9000).

Once the localhost is running there are 4 different url's for each of the tasks
1. http://localhost:9000/car/sort/price - get's the vehicle list in price order
![Sort price working](images/sort-price.png?raw=true)
2. http://localhost:9000/car/summary - get's the vehicle list summary
![Sort price working](images/summary.png?raw=true)
3. http://localhost:9000/car/sort/rating - get's the vehicle list in rating and
vehicle type order
![Sort price working](images/sort-rating.png?raw=true)
4. http://localhost:9000/car/sort/score - get's the vehicle list by score order
![Sort price working](images/sort-score.png?raw=true)
