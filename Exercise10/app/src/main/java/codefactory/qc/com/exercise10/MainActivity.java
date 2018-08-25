package codefactory.qc.com.exercise10;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnLangue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLangue = findViewById(R.id.idLangue);
        btnLangue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String langueVoulue = btnLangue.getText().toString();
                String codeLangue;
                if(langueVoulue.equalsIgnoreCase("Francais")){
                    codeLangue ="fr";
                }else{
                    codeLangue ="en";
                }
                Locale locale = new Locale(codeLangue);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });

    }
}
