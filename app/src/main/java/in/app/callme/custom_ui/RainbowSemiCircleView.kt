package `in`.app.callme.custom_ui

import `in`.app.callme.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.View
import androidx.core.content.ContextCompat

class RainbowSemiCircleView(context: Context) : View(context) {

    private val paint: Paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.color = ContextCompat.getColor(context, R.color.black)
        paint.style = Paint.Style.STROKE

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

}