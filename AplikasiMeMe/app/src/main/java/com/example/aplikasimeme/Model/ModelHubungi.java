package com.example.aplikasimeme.Model;

public class ModelHubungi {
    String name, email, pesan;
    public ModelHubungi(){}

    public ModelHubungi(String name, String email, String subject, String pesan) {
        this.name = name;
        this.email = email;
        this.pesan = pesan;
    }

    public String getNama() {
        return name;
    }

    public void setNama(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMessage() {
        return pesan;
    }

    public void setMessage(String pesan) {
        this.pesan = pesan;
    }

}
