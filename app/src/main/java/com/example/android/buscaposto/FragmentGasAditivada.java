package com.example.android.buscaposto;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.buscaposto.Adapter.AdapterPosto;
import com.example.android.buscaposto.DAO.ConfiguracaoFirebase;
import com.example.android.buscaposto.Entities.Posto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGasAditivada extends Fragment {

    private ListView mLista;
    private ArrayAdapter<Posto> adapterPosto;
    private ArrayList<Posto> postos;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerPostos;

    public FragmentGasAditivada() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Nova view utilizando o inflater e passando o layout da ListView
        View view = inflater.inflate(R.layout.fragment_listas,container,false);

        postos = new ArrayList<>();

        mLista = (ListView) view.findViewById(R.id.listViewPostos);
        adapterPosto = new AdapterPosto(getActivity(), postos);
        mLista.setAdapter(adapterPosto);

        firebase = ConfiguracaoFirebase.getFirebase().child("PostosAdicionados");

        valueEventListenerPostos = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postos.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    Posto postoNovo = dados.getValue(Posto.class);
                    postos.add(postoNovo);
                }

                //Posto auxiliar para ajudar na ordenação.
                Posto auxPosto;
                //ordenação
                for (int i = 0; i<postos.size(); i++){
                    for (int j = i+1; j<postos.size();j++) {
                        if(postos.get(j).getPrecoGasAditivada() < postos.get(i).getPrecoGasAditivada()){
                            auxPosto = postos.get(j);
                            postos.set(j,postos.get(i));
                            postos.set(i,auxPosto);
                        }
                    }
                }
                adapterPosto.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerPostos);
    }

    @Override
    public void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerPostos);

    }
}
