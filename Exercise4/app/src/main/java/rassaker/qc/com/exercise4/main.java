package rassaker.qc.com.exercise4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.idButtonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtUserName = findViewById(R.id.idTextUserName);
                TextView txtPassword = findViewById(R.id.idTextUserPassword);
                String userName = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                if(userName.equalsIgnoreCase("user")&& password.equalsIgnoreCase("pass")){
                    LinearLayout layoutLogin = findViewById(R.id.idLayoutLogin);
                    LinearLayout layoutImage = findViewById(R.id.idLayoutImage);

                    layoutLogin.setVisibility(View.GONE);
                    layoutImage.setVisibility(View.VISIBLE);


                }
            }
        });
    }
}
