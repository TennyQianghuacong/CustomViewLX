package com.qiang.customviewlx.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
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

    //    canvas.drawBitmap(bitmap, 0, 0, paint);

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

        /**
         * 平移和旋转的效果解析
         */
        //平移后再做旋转 和旋转之后再做平移是不一样的两个效果  平移，是按照坐标系平移， 旋转是整个坐标系旋转！
        canvas.save();
        canvas.translate(600 , 0);
        canvas.rotate(45, bitmapWith / 2, bitmapHeight * 3 / 2);

       /*   和上面那种，效果一样，对坐标系的旋转
        canvas.rotate(45, bitmapWith / 2, bitmapHeight * 3 / 2);
        canvas.translate((float) (600 * Math.sin(Math.PI / 4)), (float) (- 600 * Math.sin(Math.PI / 4)));*/
        canvas.clipOutPath(path);
        canvas.drawBitmap(bitmap, 0, bitmapHeight, paint);
        canvas.restore();

        /**
         * scale解析
         */
        //scale(scaleX, scaleY) 是以坐标0,0为点进行缩放
        //scale(scaleX, scaleY, x, y) 是以坐标x,y为点进行缩放  可以拆分成先移动到(x,y), 再以（0,0）为点进行缩放，再平移到（-x,-y)（缩放之后的坐标也是缩放了的）
        canvas.save();
        canvas.scale(0.5f, 0.5f, bitmapWith, bitmapHeight * 2);
        canvas.drawBitmap(bitmap, 0, bitmapHeight , paint);
        canvas.restore();

        //同效果拆分：
        canvas.save();

        canvas.translate(bitmapWith, bitmapHeight * 2);
        canvas.drawBitmap(bitmap, 0, bitmapHeight , paint);

        canvas.scale(0.5f, 0.5f);
        canvas.drawBitmap(bitmap, 0, bitmapHeight , paint);

     /* 这一步执行完之后就是上面的   canvas.scale(0.5f, 0.5f, bitmapWith, bitmapHeight * 2)  效果
        canvas.translate(-bitmapWith, -bitmapHeight * 2);
        canvas.drawBitmap(bitmap, 0, bitmapHeight , paint);*/

        canvas.restore();


        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getWidth());
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.BUTT);
        /**
         * skew
         */
        canvas.save();

        canvas.skew(1f, 1f);
      //  canvas.drawRect(rect, paint);
      //  canvas.drawBitmap(bitmap, 0, 0 , paint);
        canvas.drawPoint(bitmap.getWidth(), bitmap.getWidth(), paint);

        canvas.restore();

        canvas.drawRect(0, 0, bitmap.getWidth(), bitmap.getWidth() * 3, paint);
    }
}
