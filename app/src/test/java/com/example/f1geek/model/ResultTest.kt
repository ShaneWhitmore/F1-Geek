package com.example.f1geek.model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ResultTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {

    }

    @Test
    fun getFirst() {
        val result1 = Result("Max","Lando","Charles","2022" )
        val result2 = Result("Max", "Carlos","Estaban","2020")

        assertEquals("Max", result1.first)
        assertEquals("Max", result2.first)
    }

    @Test
    fun getSecond() {
        val result1 = Result("Max","Lando","Charles","2022" )
        val result2 = Result("Max", "Carlos","Estaban","2020")

        assertEquals("Lando", result1.second)
        assertEquals("Carlos", result2.second)
    }

    @Test
    fun getThird() {
        val result1 = Result("Max","Lando","Charles","2022" )
        val result2 = Result("Max", "Carlos","Estaban","2020")

        assertEquals("Charles", result1.third)
        assertEquals("Estaban", result2.third)
    }

    @Test
    fun getYear() {
        val result1 = Result("Max","Lando","Charles","2022" )
        val result2 = Result("Max", "Carlos","Estaban","2020")

        assertEquals("2022", result1.year)
        assertEquals("2020", result2.year)
    }
}