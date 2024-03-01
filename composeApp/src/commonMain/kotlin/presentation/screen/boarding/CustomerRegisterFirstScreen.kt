package presentation.screen.boarding

import Destination
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import presentation.extra.BackButton
import presentation.extra.DefaultFilledButton
import presentation.extra.DefaultTextField
import presentation.theme.Spacing

@Composable
fun CustomerRegisterFirstScreen(
    navController: Navigator,
    onSubmit:() -> Unit
){
    var nameField: String by remember{ mutableStateOf("") }
    var emailField: String by remember{ mutableStateOf("") }
    var passwordField: String by remember{ mutableStateOf("") }
    var confirmPasswordField: String by remember{ mutableStateOf("") }
    var isPasswordMatching: Boolean? by remember {
        mutableStateOf(null)
    }
    var passwordFinal = if ((confirmPasswordField == passwordField) && confirmPasswordField.isNotBlank()) confirmPasswordField else null
    var justLaunched:Boolean by remember { mutableStateOf(false) }
    LaunchedEffect(Unit){
        justLaunched = true
    }
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            BackButton(
                onClick = { navController.navigate(Destination.BoardingScreen.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing.ContainerSpacing.value)
                    .wrapContentWidth(Alignment.Start)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(vertical = 15.dp, horizontal = Spacing.ContainerSpacing.value),
            verticalArrangement = Arrangement.spacedBy(60.dp)
        ) {
            Text(
                text = "Join us to access a network of suppliers and order effortlessly",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultTextField(
                    value = nameField,
                    onValueChange ={
                        nameField = it
                    },
                    placeholderText = "Your Name",
                    isError = nameField.isBlank() && !justLaunched
                )
                DefaultTextField(
                    value = emailField,
                    onValueChange ={
                        emailField = it
                    },
                    placeholderText = "Email Address",
                    isError = emailField.isBlank() && !justLaunched
                )
                DefaultTextField(
                    value = passwordField,
                    onValueChange ={
                        passwordField = it
                    },
                    placeholderText = "Password",
                    isError = passwordField.isBlank() && !justLaunched,
                    isPassword = true
                )
                DefaultTextField(
                    value = confirmPasswordField,
                    onValueChange ={
                        confirmPasswordField = it
                    },
                    isPassword = true,
                    placeholderText = "Confirm Password",
                    isError = (confirmPasswordField.isBlank() || isPasswordMatching == false) && !justLaunched,
                    errorLabelText = if (isPasswordMatching == false){
                        "Password do not match"
                    }else{
                        "This Field is Required"
                    }
                )
                Text("By proceeding, you're agreeing to our Terms of Service, Brand Agreement, and Privacy Policy.",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colors.secondary
                    )
                DefaultFilledButton(
                    text = "Continue",
                    onClick = {
                        if (emailField.isNotBlank() && nameField.isNotBlank()){
                            if (passwordFinal != null){
                                onSubmit.invoke()
                            }else{
                                justLaunched = false
                                isPasswordMatching = false
                            }
                        }else{
                            justLaunched = false
                        }
                    }
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                ) {
                    TextButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black
                        ),
                        interactionSource = MutableInteractionSource(),
                    ){
                        Text(AnnotatedString("Already @ Purchaser? Log In",
                            spanStyles = listOf(AnnotatedString.Range(
                                SpanStyle(
                                    textDecoration = TextDecoration.Underline),
                                start = 21, end = 27))
                        ),
                            color = MaterialTheme.colors.secondary
                        )
                    }
                }

            }
        }
    }
}