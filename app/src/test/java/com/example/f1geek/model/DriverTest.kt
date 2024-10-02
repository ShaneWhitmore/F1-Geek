package com.example.f1geek.model

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class DriverTests {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getFirstName() {
        val driver = Driver("Charles" , "LeClerc" , "LEC" , 16)
        assertEquals("Charles", driver.firstName)
    }

    @Test
    fun getSurname() {
        val driver = Driver("Charles" , "LeClerc" , "LEC" , 16)
        assertEquals("LeClerc", driver.surname)
    }

    @Test
    fun getAbbreviatedName() {
        val driver = Driver("Charles" , "LeClerc" , "LEC" , 16)
        assertEquals("LEC", driver.abbreviatedName)
    }

    @Test
    fun getNumber() {
        val driver = Driver("Charles" , "LeClerc" , "LEC" , 16)
        assertEquals(16, driver.number)
    }
}