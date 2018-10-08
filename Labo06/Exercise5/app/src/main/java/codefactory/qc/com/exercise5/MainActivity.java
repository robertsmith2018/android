package codefactory.qc.com.exercise5;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button settingButton = findViewById(R.id.settingButton);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                Intent intent = pm.getLaunchIntentForPackage("com.android.settings");
                if(intent!=null){
                    startActivity(intent);
                }
                else{
                    Toast toast = Toast.makeText(MainActivity.this, "Package mon trouvé", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
