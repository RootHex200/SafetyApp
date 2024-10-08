package com.hex200.safetyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hex200.safetyapp.ui.theme.SafetyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SafetyAppTheme {
                BottomNavigationPageView()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPageView(){
    val navItem= listOf(
        BottomNavBarItem("Home",Icons.Rounded.Home,"home"),
        BottomNavBarItem("Police",Icons.Rounded.Build,"police"),
        BottomNavBarItem("History",Icons.Rounded.Refresh,"history"),
        BottomNavBarItem("profile",Icons.Rounded.Person,"profile"),
    )
    var currentRoute by remember { mutableStateOf("home") }
    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//
//                onClick = { /*TODO*/ }) {
//                Box(
//                    contentAlignment = Alignment.Center,
//                    modifier = Modifier.width(50.dp).background(color = androidx.compose.ui.graphics.Color.Red,
//
//                        )) {
//                    Icon(Icons.Filled.Add, "Floating action button.")
//                }
//            }
//        },
//        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            NavigationBar {
                Row {
                    navItem.forEach {item->
                        NavigationBarItem(selected =item.route==currentRoute , onClick = {
                            currentRoute=item.route
                        }, icon = {
                            Icon(item.icon, contentDescription =null )
                        }, label = { Text(item.name) })
                    }
                }
            }
        }
    ) {scaffoldPadding->
        when(currentRoute){
            "home"-> HomeScreen(scaffoldPadding)
            "police"-> PoliceStationScreen(scaffoldPadding)
            "history"-> HistoryScreen(scaffoldPadding)
            "profile"-> ProfileScreen()
        }
    }
}


