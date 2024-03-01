package presentation.extra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BackButton(
    onClick:()-> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = { onClick.invoke() },
        modifier = modifier
            .background(
                color = MaterialTheme.colors.onSecondary.copy(alpha = 0.37f),
                shape = RoundedCornerShape(100)
            )
            .size(40.dp)
    ) {
        Icon(
            painter = painterResource("baseline_arrow_back_24.xml"),
            contentDescription = "Go Back",
            tint = MaterialTheme.colors.secondary
        )
    }
}