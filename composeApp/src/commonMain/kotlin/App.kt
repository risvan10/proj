import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.screen.boarding.BoardingScreen
import presentation.screen.boarding.CustomerRegisterFirstScreen
import presentation.screen.boarding.LoginScreen
import presentation.screen.boarding.SupplierRegisterScreen
import presentation.theme.PurchaserTheme

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    PurchaserTheme {
        PreComposeApp {
             val navController = rememberNavigator()
            MaterialTheme {
                NavHost(
                    navigator = navController,
                    initialRoute = Destination.LoginScreen.route
                ){
                    scene(Destination.BoardingScreen.route){
                        BoardingScreen(navController)
                    }
                    scene(Destination.CustomerRegisterFirst.route){
                        CustomerRegisterFirstScreen(
                            navController,
                            onSubmit = {}
                        )
                    }
                    scene(Destination.SupplerRegisterScreen.route){
                        SupplierRegisterScreen(
                            onBackPressed = {},
                            onSubmit = {}
                        )
                    }
                    scene(Destination.LoginScreen.route){
                        var isLoginInvalid by remember{
                            mutableStateOf(false)
                        }
                        LoginScreen(
                            onSubmit = { /*TODO*/ },
                            isLoginInvalid = isLoginInvalid,
                            onAlertDialogDismissRequest = {
                                isLoginInvalid = false
                            },
                            onBack = {
                                navController.navigate(Destination.BoardingScreen.route)
                            }

                        )
                    }
                }
            }
        }
    }
}
sealed class Destination(val route:String){
    data object BoardingScreen: Destination("1")
    data object CustomerRegisterFirst: Destination("2")
    data object CustomerRegisterSecond: Destination("3")
    data object SupplerRegisterScreen: Destination("4")
    data object SupplierRegistrationWaitListScreen: Destination("5")
    data object HomeScreen: Destination("6")
    data object GetQuoteScreen: Destination("7")
    data object MessageScreen: Destination("8")
    data object ProfileScreen: Destination("9")
    data object LoginScreen: Destination("10")
}
