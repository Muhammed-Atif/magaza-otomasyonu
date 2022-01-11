package Urunler;

import java.util.ArrayList;

public class Urunler {
    private int barkod;
    private int urunSayisi;
    private String marka;
    private String urunTuru;
    private double maliyet;
    private double fiyat;


    public Urunler(int  barkod){
        this.barkod=barkod;
    }
    public Urunler(int barkod,int urunSayisi, String marka, String urunTuru, double maliyet, double fiyat) {
        setUrunSayisi(urunSayisi);
        this.marka = marka;
        this.urunTuru = urunTuru;
        setMaliyet(maliyet);
        setFiyat(fiyat);
        this.barkod= barkod;
    }


    public String bilgileriGoster(){
        String mesaj="Ürünün barkodu: "+barkod+"\nÜrünün Markası: "+marka+"\nÜrünün Sayısı: "+urunSayisi+"\nÜrünün Fiyatı: "+fiyat+"\nÜrünün Türü: "+urunTuru;
        return mesaj;
    }

    public int getUrunSayisi() {
        return urunSayisi;
    }

    public void setUrunSayisi(int urunSayisi) {
        if (urunSayisi>=0){
            this.urunSayisi = urunSayisi;
        }
        else {
            System.out.println("Urun sayısı negatif olamaz.");
        }
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(String urunTuru) {
        this.urunTuru = urunTuru;
    }

    public double getMaliyet() {
        return maliyet;
    }

    public void setMaliyet(double maliyet) {
        if (maliyet>0){
            this.maliyet = maliyet;
        }
        else {
            System.out.println("Maliyet negatif olamaz");
        }
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        if (fiyat>this.maliyet){
            this.fiyat = fiyat;}
        else{
            System.out.println("Fiyat maliyetten küçük olamaz.");
        }
    }

    public int getBarkod() {
        return barkod;
    }
}
