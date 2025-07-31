package com.example.waristmate

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.rotationMatrix
import com.example.waristmate.ui.theme.WaristmateTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import com.example.waristmate.ui.theme.DarkGreen
import com.example.waristmate.ui.theme.Green
import com.example.waristmate.ui.theme.Whites
import com.example.waristmate.ui.theme.LightGreen
import com.example.waristmate.ui.theme.Gold
import com.example.waristmate.ui.theme.Tosca

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Whites)
    ) {
        Column(
          modifier = Modifier
              .fillMaxWidth()
              .align(Alignment.TopCenter)
        ) {
            // Header
            Row(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 23.dp,
                            bottomEnd = 23.dp,
                        )
                    )
                    .fillMaxWidth()
                    .background(Green)
                    .padding(vertical = 12.dp, horizontal = 26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.app_name_capt),
                    color = Whites,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )
                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    contentDescription = "waritsmate_logo",
                    modifier = modifier
                        .size(40.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
            )
            // Hero
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.salam_compose),
                    fontSize = 18.sp,
                    color = LightGreen,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.welcome_compose),
                    color = Green,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 32.dp,
                            bottomStart = 32.dp,
                            topEnd = 32.dp,
                            bottomEnd = 32.dp,
                        )
                    )
                    .background(Green)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(24.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.greeting_compose),
                    fontSize = 18.sp,
                    color = Whites,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Left,
                )
                Text(
                    text = stringResource(id = R.string.ayo_lanjut_compose),
                    color = Whites,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Left
                )

                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )

                Row(
                    modifier = modifier
                        .padding(vertical = 12.dp, horizontal = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.blue_book),
                        contentDescription = "bluebook",
                        modifier = Modifier
                            .size(125.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding( start = 30.dp, top = 20.dp, bottom = 20.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 32.dp,
                                        bottomStart = 32.dp,
                                        topEnd = 32.dp,
                                        bottomEnd = 32.dp,
                                    )
                                )
                                .background(Gold)
                                .width(150.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.lanjut_button),
                                color = Whites,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 6.dp)
                                    .align(alignment = Alignment.Center)
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )
                        Box(
                            modifier = modifier
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 32.dp,
                                        bottomStart = 32.dp,
                                        topEnd = 32.dp,
                                        bottomEnd = 32.dp,
                                    )
                                )
                                .background(Tosca)
                                .width(150.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.tabel_button),
                                color = Whites,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 6.dp)
                                    .align(alignment = Alignment.Center)
                            )
                        }
                    }
                }
            }

            // content list
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 40.dp)
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .padding(vertical = 12.dp, horizontal = 6.dp)
                        .fillMaxWidth()
                        .clickable{ navController.navigate("list_module")}
                        .border(
                            width = 2.dp,
                            color = Green,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Tosca),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.books),
                            contentDescription = "modul",
                            modifier = modifier
                                .size(35.dp)
                        )
                    }
                    Text(
                        modifier = modifier
                            .padding(start = 5.dp),
                        text = stringResource(R.string.modul_button),
                        color = Green,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .padding(vertical = 5.dp, horizontal = 6.dp)
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = Green,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Gold),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ayat),
                            contentDescription = "modul",
                            modifier = modifier
                                .size(35.dp)
                        )
                    }
                    Text(
                        modifier = modifier
                            .padding(start = 5.dp),
                        text = stringResource(R.string.dalil_button),
                        color = Green,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .padding(vertical = 12.dp, horizontal = 6.dp)
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = Green,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(LightGreen),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.book_stand),
                            contentDescription = "modul",
                            modifier = modifier
                                .size(35.dp)
                        )
                    }
                    Text(
                        modifier = modifier
                            .padding(start = 5.dp),
                        text = stringResource(R.string.tabel_button),
                        color = Green,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }


        }

        // navbar bottom
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 23.dp,
                            topEnd = 23.dp,
                        )
                    )
                    .fillMaxWidth()
                    .background(Green)
                    .padding(start = 20.dp, top = 10.dp, bottom = 15.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .clip(RoundedCornerShape(18.dp))
                        .background(Green)
                        .width(120.dp)
                        .height(60.dp)
                        .padding(top = 5.dp)
                        .clickable{ navController.navigate("list_module")}
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.books),
                        contentDescription = "modul logo",
                        modifier = modifier
                            .size(32.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.modul),
                        color = Whites,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 1.sp
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .clip(RoundedCornerShape(18.dp))
                        .background(DarkGreen)
                        .width(120.dp)
                        .height(60.dp)
                        .padding(top = 5.dp)
                        .clickable{ navController.navigate("")}
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_button_white),
                        contentDescription = "home logo",
                        modifier = modifier
                            .size(36.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.home),
                        color = Whites,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 1.sp
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .clip(RoundedCornerShape(18.dp))
                        .background(Green)
                        .width(120.dp)
                        .height(60.dp)
                        .padding(top = 5.dp)
                        .clickable{ navController.navigate("")}
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.book_stand),
                        contentDescription = "tabel logo",
                        modifier = modifier
                            .size(32.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.modul),
                        color = Whites,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 1.sp
                    )
                }
            }
        }
    }
}