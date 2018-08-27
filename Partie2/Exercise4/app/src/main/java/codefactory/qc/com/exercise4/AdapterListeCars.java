package codefactory.qc.com.exercise4;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterListeCars extends ArrayAdapter<Cars> {
    private Context context;
    private int layoutItemListe;
    private Resources res;
    ArrayList<Cars> listeCars;

    public AdapterListeCars(@NonNull Context context, int layoutItemListe, @NonNull ArrayList<Cars> listeCars) {
        super(context, layoutItemListe, listeCars);
        this.context=context;
        this.layoutItemListe=layoutItemListe;
        res=context.getResources();
        this.listeCars=listeCars;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layoutItemListe,parent,false);
            Cars cars = listeCars.get(position);
            if(cars != null){
                TextView textViewModel = (TextView)view.findViewById(R.id.txt_model);
                TextView textViewColor = (TextView)view.findViewById(R.id.txt_color);
                TextView textViewPrice = (TextView)view.findViewById(R.id.txt_price);
                ImageView imageCars = view.findViewById(R.id.carsImage);

                textViewModel.setText(cars.getModel());
                textViewColor.setText(cars.getColor());
                textViewPrice.setText(""+cars.getPrice());
                imageCars.setImageResource(cars.getImage());

            }
        }
        return view;
    }
}
