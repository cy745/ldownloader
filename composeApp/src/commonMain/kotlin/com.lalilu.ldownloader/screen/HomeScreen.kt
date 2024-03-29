package com.lalilu.ldownloader.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column(modifier = Modifier.fillMaxSize()) {
            Text("HomeScreen")

            TextButton(onClick = { navigator?.push(LoginScreen) }) {
                Text("Login")
            }
        }
    }
}