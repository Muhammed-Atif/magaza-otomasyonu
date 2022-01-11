package Insanlar;

public class Insan {
    private int id;
    private String ad;
    private String soyAd;
    private String eMail;
    private String parola;
    private String telofon;


    public Insan(int id){
        this.id=id;
    }
    public Insan(int id,String ad, String soyAd, String eMail, String parola, String telofon) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.eMail = eMail;
        this.parola = parola;
        setTelofon(telofon);
        this.id=id;
    }

    public String bilgilerimiGoster(){
        return "İd: "+id+"\nAd: "+ad+"\nSoyad: "+soyAd+"\nE-Mail: "+eMail+"\nParola: "+parola+"\nTelofon numarası: "+telofon;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getTelofon() {
        return telofon;
    }

    public void setTelofon(String telofon) {
        if (telofon.length()==11){
        this.telofon = telofon;}
        else{
            System.out.println("Telefon numaranız 11 haneli olmalı.");
        }
    }
}
