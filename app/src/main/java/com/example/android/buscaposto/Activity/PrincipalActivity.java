package com.example.android.buscaposto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.android.buscaposto.R;
import com.example.android.buscaposto.TabActivity;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.android.buscaposto.R.id.btnSair;

public class PrincipalActivity extends AppCompatActivity {

    private FirebaseAuth usuarioFirebase;
    private Button btnCadastrarPosto, btnListarPostos, btnSair, btnTelaTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnCadastrarPosto = (Button) findViewById(R.id.btnCadastrarPosto);
        btnListarPostos = (Button) findViewById(R.id.btnListarPostos);
        btnSair = (Button) findViewById(R.id.btnSair);
        btnTelaTab = (Button) findViewById(R.id.btnTab);

        btnTelaTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabFunction();
            }
        });

        btnCadastrarPosto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarPosto();
            }
        });

        btnListarPostos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listarPostos();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sair();
            }
        });

    }

    private void tabFunction(){
        Intent it = new Intent(PrincipalActivity.this, TabActivity.class);
        startActivity(it);
        finish();
    }


    private void cadastrarPosto() {
        Intent it = new Intent(PrincipalActivity.this, CadastroPostos.class);
        startActivity(it);
        finish();

    }

    private void listarPostos() {
        Intent it = new Intent(PrincipalActivity.this, PostosActivity.class);
        startActivity(it);
        finish();
    }

    private void sair() {

        Intent it = new Intent(PrincipalActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
