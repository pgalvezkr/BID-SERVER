# BID-SERVER

This is a bid backend service, it is done with Springboot Framework and MongoDB.
This project allows the user makes bids to an item.

## Instructions 🚀

To deploy this project you need to install :
  - MongoDB
  - JAVA
  
You need to create bids database with user collection on Mongodb and clone the repositoy on develop branch.
## Running unit tests ⚙️

To launching unit tests you have to open a terminal in the root of project and execute the command mvn clean install


## Deployment
To deploy the project open a terminal in the root and execute the following command: mvn spring-boot:run, then you need to call this endpoint for create the infrastructure of project:

*POST:* http://localhost:8090/user/infrastructure (List of users)

The project will be deployed in 8090 port.The available endpoints are:

#### -LOGIN
*GET:* http://localhost:8090/user/{idUser}/login (sessionKey)

For the following endpoints is neccesary to send the sessionKey param.

#### -CREATE A BID FOR AN INTEM 
*POST:* http://localhost:8090/bids/{itemId}/bid?sessionKey=value

{
    "bid": 4.5
}

### -TOP BIDS FOR AN ITEM
*GET:* http://localhost:8090/bids/{itemId}/topBidList?sessionKey=value (top of bids for an item in descending order)
