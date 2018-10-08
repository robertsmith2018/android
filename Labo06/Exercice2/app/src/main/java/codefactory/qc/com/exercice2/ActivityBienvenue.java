package codefactory.qc.com.exercice2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityBienvenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenue);
        Intent intent = getIntent();
        String nom = intent.getStringExtra("lastName");
        String prenom = intent.getStringExtra("firstName");
        TextView textView = findViewById(R.id.idTextViewBienvenue);
        String message = getString(R.string.text_bienvenue)+" "+nom+" "+prenom;
        textView.setText(message);

    }
}
