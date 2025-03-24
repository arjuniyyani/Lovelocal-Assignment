# Lovelocal-Assignment

## Overview
This repository contains a hybrid test automation framework for:
- Selenium (Web UI automation)
- RestAssured (API automation)
- Allure Reporting integration
- Parameterized tests via Excel input
- Appium-ready structure (can be extended for mobile automation)

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- RestAssured
- Apache POI (for Excel data handling)
- Allure Reporting
- Maven

## Project Structure
```
|-- src
|   |-- main
|       |-- java
|           |-- base
|           |-- pages
|           |-- utils
|   |-- test
|       |-- java
|           |-- tests
|-- testng.xml
|-- pom.xml
```

## Setup Instructions
1. Clone the repo:
```
git clone git@github.com:arjuniyyani/Lovelocal-Assignment.git
```
2. Import as a Maven project in IntelliJ/IDE of choice.
3. Update drivers in `/src/main/resources/` if necessary (e.g., `geckodriver`).
4. Run `mvn clean install` to install dependencies.

## How to Run Tests
- **Web UI Tests**: 
  - Run `testng.xml` directly from IDE.
  - Or execute via terminal:
```
mvn clean test
```
- **API Tests**:
  - Located under `tests` package.
  - Can be run similarly via TestNG or command line.

## Reporting
- Reports are generated using Allure.
- To generate and open the report:
```
mvn allure:report
mvn allure:serve
```

## Extensions
- Appium integration setup ready (base structure can be extended).
- Easily extendable for mobile and additional API endpoints.

## Contributors
- Arjun Iyyani

## License
This project is licensed under the MIT License.

