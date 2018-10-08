package com.example.portable.p3_exercice_03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Affichage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage);

        Intent intent = getIntent();

        String txtMatricule = intent.getStringExtra("Matricule");
        String txtNom = intent.getStringExtra("Nom");
        String txtPrenom = intent.getStringExtra("Prenom");
        String txtSexe = intent.getStringExtra("Sexe");
        String txtEtatCivil = intent.getStringExtra("EtatCivil");
        String txtLangue = intent.getStringExtra("Langue");
        String txtSalaire = intent.getStringExtra("Salaire");

        TextView matricule = findViewById(R.id.idMatricule);
        TextView nom = findViewById(R.id.idNom);
        TextView prenom = findViewById(R.id.idPrenom);
        TextView sexe = findViewById(R.id.idSexe);
        TextView etatCivil = findViewById(R.id.idEtatCivil);
        TextView langue = findViewById(R.id.idLangue);
        TextView salaire = findViewById(R.id.idSalaire);

        matricule.setText(txtMatricule);
        nom.setText(txtNom);
        prenom.setText(txtPrenom);
        sexe.setText(txtSexe);
        etatCivil.setText(txtEtatCivil);
        langue.setText(txtLangue);
        salaire.setText(txtSalaire);


    }

}
