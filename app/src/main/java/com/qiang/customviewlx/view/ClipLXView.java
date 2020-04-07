package com.qiang.customviewlx.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.qiang.customviewlx.R;

/**
 * @author qhc
 * @time 2020/4/7
 */
public class ClipLXView extends View {

    public ClipLXView(Context context) {
        super(context);
    }

    public ClipLXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClipLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ClipLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);

        int bitmapWith = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        canvas.drawBitmap(bitmap, 0, 0, paint);

        canvas.save();

        canvas.clipOutRect(new Rect(bitmapWith * 3 / 2 + 10, bitmapHeight * 3 / 10, bitmapWith * 5 / 2 - 40, bitmapHeight * 7 / 10));
        canvas.drawBitmap(bitmap, bitmapWith * 3 / 2, 0, paint);

        canvas.restore();

        //来个五角星
        int length = 260;
        int pointX = (bitmapWith - 30) / 2;
        int pointY = bitmapHeight + 55;

        Path path = new Path();

        path.moveTo(pointX, pointY);

        pointX += Math.sin(Math.PI / 10) * length;
        pointY += Math.cos(Math.PI / 10) * length;
        path.lineTo(pointX, pointY);

        pointX -= Math.cos(Math.PI / 5) * length;
        pointY -= Math.sin(Math.PI / 5) * length;
        path.lineTo(pointX, pointY);

        pointX += length;
        path.lineTo(pointX, pointY);

        pointX -= Math.cos(Math.PI / 5) * length;
        pointY += Math.sin(Math.PI / 5) * length;
        path.lineTo(pointX, pointY);
        path.close();

        canvas.save();
        canvas.clipOutPath(path);
        canvas.drawBitmap(bitmap, 0, bitmapHeight, paint);
        canvas.restore();

    }
}
