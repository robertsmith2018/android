package com.example.portable.p3_exercice_12;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView ph = findViewById(R.id.image);

        ph.setBackgroundResource(R.drawable.animation);

        final AnimationDrawable phAnimation = (AnimationDrawable) ph.getBackground();

        ph.post(new Runnable() {
            @Override
            public void run() {
                if (phAnimation != null){
                    phAnimation.start();
                }
            }
        });

    }
}
