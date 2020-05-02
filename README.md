## Overview
- Skill Distillery Java Code Remote Course
- Software Developer Yettsy Jo Knapp, Denver, CO.
- Film Query command line application that retrieves and displays film data.
- It is menu-based, allowing the user to choose and submit query data.

## Technologies Used:
1. Java 8
1. mySQL
1. JDBC library via java.sql
1. Maven pom.xml file and SQL Driver

## Lessons Learned
1. After OCA Exam Prep week, coming back to use my IDE had a bit of an epiphany moment regarding classes and object-oriented programming.
1. Introduced to JDBC API
1. PreparedStatments
1. mySQL commands

## User Story1
- The user is presented with a menu in which they can choose to:

  - Look up a film by its id.
  - Look up a film by a search keyword.
  - Exit the application.
## User Story2
  - If the user looks up a film by id, they are prompted to enter the film id. If the film is not found, they see a message saying so. If the film is found, its title, year, rating, and description are displayed.
## User Story3
  - If the user looks up a film by search keyword, they are prompted to enter it. If no matching films are found, they see a message saying so. Otherwise, they see a list of films for which the search term was found anywhere in the title or description, with each film displayed exactly as it is for User Story 2.
## User Story4
  - When a film is displayed, its language (English,Japanese, etc.) is also displayed.
## User Story5
  - When a film is displayed, the list of actors in its cast is displayed along with the title, year, rating, and description.

## MVP
  - Satisfy user story 1-5 without throwing any exceptions
