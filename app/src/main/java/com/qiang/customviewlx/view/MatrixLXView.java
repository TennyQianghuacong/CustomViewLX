package com.qiang.customviewlx.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.qiang.customviewlx.R;

/**
 * @author qhc
 * @time 2020/4/9
 */
public class MatrixLXView extends View {

    public MatrixLXView(Context context) {
        super(context);
    }

    public MatrixLXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MatrixLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MatrixLXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // Matrix setXXX 首先会将该Matrix重置为单位矩阵，即相当于首先会调用reset()方法，然后再设置该Matrix中对应功能的值

    // [1.0, 0.0, 0.0]
    // [0.0, 1.0, 0.0]
    // [0.0, 0.0, 1.0]
    // Matrix matrix = new Matrix();

    // [1.0, 0.0, 0.0]    [2.0, 3.0, 4.0]
    // [0.0, 1.0, 0.0] -> [2.0, 0.0, 0.0]
    // [0.0, 0.0, 1.0]    [1.0, 1.0, 1.0]
    // matrix.setValues(new float[]{2.0f,3.0f, 4.0f,2.0f,0.0f, 0.0f,1.0f,1.0f,1.0f});

    // [2.0, 3.0, 4.0]    [1.0, 0.0, 0.0]    [2.0, 0.0, 0.0]
    // [2.0, 2.0, 0.0] -> [0.0, 1.0, 0.0] -> [0.0, 2.0, 0.0]
    // [1.0, 1.0, 1.0]    [0.0, 0.0, 1.0]    [0.0, 0.0, 1.0]
    // matrix.setScale(2,2);

    // preXXX 不会重置Matrix，相当于当前操作矩阵(A)左乘参数矩阵(B)，即AB

    // [1.0, 0.0, 0.0]
    // [0.0, 1.0, 0.0]
    // [0.0, 0.0, 1.0]
    // Matrix matrix = new Matrix();

    // [1.0, 0.0, 0.0]    [2.0, 3.0, 4.0]
    // [0.0, 1.0, 0.0] -> [2.0, 0.0, 0.0]
    // [0.0, 0.0, 1.0]    [1.0, 1.0, 1.0]
    // matrix.setValues(new float[]{2.0f,3.0f, 4.0f,2.0f,0.0f, 0.0f,1.0f,1.0f,1.0f});

    // [2.0, 3.0, 4.0]           [2.0, 0.0, 0.0]   [4.0, 6.0, 4.0]
    // [2.0, 0.0, 0.0](matrix) * [0.0, 2.0, 0.0] = [4.0, 0.0, 0.0](matrix)
    // [1.0, 1.0, 1.0]           [0.0, 0.0, 1.0]   [2.0, 2.0, 1.0]
    // matrix.preScale(2,2);

    // postXXX 不会重置Matrix，相当于当前操作矩阵(A)右乘参数矩阵(B)，即BA
    // [1.0, 0.0, 0.0]
    // [0.0, 1.0, 0.0]
    // [0.0, 0.0, 1.0]
    // Matrix matrix = new Matrix();

    // [1.0, 0.0, 0.0]    [2.0, 3.0, 4.0]
    // [0.0, 1.0, 0.0] -> [2.0, 0.0, 0.0]
    // [0.0, 0.0, 1.0]    [1.0, 1.0, 1.0]
    // matrix.setValues(new float[]{2.0f,3.0f, 4.0f, 2.0f,0.0f, 0.0f,1.0f,1.0f,1.0f});

    // [2.0, 0.0, 0.0]   [2.0, 3.0, 4.0]            [4.0, 6.0, 8.0]
    // [0.0, 2.0, 0.0] * [2.0, 0.0, 0.0] (matrix) = [4.0, 0.0, 0.0](matrix)
    // [0.0, 0.0, 1.0]   [1.0, 1.0, 1.0]            [1.0, 1.0, 1.0]
    // matrix.postScale(2,2);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);

        int bitmapWith = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        Matrix matrix = new Matrix();

        int left = getWidth() / 2 - bitmapWith / 2;
        int top = getHeight() / 2 - bitmapHeight / 2;
        int right = left + bitmapWith;
        int bottom = top + bitmapHeight;



    }
}
