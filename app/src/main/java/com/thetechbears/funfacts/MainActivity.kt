package com.thetechbears.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thetechbears.funfacts.ui.screens.FunFactsNavigationGraph
import com.thetechbears.funfacts.ui.screens.Routes
import com.thetechbears.funfacts.ui.screens.UserInputScreen
import com.thetechbears.funfacts.ui.screens.WelcomeScreen
import com.thetechbears.funfacts.ui.theme.FunfactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunfactsTheme {
                FunFactApps()
            }
        }
    }

    @Composable
    fun FunFactApps() {
        FunFactsNavigationGraph()
    }
}