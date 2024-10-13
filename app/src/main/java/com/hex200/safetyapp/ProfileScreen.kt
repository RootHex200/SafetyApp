package com.hex200.safetyapp

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.hex200.safetyapp.ui.theme.editProfileButtonColor
import com.hex200.safetyapp.ui.theme.editProfileShadwoColor
import com.hex200.safetyapp.ui.theme.profileCardbackgroundcolor
import com.hex200.safetyapp.ui.theme.sosCustomizationButtonColor
import com.hex200.safetyapp.ui.theme.sosCustomizationShadowColor


@Composable

fun ProfileScreen(scaffoldPadding: PaddingValues){
    val selectedImage= remember { mutableStateOf<Uri?>(null) }

    val photoPicker= rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            selectedImage.value=it
        }
    )

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
                Text("Profile Page", style =
                TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize =18.sp)
                )



            }
        }
    ) {padding->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = padding.calculateTopPadding(), start = 20.dp, end = 20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            //Spacer(modifier = Modifier.height(10.dp))
            //Profile Image part
            Box (
                modifier = Modifier.height(150.dp).width(150.dp).
            clip(shape = CircleShape).
            background(color = Color.Gray).align(alignment = Alignment.CenterHorizontally).clickable {
                photoPicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                },){
                AsyncImage(
                    model = selectedImage.value,
                    contentDescription = null

                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            //user Name
            Text("Sabitur Rahmna", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))
            Spacer(modifier = Modifier.height(10.dp))

            Row (
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    //edit profile
                    Box(
                        modifier = Modifier
                            .border(width = 3.dp, color = editProfileShadwoColor, shape = CircleShape)
                            .clip(shape = CircleShape)
                            .background(color = editProfileButtonColor),
                        contentAlignment = Alignment.Center,
                        content = {
                            Row(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text("Edit Profile", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp))
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(Icons.Rounded.Edit, contentDescription = "")
                            }
                        })
                    //Spacer(modifier = Modifier.width(20.dp))
                    Box(
                        modifier = Modifier
                            .border(width = 3.dp, color = sosCustomizationShadowColor, shape = CircleShape)
                            .clip(shape = CircleShape)
                            .background(color = sosCustomizationButtonColor),
                        contentAlignment = Alignment.Center,
                        content = {
                            Row(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,

                                ) {
                                Text("sos customize", style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp))
                            }
                        })
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
            //information card
            Card(
                modifier = Modifier

                    //.height(500.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(13.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = profileCardbackgroundcolor
                ),
                content = {
                    Column(
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
                        content = {
                            Text("Email", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                            Text("sabiturrahman60@gmail.com", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))
                            Text("State", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                            Text("Chattogram", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))
                            Text("City", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                            Text("Cumilla", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))
                            Text("Pin/Zip Code", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                            Text("3620", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))
                            Text("Address", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                            Text("Boloram pur ,kotbari road, cumilla", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))
                        }
                    )
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier

                    //.height(500.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(13.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = profileCardbackgroundcolor
                ),
                content = {
                    Column(
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
                        content = {
                            Row (
                                horizontalArrangement = Arrangement.SpaceBetween,

                            ){
                                Text("Emergency contract", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Box(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp).clip(shape = RoundedCornerShape(15.dp)).background(color = editProfileButtonColor),
                                    content = {
                                        Text("Family", style = TextStyle(fontWeight = FontWeight.Bold))
                                    }
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text("Phone", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                            Text("+8801750695930", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))
                            Text("Whats App", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 19.sp))
                            Text("+8801750695930", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp))

                        }
                    )
                }
            )

            
        }

    }
}
@Preview
@Composable

fun Previews(){
    ProfileScreen(scaffoldPadding = PaddingValues(10.dp))
}