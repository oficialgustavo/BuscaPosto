package com.example.android.buscaposto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.buscaposto.Entities.Posto;
import com.example.android.buscaposto.R;

import java.util.ArrayList;

/**
 * Created by Gustavo on 20/08/2017.
 */

public class AdapterPosto extends ArrayAdapter<Posto> {

    private ArrayList<Posto> postos;
    private Context context;

    public AdapterPosto(Context c, ArrayList<Posto> objects) {
        super(c, 0, objects);
        this.context = c;
        this.postos = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (postos != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.item_listar, parent, false);

            TextView nomePosto = (TextView) view.findViewById(R.id.nome_posto);
            TextView valorGasComum = (TextView) view.findViewById(R.id.preco_gas_comum);
            TextView valorGasAditivada = (TextView) view.findViewById(R.id.preco_gas_aditivada);
            TextView valorDiesel = (TextView) view.findViewById(R.id.preco_Diesel);
            TextView valorEtanol = (TextView) view.findViewById(R.id.preco_etanol);

            Posto posto = postos.get(position);
            nomePosto.setText(posto.getNomePosto());
            valorGasComum.setText("" + posto.getPrecoGasComum());
            valorGasAditivada.setText("" + posto.getPrecoGasAditivada());
            valorEtanol.setText("" + posto.getPrecoEtanol());
            valorDiesel.setText("" + posto.getPrecoDiesel());
        }

        return view;
    }
}
