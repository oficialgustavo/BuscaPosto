package com.example.android.buscaposto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.buscaposto.Adapter.AdapterPosto;
import com.example.android.buscaposto.DAO.ConfiguracaoFirebase;
import com.example.android.buscaposto.Entities.Posto;
import com.example.android.buscaposto.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PostosActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Posto> adapterPosto;
    private ArrayList<Posto> postos;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerPostos;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postos);

        postos = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listViewPostos);
        adapterPosto = new AdapterPosto(this, postos);
        listView.setAdapter(adapterPosto);

        firebase = ConfiguracaoFirebase.getFirebase().child("PostosAdicionados");

        valueEventListenerPostos = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postos.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    Posto postoNovo = dados.getValue(Posto.class);
                    postos.add(postoNovo);
                }
                adapterPosto.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarTelaPrincipal();
            }
        });
    }

    public void voltarTelaPrincipal() {
        Intent it = new Intent(PostosActivity.this, PrincipalActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerPostos);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerPostos);

    }
}
