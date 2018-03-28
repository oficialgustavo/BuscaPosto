package com.example.android.buscaposto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.buscaposto.DAO.ConfiguracaoFirebase;
import com.example.android.buscaposto.Entities.Posto;
import com.example.android.buscaposto.R;
import com.google.firebase.database.DatabaseReference;

public class CadastroPostos extends AppCompatActivity {

    private Button btnFinalizar, btnCancelar;
    private EditText edtCadNomePosto, edtCadPrecoGasComum, edtCadPrecoGasAditivada, edtCadPrecoAlcool, edtCadPrecoDiesel, edtCadCidade, edtCadEndereco;
    private Posto postos;
    private DatabaseReference firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_postos);

        edtCadNomePosto = (EditText) findViewById(R.id.edtCadNomePosto);
        edtCadPrecoGasComum = (EditText) findViewById(R.id.edtCadPrecoGasComum);
        edtCadPrecoGasAditivada = (EditText) findViewById(R.id.edtCadPrecoGasAditivada);
        edtCadPrecoAlcool = (EditText) findViewById(R.id.edtCadPrecoAlcool);
        edtCadPrecoDiesel = (EditText) findViewById(R.id.edtCadPrecoDiesel);
        edtCadCidade = (EditText) findViewById(R.id.edtCadCidade);
        edtCadEndereco = (EditText) findViewById(R.id.edtCadEndereco);

        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean verificador = verificaCadastro();

                if (verificador == true) {

                    postos = new Posto();
                    postos.setNomePosto(edtCadNomePosto.getText().toString());
                    postos.setPrecoGasComum(Double.parseDouble(edtCadPrecoGasComum.getText().toString()));
                    postos.setPrecoGasAditivada(Double.parseDouble(edtCadPrecoGasAditivada.getText().toString()));
                    postos.setPrecoEtanol(Double.parseDouble(edtCadPrecoAlcool.getText().toString()));
                    postos.setPrecoDiesel(Double.parseDouble(edtCadPrecoDiesel.getText().toString()));
                    postos.setCidade(edtCadCidade.getText().toString());
                    postos.setEndereco(edtCadEndereco.getText().toString());

                    salvarPosto(postos);
                    cancel();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

    }

    private boolean verificaCadastro(){
        if (edtCadNomePosto.getText().toString().isEmpty()){
            Toast.makeText(this,"Cadastre um nome para o Posto", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (edtCadPrecoGasComum.getText().toString().isEmpty() && edtCadPrecoGasAditivada.getText().toString().isEmpty() && edtCadPrecoAlcool.getText().toString().isEmpty()&& edtCadPrecoDiesel.getText().toString().isEmpty()){
            Toast.makeText(this, "Cadastre pelo menos 1 combustível", Toast.LENGTH_SHORT).show();
            return false;
        }
        else return true;
    }

    private boolean salvarPosto(Posto posto) {

        try {
            firebase = ConfiguracaoFirebase.getFirebase().child("PostosAdicionados");
            firebase.child(posto.getNomePosto()).setValue(posto);
            Toast.makeText(CadastroPostos.this, "Posto cadastrado com sucesso", Toast.LENGTH_LONG).show();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void cancel() {
        Intent it = new Intent(CadastroPostos.this, PrincipalActivity.class);
        startActivity(it);
        finish();

    }
}
