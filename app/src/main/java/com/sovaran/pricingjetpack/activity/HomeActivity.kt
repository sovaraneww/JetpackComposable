package com.sovaran.pricingjetpack.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sovaran.pricingjetpack.R
import com.sovaran.pricingjetpack.activity.ui.theme.PricingJetpackTheme
import com.sovaran.pricingjetpack.model.Plant
import com.sovaran.pricingjetpack.ui.theme.Black
import com.sovaran.pricingjetpack.ui.theme.Purple500
import com.sovaran.pricingjetpack.ui.theme.White


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.sovaran.pricingjetpack.ui.theme.PricingJetpackTheme {
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

    var plant: Plant = Plant(
        1,
        "Aloe Vera",
        "It is used in the pharmaceutical industryfor its healing properties and it can often be found in serveral cosmetic products as well.",
        R.drawable.ic_aloe_vera
    )

    var plant1: Plant = Plant(
        1,
        "Rose",
        "Rose is a valuable natural cosmetic ingredient. it contains antibacterial and antioxidants, It's toning and relaxing.",
        R.drawable.ic_rose
    )

    var plant2: Plant = Plant(
        1,
        "Calendula",
        "Calendula helps reducing redness and healing up the skin and it is considered a medicinal plant.",
        R.drawable.ic_calendula
    )

    var platList = ArrayList<Plant>()
    platList.add(plant)
    platList.add(plant1)
    platList.add(plant2)
    platList.add(plant)


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Black,
                title = {
                    Text(
                        stringResource(R.string.app_name),
                        color = White,
                        style = MaterialTheme.typography.body1,
                        fontSize = 20.sp
                    )
                }
            )
        }
    ) {
        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "\uD83C\uDF3F  Plants in Cosmetics",
                        style = MaterialTheme.typography.h3,
                        color = Black,
                        fontSize = 45.sp
                    )
                }
            }
            items(platList) { plant ->
                platList(plant.name, plant.description, plant.imageRes)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    PricingJetpackTheme {
        setUIHome()
    }
}