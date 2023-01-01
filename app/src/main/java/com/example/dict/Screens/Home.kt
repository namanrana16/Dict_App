package com.example.dict.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dict.model.MessageItem

@Composable
fun Home(navController: NavHostController) {

    val HomeViewModel : HomeViewModel = hiltViewModel()
    val state by HomeViewModel.state.collectAsState()

    Column(Modifier.fillMaxSize()) {

        LazyColumn{


            items(state){ items:MessageItem ->

                DictCard(items)

            }

        }
        
    }
}


@Composable
fun DictCard(items:MessageItem) {


Box(modifier = Modifier
    .fillMaxWidth()
    .padding(16.dp)
    .clip(RoundedCornerShape(8.dp))
    .background(Color.White)
    .padding(16.dp)
) {
    Column {
        Text(
            text = "Message:${items.body}",
            style = MaterialTheme.typography.h6,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "UserId: ${items.userId}",
            style = MaterialTheme.typography.body2,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Thread: ${items.threadId}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Time: ${items.timestamp}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}
}
