# F1Geek

## Introduction

Source for the F1Geek android app.

## Student Information

| Field          | Value          |
|----------------|----------------|
| Name           | Shane Whitmore |
| Student Number | 20098910       |



## Initial Data Model

```mermaid
classDiagram
    Team "1" --> "1" Driver: primaryDriver
    Team "1" --> "1" Driver: secondaryDriver
    Team "1" --> "1..*" Driver: reserveDrivers
    class Driver{
      +String surname
      +String firstName
      +String abbreviatedName
      +Integer number
    }
    class Team{
      +String name
    }
```