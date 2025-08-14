# cook.ie
<p>cook.ie is a web application for sharing and discovering recipes and cookbooks. Users can create and share their own recipes, compile cookbooks and explore other users' culinary creations!</p>

<h3>Features</h3>
<p>
  <ul>
    <li>User authentication and session management</li>
    <li>Create, read, update and delete recipes and cookbooks</li>
    <li>Browse latest recipes and cookbooks</li>
    <li>Ingredient and instruction management for recipes</li>
    <li>Personalized user dashboard</li>
  </ul>
  and more to come! cook.ie is currently in development stage.
</p>

<h3>Tech Stack</h3>
<ul>
  <li>Frontend: React, JavaScript, HTML, CSS</li>
  <li>Backend: Java (Spring Boot)</li>
  <li>Database: MySQL</li>
  <li>Build Tools: Maven</li>
</ul>

<h3>Setup and Installation</h3>
<p>
  Here is how I personally set cook.ie up for testing purposes while developing. If you encounter any issues, please let me know.
  Necessities: Spring, Node.js, Java JDK, Maven and WAMP
  <ul>
    <li>Start WAMP and go to phpMyAdmin. In project files, the username for phpMyAdmin set as "root" and the password field is empty. Can be modified in application.properties.</li>
    <li>Import cookie.sql in database and run it.</li>
    <li>Clone this repository and open the project in Eclipse (or your IDE of choice)</li>
    <li>Build the project so Maven downloads necessary dependencies automatically</li>
    <li>Run the Spring Boot application from cook.ie/src/main/java/cookie/CookieAppApplication.java</li>
    <li>For frontend, run npm install (if needed) and npm start.</li>
  </ul>
  The app should now be running at http://localhost:3000 (frontend) and http://localhost:8080 (backend)
</p>

<hr>
<p>Thanks for reading this far! cook.ie is still in development stage, and has some bugs and missing stuff.</p>
started on: 10.07.2025
last updated: 15.08.2025
