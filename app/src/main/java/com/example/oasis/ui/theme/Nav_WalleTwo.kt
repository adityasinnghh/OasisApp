package com.example.oasis.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oasis.R
import kotlin.math.max

@Composable
fun HomeScreen() {
    val itemsList = List(30) { "Item #$it" } // Fake content
    val gridState = rememberLazyGridState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.blue),
                            colorResource(id = R.color.blue_light)
                        )
                    )
                )
        ) {
            // 🔹 Wallet Banner Card (as per screenshot)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(180.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.coin_bgm_img), // replace with your orange bg image
                        contentDescription = "Wallet Card Background",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Available Balance",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "00000",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        // Trophy icon
                        Image(
                            painter = painterResource(id = R.drawable.coin_bgm_img), // replace with your trophy drawable
                            contentDescription = "Trophy",
                            modifier = Modifier.size(60.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 🔹 Modern Grid Items
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                state = gridState,
                modifier = Modifier.fillMaxSize()
            ) {
                items(itemsList) { label ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color(0xFF90CAF9),
                                            Color(0xFF42A5F5)
                                        )
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = label,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

        // 🔹 Modern Scrollbar (unchanged)
        ModernScrollbar(
            gridState = gridState,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .padding(end = 6.dp)
        )
    }
}

@Composable
fun ModernScrollbar(gridState: androidx.compose.foundation.lazy.grid.LazyGridState, modifier: Modifier = Modifier) {
    val totalItems = gridState.layoutInfo.totalItemsCount
    val visibleItems = gridState.layoutInfo.visibleItemsInfo.size
    if (totalItems == 0 || visibleItems == 0) return

    val firstVisibleItemIndex = gridState.firstVisibleItemIndex
    val scrollProgress =
        firstVisibleItemIndex.toFloat() / max(1f, (totalItems - visibleItems).toFloat())

    Box(
        modifier = modifier
            .width(8.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.Gray.copy(alpha = 0.15f)) // Track
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp) // Thumb size
                .align(Alignment.TopCenter)
                .offset(y = ((scrollProgress * 250).dp)) // Moves dynamically
                .clip(CircleShape)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF2196F3),
                            Color(0xFF1976D2)
                        )
                    )
                )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHome() {
    HomeScreen()
}
