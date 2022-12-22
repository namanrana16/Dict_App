package com.example.dict.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dict.model.Definition

@Composable
fun Home() {

    val HomeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by HomeViewModel.state.collectAsState()

    Column(Modifier.fillMaxSize()) {

        LazyColumn{


            items(state){ items:Definition ->

                DictCard(items)

            }

        }
        
    }
}


@Composable
fun DictCard(items:Definition) {


Box(modifier = Modifier
    .fillMaxWidth()
    .padding(16.dp)
    .clip(RoundedCornerShape(8.dp))
    .background(Color.White)
    .padding(16.dp)
) {
    Column {
        Text(
            text = "Type:${items.type}",
            style = MaterialTheme.typography.h6,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Definition: ${items.definition}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}
}
