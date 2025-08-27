package com.example.oasis

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.oasis.ui.theme.EditProfilePreview
import com.example.oasis.ui.theme.EditProfileScreen
import com.example.oasis.ui.theme.HomeScreen
import com.example.oasis.ui.theme.OASISTheme
import com.example.yourapp.ui.MenuPage

class MainActivity : ComponentActivity() {
    override fun
            onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                HomeScreen()
            }
        }

        }
    }


