package com.qiang.customviewlx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.material.internal.ViewUtils;

/**
 * @author qhc
 * @time 2020/4/3
 */
public class CircleView extends View {

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = getWidth() / 5;

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth() / 4, getWidth() / 4, radius, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(ViewUtil.dip2px(getContext(), 5));
        canvas.drawCircle(getWidth() * 3 / 4, getWidth() / 4, radius, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth() / 4, getWidth() * 3 / 4, radius, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth() * 3 / 4, getWidth() * 3 / 4, radius, paint);

        paint.setColor(Color.WHITE);
        canvas.drawCircle(getWidth() * 3 / 4, getWidth() * 3 / 4, radius * 3 / 4, paint);

        Shader shader = new LinearGradient(getWidth() / 4 - radius, getWidth() * 5 / 4 - radius, getWidth() / 4 + radius , getWidth() * 5 / 4 + radius , Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(getWidth() / 4, getWidth() * 5 / 4, radius, paint);
    }
}
