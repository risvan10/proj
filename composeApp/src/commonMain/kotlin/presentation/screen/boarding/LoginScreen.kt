package presentation.screen.boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.extra.BackButton
import presentation.extra.DefaultFilledButton
import presentation.extra.DefaultTextField
import presentation.theme.Spacing

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginScreen(
    onSubmit:()-> Unit,
    isLoginInvalid : Boolean,
    onAlertDialogDismissRequest: () -> Unit,
    onBack:() -> Unit
){
    var emailField:String by remember{
        mutableStateOf("")
    }
    var passwordField by remember{
        mutableStateOf("")
    }
    var isInvalidEmail by remember{
        mutableStateOf(false)
    }
    var isInvalidPassword by remember{
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primary)
    ) {

        if (isLoginInvalid){
            DefaultAlertDialog(onAlertDialogDismissRequest = {})
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(90.dp),
            modifier = Modifier
                .padding(all= Spacing.ContainerSpacing.value)
                .fillMaxWidth()
        ){
            BackButton(
                onClick = { onBack.invoke() },
            )
            Image(
                painter = painterResource("undraw_mobile_login_re_9ntv.xml"),
                contentDescription = "Vector image: Person with phone on login screen.",
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Welcome Back",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                )

                DefaultTextField(
                    value = emailField,
                    onValueChange = { emailField = it },
                    placeholderText = "Email Address",
                    isError = false
                )
                DefaultTextField(
                    value = passwordField,
                    onValueChange = { passwordField = it },
                    placeholderText = "Password",
                    isError = false
                )
                DefaultFilledButton(
                    text = "Continue",
                    onClick = {
                        if (passwordField.isNotBlank() && emailField.isNotBlank()){
                            onSubmit.invoke()
                        }
                    }
                )
            }
        }
    }
}