package codefactory.qc.com.webserviceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        new AccesAuWebService().execute();
    }

    class AccesAuWebService extends AsyncTask<Void, Void, String>
    {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/albums");
                HttpURLConnection conn =  (HttpURLConnection)url.openConnection();
                // recuperer le resultat du Web Service
                InputStream is = new BufferedInputStream(conn.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                //convertir le json en String
                StringBuffer bs = new StringBuffer();
                String line= "";
                while((line= br.readLine()) != null){
                    bs.append(line);
                }
                return bs.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s != null) {
                try {
                    JSONArray array = new JSONArray(s);
                    List<String> titres = new ArrayList();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject album = array.getJSONObject(i);
                        titres.add(album.getString("title"));
                    }
                    listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, titres));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
