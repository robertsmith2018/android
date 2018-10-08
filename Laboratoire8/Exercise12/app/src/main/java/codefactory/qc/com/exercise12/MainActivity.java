package codefactory.qc.com.exercise12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.list);
        Chapitre chapitre1 = new Chapitre("La Plateforme","Présentation et Historique");
        Chapitre chapitre2= new Chapitre("Environnement de développement","Présentation et installation");
        Chapitre chapitre3 = new Chapitre("Les Interfaces Simples","Présentation des interfaces simples");

        ChapitreBD chapitreBd = new ChapitreBD(this);
        chapitreBd.openForWrite();
        chapitreBd.insertChapter(chapitre1);
        chapitreBd.insertChapter(chapitre2);
        chapitreBd.insertChapter(chapitre3);

        ArrayList<Chapitre> chapterList = chapitreBd.getAllChapters();
        chapitreBd.close();

        ArrayAdapter<Chapitre> adapter = new ArrayAdapter<Chapitre>(this,
                android.R.layout.simple_list_item_1, chapterList);
    }
}
