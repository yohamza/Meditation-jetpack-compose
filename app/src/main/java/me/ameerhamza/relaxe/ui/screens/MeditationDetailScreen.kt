package me.ameerhamza.relaxe.ui.screens

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.google.gson.Gson
import me.ameerhamza.relaxe.R
import me.ameerhamza.relaxe.data.Feature
import me.ameerhamza.relaxe.ui.components.FeatureItem
import me.ameerhamza.relaxe.ui.theme.*


@Composable
fun MeditationDetailScreen(feature: Feature?) {

    val features = listOf(
        Feature(
            title = "Night island",
            R.drawable.ic_headphone,
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ),
        Feature(
            title = "Calming sounds",
            R.drawable.ic_headphone,
            Beige1,
            Beige2,
            Beige3
        ),
        Feature(
            title = "Sleep meditation",
            R.drawable.ic_headphone,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Feature(
            title = "Tips for sleeping",
            R.drawable.ic_videocam,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        Feature(
            title = "Sleep meditation",
            R.drawable.ic_headphone,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Feature(
            title = "Tips for sleeping",
            R.drawable.ic_videocam,
            LightGreen1,
            LightGreen2,
            LightGreen3
        )
    )

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    ToolBar()
                }
                item {
                    DetailsSection(feature)
                }
                item {
                    Divider(color = AquaBlue, thickness = 1.dp, modifier = Modifier.padding(15.dp))
                }
                item {
                    Text(
                        text = "Related",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.padding(15.dp)
                    )
                }
                item {
                    val itemSize: Dp = LocalConfiguration.current.screenWidthDp.dp / 2
                    RelatedSection(
                        features = features,
                        itemSize = itemSize
                    )
                }

            }
        }

}

@Composable
fun ToolBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "back",
            tint = TextWhite,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "favourite",
            tint = TextWhite,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun DetailsSection(feature: Feature?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = feature?.title ?: "Sleep Meditation",
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Best Practice Meditations",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(10.dp))
        FeatureItem(
            feature = feature,
            showTitle = false,
            modifier = Modifier
                .aspectRatio(1.3f)
        ) {

        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Sleep Music   -   45 min",
        modifier = Modifier.padding(horizontal = 15.dp),
        fontSize = 12.sp,
        color = AquaBlue
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Erase the mind into a restful night's sleep\nwith these deep, amblent tones",
        modifier = Modifier.padding(horizontal = 15.dp),
        fontSize = 14.sp,
        color = AquaBlue
    )
    Spacer(modifier = Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "favourites",
                tint = TextWhite,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "12,425 Saved",
                fontSize = 12.sp,
                color = TextWhite
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_music),
                contentDescription = "listening",
                tint = TextWhite,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "43,453 Listening",
                fontSize = 12.sp,
                color = TextWhite
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RelatedSection(
    features: List<Feature>,
    itemSize: Dp
) {
        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly
        )
        {
            features.forEachIndexed { index, _ ->
                FeatureItem(
                    feature = features[index],
                    modifier = Modifier
                        .size(itemSize)
                        .aspectRatio(1f)
                        .padding(7.5.dp)
                ) {

                }
            }
       }

    }