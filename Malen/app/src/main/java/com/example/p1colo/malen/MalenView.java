package com.example.p1colo.malen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


class MalenView extends View implements View.OnTouchListener {

    //Membervariablen
    Bitmap bitmap;
    Canvas leinwand;
    Paint paint = new Paint();
    boolean isInitialized = false;

    float downX, downY, upX, upY;

    //Constructor
    public MalenView(Context c) {
        super(c);

        setFocusable(true);
        setFocusableInTouchMode(true);

        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL); //malen mit kleinen runden Punkt
        paint.setStrokeWidth(8.3f);


        setOnTouchListener(this);
    }


    private void init() {

        bitmap = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.RGB_565);

        leinwand = new Canvas();
        leinwand.setBitmap(bitmap); //Grundierung
        leinwand.drawColor(Color.BLACK); //Hintergrund vom Spiel

        isInitialized = true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (!isInitialized) {
            init();
        }

        canvas.drawBitmap(bitmap,0,0,paint);


    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {

        int action = e.getAction();

        switch (action){
            case MotionEvent.ACTION_DOWN:
                downX = e.getX();
                downY = e.getY();
                leinwand.drawCircle(downX,downY,7,paint);
                break;
            case MotionEvent.ACTION_MOVE:
                upX = e.getX();
                upY = e.getY();
                leinwand.drawLine(downX,downY,upX,upY,paint);
                downX = upX;
                downY = upY;
                break;
            case MotionEvent.ACTION_CANCEL:

                break;
        }

        //leinwand.drawCircle(e.getX(),e.getY(),20,paint);

        invalidate(); //die View ist ungültig geworden, hat Zustandsänderung

        return true;
    }
}
