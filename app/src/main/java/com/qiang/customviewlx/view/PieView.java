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
        canvas.drawArc(rectF1, - 60 + 0.5f, 60 - 0.5f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.blue_700));
        canvas.drawArc(rectF1, 0 + 0.5f, 120 - 0.5f, true, paint);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.green_700));
        canvas.drawArc(rectF1, 120 + 0.5f, 60 - 0.5f, true, paint);

        float offset = ViewUtil.dip2px(getContext(), 2);
        float offsetX = (float) (offset * Math.sin(Math.PI * 1 / 6));
        float offsetY = (float) (offset * Math.cos(Math.PI * 1 / 6));

        RectF rectF2 = new RectF(rectFWith / 2 - offsetX, getWidth() / 8 - offsetY, rectFWith / 2 + rectFWith - offsetX,  getWidth() / 8 + rectFWith - offsetY);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.red_700));
        canvas.drawArc(rectF2, 180 + 0.5f, 120 - 0.5f, true, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(27);
        canvas.drawText("饼图", rectFWith / 2 + rectFWith /2 * 0.9f, getWidth() * 1.7f/ 8 + rectFWith, paint);

        float horizontalWith = ViewUtil.dip2px(getContext(), 30);

        paint.setStrokeWidth(ViewUtil.dip2px(getContext(), 1));
        float yellowPointStartX = (float) (rectFWith + (rectFWith / 2) * Math.cos(Math.PI * 1 / 6) );
        float yellowPointStartY = (float) (getWidth() / 8 + rectFWith / 2 - rectFWith * Math.sin(Math.PI * 1 / 6) / 2);
        float yellowPointEndX = (float) (rectFWith + (rectFWith / 2) * 1.2 * Math.cos(Math.PI * 1 / 6) );
        float yellowPointEndY = (float) (getWidth() / 8 + rectFWith / 2 - rectFWith * 1.2 * Math.sin(Math.PI * 1 / 6) / 2);

        float[] yellowPoint = {yellowPointStartX, yellowPointStartY, yellowPointEndX, yellowPointEndY, yellowPointEndX, yellowPointEndY, yellowPointEndX + horizontalWith, yellowPointEndY};
        canvas.drawLines(yellowPoint, paint);
        canvas.drawText("yellow", yellowPointEndX + 10, yellowPointEndY - 10, paint);

        float bluePointStartX = (float) (rectFWith + (rectFWith / 2) * Math.cos(Math.PI * 1 / 3) );
        float bluePointStartY = (float) (getWidth() / 8 + rectFWith / 2 + rectFWith * Math.sin(Math.PI * 1 / 3) / 2);
        float bluePointEndX = (float) (rectFWith + (rectFWith / 2) * 1.2 * Math.cos(Math.PI * 1 / 3) );
        float bluePointEndY = (float) (getWidth() / 8 + rectFWith / 2 + rectFWith * 1.2 * Math.sin(Math.PI * 1 / 3) / 2);
        float[] bluePoint = {bluePointStartX, bluePointStartY, bluePointEndX, bluePointEndY, bluePointEndX, bluePointEndY, bluePointEndX + horizontalWith, bluePointEndY};
        canvas.drawLines(bluePoint, paint);
        canvas.drawText("blue", bluePointEndX + 12, bluePointEndY - 10, paint);

        float greenPointStartX = (float) (rectFWith - (rectFWith / 2) * Math.cos(Math.PI * 1 / 6) );
        float greenPointStartY = (float) (getWidth() / 8 + rectFWith / 2 + rectFWith * Math.sin(Math.PI * 1 / 6) / 2);
        float greenPointEndX = (float) (rectFWith - (rectFWith / 2) * 1.2 * Math.cos(Math.PI * 1 / 6) );
        float greenPointEndY = (float) (getWidth() / 8 + rectFWith / 2 + rectFWith * 1.2 * Math.sin(Math.PI * 1 / 6) / 2);
        float[] greenPoint = {greenPointStartX, greenPointStartY, greenPointEndX, greenPointEndY, greenPointEndX, greenPointEndY, greenPointEndX - horizontalWith, greenPointEndY};
        canvas.drawLines(greenPoint, paint);
        canvas.drawText("green", greenPointEndX - horizontalWith + 12, greenPointEndY - 10, paint);

        float redPointStartX = (float) (rectFWith - (rectFWith / 2) * Math.cos(Math.PI * 1 / 3) - offsetX);
        float redPointStartY = (float) (getWidth() / 8 + rectFWith / 2 - rectFWith * Math.sin(Math.PI * 1 / 3) / 2 - offsetY);
        float redPointEndX = (float) (rectFWith - (rectFWith / 2) * 1.2 * Math.cos(Math.PI * 1 / 3) - offsetX);
        float redPointEndY = (float) (getWidth() / 8 + rectFWith / 2 - rectFWith * 1.2 * Math.sin(Math.PI * 1 / 3) / 2 - offsetY);
        float[] redPoint = {redPointStartX, redPointStartY, redPointEndX, redPointEndY, redPointEndX, redPointEndY, redPointEndX - horizontalWith, redPointEndY};
        canvas.drawLines(redPoint, paint);
        canvas.drawText("red", redPointEndX - horizontalWith + 12, redPointEndY - 10, paint);
    }
}
