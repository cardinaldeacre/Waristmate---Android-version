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

// --- Data Model Bab ---
data class Bab(val id: Int, val titleResId: Int, val route: String)

// --- Daftar Bab (Data untuk LazyColumn) ---
val babList = listOf(
    Bab(1, R.string.bab_1, "materi_bab_1"),
    Bab(2, R.string.bab_2, "materi_bab_2"),
    Bab(3, R.string.bab_3, "materi_bab_3"),
    Bab(4, R.string.bab_4, "materi_bab_4"),
    Bab(5, R.string.bab_5, "materi_bab_5"),
    Bab(6, R.string.bab_6, "materi_bab_6"),
    Bab(7, R.string.bab_7, "materi_bab_7"),
    Bab(8, R.string.bab_8, "materi_bab_8"),
    Bab(9, R.string.bab_9, "materi_bab_9"),
    Bab(10, R.string.bab_10, "materi_bab_10"),
    Bab(11, R.string.bab_11, "materi_bab_11"),
    Bab(12, R.string.bab_12, "materi_bab_12"),
)

// --- Komponen Reusable: Item Bab ---
@Composable
fun BabItem(
    babText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(vertical = 5.dp, horizontal = 6.dp)
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Tosca,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick),
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
                modifier = Modifier.padding(start = 12.dp),
                text = babText,
                color = Whites,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}


@Composable
fun BottomNavModul(
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
fun ModulBelajarScreen(
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
                    onClick = { navController.navigate("list_module") }
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
fun ModulBelajarScreenPreview() {
    WaristmateTheme {
        ModulBelajarScreen(navController = NavController(androidx.compose.ui.platform.LocalContext.current))
    }
}