package com.example.f1geek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        //enableEdgeToEdge()
        var selectedTeam: Team? = null

        setContent {
            F1GeekTheme {
                //val driverStore = seedDriverStore()
                val teamStore = seedTeamStore()
                var currentScreen by remember { mutableStateOf("") }
                val onTeamClick = { team: Team ->
                    println("Selected ${team.name}")
                    selectedTeam = team
                    currentScreen = "team"
                }
                println("Current screen is $currentScreen")


                if (currentScreen === "team") {
                    val teams = teamStore.teams.filter { it.name === selectedTeam?.name }
                    DriverList(
                        teams = teams, { currentScreen = "home" }, Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                } else {
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
    fun DriverList(teams: List<Team>,onClickHandler: () -> Unit, modifier: Modifier = Modifier) {
        Column(modifier) {
            Button(onClick = { onClickHandler() }, modifier = modifier) {
                Text("Home")
            }

            teams.forEachIndexed { index, team ->
                val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
                Text(
                    text = team.primaryDriver.fullName,

                    modifier = modifier.background(backgroundColor)
                )
                Text(
                    text = team.secondaryDriver.fullName,

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