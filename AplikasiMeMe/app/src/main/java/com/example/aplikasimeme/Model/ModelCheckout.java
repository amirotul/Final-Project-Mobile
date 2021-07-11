package com.example.aplikasimeme.Model;

public class ModelCheckout {
    String produk, jumlah, total, nama, alamat, nohp;
    public ModelCheckout(){}

    public ModelCheckout(String produk, String jumlah, String total, String nama, String alamat, String nohp) {
        this.produk = produk;
        this.jumlah = jumlah;
        this.total = total;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

}
