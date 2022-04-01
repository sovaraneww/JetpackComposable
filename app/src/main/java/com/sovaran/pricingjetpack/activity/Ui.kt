package com.sovaran.pricingjetpack.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sovaran.pricingjetpack.activity.ui.theme.PricingJetpackTheme
import com.sovaran.pricingjetpack.R
import com.sovaran.pricingjetpack.ui.theme.Black

@Composable
fun platList(name: String, des: String, plant: Int) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = plant),
                contentDescription = null,
                modifier = Modifier.size(130.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )

            Column(Modifier.padding(8.dp)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = des,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    PricingJetpackTheme {
        platList(name = "Aloe Vera", des = "It is used in the pharmaceutical industryfor its healing properties and it can often be found in serveral cosmetic products as well.", plant = R.drawable.ic_aloe_vera)
    }
}