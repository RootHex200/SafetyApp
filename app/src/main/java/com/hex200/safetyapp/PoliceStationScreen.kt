package com.hex200.safetyapp
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.hex200.safetyapp.ui.common.GoogleMapView
import kotlinx.coroutines.launch
@Composable

fun PoliceStationScreen(scaffoldPadding:PaddingValues){
    val singapore = LatLng(1.35, 103.87)

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
                    Text("Police Station Page", style =
                    TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize =18.sp))



                }
            }
        ) {
                padding->
            Spacer(modifier = Modifier.height(20.dp).padding(padding))
            //history listview item
            LazyColumn (
                modifier = Modifier.padding(top = padding.calculateTopPadding()),
                content = {
                    items(10, itemContent = {
                        val singaporeMarkerState = rememberMarkerState(position = singapore)
                        val cameraPositionState = rememberCameraPositionState {
                            position = CameraPosition.fromLatLngZoom(singapore, 15f)
                        }
                        Card(
                            modifier = Modifier

                                .fillMaxWidth()
                                .height(300.dp)
                                .padding(horizontal = 20.dp, vertical = 8.dp)
                                .background(color = Color.White).border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(12.dp)),
                            onClick = {

                            }
                        ) {
                            Column(
                                modifier = Modifier.padding(top = 15.dp, end = 10.dp, start = 10.dp, bottom = 10.dp)
                            ) {
                                //Police station Name
                                Text("Police Station Name$it",
                                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black))
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Icon(Icons.Rounded.LocationOn, contentDescription = "")
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Address Details", style = TextStyle(color = Color.Gray, fontSize = 14.sp))
                                }
                                Spacer(modifier = Modifier.height(7.dp))

                                //GOOGle Map Link
                                Box(
                                    modifier = Modifier.padding(7.dp).fillMaxWidth().fillMaxHeight().clip(shape = RoundedCornerShape(12.dp)).background(color = Color.Gray)
                                ) {
                                    GoogleMapView(cameraPositionState,singaporeMarkerState)
//
                                }
                            }
                        }
                    })
                })

        }
    }
}