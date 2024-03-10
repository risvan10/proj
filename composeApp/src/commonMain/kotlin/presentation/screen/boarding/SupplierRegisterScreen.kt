package presentation.screen.boarding

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import io.ktor.util.Identity.encode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import presentation.extra.BackButton
import presentation.extra.DefaultFilledButton
import presentation.extra.DefaultTextField
import presentation.theme.Spacing

@Composable
fun SupplierRegisterScreen(
    onBackPressed : ()-> Unit,
    onSubmit: ()-> Unit
){
    var companyNameField by remember{ mutableStateOf("") }
    var emailField by remember{ mutableStateOf("") }
    var websiteUrlField by remember{ mutableStateOf("") }
    var contactNumber by remember { mutableStateOf("") }
    var industryField by remember{ mutableStateOf("") }
    var isFileAttached by remember{mutableStateOf(false)}
    var showFilePicker by remember { mutableStateOf(false) }


    var justLaunched:Boolean by remember { mutableStateOf(false) }
    LaunchedEffect(Unit){
        justLaunched = true
    }
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            BackButton(
                onClick = { onBackPressed.invoke()},
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
                text = "Join our supplier network!",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultTextField(
                    value = companyNameField,
                    onValueChange ={
                        companyNameField = it
                    },
                    placeholderText = "Company Name",
                    isError = companyNameField.isBlank() && !justLaunched
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
                    value = websiteUrlField,
                    onValueChange ={
                        websiteUrlField = it
                    },
                    placeholderText = "Website URL",
                    isError = false
                )
                DefaultTextField(
                    value = industryField,
                    onValueChange ={
                        industryField = it
                    },
                    placeholderText = "Industry",
                    isError = false
                )
                DefaultTextField(
                    value = contactNumber,
                    onValueChange ={
                        contactNumber = it
                    },
                    placeholderText = "Contact Number",
                    isError = contactNumber.isBlank() && !justLaunched
                )

                val fileType = listOf("jpg", "png")
                FilePicker(show = showFilePicker, fileExtensions = fileType) { file ->
                    showFilePicker = false
//                    CoroutineScope(Dispatchers.IO).launch {
//                        val ref = Firebase.storage.reference
//                        if (file != null) {
//                            ref.putFile(file.platformFile as File)
//                        }
//
//                    }
                }
                DefaultFilledButton(
                        text = "Pick File",
                onClick = {
                    showFilePicker = true
                }
                )

                Text("By proceeding, you're agreeing to our Terms of Service, Brand Agreement, and Privacy Policy.",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colors.secondary
                )
                DefaultFilledButton(
                    text = "Register",
                    onClick = {
                        if (emailField.isNotBlank() && companyNameField.isNotBlank()){
                            if (isFileAttached){
                                onSubmit.invoke()
                            }else{
                                isFileAttached = false
                                justLaunched= false
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
                        Text(
                            AnnotatedString("Already @ Purchaser? Log In",
                            spanStyles = listOf(
                                AnnotatedString.Range(
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
