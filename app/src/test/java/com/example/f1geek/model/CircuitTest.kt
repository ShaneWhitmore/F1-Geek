package com.example.f1geek.model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CircuitTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getName() {

        val result1 = Result("Max","Lando","Charles","2022" )
        val circuit1 = Circuit("Nurburgring","Germany",20.83f,result1)

        assertEquals("Nurburgring",circuit1.name)
    }

    @Test
    fun getCountry() {
        val result1 = Result("Max","Lando","Charles","2022" )
        val circuit1 = Circuit("Nurburgring","Germany",20.83f,result1)

        assertEquals("Germany",circuit1.country)
    }

    @Test
    fun getLength() {
        val result1 = Result("Max","Lando","Charles","2022" )
        val circuit1 = Circuit("Nurburgring","Germany",20.83f,result1)

        assertEquals(20.83f,circuit1.length)
    }

    @Test
    fun getResult() {
        val result1 = Result("Max","Lando","Charles","2022" )
        val circuit1 = Circuit("Nurburgring","Germany",20.83f,result1)

        assertEquals(result1,circuit1.result)
    }
}