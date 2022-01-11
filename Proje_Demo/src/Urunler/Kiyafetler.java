package Urunler;

import java.io.FileWriter;
import java.util.ArrayList;

public class Kiyafetler extends Urunler {

    private String renk;
    private String beden;
    private String cinsiyet;
    private int iIstem;
    private int uIstem;



    public Kiyafetler(int barkod) {
        super(barkod);
    }

    public Kiyafetler(int barkod,int urunSayisi, String marka, String urunTuru, double maliyet, double fiyat, String renk, String beden, String cinsiyet) {
        super(barkod,urunSayisi, marka, urunTuru, maliyet, fiyat);
        this.renk = renk;
        this.beden = beden;
        this.cinsiyet = cinsiyet;

    }

    @Override
    public String bilgileriGoster() {
        return super.bilgileriGoster()+"\nÜrünün Rengi: "+renk+"\nÜrünün Bedeni: "+beden+"\nÜrünün Cinsiyeti: "+cinsiyet;
    }

    public void indirimYap(double indirimOrani ){

        this.setFiyat(this.getFiyat()*(100-indirimOrani)/100);

    }


    public int getiIstem() {
        return iIstem;
    }

    public void setiIstem(int iIstem) {
        this.iIstem = iIstem;
    }

    public int getuIstem() {
        return uIstem;
    }

    public void setuIstem(int uIstem) {
        this.uIstem = uIstem;
    }

    @Override
    public int getUrunSayisi() {
        return super.getUrunSayisi();
    }

    @Override
    public void setUrunSayisi(int urunSayisi) {
        super.setUrunSayisi(urunSayisi);
    }

    @Override
    public String getMarka() {
        return super.getMarka();
    }

    @Override
    public void setMarka(String marka) {
        super.setMarka(marka);
    }

    @Override
    public String getUrunTuru() {
        return super.getUrunTuru();
    }

    @Override
    public void setUrunTuru(String urunTuru) {
        super.setUrunTuru(urunTuru);
    }

    @Override
    public double getMaliyet() {
        return super.getMaliyet();
    }

    @Override
    public void setMaliyet(double maliyet) {
        super.setMaliyet(maliyet);
    }

    @Override
    public double getFiyat() {
        return super.getFiyat();
    }

    @Override
    public void setFiyat(double fiyat) {
        super.setFiyat(fiyat);
    }

    @Override
    public int getBarkod() {
        return super.getBarkod();
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getBeden() {
        return beden;
    }

    public void setBeden(String beden) {
        this.beden = beden;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

}
