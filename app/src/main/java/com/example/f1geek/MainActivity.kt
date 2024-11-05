package com.example.f1geek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.f1geek.model.Driver
import com.example.f1geek.model.Team
import com.example.f1geek.model.seedDriverStore
import com.example.f1geek.model.seedTeamStore
import com.example.f1geek.ui.theme.F1GeekTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            F1GeekTheme {
                val driverStore = seedDriverStore()

                /*DriverList(
                    drivers = driverStore.drivers, Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )

                 */
                val teamStore = seedTeamStore()
                TeamList(teams = teamStore.teams, Modifier
                    .fillMaxWidth()
                    .padding(4.dp))
            }
        }
    }


    @Composable
    fun DriverList(drivers: List<Driver>, modifier: Modifier = Modifier) {
        Column(modifier) {
            drivers.forEachIndexed { index, driver ->
                val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
                Text(
                    text = driver.fullName,
                    modifier = modifier.background(backgroundColor)
                )
            }
        }
    }

    /*
    @Composable
    fun DriverList(drivers: List<Driver>, modifier: Modifier = Modifier) {
        var filterText by rememberSaveable { mutableStateOf("") }
        println("Hello, i'm recomposing")
        Column {
            TextField(
                value = filterText,
                onValueChange = { value -> filterText = value },
                label = { Text("Search") }
            )

            drivers
                .filter { it.fullName.contains(filterText, true) }
                .forEachIndexed{ index , driver ->
                    val backgroundColor = if (index % 2 == 0)  Color.Gray else Color.White
                    Text("${driver.fullName}", modifier.background(backgroundColor))
                }
        }
    }

     */

    @Composable
    fun TeamList(teams: List<Team>, modifier: Modifier = Modifier) {
        Column(modifier) {
            teams.forEachIndexed { index, team ->
                val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
                Text(
                    text = team.name,
                    modifier = modifier
                        .background(backgroundColor)
                        .clickable { println(team.name) },
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        F1GeekTheme {
            val driverStore = seedDriverStore()
            val teamStore = seedTeamStore()
            TeamList(teams = teamStore.teams)
        }

    }
}