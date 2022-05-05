package Model;

/**
 * Model - Product : clasa de baza a unui produs, contine datele acestuia
 */

public class product {
    private String idproduct;
    private String nume;
    private String stoc;
    private String pret;

    public product(){
    }

    public product(String idproduct, String nume, String stoc, String pret) {
        this.idproduct = idproduct;
        this.nume = nume;
        this.stoc = stoc;
        this.pret = pret;
    }

    public product(String nume, String stoc,String pret) {
        this.nume = nume;
        this.stoc = stoc;
        this.pret = pret;
    }

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getStoc() {
        return stoc;
    }

    public void setStoc(String stoc) {
        this.stoc = stoc;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Product [id=" + idproduct + ", name=" + nume + ", stoc=" + stoc + ", pret=" + pret + "]";
    }
}
