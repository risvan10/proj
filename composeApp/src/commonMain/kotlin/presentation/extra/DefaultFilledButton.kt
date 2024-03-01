package presentation.extra

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultFilledButton(
    text: String,
    onClick:()-> Unit,
    modifier: Modifier = Modifier,
    isContainerColorPrimary: Boolean = false
){
    OutlinedButton(onClick = { onClick.invoke() },
        colors = if (isContainerColorPrimary)
            ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.secondary,)
        else
            ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.primary),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = text,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(vertical = 5.dp)
            )
    }
}