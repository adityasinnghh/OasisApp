package com.example.yourapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// --------------------- MENU PAGE ---------------------
@Composable
fun MenuPage() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color(0xFF0E1A3A)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE7ECFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color(0xFF0E1A3A),
                        modifier = Modifier.size(44.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "test",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "1234567893",
                        color = Color(0xFFBDC7FF),
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Menu items (each shows a Toast for now)
        DrawerMenuItem(
            icon = Icons.Default.Home,
            label = "Home",
            onClick = { Toast.makeText(context, "Home clicked", Toast.LENGTH_SHORT).show() }
        )
        DrawerMenuItem(
            icon = Icons.Default.Person,
            label = "Profile",
            onClick = { Toast.makeText(context, "Profile clicked", Toast.LENGTH_SHORT).show() }
        )
        DrawerMenuItem(
            icon = Icons.Default.Lock,
            label = "Change Password",
            onClick = { Toast.makeText(context, "Change Password clicked", Toast.LENGTH_SHORT).show() }
        )
        DrawerMenuItem(
            icon = Icons.Default.Email,
            label = "Send Email",
            onClick = { Toast.makeText(context, "Send Email clicked", Toast.LENGTH_SHORT).show() }
        )
        DrawerMenuItem(
            icon = Icons.Default.Share,
            label = "Share App",
            onClick = { Toast.makeText(context, "Share App clicked", Toast.LENGTH_SHORT).show() }
        )

        Spacer(modifier = Modifier.weight(1f)) // Push logout to bottom

        // Logout button
        DrawerMenuItem(
            icon = Icons.Default.ExitToApp,
            label = "Log Out",
            onClick = { Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show() },
            isLogout = true
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

// --------------------- MENU ITEM ---------------------
@Composable
private fun DrawerMenuItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    isLogout: Boolean = false
) {
    val iconTint = if (isLogout) Color.Red else Color.Black
    val textColor = if (isLogout) Color.Red else Color.Black

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = iconTint,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label, fontSize = 16.sp, color = textColor)
    }
}

// --------------------- PREVIEW ---------------------
@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewMenuPage() {
    MaterialTheme {
        MenuPage()
    }
}