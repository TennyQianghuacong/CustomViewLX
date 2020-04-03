package com.qiang.customviewlx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.qiang.customviewlx.R;

/**
 * @author qhc
 * @time 2020/4/3
 */
public class PieView extends View {

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        float rectFWith = getWidth() / 2;

        RectF rectF1 = new RectF(rectFWith / 2, getWidth() / 8, rectFWith / 2 + rectFWith,  getWidth() / 8 + rectFWith);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.yellow_500));
        canvas.drawArc(rectF1, - 30 + 0.5f, 30 - 0.5f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.blue_700));
        canvas.drawArc(rectF1, 0 + 0.5f, 120 - 0.5f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.green_700));
        canvas.drawArc(rectF1, 120 + 0.5f, 60 - 0.5f, true, paint);

        float offset = ViewUtil.dip2px(getContext(), 2);
        float offsetX = (float) (offset * Math.sin(Math.PI * 1 / 6));
        float offsetY = (float) (offset * Math.cos(Math.PI * 1 / 6));

        RectF rectF2 = new RectF(rectFWith / 2 - offsetX, getWidth() / 8 - offsetY, rectFWith / 2 + rectFWith - offsetX,  getWidth() / 8 + rectFWith - offsetY);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.red_700));
        canvas.drawArc(rectF2, 180 + 0.5f, 150 - 0.5f, true, paint);
    }
}
