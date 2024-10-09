package com.example.f1geek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.f1geek.model.Driver
import com.example.f1geek.ui.theme.F1GeekTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1GeekTheme {
                DriverList()
            }
        }
    }
}

@Composable
fun DriverList(modifier: Modifier = Modifier) {
    val drivers = listOf(
        Driver(
            firstName = "Roland", surname = "Ratzenberger", abbreviatedName = "RAT", number = 32
        ),
        Driver(firstName = "Jochen", surname = "Rindt", abbreviatedName = "RIN", number = 22),
        Driver(firstName = "Jules", surname = "Bianchi", abbreviatedName = "BIA", number = 17)
    )

    var filterText by rememberSaveable  { mutableStateOf("") }
    println("Hello, i'm recomposing")

    Column {
        TextField(
            value = filterText,
            onValueChange = { value -> filterText = value },
            label = { Text("Search") }
        )
        drivers.filter { it.firstName.contains(filterText, true) }.forEach { driver ->
            Text("${driver.firstName} ${driver.surname}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    F1GeekTheme {
        DriverList()
    }
}