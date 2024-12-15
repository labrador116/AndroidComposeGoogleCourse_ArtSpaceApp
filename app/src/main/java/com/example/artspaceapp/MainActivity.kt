package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceLayout()
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    var intRes by remember { mutableIntStateOf(R.drawable._19) }
    var title by remember { mutableStateOf("Artwork Title") }
    var artist by remember { mutableStateOf("Artwork artist") }
    var year by remember { mutableStateOf("(2024)") }

    var state by remember { mutableIntStateOf(0) }

    when (state) {
        1 -> {
            title = "Test test"
            artist = "artist artis"
            year = "(2025)"
            intRes = R.drawable._106
        }

        2 -> {
            title = "Test test_2"
            artist = "artist artis_2"
            year = "(2026)"
            intRes = R.drawable._115
        }

        3 -> {
            title = "Test test_3"
            artist = "artist artis_3"
            year = "(2027)"
            intRes = R.drawable._127
        }

        else -> {
            title = stringResource(R.string.artwork_title_default)
            artist = stringResource(R.string.artwork_artist_default)
            year = stringResource(R.string.year_default)
            intRes = R.drawable._19
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtLayout(intRes)
            Spacer(Modifier.padding(32.dp))
            ArtDescriptionText(
                title,
                artist,
                year
            )
            Spacer(Modifier.padding(32.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                Button(
                    content = { Text("Previous") },
                    onClick = { if (state != 0) state-- },
                    modifier = Modifier.width(150.dp)

                )
                Button(
                    content = { Text("Next") },
                    onClick = { if (state < 3) state++ },
                    modifier = Modifier.width(150.dp)
                )
            }
        }
    }
}

@Composable
fun ArtLayout(
    @DrawableRes drawable: Int
) {
    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .background(Color.White)
            .shadow(elevation = 3.dp, shape = RectangleShape, clip = true),
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier.padding(32.dp)
        )
    }
}

@Composable
fun ArtDescriptionText(
    title: String,
    artist: String,
    year: String
) {
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .padding(8.dp)
    ) {
        Text(
            title,
            fontSize = 32.sp,
            textAlign = TextAlign.Left,
        )

        Row(
            modifier = Modifier.wrapContentSize(Alignment.Center)
        ) {
            Text(
                artist,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                year,
                fontSize = 26.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceLayout()
}