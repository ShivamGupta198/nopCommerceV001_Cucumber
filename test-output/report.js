$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/basicBarclay-workflow.feature");
formatter.feature({
  "name": "basicBarclay-workflow",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Successful Login and validate different validations on same attributes on the basis of different data \u003ckey\u003e",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@datadriven"
    }
  ]
});
formatter.step({
  "name": "User Launch needed website",
  "keyword": "Given "
});
formatter.step({
  "name": "User Clicked on Registered Customers More Info",
  "keyword": "When "
});
formatter.step({
  "name": "User Entered First Name",
  "keyword": "Then "
});
formatter.step({
  "name": "User Clicked on Search",
  "keyword": "And "
});
formatter.step({
  "name": "Validated api response",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "key"
      ]
    },
    {
      "cells": [
        "us002_orderOfVictoria"
      ]
    },
    {
      "cells": [
        "us002_orderOfBrenda"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Successful Login and validate different validations on same attributes on the basis of different data us002_orderOfVictoria",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@datadriven"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch needed website",
  "keyword": "Given "
});
formatter.match({
  "location": "BasicBarclayStepDef.user_Launch_needed_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicked on Registered Customers More Info",
  "keyword": "When "
});
formatter.match({
  "location": "BasicBarclayStepDef.userClickedOnRegisteredCustomersMoreInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Entered First Name",
  "keyword": "Then "
});
formatter.match({
  "location": "BasicBarclayStepDef.userEnteredFirstName()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicked on Search",
  "keyword": "And "
});
formatter.match({
  "location": "BasicBarclayStepDef.userClickedOnSearch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validated api response",
  "keyword": "And "
});
formatter.match({
  "location": "BasicBarclayStepDef.validatedApiResponse()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Successful Login and validate different validations on same attributes on the basis of different data us002_orderOfBrenda",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@datadriven"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch needed website",
  "keyword": "Given "
});
formatter.match({
  "location": "BasicBarclayStepDef.user_Launch_needed_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicked on Registered Customers More Info",
  "keyword": "When "
});
formatter.match({
  "location": "BasicBarclayStepDef.userClickedOnRegisteredCustomersMoreInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Entered First Name",
  "keyword": "Then "
});
formatter.match({
  "location": "BasicBarclayStepDef.userEnteredFirstName()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicked on Search",
  "keyword": "And "
});
formatter.match({
  "location": "BasicBarclayStepDef.userClickedOnSearch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validated api response",
  "keyword": "And "
});
formatter.match({
  "location": "BasicBarclayStepDef.validatedApiResponse()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "status": "passed"
});
});