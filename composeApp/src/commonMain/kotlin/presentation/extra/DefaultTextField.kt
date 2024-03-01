package presentation.extra

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultTextField(
    value: String,
    onValueChange: (String)-> Unit,
    placeholderText: String,
    supportingText: String? = null,
    isError: Boolean,
    errorLabelText: String = "This Field is Required!",
    isPassword : Boolean = false,
    isNumberKeyboard:Boolean = false,
    isChatKeyboard: Boolean = false,
    onSend: () -> Unit = {}

){
    TextField(
        value = (value),
        onValueChange = {
            onValueChange.invoke(it) },
        enabled = true,
        textStyle = MaterialTheme.typography.h4,
        shape = RoundedCornerShape(10.dp),
        isError = isError,
        placeholder = {
            Text(
                text = placeholderText,
                style = MaterialTheme.typography.h4,
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isNumberKeyboard) KeyboardType.Phone else KeyboardType.Text,
            imeAction = if (isChatKeyboard) ImeAction.Send else ImeAction.Default
        ),
        keyboardActions = if (isChatKeyboard){
            KeyboardActions(
                onSend = { onSend.invoke() }
            )
        }else{
            KeyboardActions.Default
        },
        label = if (!isError) {null}  else{
            {
                Text(
                    text = errorLabelText,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.body2
                )
            }
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth().wrapContentHeight(Alignment.CenterVertically),
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSecondary,
            backgroundColor = MaterialTheme.colors.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = MaterialTheme.colors.onSecondary.copy(alpha = 0.6f),
            errorIndicatorColor = Color.Transparent,
        )
    )
}