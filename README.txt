Here are the instructions to perform the initial setup of the Spring app.

Needed software
MySQL
Tomcat 6.0.x
JDK 1.6


1. Unzip the file (Store.zip)

2. You can import the project source on Eclipse or move the WebContent folder into Tomcat webapps folder directly.
   If you choose to do the second option, please, make sure to rename the folder to a more specific context, like "Store", for example.

3. Using MySQL Administrator, create a database schema called "store".

4. You can change the connection preferences in the file WEB-INF/applicationContext.xml, look for an element with "dataSource" as an id value (example below).
   The user used to connect is 'root' and the password is 'root'. You may change them, too. 

       <bean id="dataSource"
	  ...
	  <property name="url" value="jdbc:mysql://localhost:3306/store" />
	  <property name="username" value="root" />
	  <property name="password" value="root" />
	  ...
       </bean>

5. Start your server, inside Eclipse or just a standalone Tomcat. The application data will be created during the initialization.

6. Point your browser to this address: http://localhost:8080/Store/faces/index.jsp

7. when prompted for an username and pass, use these values: "customer" and "123", without quotes.

PS.: ActiveMQ needs internet connection to validate the XML content.

