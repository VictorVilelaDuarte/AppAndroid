package com.example.victo.agenda;

/**
 * Created by victo on 22/04/2018.
 */

public class Cep {
    private String cep;
    private String logradouro;


    public Cep(String cep, String logradouro) {
        this.cep = cep;
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
