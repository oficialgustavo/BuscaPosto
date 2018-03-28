package com.example.android.buscaposto.Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by rafael on 19/08/17.
 */

public class Preferencias {
    private final String CHAVE_IDENTIFICADOR = "identificarUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";
    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "buscaposto.prefrencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    public Preferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void salvarUsuarioPreferencias(String identificadorUsuario, String nomeUsuario) {
        editor.putString(CHAVE_IDENTIFICADOR, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }

    public String getIdentificador() {
        return preferences.getString(CHAVE_IDENTIFICADOR, null);
    }

    public String getNome() {
        return preferences.getString(CHAVE_NOME, null);
    }
}
