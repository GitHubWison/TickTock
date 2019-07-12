package studio.dex.project.ticktock.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View

class ClockDial : View {
    private val paint = Paint()

    constructor(context: Context) : super(context, null, 0)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet, def: Int) : super(context, attrs, def) {
        initView()
    }

    private fun initView() {

    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 6f
        paint.isAntiAlias = true
        paint.color = ContextCompat.getColor(context,android.R.color.holo_red_dark)
        canvas?.drawCircle(width.toFloat() / 2f, height.toFloat() / 2f, (width-10f) /2f,paint)
    }
}