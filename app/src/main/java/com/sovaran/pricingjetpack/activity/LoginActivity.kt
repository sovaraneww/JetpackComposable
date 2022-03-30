package com.sovaran.pricingjetpack.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.resolveDefaults
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.sovaran.pricingjetpack.R
import com.sovaran.pricingjetpack.ui.theme.*
import kotlin.properties.Delegates

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        setContent {
            PricingJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Login(this)
                }
            }
        }
    }
}

@Composable
private fun Login(context: Context) {

    var textEmail by remember { mutableStateOf<String>("") }
    var textPassword by remember { mutableStateOf<String>("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    /*val  modifier = Modifier.verticalScroll(
         state = rememberScrollState())*/

    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .padding(0.dp, 10.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.skip),
            modifier = Modifier
                .align(Alignment.End)
                .padding(10.dp)
                .clickable {
                    ContextCompat.startActivity(
                        context,
                        Intent(context, HomeActivity::class.java),
                        null
                    )
                },
            textAlign = TextAlign.End,
            color = Purple500,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                fontFamily = fonts
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        /*Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "",
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
        )*/

        InfiniteAnimation()

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = stringResource(id = R.string.hello_again),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp),
            textAlign = TextAlign.End,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            style = TextStyle(fontFamily = fonts)
        )

        Text(
            text = stringResource(id = R.string.welcome_back),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 0.dp, start = 20.dp),
            textAlign = TextAlign.Start,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 25.sp,
            style = TextStyle(fontFamily = fonts)
        )

        Surface(
            elevation = 10.dp,
            color = MaterialTheme.colors.surface,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = textEmail,
                onValueChange = {
                    textEmail = it
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Black,
                    textColor = Black,
                    backgroundColor = White,
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = "",
                        tint = Yellow
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.email),
                        style = TextStyle(fontFamily = fonts)
                    )
                }
            )
        }


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 20.dp, end = 20.dp),
            elevation = 10.dp,
            color = MaterialTheme.colors.surface,
            shape = RoundedCornerShape(15.dp)
        ) {
            TextField(modifier = Modifier
                .fillMaxWidth(),
                value = textPassword,
                onValueChange = {
                    textPassword = it
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Black,
                    textColor = Black,
                    backgroundColor = White,
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_password),
                        contentDescription = "",
                        tint = Yellow
                    )
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.password),
                        style = TextStyle(fontFamily = fonts)
                    )
                },
                trailingIcon = {
                    val image = if (passwordVisibility)
                        painterResource(id = R.drawable.ic_eye_hide)
                    else painterResource(id = R.drawable.ic_eye)

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisibility) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(painter = image, description, modifier = Modifier.padding(10.dp))
                    }
                }
            )
        }

        Text(
            text = stringResource(id = R.string.forgot_password),
            color = Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 10.dp, end = 20.dp),
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                fontFamily = fonts
            ),
        )

        Button(
            onClick = {
                ContextCompat.startActivity(
                    context,
                    Intent(context, HomeActivity::class.java),
                    null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple500)
        ) {
            Text(
                text = stringResource(id = R.string.login),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                style = TextStyle(fontFamily = fonts)
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row {

            Text(
                text = stringResource(id = R.string.are_you_new_user),
                color = Black,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = stringResource(id = R.string.register),
                color = Purple500,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(start = 5.dp)
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

    }


}

@Composable
fun InfiniteAnimation() {
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize by infiniteTransition.animateFloat(
        initialValue = 120.0f,
        targetValue = 130.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, delayMillis = 100, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Image(
        painter = painterResource(R.drawable.ic_logo),
        contentDescription = "heart",
        modifier = Modifier
            .size(heartSize.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PricingJetpackTheme {
//        Greeting2("Android")
        val context = LocalContext.current
        Login(context = context)
    }
}