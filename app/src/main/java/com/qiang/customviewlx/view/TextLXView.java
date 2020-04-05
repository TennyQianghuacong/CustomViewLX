package com.qiang.customviewlx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class TextLXView extends View {

    public TextLXView(Context context) {
        super(context);
    }

    public TextLXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TextLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Hello world!";

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        float offsetX = 100;
        float offsetY = 0;

        paint.setTextSize(30);
        paint.setFakeBoldText(false);
        offsetY += paint.getFontSpacing();
        canvas.drawText(text, offsetX, offsetY, paint);

        paint.setTextSize(36);
        paint.setFakeBoldText(true);
        offsetY += paint.getFontSpacing();
        canvas.drawText(text, offsetX, offsetY, paint);

        paint.setTextSize(48);
        paint.setFakeBoldText(false);
        offsetY += paint.getFontSpacing();
        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));
        canvas.drawText(text, offsetX, offsetY, paint);

        paint.setTextSize(48);
        paint.setFakeBoldText(false);
        offsetY += paint.getFontSpacing();
        paint.setTypeface(Typeface.DEFAULT);
        float advance = paint.getRunAdvance(text, 0, text.length(), 0, text.length(), false, text.length());
        canvas.drawText(text, offsetX, offsetY, paint);
        canvas.drawLine(offsetX + advance, offsetY - 48, offsetX + advance, offsetY, paint);

        paint.setTextSize(48);
        paint.setFakeBoldText(false);
        offsetY += paint.getFontSpacing();
        float textWith = paint.measureText(text);
        canvas.drawLine(offsetX, offsetY, offsetX + textWith, offsetY, paint);
        canvas.drawText(text, offsetX, offsetY, paint);

    }
}
