package com.example.f1geek.model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class TeamTests {

    @Test
    fun getName() {
        val charles = Driver("Charles", "LeClerc", "LEC" , 16)
        val carlos = Driver("Carlos" , "Sainz", "SAI" , 55)
        val team = Team("Ferrari", charles, carlos, mutableListOf());

        assertEquals("Ferrari", team.name)
    }

    @Test
    fun getPrimaryDriver() {
        val charles = Driver("Charles", "LeClerc", "LEC" , 16)
        val carlos = Driver("Carlos" , "Sainz", "SAI" , 55)
        val team = Team("Ferrari", charles, carlos, mutableListOf());

        assertEquals(charles, team.primaryDriver)
    }

    @Test
    fun getSecondaryDriver() {
        val charles = Driver("Charles", "LeClerc", "LEC" , 16)
        val carlos = Driver("Carlos" , "Sainz", "SAI" , 55)
        val team = Team("Ferrari", charles, carlos, mutableListOf());

        assertEquals(carlos, team.secondaryDriver)
    }

    @Test
    fun getReserveDrivers() {
        val charles = Driver("Charles", "LeClerc", "LEC" , 16)
        val carlos = Driver("Carlos" , "Sainz", "SAI" , 55)
        val team = Team("Ferrari", charles, carlos, mutableListOf());

        assertEquals(team.reserveDrivers, mutableListOf<Driver>())
    }
}