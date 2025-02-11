package com.mokelab.lesson.compose.layout.loading

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mokelab.lesson.compose.layout.R
import com.mokelab.lesson.compose.layout.ui.theme.ComposeLayoutLessonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginAnswerScreen(
    back: () -> Unit,
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

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
        }
    ) { innerPadding ->
        Text(
            "Let's write your layout at LoginAnswerScreen.kt",
            modifier = Modifier
                .padding(innerPadding)
                .padding(all = 16.dp)
        )
        // Remove Text above and write your layout here
    }
}

@Preview
@Composable
private fun PreviewLoginAnswerScreen() {
    ComposeLayoutLessonTheme {
        LoginAnswerScreen(
            back = {},
        )
    }
}