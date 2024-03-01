package presentation.screen.boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DefaultAlertDialog(
    onAlertDialogDismissRequest :() -> Unit
){
    Dialog(
        onDismissRequest = { onAlertDialogDismissRequest.invoke() }
    ){
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colors.secondary,
                        shape = RoundedCornerShape(10.dp)
                    )
            ){
                Text(
                    text = "Invalid email or password",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(vertical = 20.dp)
                )
                Divider(
                    thickness = Dp.Hairline,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.fillMaxWidth()
                )

                TextButton(
                    interactionSource = MutableInteractionSource(),
                    onClick = { onAlertDialogDismissRequest.invoke() },
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "OK",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                }
            }
        }

    }
}