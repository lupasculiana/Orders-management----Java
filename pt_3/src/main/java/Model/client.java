package Model;

import java.util.ArrayList;

/**
 * Model - Client : clasa de baza a unui client, contine datele acestuia
 */

public class client {
    private String idclient;
    private String nume;
    private String adresa;
    private String prenume;
    private String email;

    public client() {
    }

    public client(String idclient, String nume, String adresa, String prenume, String email) {
        super();
        this.idclient = idclient;
        this.nume = nume;
        this.adresa = adresa;
        this.prenume = prenume;
        this.email = email;
    }

    public client(String nume, String adresa, String prenume, String email) {
        super();
        this.nume = nume;
        this.adresa = adresa;
        this.prenume = prenume;
        this.email = email;
    }

    public String getIdclient() {
        return idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client [id=" + idclient + ", name=" + nume + " " + prenume
        + ", address=" + adresa + ", email=" + email + "]";
    }

}
