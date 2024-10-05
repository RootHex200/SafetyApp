package com.hex200.safetyapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun HistoryScreen(scaffoldPadding: PaddingValues){
    Surface {
        Scaffold(
            modifier = Modifier.padding(scaffoldPadding),
            topBar = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(60.dp).background(color = Color.Yellow)) {
                    Spacer(modifier =Modifier.width(40.dp))
                    //app bar back option
                    Icon(modifier = Modifier.width(30.dp).height(30.dp),
                        imageVector =  Icons.Rounded.ArrowBack, contentDescription = "Back arrow icon")
                    Spacer(modifier =Modifier.width(80.dp))
                    //App Bar Title
                    Text("Hisoty Page", style =
                    TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize =18.sp))



                }
            }
        ) {
                padding->
            Spacer(modifier = Modifier.height(20.dp).padding(padding))
            //Card view of history data
            Card(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 20.dp, vertical = 8.dp)
                    .background(color = Color.White).border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(12.dp)),
                onClick = {

                }
            ) {
                Column(
                    modifier = Modifier.padding()
                ) {
                    //Police station Name
                    Text("Police Station Name",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black))
                    Row {
                        Text("Address Details", style = TextStyle(color = Color.Gray, fontSize = 14.sp))
                    }
                }
            }
        }
    }
}

