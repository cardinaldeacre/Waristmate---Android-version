// ModulBelajarScreen.kt
package com.example.waristmate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import com.example.waristmate.ui.theme.WaristmateTheme
import com.example.waristmate.ui.theme.DarkGreen
import com.example.waristmate.ui.theme.Green
import com.example.waristmate.ui.theme.Whites
import com.example.waristmate.ui.theme.Tosca




@Composable
fun BottomNavGlosarium(
    iconResId: Int,
    labelResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(if (isSelected) DarkGreen else Green)
            .width(120.dp)
            .height(60.dp)
            .padding(top = 5.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = stringResource(id = labelResId),
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = stringResource(id = labelResId),
            color = Whites,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 1.sp
        )
    }
}

@Composable
fun GlosariumScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Whites)
    ) {
        // --- Header ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
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
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { navController.popBackStack() }
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
                    modifier = Modifier
                        .size(40.dp)
                )
            }
            // --- Content List (Daftar Bab) ---
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp, horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(babList) { bab ->
                    BabItem(
                        babText = stringResource(id = bab.titleResId),
                        onClick = { navController.navigate(bab.route) }
                    )
                }
            }
        }
        // --- Navbar Bottom ---
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
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomNavModul(
                    iconResId = R.drawable.books,
                    labelResId = R.string.modul,
                    isSelected = true,
                    onClick = {  }
                )
                BottomNavModul(
                    iconResId = R.drawable.home_button_white,
                    labelResId = R.string.home,
                    isSelected = false,
                    onClick = { navController.navigate("home_screen") }
                )
                BottomNavModul(
                    iconResId = R.drawable.book_stand,
                    labelResId = R.string.modul,
                    isSelected = false,
                    onClick = { navController.navigate("glosarium_screen") }
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun GlosariumScreenPreview() {
    WaristmateTheme {
        GlosariumScreen(navController = NavController(androidx.compose.ui.platform.LocalContext.current))
    }
}