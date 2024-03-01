package presentation.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class Spacing(val value: Dp){
    data object ContainerSpacing: Spacing(20.dp)
    data object MinimumContainerSpacing: Spacing(10.dp)
}
