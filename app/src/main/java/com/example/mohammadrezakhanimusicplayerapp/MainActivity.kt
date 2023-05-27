package com.example.mohammadrezakhanimusicplayerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mohammadrezakhanimusicplayerapp.ui.theme.MohammadRezaKhaniMusicPlayerAppTheme
import com.example.mohammadrezakhanimusicplayerapp.ui.theme.inter
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MohammadRezaKhaniMusicPlayerAppTheme {
                MenuPage()
            }
        }
    }
}

val backgroundColor = Color(0xFF16161E)
val whiteColor = Color(0xFFFFFFFF)
val darkBlueColor = Color(0xFF6A6A8C)
val yellowColor = Color(0xFFD8F26A)
val greyColor = Color(0xFF1F1F27)
val redColor = Color(0xFFDC3131)
val painterSongsCover = listOf(
    R.drawable.hamed_1, R.drawable.hamed_2,
    R.drawable.hamed_3, R.drawable.hamed_4,
    R.drawable.hamed_5, R.drawable.hamed_6
)

@Composable
fun MenuPage() {
    Column(
        Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        TopIcons()
        HeaderText()
        MusicRow()
        DescriptionText()
        MusicDetails(
            painter = R.drawable.hoorosh_band,
            title = "TARKAM NAKONIA", artist = "Hoorosh Band"
        )
        MusicDetails(
            painter = R.drawable.hamid_hirrad,
            title = "VATAN", artist = "Hamid Hirad"
        )
        PlayedMusic()
    }
}

@Composable
fun TopIcons() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 40.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.more_icon),
            contentDescription = "Hamburger Menu", tint = whiteColor,
            modifier = Modifier
                .padding(end = 20.dp)
                .size(32.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Column(
                Modifier.height(35.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hi,Alireza", fontSize = 13.sp, fontFamily = inter,
                    color = whiteColor, fontWeight = FontWeight.Normal
                )
                Text(
                    text = "welcome", fontSize = 13.sp, fontFamily = inter,
                    color = whiteColor, fontWeight = FontWeight.Light
                )
            }
            Box {
                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "", tint = whiteColor,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(32.dp)
                )
                Box(
                    Modifier
                        .padding(start = 6.dp, top = 8.dp)
                        .size(8.dp)
                        .background(redColor, CircleShape)
                )
            }
        }
    }
}

@Composable
fun HeaderText() {
    Text(
        text = "Playlist",
        fontSize = 25.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        color = darkBlueColor,
        modifier = Modifier.padding(
            start = 30.dp,
            top = 15.dp,
            bottom = 30.dp
        )
    )
}

@Composable
fun MusicRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        for (element in painterSongsCover) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = element),
                    contentDescription = "Songs Cover", contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(200.dp, 255.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Row(
                    modifier = Modifier
                        .padding(top = 245.dp)
                        .background(
                            backgroundColor,
                            RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                        .size(90.dp, 30.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    RatingStar(R.drawable.filled_star, yellowColor, 6.dp, 3.dp)
                    RatingStar(R.drawable.filled_star, yellowColor, 3.dp, 3.dp)
                    RatingStar(R.drawable.filled_star, yellowColor, 0.dp, 3.dp)
                    RatingStar(R.drawable.filled_star, yellowColor, 3.dp, 3.dp)
                    RatingStar(R.drawable.empty_star, darkBlueColor, 6.dp, 0.dp)
                }
            }
        }
    }
}

@Composable
fun RatingStar(painter: Int, color: Color, topPadding: Dp, endPadding: Dp) {
    Icon(
        painter = painterResource(id = painter),
        contentDescription = "Star", tint = color,
        modifier = Modifier
            .padding(top = topPadding, end = endPadding)
            .size(10.dp)
    )
}

@Composable
fun DescriptionText() {
    Text(
        text = "recently played",
        fontFamily = inter,
        fontSize = 25.sp,
        fontWeight = FontWeight.Medium,
        color = darkBlueColor,
        modifier = Modifier.padding(
            start = 30.dp,
            top = 25.dp,
            bottom = 20.dp
        )
    )
}

@Composable
fun MusicDetails(painter: Int, title: String, artist: String) {
    Row(
        Modifier
            .padding(start = 30.dp, bottom = 40.dp, end = 30.dp)
            .height(75.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = "Music Cover",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Column(
            Modifier
                .weight(1F)
                .fillMaxHeight()
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Medium,
                color = whiteColor
            )
            Text(
                text = artist,
                fontSize = 13.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Light,
                color = whiteColor
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.more_icon),
            contentDescription = "More Icon",
            tint = whiteColor,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun PlayedMusic() {
    Row(
        Modifier
            .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
            .height(100.dp)
            .fillMaxWidth()
            .background(greyColor, RoundedCornerShape(15.dp))
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.hamed_7),
            contentDescription = "Music Cover",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Box(
            Modifier
                .weight(1F)
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.Center,
        ) {
            MusicBars()
        }
        Icon(
            painter = painterResource(id = R.drawable.play),
            contentDescription = "Play",
            tint = yellowColor,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun MusicBars() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in 0..25) {
            Divider(
                Modifier
                    .height(Random.nextInt(5, 20).dp)
                    .width(2.5.dp)
                    .background(
                        if (i < 15) yellowColor else whiteColor,
                        CircleShape
                    )
            )
            if (i == 14) {
                Box(
                    Modifier
                        .size(15.dp)
                        .background(yellowColor, CircleShape)
                )
            }
        }
    }
}
