package com.qiang.customviewlx.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.qiang.customviewlx.R;

public class ShaderLXView extends View {

    public ShaderLXView(Context context) {
        super(context);
    }

    public ShaderLXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShaderLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ShaderLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Bitmap gundamBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.gundam);
        Bitmap gundamLogoBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tr_logo);

        Shader batManShader = new BitmapShader(gundamBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader batManLogoShader = new BitmapShader(gundamLogoBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader composeShader = new ComposeShader(batManShader, batManLogoShader, PorterDuff.Mode.DST_IN);
        paint.setShader(composeShader);
        canvas.drawRect(0, 0, gundamLogoBitmap.getWidth(), gundamLogoBitmap.getHeight(), paint);

        int gundamWith = gundamBitmap.getWidth();
        int gundamHeight = gundamBitmap.getHeight();

        Rect rect = new Rect(0, 0, gundamWith, gundamHeight);

        float scale = gundamLogoBitmap.getHeight() * 1.0f / gundamHeight;

        int scaleGundamWith = (int) (scale * gundamWith);
        int scaleGundamHeight = (int) (scale * gundamHeight);


        canvas.drawBitmap(gundamBitmap, rect, new Rect(0, gundamLogoBitmap.getHeight(), scaleGundamWith, gundamLogoBitmap.getHeight() + scaleGundamHeight), paint);


    }
}
