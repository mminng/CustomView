package com.ming.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

/**
 * Created by zh on 2022/9/23.
 */
class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val paint: Paint = Paint()
    val rect: Rect = Rect()
    val rectF: RectF = RectF()
    val points: FloatArray = floatArrayOf(
        0F, 0F, 50F, 50F, 50F, 100F, 100F,
        50F, 100F, 100F, 150F, 50F, 150F, 100F
    )

    init {
        paint.color = ContextCompat.getColor(context, R.color.purple_200)
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10F
        paint.strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rectF.set(100F, 100F, 300F, 300F)
        canvas?.let {
//            it.drawColor(Color.parseColor("#80FFFFFF"))
//            it.drawCircle(50F, 50F, 50F, paint)
//            it.drawRect(0F, 110F, 100F, 210F, paint)
//            it.drawPoint(25F, 260F, paint)
//            it.drawPoints(points, 2, 8, paint)
//            it.drawOval(50F, 50F, 200F, 300F, paint)
            it.drawLine(200F, 200F, 800F, 500F, paint)
        }
    }
}