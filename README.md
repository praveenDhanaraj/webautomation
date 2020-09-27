# Web Automation

This repository is built for developing and executing UI tests for flipkart application. It supports chrome, firefox and IE edge browsers.

##### Repository Details:
Design pattern: Page Object Model
Framework: TestNG
Build Tool: Maven
Reports: ExtentReports

Prerequisites:
- JDK 1.8 or above
- Apache Maven

Steps for execution:
1. Clone the project (Or download and unzip the project file)
```sh
$ git clone git@github.com:xyz/gotest.git
```
2. Go to the project directory via terminal
3. Run the following command:
```sh
$ mvn clean test
```
### Run time parameters:
Add the below parameters to the run command to change default configuration
| Parameter | Options | Default |
| ------ | ------ | ------ |
| browser | chrome/firefor/ie | chrome|
| groups | sanity/regression |null|

Sample command using optional parameters
```sh
$ mvn clean test -Dbrowser=firefox -Dgroups=regression
```

##### Reports:
After the execution is completed, an emailable report will be generated under TestReport folder in project directory. If there is a test failure, a screenshot will also be attached to the failed case
