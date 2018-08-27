package codefactory.qc.com.exercise3_1;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterListeCours extends ArrayAdapter<Cours> {
    private Context context;
    private int layoutItemListe;
    private Resources res;
    ArrayList<Cours> listeCours;

    public AdapterListeCours(Context context, int layoutItemListe, ArrayList<Cours>listeCours) {
        super(context, layoutItemListe, listeCours);
        this.context=context;
        this.layoutItemListe=layoutItemListe;
        res=context.getResources();
        this.listeCours=listeCours;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layoutItemListe, parent, false);
            Cours cours = listeCours.get(position);
            if(cours != null){
                TextView textViewTitreCours = (TextView)view.findViewById(R.id.titre);
                ImageView imageViewCours = (ImageView)view.findViewById(R.id.icon);
                textViewTitreCours.setText(cours.getNom());
                imageViewCours.setImageResource(cours.getImage());

            }
        }
        return view;
    }

    public int getCount(){
        return listeCours.size();
    }
}
