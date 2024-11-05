package com.example.f1geek.model

class TeamStore(
    val teams: List<Team> = mutableListOf(),
    val drivers: List<Driver> = mutableListOf()
)

fun seedTeamStore(): TeamStore{
    val reserveDriver: List<Driver> = mutableListOf();
    val drivers = mutableListOf(
        Driver(firstName = "Lewis", surname = "Hamilton", abbreviatedName = "HAM", number = 44),
        Driver(firstName = "Max", surname = "Verstappen", abbreviatedName = "VER", number = 1),
        Driver(firstName = "Charles", surname = "Leclerc", abbreviatedName = "LEC", number = 16),
        Driver(firstName = "Sergio", surname = "Perez", abbreviatedName = "PER", number = 11),
        Driver(firstName = "George", surname = "Russel", abbreviatedName = "RUS", number = 63),
        Driver(firstName = "Carlos", surname = "Sainz", abbreviatedName = "SAI", number = 55),
        Driver(firstName = "Lando", surname = "Norris", abbreviatedName = "NOR", number = 4),
        Driver(firstName = "Fernando", surname = "Alonso", abbreviatedName = "ALO", number = 14),
        Driver(firstName = "Oscar", surname = "Piastri", abbreviatedName = "PIA", number = 81),
        Driver(firstName = "Esteban", surname = "Ocon", abbreviatedName = "OCO", number = 31)
    )

    val teams = mutableListOf(
        Team(name="Ferrari" , primaryDriver=drivers.get(2) , secondaryDriver=drivers.get(5), reserveDrivers = reserveDriver),
        Team(name="RedBull" , primaryDriver=drivers.get(1) , secondaryDriver=drivers.get(3), reserveDrivers = reserveDriver),
        Team(name="Mercedes" , primaryDriver=drivers.get(0) , secondaryDriver=drivers.get(4), reserveDrivers = reserveDriver),
    )

    return TeamStore(teams = teams, drivers = drivers)
}