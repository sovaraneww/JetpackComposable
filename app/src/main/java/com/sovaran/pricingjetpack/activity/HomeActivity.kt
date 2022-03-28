package com.sovaran.pricingjetpack.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sovaran.pricingjetpack.activity.ui.theme.PricingJetpackTheme
import com.sovaran.pricingjetpack.ui.theme.Black

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PricingJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    setUIHome()
                }
            }
        }
    }
}

@Composable
fun setUIHome() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Text(text = "Hello")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    PricingJetpackTheme {
        setUIHome()
    }
}