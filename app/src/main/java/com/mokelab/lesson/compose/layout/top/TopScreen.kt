package com.mokelab.lesson.compose.layout.top

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mokelab.lesson.compose.layout.R

@Composable
fun TopScreen(
    toLogin: () -> Unit,
    toAppList: () -> Unit,
) {
    val menuItems = listOf(
        Pair(R.string.login, toLogin),
        Pair(R.string.applist, toAppList),
    )
    Scaffold { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(menuItems) { item ->
                ListItem(
                    headlineContent = {
                        Text(stringResource(item.first))
                    },
                    modifier = Modifier.clickable {
                        item.second()
                    }
                )
            }
        }
    }
}