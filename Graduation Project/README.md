## Used Technologies

* Java `8`
* Spring Boot `2.5.4`
* Docker
* React
* MySQL

###To build project

`docker build -t graduation_project .`

###Run project

`docker run -p 8080:8080 graduation_project`



[User Paths](../main/GittiGidiyor_Graduation_Project/src/main/java/service/loan/gittigidiyor_graduation_project/controller/UserController.java)

| Request |    Route   |                                                                     Body                                                                    |        Description        |
|:-------:|:----------:|:-------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------:|
|   POST  |    /user   | { "fullName": "Gökhan Göksel Elpeze", "identityNumber": "29903218718", "monthlyIncome": "5500",  "phoneNumber": "05554554545" }             |        Save a User        |
|   PUT   |    /user   | { "id": 3,     "fullName": "Gökhan Göksel Elpeze", "identityNumber": "29903218718", "monthlyIncome": "3000", "phoneNumber": "05554554545" } |       Update a User       |
|  DELETE | /user/{id} |                                                                    EMPTY                                                                    |       Delete a User       |

[CreditForm Paths](../main/GittiGidiyor_Graduation_Project/src/main/java/service/loan/gittigidiyor_graduation_project/controller/CreditFormController.java)

| Request |    Route   |                                                                     Body                                                                    |        Description        |
|:-------:|:----------:|:-------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------:|
|   POST  |   /credit  | { "fullName": "Gökhan Göksel Elpeze", "identityNumber": "29903218718", "monthlyIncome": "5500", "phoneNumber": "05554554545" }              |     Credit Application    |
|   GET   |   /credit  |                                                  ?identityNumber=29903218718(RequestParam)                                                  | Find a Credit Application |
