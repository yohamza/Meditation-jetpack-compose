package me.ameerhamza.relaxe.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ameerhamza.relaxe.R
import me.ameerhamza.relaxe.data.Feature
import me.ameerhamza.relaxe.ui.theme.*
import me.ameerhamza.relaxe.util.standardQuadTo

@Composable
fun FeatureItem(
    feature: Feature?,
    showTitle: Boolean = true,
    modifier: Modifier,
    onItemClick: () -> Unit
) {
    BoxWithConstraints(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(feature?.darkColor ?: BlueViolet3)
            .clickable { onItemClick() }

    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium colored path
        val mediumColoredPoint1 = Offset(x = 0f, y = height * 0.3f)
        val mediumColoredPoint2 = Offset(x = width * 0.1f, y = height * 0.35f)
        val mediumColoredPoint3 = Offset(x = width * 0.4f, y = height * 0.05f)
        val mediumColoredPoint4 = Offset(x = width * 0.75f, y = height * 0.7f)
        val mediumColoredPoint5 = Offset(x = width * 1.4f, y = -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadTo(from= mediumColoredPoint1, to= mediumColoredPoint2)
            standardQuadTo(from= mediumColoredPoint2, to= mediumColoredPoint3)
            standardQuadTo(from= mediumColoredPoint3, to= mediumColoredPoint4)
            standardQuadTo(from= mediumColoredPoint4, to= mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadTo(lightPoint1, lightPoint2)
            standardQuadTo(lightPoint2, lightPoint3)
            standardQuadTo(lightPoint3, lightPoint4)
            standardQuadTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature?.mediumColor ?: BlueViolet2
            )
            drawPath(
                path = lightColoredPath,
                color = feature?.lightColor ?: BlueViolet1
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            if(showTitle) {
                Text(
                    text = feature?.title ?: "Sleep Meditation",
                    style = MaterialTheme.typography.h2,
                    lineHeight = 26.sp,
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }

            Icon(
                painter = painterResource(id = feature?.iconId ?: R.drawable.ic_music),
                contentDescription = feature?.title ?: "Sleep",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {

                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(horizontal = 15.dp, vertical = 6.dp)
            )
        }
    }
}