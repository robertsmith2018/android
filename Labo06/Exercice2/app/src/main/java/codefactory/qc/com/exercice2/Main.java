package codefactory.qc.com.exercice2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    Button btnAfficher;
    EditText txtNom;
    EditText txtPrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnAfficher = findViewById(R.id.idButtonAfficher);
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNom = findViewById(R.id.idEditTextNom);
                txtPrenom = findViewById(R.id.idEditTextPrenom);
                Intent intent = new Intent(Main.this,ActivityBienvenue.class);
                intent.putExtra("lastName", txtNom.getText().toString());
                intent.putExtra("firstName", txtPrenom.getText().toString());
                startActivity(intent);

            }
        });

    }
}
