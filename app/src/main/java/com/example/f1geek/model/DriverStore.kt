package com.example.f1geek.model

class DriverStore(val drivers: List<Driver> = mutableListOf())

fun seedDriverStore(): DriverStore{


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

    return DriverStore(drivers)
}