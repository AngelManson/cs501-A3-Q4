package com.example.individualassignment3_4

//import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.individualassignment3_4.ui.theme.IndividualAssignment34Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndividualAssignment34Theme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                    ResponsiveScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

data class NavRailItemInfo(
    val label: String,
    val icon: ImageVector,
    val screenContent: String
)

@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ResponsiveScreen( modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val isPhone = this.maxWidth < 600.dp

        val navRailItems = listOf(
            NavRailItemInfo(
                "Home",
                Icons.Default.Home,
                "Individual Assignment 3-4: Responsive Screen"
            ),
            NavRailItemInfo(
                "Favorites",
                Icons.Default.Favorite,
                "My Favorite Class: CS501"
            ),
            NavRailItemInfo(
                "Profile",
                Icons.Default.Person,
                "Hi! My name is Angel Manson. I'm a senior studying Computer Science."
            ),
            NavRailItemInfo(
                "Settings",
                Icons.Default.Settings,
                "Adjust Settings Here!"
            )
        )
        var selectedItemIndex by remember { mutableIntStateOf(0) }

        if (isPhone) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Responsive Screen") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                },
            ) { scaffoldInnerPadding ->

                Column(
                    modifier = Modifier
                        .padding(scaffoldInnerPadding)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Divider()

                    navRailItems.forEachIndexed { index, item ->
                        ListItem(
                            headlineContent = { Text(item.label) },
                            leadingContent = {
                                Icon(item.icon, contentDescription = item.label)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedItemIndex = index },
                        )

                        if (index < navRailItems.size - 1) {
                            Divider()
                        }
                    }

                    Divider()

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = navRailItems[selectedItemIndex].label,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(6.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                                .padding(16.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                navRailItems[selectedItemIndex].screenContent,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }

                    Button(
                        onClick = { },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Press!")
                    }
                }
            }
//            Column(modifier = Modifier.fillMaxSize()
//                .verticalScroll(rememberScrollState())
//                .padding(16.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp))
//            {
//
//            }
        } else {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
//                .verticalScroll(rememberScrollState())
//                .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .weight(0.3f)
                            .fillMaxHeight()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        NavigationRail(
                            modifier = Modifier.fillMaxHeight(),
//                            containerColor = Color(0xFF90CAF9)
                            header = {
                                FloatingActionButton(
                                    onClick = { },
                                    modifier = Modifier.padding( bottom = 16.dp),
                                    elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp)
                                ) {
                                    Icon(Icons.Default.Face, contentDescription = "App Action/Logo")
                                }
                            }
                        ) {
                            navRailItems.forEachIndexed { index, item ->
                                NavigationRailItem(
                                    selected = selectedItemIndex == index,
                                    onClick = { selectedItemIndex = index },
                                    icon = { Icon(item.icon, contentDescription = item.label) },
                                    label = { Text(item.label) },
                                    alwaysShowLabel = true
                                )
                                if (index < navRailItems.size - 1) {
                                    Spacer(Modifier.height(12.dp))
                                }
                            }
                        }
                    }


                    Scaffold(
                        modifier = Modifier.weight(3.8f),
                        topBar = {
                            TopAppBar(
                                title = { Text("Responsive Screen") },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                                )
                            )
                        },
                    ) { scaffoldInnerPadding ->
                        Box(
                            modifier = Modifier
//                                .weight(0.7f)
                                .padding(scaffoldInnerPadding)
                                .fillMaxHeight()
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState())
                                    .padding(24.dp),
                                verticalArrangement = Arrangement.spacedBy(20.dp)
                            ) {

                                Text(
                                    text = navRailItems[selectedItemIndex].label,
                                    style = MaterialTheme.typography.headlineMedium
                                )

                                Divider()

                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    elevation = CardDefaults.cardElevation(6.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(220.dp)
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            navRailItems[selectedItemIndex].screenContent,
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    }
                                }
                                Button(
                                    onClick = { },
                                    modifier = Modifier.align(Alignment.End)
                                ) {
                                    Text("Press!")
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 400)
@Composable
fun PhonePreview() {
    ResponsiveScreen()
}

@Preview(showBackground = true, widthDp = 800, heightDp = 600)
@Composable
fun TabletPreview() {
    Scaffold(modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        ResponsiveScreen(modifier = Modifier.padding(innerPadding))
    }
}