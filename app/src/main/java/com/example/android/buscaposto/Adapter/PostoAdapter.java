package com.example.android.buscaposto.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.buscaposto.Entities.Posto;
import com.example.android.buscaposto.R;

import java.util.ArrayList;

/**
 * Created by Gustavo on 16/08/2017.
 * A princípio não está sendo usado
 */

public class PostoAdapter extends ArrayAdapter<Posto> {
    public PostoAdapter(Activity context, ArrayList<Posto> postoList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, postoList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_listar, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Posto currentPosto = getItem(position);

        // Find the TextView in the item_listar.xml layout with the ID nome_posto
        TextView nomePosto = (TextView) listItemView.findViewById(R.id.nome_posto);
        // Get the name of the "posto" from the current Posto object and
        // set this text on the item TextView
        nomePosto.setText(currentPosto.getNomePosto());

        // Find the TextView in the item_listar.xml layout with the ID precoGasolinaComum
        TextView precoGasComum = (TextView) listItemView.findViewById(R.id.precoGasolinaComum);
        // Get the default translation from the current Word object and
        // set this text on the item TextView
        precoGasComum.setText("" + currentPosto.getPrecoGasComum());

        /*
        *add o restante do código para os preços restantes. Seguir o padrão da TextViem acima
         */

        // Return the whole list item layout (containing N TextViews )
        // so that it can be shown in the ListView
        return listItemView;
    }
}
