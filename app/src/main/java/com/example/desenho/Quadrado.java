package com.example.desenho;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.ColorInt;

public class Quadrado extends View{
    private final float x;
    private final float y;
    private final float f;
    private final float r; // raio do circulo
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Quadrado(Context context, float x, float y, float f, float r, int color) {
        super(context);
        this.x = x;
        this.y = y;
        this.f = f;
        this.r = r;
        //definir a cor base
        mPaint.setColor(color); // cor
    }



    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //desenha um circulo
        canvas.drawRect(x,y,f,r,mPaint);
    }

}