package Urunler;

import java.io.FileWriter;
import java.util.ArrayList;

public class Elektronik extends Urunler {



    public Elektronik(int barkod) {
        super(barkod);
    }

    public Elektronik(int barkod,int urunSayisi, String marka, String urunTuru, double maliyet, double fiyat) {
        super(barkod,urunSayisi, marka, urunTuru, maliyet, fiyat);

    }


    @Override
    public String bilgileriGoster() {
        return super.bilgileriGoster();
    }

    @Override
    public int getBarkod() {
        return super.getBarkod();
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
}
