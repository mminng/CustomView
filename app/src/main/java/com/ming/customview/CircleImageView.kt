package com.ming.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView

/**
 * Created by zh on 2022/9/30.
 */
@SuppressLint("AppCompatCustomView")
class CircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ImageView(context, attrs) {

    private var _bitmap: Bitmap? = null
    private var _bitmapShader: BitmapShader? = null
    private val paint: Paint = Paint()
    private val shaderMatrix: Matrix = Matrix()
    private var _rectF: RectF? = null
    private var _radius: Float = 0F

    init {
        Log.e("wtf", "init")
        paint.shader = _bitmapShader
        paint.isAntiAlias = true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.e("wtf", "onMeasure")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.e("wtf", "onSizeChanged new=$w/$h")
        Log.e("wtf", "onSizeChanged old=$oldw/$oldh")

        val availableWidth = w
        val availableHeight = h
        val sideLength = availableWidth.coerceAtMost(availableHeight)
        val left: Float = (availableWidth - sideLength) / 2F
        val top: Float = (availableHeight - sideLength) / 2F
        _rectF = RectF(left, top, left + sideLength, top + sideLength)
        _radius = (_rectF!!.width() / 2.0F).coerceAtMost(_rectF!!.height() / 2.0F)

        var scale: Float
        var dx: Float = 0F
        var dy: Float = 0F
        _bitmap?.let {
            if (it.width * _rectF!!.height() > it.height * _rectF!!.width()) {
                scale = _rectF!!.height() / it.height
                dx = (_rectF!!.width() - it.width * scale) * 0.5F
            } else {
                scale = _rectF!!.width() / it.width
                dy = (_rectF!!.height() - it.height * scale) * 0.5F
            }
            shaderMatrix.reset()
            shaderMatrix.setScale(scale, scale)
            shaderMatrix.postTranslate(
                (dx + 0.5F) + _rectF!!.left,
                (dy + 0.5F) + _rectF!!.top
            )
            _bitmapShader?.setLocalMatrix(shaderMatrix)
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.e("wtf", "onLayout left=$left，top=$top，right=$right，bottom=$bottom")
    }

    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
        _rectF?.let {
            canvas?.drawCircle(
                it.centerX(),
                it.centerY(),
                _radius,
                paint
            )
            Log.e("wtf", "onDraw")
        }
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        Log.e("wtf", "setImageDrawable")
        _bitmap = (this.drawable as BitmapDrawable).bitmap
        _bitmap?.let {
            Log.e("wtf", "init bitmapShader")
            _bitmapShader = BitmapShader(it, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint?.shader = _bitmapShader
        }
        invalidate()
    }

    override fun setImageResource(resId: Int) {
        super.setImageResource(resId)
        Log.e("wtf", "setImageResource")
        _bitmap = (drawable as BitmapDrawable).bitmap
        _bitmap?.let {
            Log.e("wtf", "init bitmapShader")
            _bitmapShader = BitmapShader(it, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.shader = _bitmapShader
        }
        invalidate()
    }

    private fun getBitmap(drawable: Drawable): Bitmap {
        val bitmap: Bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas: Canvas = Canvas(bitmap)

        return bitmap
    }
}