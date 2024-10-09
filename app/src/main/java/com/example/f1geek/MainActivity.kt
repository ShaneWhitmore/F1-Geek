package com.example.f1geek
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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

    val roland = Driver(
        firstName = "Roland", surname = "Ratzenberger", abbreviatedName = "RAT", number = 32
    )
    val jochen = Driver(
        firstName = "Jochen", surname = "Rindt", abbreviatedName = "RIN", number = 22
    )
    val jules = Driver(
        firstName = "Jules", surname = "Bianchi", abbreviatedName = "BIA", number = 17
    )

    var drivers = ArrayList<Driver>()
    drivers.add(roland)
    drivers.add(jochen)
    drivers.add(jules)

    Column {
        TextField(value = "", onValueChange = {}, label = { Text("Search") })
        Text("${roland.firstName} ${roland.surname}")
        Text("${jochen.firstName} ${jochen.surname}")
        Text("${jules.firstName} ${jules.surname}")
    }

    Column {
        for(driver in drivers)
        {
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