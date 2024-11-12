package com.example.f1geek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        //enableEdgeToEdge()
        var selectedTeam: Team? = null
        var selectedDriver: Driver? = null

        setContent {
            F1GeekTheme {
                val driverStore = seedDriverStore()
                val teamStore = seedTeamStore()
                var currentScreen by remember { mutableStateOf("") }
                val onTeamClick = { team: Team ->
                    println("Selected ${team.name}")
                    selectedTeam = team
                    currentScreen = "team"
                }
                val onDriverClick = { driver: Driver ->
                    println("Selected ${driver.fullName}")
                    selectedDriver = driver
                    currentScreen = "driver"
                }



                println("Current screen is $currentScreen")


                if (currentScreen === "driver") {
                    val driver = selectedDriver
                    if (driver != null) {
                        DriverList(
                            driver = driver, { currentScreen = "home" }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }
                }
                else if( currentScreen === "team")
                {
                    val teams = teamStore.teams.filter { it.name === selectedTeam?.name }
                    DriversList(
                        teams = teams, onDriverClick, Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }
                else
                {
                    TeamList(
                        teams = teamStore.teams, onTeamClick, Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }
            }
        }
    }
    @Composable
    fun DriverList(driver: Driver, onClickHandler: (Driver) -> Unit, modifier: Modifier = Modifier) {
        Column(modifier) {
            Button(onClick = { onClickHandler.invoke(Driver("","","",0,"")) }, modifier = modifier) {
                Text("Teams")
            }

            Text(text = driver.fullName)
            Text(text = driver.abbreviatedName)
            Text(text = driver.number.toString())

        }

    }


    @Composable
    fun DriversList(teams: List<Team>,onClickHandler: (Driver) -> Unit, modifier: Modifier = Modifier) {
        Column(modifier) {
            Button(onClick = { onClickHandler.invoke(Driver("","","",0,"")) }, modifier = modifier) {
                Text("Home")
            }


            teams.forEachIndexed { index, team ->
                val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
                val primary = team.primaryDriver
                val secondary = team.secondaryDriver
                Text(
                    text = primary.fullName,
                    modifier = modifier
                        .background(backgroundColor)
                        .clickable { onClickHandler(primary) },
                )
                Text(
                    text = secondary.fullName,
                    modifier = modifier
                        .background(backgroundColor)
                        .clickable { onClickHandler(secondary) },
                )
            }
        }
    }

    @Composable
    fun TeamList(teams: List<Team>,  onClickHandler: (Team) -> Unit ,modifier: Modifier = Modifier) {
        Column(modifier) {
            teams.forEachIndexed { index, team ->
                val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
                Text(
                    text = team.name,
                    modifier = modifier
                        .background(backgroundColor)
                        .clickable { onClickHandler(team) },
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
            TeamList(teams = teamStore.teams,
                onClickHandler = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp))
        }

    }
}