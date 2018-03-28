package com.example.android.buscaposto.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.android.buscaposto.R;

public class BuscarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }

    /**
     * @param view
     */
    public void combustiveisSelecioanados(View view) {

        CheckBox hasGasolinaComum = (CheckBox) findViewById(R.id.gasolinaComum);
        CheckBox hasGasolinaAdtitivada = (CheckBox) findViewById(R.id.gasolinaAditivada);
        CheckBox hasDiesel = (CheckBox) findViewById(R.id.diesel);
        CheckBox hasEtanol = (CheckBox) findViewById(R.id.etanol);

        buscar(hasGasolinaComum.isChecked(), hasGasolinaAdtitivada.isChecked(), hasDiesel.isChecked(), hasEtanol.isChecked());
    }

    /**
     * recebe os checkboxes selecionado e faz a busca no banco de dados
     *
     * @param gasCom verifica se o checkbox da gasolina comum está selecionado
     * @param gasAdt verifica se o checkbox da gasolina aditivada está selecionado
     * @param diesel verifica se o checkbox do diesel está selecionado
     * @param etanol verifica se o checkbox do etanol está selecionado
     */
    public void buscar(boolean gasCom, boolean gasAdt, boolean diesel, boolean etanol) {

        String saida = "";
        if (gasCom) {
            saida += "gasCom, ";
        }
        if (gasAdt) {
            saida += "gasAdt, ";
        }
        if (diesel) {
            saida += "diesel, ";
        }
        if (etanol) {
            saida += "etanol.";
        }
        //teste de funcionamento
        Toast.makeText(this, saida, Toast.LENGTH_SHORT).show();
    }
}
