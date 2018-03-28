package com.example.android.buscaposto.Entities;

/**
 * Created by Gustavo on 20/08/2017.
 */

public class Posto {
    private String nomePosto;
    private Double precoGasComum;
    private Double precoGasAditivada;
    private Double precoEtanol;
    private Double precoDiesel;
    private String endereco;
    private String cidade;

    public Posto() {

    }

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }

    public double getPrecoGasComum() {
        return precoGasComum;
    }

    public void setPrecoGasComum(double precoGasComum) {
        this.precoGasComum = precoGasComum;
    }

    public double getPrecoGasAditivada() {
        return precoGasAditivada;
    }

    public void setPrecoGasAditivada(double precoGasAditivada) {
        this.precoGasAditivada = precoGasAditivada;
    }

    public double getPrecoEtanol() {
        return precoEtanol;
    }

    public void setPrecoEtanol(double precoEtanol) {
        this.precoEtanol = precoEtanol;
    }

    public double getPrecoDiesel() {
        return precoDiesel;
    }

    public void setPrecoDiesel(double precoDiesel) {
        this.precoDiesel = precoDiesel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
