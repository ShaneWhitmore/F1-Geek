# F1Geek

## Introduction

Source for the F1Geek android app.

## Student Information

| Field          | Value          |
|----------------|----------------|
| Name           | Shane Whitmore |
| Student Number | 20098910       |


## MindMap

```mermaid
mindmap
  root((F1 Geek))
    Drivers
    Teams
    Race Tracks
    Seasons
        Races
            Results
    Personalisation
        Follow Drivers
        Favourite Team
            Favourite Drivers
    News Feed
        Driver Interviews
        Team News
        Vehicle improvements
        FIA regulation updates
```

## Initial Data Model

```mermaid
classDiagram
    Team "1" --> "1" Driver: primaryDriver
    Team "1" --> "1" Driver: secondaryDriver
    Team "1" --> "1..*" Driver: reserveDrivers
    Circuit --> Result:raceResults
    class Driver{
      +String surname
      +String firstName
      +String abbreviatedName
      +Integer number
    }
    class Team{
      +String name
    }
    class Circuit{
    +String name
    +String country
    +Float length
    }
    class Result{
    +String first
    +String second
    +String third
    +String year
    }
```