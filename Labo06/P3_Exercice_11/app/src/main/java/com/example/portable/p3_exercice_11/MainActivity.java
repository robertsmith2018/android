package com.example.portable.p3_exercice_11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation rotation;
    Animation alpha;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

         logo = findViewById(R.id.image);
         rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);
         alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);


        Button btnStart = findViewById(R.id.start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // logo.startAnimation(alpha);
                logo.startAnimation(rotation);
            }
            });


        Button btnAlpha = findViewById(R.id.alpha);
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 logo.startAnimation(alpha);
               // logo.startAnimation(rotation);
            }
        });
    }
}
