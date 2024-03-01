package presentation.screen.boarding

import Destination
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import presentation.extra.DefaultFilledButton
import presentation.extra.FilledTonalButton

@Composable
fun BoardingScreen(navController: Navigator) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 65.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text = "App Name",
                    color = Color.White,
                    style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Moderately Long headline text describing app name",
                    color = Color.White,
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                DefaultFilledButton(
                    text = "Sign Up to Shop",
                    onClick = {
                        navController.navigate(Destination.CustomerRegisterFirst.route)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                DefaultFilledButton(
                    text= "Sell On Purchaser",
                    onClick = {
                        navController.navigate(Destination.SupplerRegisterScreen.route)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedButton(
                    onClick = {
                              navController.navigate(Destination.LoginScreen.route)
                    },
                    enabled = true,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.secondary),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = MaterialTheme.colors.secondary
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Already @ Purchaser? Log In",
                        color = MaterialTheme.colors.secondary,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }

        }
    }
}