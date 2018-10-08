package com.example.portable.exercice_database2;

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

public class Ajouter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter);

        Button ajouter = findViewById(R.id.idBtnAjouter);
        final ChapitreDB ch = new ChapitreDB(this);

        ajouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                EditText nom = findViewById(R.id.idNomAjouter);
                EditText desc = findViewById(R.id.idDescAjouter);

                Chapitre ch1 = new Chapitre(0,nom.getText().toString(),
                        desc.getText().toString());

                 ch.openForWrite();
                 long isAdd = ch.insertRow(ch1);

                if (isAdd == 0) {
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Impossible d'ajouter le chapitre", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent= new Intent(Ajouter.this, Liste.class);
                    startActivity(intent);
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