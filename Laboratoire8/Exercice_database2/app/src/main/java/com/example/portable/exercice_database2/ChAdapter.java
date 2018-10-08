package com.example.portable.exercice_database2;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChAdapter  extends ArrayAdapter<Chapitre> {

    private Context context;
    private int layoutItemList;
    private Resources res;
    ArrayList<Chapitre> listChapitre;

    public ChAdapter(Context context, int layoutItemList, ArrayList<Chapitre> listChapitre ){
        super(context,layoutItemList, listChapitre);
        this.context=context;
        this.layoutItemList=layoutItemList;
        this.res=context.getResources();
        this.listChapitre = listChapitre;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view =  convertView;
        if(view==null){
            LayoutInflater layoutInflater =(LayoutInflater ) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layoutItemList, parent, false);
            Chapitre ch = listChapitre.get(position);
            if (ch!=null) {

                TextView textViewIdCh = (TextView) view.findViewById(R.id.txtId);
                TextView textViewNameCh = (TextView) view.findViewById(R.id.txtName);
                TextView textViewDescCh = (TextView) view.findViewById(R.id.txtDesc) ;


                textViewIdCh.setText("" + ch.getId());
                textViewNameCh.setText("" + ch.getName());
                textViewDescCh.setText("" + ch.getDescription());


            }
        }
        return view;
    }

    @Override
    public  int getCount(){
        return listChapitre.size();
    }
}
