// SplashActivity.kt
package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.studentapp.MainActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay to simulate loading time before launching MainActivity
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)  // Splash screen duration (2 seconds)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()  // Close the splash screen activity
        }
    }
}

@Composable
fun SplashScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Todo App",
            style = MaterialTheme.typography.displayLarge,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
