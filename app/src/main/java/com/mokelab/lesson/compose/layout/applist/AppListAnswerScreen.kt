package com.mokelab.lesson.compose.layout.applist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mokelab.lesson.compose.layout.R
import com.mokelab.lesson.compose.layout.ui.theme.ComposeLayoutLessonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListAnswerScreen(
    back: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.your_answer)) },
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
    Text(
        "Let's write your layout at AppListAnswerScreen.kt",
        modifier = modifier
    )
}

@Preview
@Composable
private fun PreviewAppListExampleScreen() {
    ComposeLayoutLessonTheme {
        AppListExampleScreen(back = {})
    }
}