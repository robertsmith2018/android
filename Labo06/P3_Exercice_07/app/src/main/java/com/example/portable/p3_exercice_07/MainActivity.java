package com.example.portable.p3_exercice_07;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));


        Button btnAffichage = findViewById(R.id.idChangeColor);
        btnAffichage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#C70039")));

            }

        });

    }
}