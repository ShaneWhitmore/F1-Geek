package com.example.f1geek.model

class TeamStore(
    val teams: List<Team> = mutableListOf(),
    val drivers: List<Driver> = mutableListOf()
)

fun seedTeamStore(): TeamStore{
    val reserveDriver: List<Driver> = mutableListOf();
    //Ferrari
    val leclerc = Driver(firstName = "Charles", surname = "Leclerc", abbreviatedName = "LEC", number = 16)
    val sainz = Driver(firstName = "Carlos", surname = "Sainz", abbreviatedName = "SAI", number = 55)
    //Mercedes
    val hamilton = Driver(firstName = "Lewis", surname = "Hamilton", abbreviatedName = "HAM", number = 44)
    val russell = Driver(firstName = "George", surname = "Russel", abbreviatedName = "RUS", number = 63)
    //RedBull
    val verstappen = Driver(firstName = "Max", surname = "Verstappen", abbreviatedName = "VER", number = 1)
    val perez = Driver(firstName = "Sergio", surname = "Perez", abbreviatedName = "PER", number = 11)
    //Mclaren
    val norris = Driver(firstName = "Lando", surname = "Norris", abbreviatedName = "NOR", number = 4)
    val piastri = Driver(firstName = "Oscar", surname = "Piastri", abbreviatedName = "PIA", number = 81)
    //Aston Martin
    val alonso =  Driver(firstName = "Fernando", surname = "Alonso", abbreviatedName = "ALO", number = 14)
    val stroll = Driver(firstName = "Lance", surname = "Stroll", abbreviatedName = "STR", number = 18)

    val ferrari = Team(name="Ferrari" ,
        primaryDriver=leclerc,
        secondaryDriver=sainz,
        reserveDrivers = reserveDriver)

    val mercedes = Team(name="Mercedes" ,
        primaryDriver=hamilton,
        secondaryDriver=russell,
        reserveDrivers = reserveDriver)

    val redBull = Team(name="RedBull" ,
        primaryDriver=verstappen,
        secondaryDriver=perez,
        reserveDrivers = reserveDriver)

    val mcLaren = Team(name="McLaren" ,
        primaryDriver=norris,
        secondaryDriver=piastri,
        reserveDrivers = reserveDriver)

    val astonMartin = Team(name="Aston Martin" ,
        primaryDriver=alonso,
        secondaryDriver=stroll,
        reserveDrivers = reserveDriver)

    val teams = listOf(
        ferrari,
        mercedes,
        redBull,
        mcLaren,
        astonMartin

    )
    val drivers = listOf(leclerc, sainz, hamilton, russell, verstappen, perez, norris,piastri,alonso,stroll)

    return TeamStore(teams = teams, drivers = drivers)
}