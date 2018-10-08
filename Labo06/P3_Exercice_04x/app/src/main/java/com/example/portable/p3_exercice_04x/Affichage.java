package com.example.portable.p3_exercice_04x;


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

         Employe em = (Employe)intent.getSerializableExtra("Employe");

        TextView matricule = findViewById(R.id.idMatricule);
        TextView nom = findViewById(R.id.idNom);
        TextView prenom = findViewById(R.id.idPrenom);
        TextView sexe = findViewById(R.id.idSexe);
        TextView etatCivil = findViewById(R.id.idEtatCivil);
        TextView langue = findViewById(R.id.idLangue);
        TextView salaire = findViewById(R.id.idSalaire);

        matricule.setText(em.getMatricule());
        nom.setText(em.getNom());
        prenom.setText(em.getPrenom());
        sexe.setText(em.getSexe());
        etatCivil.setText(em.getEtatCivil());
        langue.setText(em.getLangue());
        salaire.setText(em.getSalaire());


    }

}
