package com.mokelab.lesson.compose.layout.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mokelab.lesson.compose.layout.R
import com.mokelab.lesson.compose.layout.ui.theme.ComposeLayoutLessonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    back: () -> Unit,
    toExample: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.login)) },
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
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            Text(
                stringResource(R.string.login_description),
                modifier = Modifier.padding(all = 16.dp)
            )
            Button(
                onClick = toExample,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(stringResource(R.string.example))
            }

            Image(
                painter = painterResource(R.drawable.login),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 32.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewLoginScreen() {
    ComposeLayoutLessonTheme {
        LoginScreen(
            back = {},
            toExample = {},
        )
    }
}