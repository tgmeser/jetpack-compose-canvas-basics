package com.babyapps.canvasbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.babyapps.canvasbasics.ui.theme.CanvasBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCanvas()
        }
    }
}

@Composable
fun SimpleCanvas(
) {

    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(20.dp)
    ) {
        drawRect(color = Color.Blue, size = size)
        drawRect(
            color = Color.Red,
            size = Size(400f, 400f),
            topLeft = Offset(100f, 100f),
            style = Stroke(
                //width = 5f,
                // 5 pixel , 5f' den daha büyük görüntü oluşturuyor, Yani px ve f eşit olmuyor
                width = 5.dp.toPx(),

                )
        )
        drawCircle(

            // Gradient alan brush ile ayarlıyor
            brush = Brush.radialGradient(
                colors = listOf(Color.Red, Color.Yellow),
                center = center,
                radius = 100f
            ),
            // radius = 200f,  <---- Dışardaki yarıçap daha büyük olursa gradient kısım küçük kalır
            radius = 100f,
            // center = center  <---- Bu işleme gerek yok default olarak sağlanıyor
        )

        // Pasta
        drawArc(
            color = Color.Green,
            startAngle = 0f, // Yayın çizilmeye başlanacağı açı 0 derece
            sweepAngle = 270f, // Yay 270 derece açıya kadar çizilecek
            useCenter = true,
            topLeft = Offset(100f, 500f),
            size = Size(200f, 200f),
        )

        // ProgressBar gibi
        drawArc(
            color = Color.Cyan,
            startAngle = 0f, // Yayın çizilmeye başlanacağı açı 0 derece
            sweepAngle = 270f, // Yay 270 derece açıya kadar çizilecek
            useCenter = true,
            topLeft = Offset(500f, 500f),
            size = Size(200f, 200f),
            style = Stroke(
                width = 3.dp.toPx()
            )

        )

        //Oval
        drawOval(
            color = Color.Red,
            topLeft = Offset(500f,100f),
            size = Size(200f,200f)
        )


        // Çizgi
        drawLine(
            color = Color.White,
            start = Offset(300f,700f),
            end = Offset(700f,700f),
            strokeWidth = 5.dp.toPx()

        )
    }


}