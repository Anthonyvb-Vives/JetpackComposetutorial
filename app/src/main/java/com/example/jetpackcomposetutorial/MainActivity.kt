package com.example.jetpackcomposetutorial

import android.os.Bundle
import android.provider.Settings.System.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayPage(
                        stringResource(id = R.string.app_name),
                        stringResource(id = R.string.first_paragraph),
                        stringResource( id = R.string.second_paragraph
                    ))
                }
            }
        }
    }
}

@Composable
fun DisplayPage(title: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        DisplayText(title, firstParagraph, secondParagraph)
    }
}

@Composable
fun DisplayText(title: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = firstParagraph,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify

        )
        Text(
            text = secondParagraph,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        DisplayPage( stringResource(R.string.app_name), stringResource(R.string.first_paragraph), stringResource(R.string.second_paragraph) )
    }
}