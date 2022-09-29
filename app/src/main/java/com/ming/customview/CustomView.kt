package com.ming.customview

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat

/**
 * Created by zh on 2022/9/23.
 */
class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val paint: Paint = Paint()
    val textPaint: Paint = Paint()
    val rect: Rect = Rect()
    val rectF: RectF = RectF()
    val points: FloatArray = floatArrayOf(
        0F, 0F, 50F, 50F, 50F, 100F, 100F,
        50F, 100F, 100F, 150F, 50F, 150F, 100F
    )
    val path: Path = Path()

    val text: String =
        "简体/繁体/没有了/无"
    val textStyle: TextPaint = TextPaint()
    val staticLayout: StaticLayout = StaticLayout(
        text,
        textStyle,
        220,
        Layout.Alignment.ALIGN_NORMAL,
        3.7F,
        0F,
        true
    )

    val matrixT: Matrix = Matrix()
    val camera: Camera = Camera()
    var count: Int = 0

    val bitmap: Bitmap

    val animator: ObjectAnimator = ObjectAnimator.ofFloat(this, "progress", 0F, 65F)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.b)
        textStyle.textSize = 56F
        textStyle.isAntiAlias = true
        textStyle.typeface = Typeface.SERIF
        textStyle.isFakeBoldText = true
        textStyle.isStrikeThruText = true
        textStyle.isUnderlineText = true
        textStyle.textSkewX = -0.5F
        textStyle.letterSpacing = 0.2F

        textPaint.color = ContextCompat.getColor(context, R.color.teal_200)
        textPaint.strokeWidth = 30F
        textPaint.style = Paint.Style.STROKE
        textPaint.strokeCap = Paint.Cap.ROUND
        textPaint.strokeJoin = Paint.Join.ROUND
        textPaint.setShadowLayer(5F, 5F, 5F, Color.parseColor("#80000000"))

        paint.color = ContextCompat.getColor(context, R.color.purple_200)
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20F
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeJoin = Paint.Join.ROUND
//        paint.setShadowLayer(
//            5F, 5F, 5F,
//            Color.parseColor("#80BB86FC")
//        )
        animator.duration = 1000
        animator.start()
    }

    var progressX: Float = 65F

    private fun setProgress(progress: Float) {
        Log.e("wtf", "progress=$progress")
        this.progressX = progress
        invalidate()
    }

    private fun setColo(color: Int) {
        Log.e("wtf", "color=$color")
        paint.color = color
        invalidate()
    }

    fun resetCount() {
        count = 0
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        count++
        Log.e("wtf", "onDraw=$count")
//        rectF.set(100F, 100F, 300F, 300F)
        canvas?.let {
//            it.drawColor(Color.parseColor("#80FFFFFF"))
//            it.drawCircle(50F, 50F, 50F, paint)
//            it.drawRect(0F, 110F, 100F, 210F, paint)
//            it.drawPoint(25F, 260F, paint)
//            it.drawPoints(points, 2, 8, paint)
//            it.drawOval(50F, 50F, 200F, 300F, paint)
//            it.drawLine(0F, 0F, 800F, 500F, paint)
//            path.addCircle(100F, 100F, 50F, Path.Direction.CW)
//            path.moveTo(100F, 100F)
//            path.lineTo(300F, 300F)
//            path.rLineTo(200F, 50F)
//            path.rLineTo(200F, -100F)
//            it.drawPath(path, paint)
            it.drawArc(
                100F, 100F,
                800F, 800F,
                0F, 360F,
                false,
                textPaint
            )
            it.drawArc(
                100F, 100F,
                800F, 800F,
                -90F, progressX,
                false,
                paint
            )
//            it.drawText("Text.", 100F, 100F, paint)
//            it.drawText("Text.", 1, 4, 100F, 100F, paint)
//            it.drawTextOnPath(
//                "Hello Text.Hello Text.Hello Text.Hello Text.",
//                path, 0F, -10F, textPaint
//            )

//            it.save()
//            it.clipRect(100F, 100F, 800F, 800F)
//            it.drawBitmap(bitmap, 0F, 0F, null)
//            it.restore()

//            it.save()
//            path.moveTo(100F, 100F)
//            path.lineTo(300F, 300F)
//            path.rLineTo(200F, 50F)
//            path.close()
//            it.clipPath(path)
//            it.drawBitmap(bitmap, 0F, 0F, null)
//            it.restore()

//            it.save()
//            it.clipRect(100F, 100F, 800F, 800F)
//            it.translate(300F, 0F)
//            it.rotate(45F, 500F, 500F)
//            it.scale(2.3f, 2.3f, (bitmap.width / 2).toFloat(), (bitmap.width / 2).toFloat())
//            it.skew(-0.5F, 0F)
//            it.drawBitmap(bitmap, 0F, 0F, null)
//            it.restore()

//            matrixT.reset()
//            matrixT.postTranslate(100F, 0F)
//            matrixT.postRotate(40F, 500F, 500F)

//            canvas.save()
//            canvas.concat(matrixT)
//            canvas.setMatrix(matrixT)
//            camera.save()
//            camera.rotateX(30F)
//            camera.setLocation(0F, 0F, -50F)
//            canvas.translate(800F, 800F)
//            camera.applyToCanvas(canvas)
//            canvas.translate(-800F, -800F)
//            camera.restore()
//
//            canvas.drawBitmap(bitmap, 0F, 0F, null)
//            canvas.restore()
        }
    }
}