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

public class Supprimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supprimer);

        Button supprimer = findViewById(R.id.idBtnSupprimer);
        final ChapitreDB ch = new ChapitreDB(this);

        supprimer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                EditText nom = findViewById(R.id.idChapiterSupprimer);
                int isdelete = ch.removeRow(nom.getText().toString());

                if (isdelete == 0) {
                    Context context = getApplicationContext();
                    Toast  toast = Toast.makeText(context, "Nom du chapitre interouvable", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent= new Intent(Supprimer.this, MainActivity.class);
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