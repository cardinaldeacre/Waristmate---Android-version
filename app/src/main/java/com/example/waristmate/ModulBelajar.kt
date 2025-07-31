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
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.example.waristmate.ui.theme.DarkGreen
import com.example.waristmate.ui.theme.Green
import com.example.waristmate.ui.theme.Whites
import com.example.waristmate.ui.theme.LightGreen
import com.example.waristmate.ui.theme.Gold
import com.example.waristmate.ui.theme.Tosca

@Composable
fun ModulBelajar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

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
                    .padding(vertical = 12.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "back button",
                    modifier = modifier
                        .size(32.dp)
                        .clickable { navController.navigate("home_screen") }
                )
                Text(
                    text = stringResource(id = R.string.bab_header),
                    color = Whites,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                )
                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    contentDescription = "waritsmate logo",
                    modifier = modifier
                        .size(40.dp)
                )
            }

            // content list
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .padding(vertical = 5.dp, horizontal = 6.dp)
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = Tosca,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .height(42.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Tosca)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = modifier
                                .padding(start = 12.dp),
                            text = stringResource(R.string.bab_1),
                            color = Whites,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_2),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_3),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_4),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_5),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_6),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_7),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_8),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_9),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_10),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_11),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .padding(vertical = 5.dp, horizontal = 6.dp)
//                        .fillMaxWidth()
//                        .border(
//                            width = 2.dp,
//                            color = Tosca,
//                            shape = RoundedCornerShape(16.dp)
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(7.dp)
//                            .height(42.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .background(Tosca)
//                            .fillMaxWidth(),
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            modifier = modifier
//                                .padding(start = 12.dp),
//                            text = stringResource(R.string.bab_12),
//                            color = Whites,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
                Spacer(
                    modifier = modifier
                        .padding(40.dp)
                )
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
                        .background(DarkGreen)
                        .width(120.dp)
                        .height(60.dp)
                        .padding(top = 5.dp)
                        .clickable{ navController.navigate("")}
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
                        .background(Green)
                        .width(120.dp)
                        .height(60.dp)
                        .padding(top = 5.dp)
                        .clickable{ navController.navigate("home_screen")}
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