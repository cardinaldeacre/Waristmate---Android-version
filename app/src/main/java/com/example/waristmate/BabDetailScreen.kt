package com.example.waristmate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.waristmate.data.BabRepository
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import com.example.waristmate.ui.theme.*

@Composable
fun BottomNavBab(
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
fun BabDetailScreen(
    babId: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val bab = BabRepository.getBabById(babId)
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

    if (bab == null) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Whites),
            contentAlignment = Alignment.Center
        ) {
          Text(text = "Bab dengan ID $babId tidak ditemukan.", color = DarkGreen)
        }
        return
    }

    Box(
        modifier = modifier
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
                painter = painterResource(id = bab.imageResId),
                contentDescription = stringResource(id = bab.titleResId) + " materi",
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
                    text = stringResource(id = bab.titleResId),
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
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
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
                labelResId = R.string.glosarium_button,
                isSelected = false,
                onClick = { navController.navigate("glosarium_screen") }
            )
        }
    }
}
