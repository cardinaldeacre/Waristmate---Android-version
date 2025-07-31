package com.example.waristmate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waristmate.ui.theme.DarkGreen
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkGreen)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .fillMaxWidth()
                .padding(top = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.balance),
                contentDescription = "Balance image",
                modifier = Modifier
                    .weight(1.5f)
                    .size(320.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = R.string.app_name_capt),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.35f)
                    .align(Alignment.CenterHorizontally)
                    .clip(
                        RoundedCornerShape(
                            topStart = 24.dp,
                            topEnd = 24.dp,
                            bottomEnd = 24.dp,
                            bottomStart = 24.dp
                        )
                    )
                    .background(Color.White)
                    .padding(horizontal = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.header_welcome_page),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = DarkGreen,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.text_welcome_page),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = DarkGreen
                )
                Spacer(
                    modifier = Modifier.height(24.dp)
                )
                Column(
                    modifier = Modifier
                        .height(150.dp)
                        .width(130.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 80.dp,
                                topEnd = 80.dp,
                            )
                        )
                        .background(DarkGreen)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Spacer(
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 80.dp,
                                    topEnd = 80.dp,
                                    bottomEnd = 70.dp,
                                    bottomStart = 70.dp
                                )
                            )
                            .background(Color.White)
                            .clickable { navController.navigate("home_screen") }
                            .align(Alignment.CenterHorizontally),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.home_button_green),
                            modifier = Modifier
                                .size(70.dp),
                            contentDescription = "Home Button",
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkGreen)
                    .padding(6.dp)
            ) {
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
            }
        }
    }
}