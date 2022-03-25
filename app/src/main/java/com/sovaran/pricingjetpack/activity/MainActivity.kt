package com.sovaran.pricingjetpack.activity

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sovaran.pricingjetpack.R
import com.sovaran.pricingjetpack.ui.theme.PricingJetpackTheme
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PricingJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SetUI(this)
                }
            }
        }

       /* Handler().postDelayed(Runnable {
            startActivity(Intent(this, LoginActivity::class.java))
            //finish()
        }, 2000)*/

    }
}

@Composable
fun SetUI(context: Context) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(0.dp, 60.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val img = painterResource(R.drawable.ic_logo)
        val modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .clickable {
                startActivity(context, Intent(context, LoginActivity::class.java), null)
            }

        //val modifier = Modifier.fillMaxWidth().fillMaxHeight()
        Image(
            painter = img,
            contentDescription = "",
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            modifier = modifier,
        )

        Spacer(modifier = Modifier.height(10.dp))

        val img1 = painterResource(R.drawable.ic_group_tem)
        val modifier1 = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(0.dp, 20.dp, 20.dp, 0.dp)
        //val modifier = Modifier.fillMaxWidth().fillMaxHeight()
        Image(
            painter = img1,
            contentDescription = "",
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            modifier = modifier1
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PricingJetpackTheme {
        //Greeting("Android")
        val context = LocalContext.current
        SetUI(context)
    }
}