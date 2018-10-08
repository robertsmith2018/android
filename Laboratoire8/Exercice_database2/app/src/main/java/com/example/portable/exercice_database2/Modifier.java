package com.example.portable.exercice_database2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modifier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifier);

        Button affichier = findViewById(R.id.idBtnAffichage);
        Button modifier = findViewById(R.id.idBtnModifier);

        final EditText id = findViewById(R.id.idChapitreModifier);
        final EditText nom = findViewById(R.id.idNom);
        final EditText description = findViewById(R.id.idDescription);

        final ChapitreDB ch = new ChapitreDB(this);

        affichier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){



                int myId = Integer.parseInt(id.getText().toString());

                Chapitre chapitre = (Chapitre) new Chapitre();
                chapitre = ch.getChapitre2(myId);

                if (chapitre != null) {

                    nom.setText(chapitre.getName().toString());
                    description.setText(chapitre.getDescription().toString());

                }else{
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Nom du chapitre interouvable", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        modifier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            int myId = Integer.parseInt(id.getText().toString());
            Chapitre chapitre = new Chapitre(myId, nom.getText().toString(), description.getText().toString());

            int   isUpdate = ch.updateRow(myId, chapitre);

                if (chapitre != null) {

                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "La modification et terminer avec succes", Toast.LENGTH_SHORT);
                    toast.show();

                }else{
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT);
                    toast.show();
                }

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