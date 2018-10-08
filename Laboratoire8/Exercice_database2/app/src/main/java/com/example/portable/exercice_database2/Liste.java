package com.example.portable.exercice_database2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Liste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste);

    /*    Chapitre ch1 = new Chapitre("plateform Android",
                "Presentation et historique de la plateform Android");
        Chapitre ch2 = new Chapitre("Environment et develppement",
                "Présentation et Installation de l'Environment et develppement Android");
        Chapitre ch3 = new Chapitre("Les Interfaces simples",
                "Presentation des Interfaces simples");*/
        ChapitreDB chTbl = new ChapitreDB(this);

     // chTbl.openForWrite();

        chTbl.openForRead();
/*
        chTbl.insertRow(ch1);
        chTbl.insertRow(ch2);
        chTbl.insertRow(ch3);*/


        ListView listViewChapitre = (ListView) findViewById(R.id.idMaListe);
        ArrayList<Chapitre> chList = chTbl.getAllRows();
        chTbl.close();

        if (chList != null){
            ChAdapter adapter = new ChAdapter(this, R.layout.item, chList);
            listViewChapitre.setAdapter(adapter);
        }


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
