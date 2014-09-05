package com.general5.drawingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class DrawingView extends View {
    private Paint paint;
    private Path path;


    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.path = new Path();

        this.paint = new Paint();
        paint.setColor(Color.RED);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            this.path.moveTo(x, y);
            break;
        case MotionEvent.ACTION_MOVE:
            this.path.lineTo(x, y);
            break;
        case MotionEvent.ACTION_UP:
            this.path.lineTo(x, y);
            break;
        }
        invalidate();
        return true;
    }

    public void delete() {
        this.path.reset();
        invalidate();
    }
}
