package rassaker.qc.com.welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static rassaker.qc.com.welcome.R.id.edit_text;
import static rassaker.qc.com.welcome.R.id.text_view;

public class MainActivity extends AppCompatActivity {
    public static final String MAIN_ACTIVITY_EXTRA = "user";

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        Button hellowbutton = findViewById(R.id.hello_button);

        hellowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayHello(view);

            }
        });
    }

    public void sayHello(View k) {
        String name = editText.getText().toString();
      //  textView.setText(String.format("Hello,%s! ", name));
        Intent intent = new Intent(this,WelcomeActivity.class);
        intent.putExtra(MAIN_ACTIVITY_EXTRA, name);
        startActivity(intent);



    }
}
