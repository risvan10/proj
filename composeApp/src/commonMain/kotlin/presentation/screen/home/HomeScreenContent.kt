package presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.theme.Spacing


data class Category(
    val id: String,
    val name:String,
    val image: String
)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreenContent(){
    Column(modifier = Modifier.fillMaxWidth()
        .padding(Spacing.MinimumContainerSpacing.value)) {
        Spacer(Modifier.padding(vertical = 8.dp))
        Text(
            text = "Categories",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier.fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
            )
        val list = mutableListOf<Category>()
        list.add(Category("1","Sample","imageUrl"))
        list.add(Category("1","Sample","imageUrl"))
        list.add(Category("1","Sample","imageUrl"))
        list.add(Category("1","Sample","imageUrl"))
        list.add(Category("1","Sample","imageUrl"))
        list.add(Category("1","Sample","imageUrl"))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(vertical = 10.dp)
        ){
            this.items(list){
                Card(
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = Color.Gray,
                    modifier = Modifier.height(55.dp).width(60.dp),
                    onClick = {}
                ) {

                }
            }
        }
    }
}
