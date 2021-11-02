package `in`.app.callme.custom_ui

import android.graphics.Color.RED
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

@Preview
@Composable
fun CustomPieChartCompose() {
    val colors = arrayListOf(Color.Red, Color.Blue, Color.Black, Color.DarkGray, Color.Yellow)
    val points = arrayListOf(20f, 30f,500f,700f,500f)

    val totalPoint = points.sum()
    val proportions = points.map {
        it * 100 / totalPoint
    }
    val sweepAngle = proportions.map {
        360 * it / 100
    }
    var startAngle = 270f
    Canvas(modifier = Modifier
        .fillMaxSize()
        .background(White), onDraw = fun DrawScope.() {
        sweepAngle.forEachIndexed { index, sweep ->
            drawArc(color = colors[index], startAngle, sweepAngle = sweep)
            startAngle += sweep
        }
    })
}

fun DrawScope.drawArc(color: Color, startAngle: Float, sweepAngle: Float) {
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false,
        size = Size(250f,250f),
        style = Stroke(
            width = 50f
        )
    )
}