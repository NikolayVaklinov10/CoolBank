# CoolBank

The following is a Spring boot RESTful application which creates several capabilities for a fictional online bank called "CoolBank"

![](src/main/resources/static/online-banking.jpeg)

To reach the url run the spring app and in your browser type `localhost:8080/offers`

The app endpoints are tested with Postman

To create a new offer go to Postman set to POST `localhost:8080/offers` and the body will contains: 1) the 'offer_name', 2) the 'age' of the person who creates the offer, 3) the 'location' of the offer

To delete an offer set the Postman to DELETE `localhost:8080/offers/1` if for instance you want to delete the offer with ID `1`

To see the offers created so far use Postman GET `localhost:8080/offers` or specify the offer by id for instance GET `localhost:8080/offers/2` for offer with id `2`

To update an offer PUT `localhost:8080/offers/1` and in Postman body type the changes

The app is using H2 database



