package presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
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

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppHomeTopBar(){
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(150.dp)
            .background(color = MaterialTheme.colors.primary),

        ){
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 14.dp, start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Purchaser",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.secondary
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .background(
                            color = MaterialTheme.colors.onSecondary.copy(alpha = 0.37f),
                            shape = RoundedCornerShape(100)
                        )
                        .size(30.dp),
                ) {
                    Icon(
                        painter = painterResource("baseline_arrow_back_24.xml"),
                        contentDescription = null,
                        tint = MaterialTheme.colors.secondary
                    )
                }

            }
            Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())
            var searchField by remember { mutableStateOf("") }
            TextField(
                searchField,
                onValueChange = {
                    searchField = it
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onSecondary.copy(alpha = 0.37f),
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 12.dp),
                textStyle = MaterialTheme.typography.caption,
                placeholder = {
                    Text(
                        text = "Search on Purchaser",
                        color = MaterialTheme.colors.onSecondary.copy(alpha = 0.37f),
                        style = MaterialTheme.typography.caption
                    )
                }
            )

        }
    }
}