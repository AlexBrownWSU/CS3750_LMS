# CS3750_LMS

IDE: 
- Get IntelliJ Ultimate 

Server:
- Also get TomCat Server - https://tomcat.apache.org/download-90.cgi

DB: 
- Currently (09/26/2019) set to run on local MYSQL Server w/ MYSQL Workbench
- If using Local MYSQL you must download https://dev.mysql.com/downloads/connector/j/5.1.html and add the .jar to the lib file in your Tomcat Server. Just copy and paste

- NEED TODO: Add connection to Azure (The db that Ben is building for us). I have not used Azure before but it should be possible. We just need to figure out how.  

Tomcat Server 
- Configure Tomcat in IntelliJ in the top right corner by the "play" button. add this as the url http://localhost:8080/login.jsp


JDK
- Anything 8 or above should work...

Notes on Project Structure
Inside the src folder you'll find;
appLayer - This is where java classes that act aas an intermediary betweeb the servlet and the database layers
DAO -  this layer holds entity java classes. Create these to make an app level instance of data or even a whole table (check out the userDAO
datalayer - These are java classes that will access the database and execute SQL
webApp - These are the servlets they bridge the UI with the app and database. *To create one right click the webapp folder got to "New" and then look towards the bottom for "Create New Servlet"
*Servlets must be mapped to do so go to the web folder and then to the WEB-INF and then to the web.xml. THen follow pattern for mappin servlets
Web Foler - Add JSPs and style sheets (.css) to this folder. You can add HTML, JavaScript and JQuery to .jsp, as well as, java 

Local MYSQL DB Schema

Table user
id (pk, ai)
user_name (varchat(45), uq)
password (varchar(45))
fname (varchat(45))
lName (varchat(45))
type (int )

Table class
id (int, pk, ai)
instructorId (int, fk, int, uq)
class_name (varchar(45))
meeting_time (varchar(45))

