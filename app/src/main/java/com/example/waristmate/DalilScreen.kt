// ModulBelajarScreen.kt
package com.example.waristmate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import com.example.waristmate.data.BabRepository
import com.example.waristmate.ui.theme.WaristmateTheme
import com.example.waristmate.ui.theme.DarkGreen
import com.example.waristmate.ui.theme.Green
import com.example.waristmate.ui.theme.Whites

@Composable
fun DalilScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val navbarHeight = 77.dp
    val headerHeight = 70.dp

    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero)}
//    val rotationState = remember { mutableStateOf(0f)}

    val state = rememberTransformableState { zoomChange, offSetChange, rotationChange ->
        scale *= zoomChange
        offset += offSetChange
//        rotationState.value += rotationChange
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Whites)
    ) {
        // --- Materi ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = headerHeight, bottom = navbarHeight),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.dalil),
                contentDescription = "tabel",
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale,
                        translationX = offset.x,
                        translationY = offset.y,
//                    rotationZ = rotationState.value
                    )
                    .transformable(state),
                contentScale = ContentScale.Fit
            )
        }


        // --- Header ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp), //
            horizontalAlignment = Alignment.CenterHorizontally
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
                        .verticalScroll(rememberScrollState())
                )
                Text(
                    text = stringResource(id = R.string.dalil_title),
                    color = Whites,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                )
                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    contentDescription = "waritsmate logo",
                    modifier = Modifier
                        .size(40.dp)
                )
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
                BottomNav(
                    iconResId = R.drawable.books,
                    labelResId = R.string.modul,
                    isSelected = true,
                    onClick = {  }
                )
                BottomNav(
                    iconResId = R.drawable.home_button_white,
                    labelResId = R.string.home,
                    isSelected = false,
                    onClick = { navController.navigate("home_screen") }
                )
                BottomNav(
                    iconResId = R.drawable.book_stand,
                    labelResId = R.string.tabel,
                    isSelected = false,
                    onClick = { navController.navigate("table_screen") }
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun GlosariumScreenPreview() {
    WaristmateTheme {
        DalilScreen(navController = NavController(androidx.compose.ui.platform.LocalContext.current))
    }
}