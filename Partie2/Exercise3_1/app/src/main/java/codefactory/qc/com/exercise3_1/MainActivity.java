package codefactory.qc.com.exercise3_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_liste);
        ArrayList<Cours> listeCours = new ArrayList<>();
        initialiserListe(listeCours);
        AdapterListeCours adapter = new AdapterListeCours(this, R.layout.item_liste, listeCours);
        ListView listView = (ListView)findViewById(R.id.idListeCours);
        listView.setAdapter(adapter);
    }

    private void initialiserListe(ArrayList<Cours> listeCours){
        listeCours.add(new Cours("C/C++", R.drawable.animal1));
        listeCours.add(new Cours("Java", R.drawable.animal2));
        listeCours.add(new Cours("HTML", R.drawable.animal3));
        listeCours.add(new Cours("CSS", R.drawable.animal4));
        listeCours.add(new Cours("Visual Basic", R.drawable.animal2));
        listeCours.add(new Cours("PHP", R.drawable.animal3));
        listeCours.add(new Cours("MySQL", R.drawable.animal4));
    }
}
