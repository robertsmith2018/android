package rassaker.qc.com.welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String name = getIntent().getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA);
        if(getActionBar()!= null)
            getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = findViewById(R.id.welcome_text_view);
        textView.setText("Hello" + name + "!" );

    }
}
