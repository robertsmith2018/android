package codefactory.qc.com.exercise4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_liste);
        ArrayList<Cars> listeCars = new ArrayList<>();
        initialiserListe(listeCars);
        AdapterListeCars adapter = new AdapterListeCars(this, R.layout.item_liste, listeCars);
        ListView listView = (ListView)findViewById(R.id.idlisteCars);
        listView.setAdapter(adapter);
    }

    private void initialiserListe(ArrayList<Cars> listeCars) {

        listeCars.add(new Cars(R.drawable.camaro, "Camaro", "Blue", 250000 ));
        listeCars.add(new Cars(R.drawable.ferrari, "Ferrari", "Red", 175000 ));
        listeCars.add(new Cars(R.drawable.mini, "Mini Cooper", "Blue", 25000 ));
        listeCars.add(new Cars(R.drawable.nissan, "Nissan", "Red", 15000 ));
        listeCars.add(new Cars(R.drawable.porshe, "Porshe", "Red", 75000 ));
        listeCars.add(new Cars(R.drawable.wagon, "Wagon", "Red", 18000 ));
    }
}
