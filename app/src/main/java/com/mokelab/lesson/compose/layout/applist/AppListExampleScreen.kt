package com.mokelab.lesson.compose.layout.applist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mokelab.lesson.compose.layout.R
import com.mokelab.lesson.compose.layout.ui.theme.ComposeLayoutLessonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListExampleScreen(
    back: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.example)) },
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                })
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            AppItem(
                installed = true,
                modifier = Modifier.fillMaxWidth(),
            )
            AppItem(
                installed = false,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun AppItem(
    installed: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = modifier.padding(vertical = 8.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "App icon",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(48.dp)
                .background(color = Color.Blue)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        ) {
            Text(
                text = "App Name",
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = "Description\nLine 2",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp),
            ) {
                if (installed) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = "",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "Installed",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                } else {
                    Text(
                        text = "Not installed",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
    HorizontalDivider()
}

@Preview
@Composable
private fun PreviewAppListExampleScreen() {
    ComposeLayoutLessonTheme {
        AppListExampleScreen(back = {})
    }
}