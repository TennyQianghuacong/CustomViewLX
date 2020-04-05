package com.qiang.customviewlx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Xfermode;
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

        Rect textBounds = new Rect();
        paint.getTextBounds(text, 0, text.length() - 3, textBounds);
        textBounds.left += offsetX;
        textBounds.right += offsetX;
        textBounds.top += offsetY;
        textBounds.bottom += offsetY;
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(textBounds, paint);
        paint.setStyle(Paint.Style.FILL);
        float advance = paint.getRunAdvance(text, 0, text.length(), 0, text.length(), false, 2);
        canvas.drawText(text, offsetX, offsetY, paint);
        canvas.drawLine(offsetX + advance, offsetY - 48, offsetX + advance, offsetY, paint);

        paint.setTextSize(48);
        paint.setFakeBoldText(false);
        offsetY += paint.getFontSpacing();
        float textWith = paint.measureText(text);
        canvas.drawLine(offsetX, offsetY, offsetX + textWith, offsetY, paint);
        canvas.drawText(text, offsetX, offsetY, paint);

        text = "自由美利坚，枪战每一天";

        //变色 方式1
        paint.setTextSize(58);
        offsetY += paint.getFontSpacing();

        advance = paint.getRunAdvance(text, 0, text.length(), 0, text.length(), false, 6);
        float advance2 = paint.getRunAdvance(text, 0, text.length(), 0, text.length(), false, 8);

        paint.setColor(Color.BLACK);
        canvas.drawText("自由美利坚，", offsetX, offsetY, paint);
        paint.setColor(Color.RED);
        canvas.drawText("枪战", offsetX + advance, offsetY, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("每一天", offsetX + advance2, offsetY, paint);

        //变色 方式2
        paint.setTextSize(58);
        offsetY += paint.getFontSpacing();
        paint.getTextBounds(text, 0, 2, textBounds);
        textBounds.left = (int) (offsetX +  advance);
        textBounds.right = (int) (offsetX + advance2);
        textBounds.top += offsetY;
        textBounds.bottom += offsetY;

        canvas.drawText(text, offsetX, offsetY, paint);

        canvas.save();
        paint.setColor(Color.RED);
        canvas.clipRect(textBounds);
        canvas.drawText(text, offsetX, offsetY, paint);
        canvas.restore();

        text = "Aa Jj Ââ";
        paint.setTextSize(160);
        offsetY += paint.getFontSpacing() * 2;

        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

        paint.getFontMetrics(fontMetrics);

        textBounds.left = 0;
        textBounds.right = getWidth();
        textBounds.top = (int) (offsetY + fontMetrics.ascent);
        textBounds.bottom = /*(int) (offsetY + fontMetrics.bottom)*/ (int) offsetY;

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ViewUtil.dip2px(getContext(), 3));
        canvas.drawRect(textBounds, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(text, offsetX, offsetY, paint);

        paint.setTextSize(160);
        offsetY += paint.getFontSpacing() * 2;

       /* paint.getTextBounds(text, 0, text.length(), textBounds);
        textBounds.left += offsetX;
        textBounds.right += offsetX;
        textBounds.top += offsetY;
        textBounds.bottom += offsetY;*/


        paint.getFontMetrics(fontMetrics);

        textBounds.left = 0;
        textBounds.right = getWidth();
        textBounds.top = (int) (offsetY + fontMetrics.ascent);
        textBounds.bottom = (int) (offsetY + fontMetrics.bottom);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ViewUtil.dip2px(getContext(), 3));
        canvas.drawRect(textBounds, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(text, offsetX, offsetY, paint);

        paint.setTextSize(160);
        offsetY += paint.getFontSpacing() * 2;

        paint.getTextBounds(text, 0, text.length(), textBounds);
        textBounds.left += offsetX;
        textBounds.right += offsetX;
        textBounds.top += offsetY;
        textBounds.bottom += offsetY;

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ViewUtil.dip2px(getContext(), 3));
        canvas.drawRect(textBounds, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(text, offsetX, offsetY, paint);

    }
}
