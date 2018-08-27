package codefactory.qc.com.exercise2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources();
        String[] listeCours = res.getStringArray(R.array.id_liste_cours);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listeCours);
        ListView listeView = (ListView)findViewById(R.id.MaListe);
        listeView.setAdapter(adapter);
    }
}
