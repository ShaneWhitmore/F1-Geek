package com.example.f1geek.model

class Team(
    val name: String,
    val primaryDriver: Driver,
    val secondaryDriver: Driver,
    val reserveDrivers: List<Driver>
)