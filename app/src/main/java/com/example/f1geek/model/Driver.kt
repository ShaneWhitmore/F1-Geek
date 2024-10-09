package com.example.f1geek.model

class Driver(
    val firstName: String,
    val surname: String,
    val abbreviatedName: String,
    val number: Int,
    val fullName:String = firstName + surname


)
