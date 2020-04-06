package com.qiang.customviewlx.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.qiang.customviewlx.R;

public class BitMapLXView extends View {

    public BitMapLXView(Context context) {
        super(context);
    }

    public BitMapLXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BitMapLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Bitmap gundamBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.gundam);
        Bitmap gundamLogoBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tr_logo);

        int gundamWith = gundamBitmap.getWidth();
        int gundamHeight = gundamBitmap.getHeight();

        Rect srcRect = new Rect(0, 0, gundamWith, gundamHeight);
        RectF dstRect = new RectF();

        float scale = gundamLogoBitmap.getHeight() * 1.0f / gundamHeight;

        int scaleGundamWith = (int) (scale * gundamWith);
        int scaleGundamHeight = (int) (scale * gundamHeight);

        int rows = getWidth() / scaleGundamWith;
        int colums = getHeight() / scaleGundamHeight;

        float offsetX = getWidth() * 0.5f / rows - scaleGundamWith * 0.5f;
        float offsetY = getHeight() * 0.5f / colums - scaleGundamHeight * 0.5f;

        dstRect.left = offsetX;
        dstRect.top = offsetY;
        dstRect.right = offsetX + scaleGundamWith;
        dstRect.bottom = offsetX + scaleGundamHeight;

        canvas.drawBitmap(gundamBitmap, srcRect, dstRect, paint);

        dstRect.left = offsetX * 3 + scaleGundamWith;
        dstRect.top = offsetY;
        dstRect.right = offsetX * 3 + scaleGundamWith * 2;
        dstRect.bottom = offsetX + scaleGundamHeight;

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(gundamBitmap, srcRect, dstRect, paint);

        dstRect.left = offsetX * 5 + scaleGundamWith * 2;
        dstRect.top = offsetY;
        dstRect.right = offsetX * 5 + scaleGundamWith * 3;
        dstRect.bottom = offsetX + scaleGundamHeight;

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
        canvas.drawBitmap(gundamBitmap, srcRect, dstRect, paint);

        dstRect.left = offsetX;
        dstRect.top = offsetY * 3 + scaleGundamHeight;
        dstRect.right = offsetX + scaleGundamWith;
        dstRect.bottom = offsetX * 3 + scaleGundamHeight * 2;

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
        canvas.drawBitmap(gundamBitmap, srcRect, dstRect, paint);


        dstRect.left = offsetX * 3 + scaleGundamWith;
        dstRect.top = offsetY * 3 + scaleGundamHeight;
        dstRect.right = offsetX * 3 + scaleGundamWith * 2;
        dstRect.bottom = offsetX * 3 + scaleGundamHeight * 2;

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
        canvas.drawBitmap(gundamBitmap, srcRect, dstRect, paint);

        dstRect.left = offsetX * 5 + scaleGundamWith * 2;
        dstRect.top = offsetY * 3 + scaleGundamHeight;
        dstRect.right = offsetX * 5 + scaleGundamWith * 3;
        dstRect.bottom = offsetX * 3 + scaleGundamHeight * 2;

        Rect logSrcRect = new Rect((gundamLogoBitmap.getWidth() - scaleGundamWith) / 2, 0,(gundamLogoBitmap.getWidth() - scaleGundamWith) / 2 + scaleGundamWith, scaleGundamHeight);


        paint.setMaskFilter(null);

        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);

        int save = canvas.saveLayer(dstRect, paint);
        canvas.drawBitmap(gundamBitmap, srcRect, dstRect, paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(gundamLogoBitmap, logSrcRect, dstRect, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(save);
    }


}
