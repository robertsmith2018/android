package com.example.portable.p3_exercice_04x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Principal extends AppCompatActivity {

    Button btnAffichage;
    EditText textMatricule;
    EditText textNom;
    EditText textPrenom;
    RadioGroup radioGroupSexe;
    RadioGroup radioGroupEtatCivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnAffichage = findViewById(R.id.idAfficher);
        btnAffichage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textMatricule= findViewById(R.id.idMatricule);
                textNom= findViewById(R.id.idNom);
                textPrenom=findViewById(R.id.idPrenom);

                //RadioGroup Sexe
                radioGroupSexe = findViewById(R.id.idSexe);
                int idRadioSelected1 = radioGroupSexe.getCheckedRadioButtonId();
                RadioButton radioSelected1 = findViewById(idRadioSelected1);
                String sexeSelected = (String) radioSelected1.getText();

                //RadioGroup Etat Civile
                radioGroupEtatCivil = findViewById(R.id.idEtatCivil);
                int idRadioSelected2 = radioGroupEtatCivil.getCheckedRadioButtonId();
                RadioButton radioSelected2 = findViewById(idRadioSelected2);
                String etatCivilSelected = (String) radioSelected2.getText();

                //CheckBox langue
                CheckBox Fr = findViewById(R.id.idFrench);
                CheckBox En = findViewById(R.id.idEnglish);
                CheckBox Autres = findViewById(R.id.idAutres);
                EditText autreLangue = findViewById(R.id.idTextAutres);

                String langue = "";

                if(Fr.isChecked()){
                    langue +=Fr.getText();
                }
                if(En.isChecked()){
                    if(!langue.equals("")){
                        langue +=", " +En.getText();
                    }else{
                        langue +=En.getText();
                    }
                }

                if(Autres.isChecked()){
                    if(!langue.equals("")){
                        langue +=", " +  autreLangue.getText();
                    }else{
                        langue +=autreLangue.getText();
                    }
                }

                //Salaire
                EditText salaire = findViewById(R.id.idSalaire);
                Intent intent = new Intent(Principal.this, Affichage.class);
                Employe em = new Employe(
                        textMatricule.getText().toString(),
                        textNom.getText().toString(),
                        textPrenom.getText().toString(),
                        sexeSelected,
                        etatCivilSelected,
                        langue,
                        salaire.getText().toString()
                );

                intent.putExtra("Employe", em);
                startActivity(intent);

            }
        });
    }
}

