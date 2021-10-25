# Testing An Apparel Store Using Selenium

A Test automation project using Selenium tool built on POM design using Maven as build tool and TestNG for tests and Extent reports to generate extent report.
It also uses POM Framework,SureFirePlugin and Apache Poi 

The project "apparelStore" is a test automation project dedicated to test the functionalities of the website "Apparel Store" (url: http://automationpractice.com/index.php)

Project features:

This project is built on Selenium with POM design pattern and makes use of testNG for testing all the scenarios and maven as the build tool
All the test cases, test data, page objects, configurations and utilities are within the package src/test/java
In order to run all the test cases we can execute by using testng.xml
we can run them on different browsers by specifying the same in testng.xml file
We can also perform cross browser testing using crossbrowser.xml file
The same can be run using pom.xml file using maven clean test
These test cases generate an overall report named STMExtentReport.html in the test-output directory with screenshots for failed test cases
Pre-requisites for running test cases: Test data: (project_workspace)\apparelStore\src\test\java\com\apparelStore\testData\TestData.xlsx)


# Important Note:
Test data for account creation tests need to be updated once used


ChromeDriver version: 94.0,
GeckoDriver(For Firefox) version:93.0
