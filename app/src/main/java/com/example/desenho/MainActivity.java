package com.example.desenho;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout main;
    private Button btn,btn2,btn3,btn4,btn5,changeColor,btn7;
    private TextView textView,changeCo;
    private int forma = 1;
    private int color = 1;
    private int setColor = 0xFF2e5aff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obter o id da view
        main = (FrameLayout) findViewById (R.id.frag_view);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        changeColor = findViewById(R.id.changeColor);
        btn7 = findViewById(R.id.btn7);
        textView = findViewById(R.id.texto1);
        changeColor.setBackgroundColor(0xFF2e5aff);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forma = forma+1;

                if (forma == 5){textView.setText("Bola");}
                if (forma == 2){textView.setText("Quadrado");}
                if (forma == 3){textView.setText("Circulo Oval");}
                if (forma == 4){textView.setText("Linha");}


                if (forma == 5){forma = 1;}
            }
        });

        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color +1;
                if (color == 5){ setColor = 0xFF2e5aff;changeColor.setBackgroundColor(0xFF2e5aff);changeColor.setText("Azul");}
                if (color == 2){ setColor = 0xFFff0006;changeColor.setBackgroundColor(0xFFff0006);changeColor.setText("Vermelho");}
                if (color == 3){ setColor = 0xFF8657c5;changeColor.setBackgroundColor(0xFF8657c5);changeColor.setText("Roxo");}
                if (color == 4){ setColor = 0xFF19a11e;changeColor.setBackgroundColor(0xFF19a11e);changeColor.setText("Verde");}

                if (color == 5){
                    color=1;

                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                for (int i = main.getChildCount(); i>=0; i--){
                    View vi = main.getChildAt(i);
                    if (vi instanceof Quadrado){
                        main.removeViewAt(i);
                    }
                }
            }
        });



        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = main.getChildCount(); i>=0; i--){
                    View vi = main.getChildAt(i);
                    if (vi instanceof Bola){
                        main.removeViewAt(i);
                    }
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = main.getChildCount(); i>=0; i--){
                    View vi = main.getChildAt(i);
                    if (vi instanceof Oval){
                        main.removeViewAt(i);
                    }
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = main.getChildCount(); i>=0; i--){
                    View vi = main.getChildAt(i);
                    if (vi instanceof Linha){
                        main.removeViewAt(i);
                    }
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                for (int i = main.getChildCount(); i>=0; i--){
                    View vi = main.getChildAt(i);
                    if (vi instanceof Quadrado){
                        main.removeViewAt(i);
                    }
                    if (vi instanceof Bola){
                        main.removeViewAt(i);
                    }
                    if (vi instanceof Linha){
                        main.removeViewAt(i);
                    }
                    if (vi instanceof Oval){
                        main.removeViewAt(i);
                    }
                }
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (forma == 1){main.addView(new Bola(this,event.getX()-50,event.getY()-400, 40,setColor));}
                if (forma == 2){main.addView(new Quadrado(this,event.getX(),event.getY() , event.getX()+100, event.getY()+100,setColor));}
                if (forma == 3){main.addView (new Oval(this,event.getX(), event.getY(),event.getX()+300, event.getY()+100,setColor));}
                if (forma == 4){main.addView(new Linha(this, event.getX()+200, event.getY()+200,event.getX()+400, event.getY()+200,setColor ));}


                return true;
            case MotionEvent.ACTION_MOVE:
                return true;
        }
        return true;
    }
}