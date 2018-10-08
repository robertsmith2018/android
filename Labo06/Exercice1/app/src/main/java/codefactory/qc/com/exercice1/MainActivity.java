package codefactory.qc.com.exercice1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button cmdNouvelEmploye = findViewById(R.id.idButtonNouvelEmploye);
        Button cmdListeEmploye = findViewById(R.id.idButtonListeEmploye);

        cmdNouvelEmploye.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityNouvelEmploye.class);
                startActivity(intent);
            }
        });

        cmdListeEmploye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityListeEmploye.class);
                startActivity(intent);
            }
        });
    }
}
