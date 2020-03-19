# StokedPenguinWebApp

This is a very basic example of a Java EE web application using servlets.
It can be used as a starting point for a serious application.

Features include:
* Login/Logout Pages
* Database integration for username/password credentials
* Session management

## Recommended Usage:

* Install NetBeans IDE
* Install Glassfish Server
* Install MySQL or MariaDB Server
* You may need to enable the DB server network port in the config file
* Download mysql connector jar (https://dev.mysql.com/downloads/connector/j/5.1.html)
* Add mysql connector jar to the lib directory of Glassfish
* From the sql client as admin, run statements in initdb.sql (from this project)
* Start NetBeans IDE and open this project (Maven Project).
* Configure netbeans servers for Glassfish and database. Add mysql connector jar.
* Run the project. It should build, deploy, and open a browser.


After following instructions above, you should be able to access the application
at http://localhost:8080/StokedPenguinWebApp .
Default login in credentials are admin:admin.
I developed this application using NetBeans 11.1 and there are a few generated
files that are irrelevant to the application; ignore them.

This application has been tested with Glassfish 5 and MariaDB 10.4.10.

