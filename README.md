## Preparing for the project

Make sure you have the following installed:
- Eclipse (with Maven and web tools SDK packages)
- MySQL Server (latest version: http://dev.mysql.com/downloads/mysql/)
- MySQL Workbench (latest version: http://dev.mysql.com/downloads/workbench/)
- Git Bash
- Firefox or Chrome

Packages in Eclipse can be installed by going to Help > Install New Software...

Use the URL http://download.eclipse.org/technology/m2e/releases to get the Maven package.
Use the URL http://download.eclipse.org/webtools/repository/mars to get the web tools SDK (latest version)

## Setting up the environment

1. Clone this repository onto your machine. This project is a skeleton that providers boilerplate code for a server, database connection and an ORM manager
2. Import the project into eclipse as a Maven project (File > Import.. and open the 'Maven' folder. Select 'Existing Maven Projects to get started')
3. Start the MySQL Server
4. Connect Workbench to your running MySQL instance (https://dev.mysql.com/doc/workbench/en/wb-getting-started-tutorial-create-connection.html)
5. Use the Workbench to create a new schema in your instance and create tables in that schema

## Project Skeleton Notes

- The Main.java code will open a db connection, build any DAOs, and start the server. YOU must supply connection information (in createDatabaseConnection) and your DAO resource classes (in buildDaos)
- DataSourceManager.java is a Singleton class (static class that has one instance that all other classes access). It holds a map of each DAO that you create. Refer to EmployeeResource.java for a usage example
- Model classes should go in the com.gallup.gethip.model package
- Resource classes should go in the com.gallup.gethip.resources package
- The pom.xml file defines our project library dependancies. We are using Grizzly2 for our server, Jersey as our resource, ORMlite as our DB Connection and mapping tool and a MySQL connector for JDBC

It is recommended that you start by creating your database and tables. Then it is a good idea to create the Model classes that will represent your data. From there you can define your endpoints and build your resource classes. Please read the documentation as well! it is very helpful:

ORMlite: http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite.html
Jersey: https://jersey.java.net/documentation/latest/user-guide.html
MySQL: http://dev.mysql.com/doc/workbench/en/

If you have any questions on this please email the instructors.
