package com.example.portable.exercice_database2;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button ajouter = findViewById(R.id.idAjouter);
        Button liste = findViewById(R.id.idListe);
        Button modifier = findViewById(R.id.idModifier);
        Button supprimer = findViewById(R.id.idSupprimer);

        ajouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MainActivity.this, Ajouter.class);
                startActivity(intent);

            }
        });

        liste.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                 Intent intent= new Intent(MainActivity.this, Liste.class);
                startActivity(intent);

            }
        });

        modifier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MainActivity.this, Modifier.class);
                startActivity(intent);

            }
        });

        supprimer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MainActivity.this, Supprimer.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.home:
                Intent intent= new Intent( this, MainActivity.class);
                startActivity(intent);
            case R.id.about:
                return(true);
            case R.id.exit:
                finish();
                System.exit(0);
        }
        return (super.onOptionsItemSelected(item));
    }


}
