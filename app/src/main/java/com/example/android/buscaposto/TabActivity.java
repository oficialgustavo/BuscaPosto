package com.example.android.buscaposto;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.buscaposto.Activity.CadastroPostos;
import com.example.android.buscaposto.Activity.PostosActivity;
import com.example.android.buscaposto.Activity.PrincipalActivity;
import com.example.android.buscaposto.Adapter.ViewPagerAdapter;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Gustavo on 31/08/2017.
 */

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new FragmentGasComum(), "Gas. Comum");
        viewPagerAdapter.addFragments(new FragmentGasAditivada(), "Gas. Aditivada");
        viewPagerAdapter.addFragments(new FragmentEtanol(), "Etanol");
        viewPagerAdapter.addFragments(new FragmentDiesel(), "Diesel");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            case R.id.cadastrar_posto:
                Toast.makeText(this, "Cadastrar Posto -> Selecionado",Toast.LENGTH_SHORT).show();
                Intent intentCadastro = new Intent(this, CadastroPostos.class);
                startActivity(intentCadastro);
                finish();
                return true;
            case R.id.listar_postos:
                Toast.makeText(this, "Listar Postos -> Selecionado",Toast.LENGTH_SHORT).show();
                Intent intentListar = new Intent(this, PostosActivity.class);
                startActivity(intentListar);
                finish();
                return true;
            case R.id.meu_perfil:
                Toast.makeText(this, "Meu perfil -> Selecionado",Toast.LENGTH_SHORT).show();
                /**
                 * --CRIAR TELA "Meu perfil"
                 *  Intent intentPerfil = new Intent(this, MeuPerfil.class);
                 *  startActivity(intentPerfil);
                 *  finish();
                 */
                return true;

            //travando
            case R.id.sair:
                Toast.makeText(this, "Sair -> Selecionado",Toast.LENGTH_SHORT).show();
                Intent intentSair = new Intent(TabActivity.this, MainActivity.class);
                startActivity(intentSair);
                finish();
                return true;
        }

        return true; //em dúvida em relação a isso
    }
}
