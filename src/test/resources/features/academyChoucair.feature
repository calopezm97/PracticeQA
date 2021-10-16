# Author:carlos
@stories
Feature: Academy Choucair
  as a user, I want to learn how to automate in screenplay at the Choucair Academy with the automation course

  @scenario1
  Scenario: Search for a automation course
    Given than Carlos wants to learn automation at the academy Choucair
    | strUser | strPass |
    | 1097405899 | Choucair2021* |
    When he search for the course on the choucair academy platform
    | strCourse |
    | Foundation Level |
    Then he finds the course called resources
    | strCourse |
    | Foundation Level |