package com.feature.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun Content() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        content = {
            item { TopBar() }
            item {
                Text(
                    text = "Libros",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 25.sp
                )
                HorizontalDivider(color = MaterialTheme.colorScheme.outline, modifier = Modifier.padding(horizontal = 10.dp))
            }
            item { BooksHorizontal() }
            item {
                Text(
                    text = "Personajes",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 25.sp
                )
                HorizontalDivider(color = MaterialTheme.colorScheme.outline, modifier = Modifier.padding(horizontal = 10.dp))
            }
            item { Characters() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    )
}