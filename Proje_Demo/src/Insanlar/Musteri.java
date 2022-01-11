package Insanlar;

import Insanlar.Insan;
import Urunler.Urunler;
import Urunler.Kiyafetler;
import Urunler.Elektronik;
import java.util.ArrayList;

public class Musteri extends Insan {

    private double harcanan;
    private boolean indirimIsteme;
    private boolean urunIsteme;
    public Musteri(int id){
        super(id);
    }
    public Musteri(int id,String ad, String soyAd, String eMail, String parola, String telofon, double harcanan) {
        super(id,ad, soyAd, eMail, parola, telofon);
        setHarcanan(harcanan);
        this.indirimIsteme=true;
        this.urunIsteme=true;
    }

    @Override
    public String bilgilerimiGoster() {
        return super.bilgilerimiGoster()+"\nBugüne kadar harcadığınız tutar: "+harcanan;
    }

    public double urunAlma(int barkod , ArrayList<Kiyafetler> kiyafetler,ArrayList<Elektronik> elektronikler){

        for (int i = 0; i < kiyafetler.size(); i++) {

            if (kiyafetler.get(i).getBarkod()==barkod){

                if (kiyafetler.get(i).getUrunSayisi()>0){
                    System.out.println(kiyafetler.get(i).getBarkod()+" Barkodlu Ürünün ücreti: "+kiyafetler.get(i).getFiyat());
                    kiyafetler.get(i).setUrunSayisi(kiyafetler.get(i).getUrunSayisi()-1);
                    this.harcanan += kiyafetler.get(i).getFiyat();
                    return kiyafetler.get(i).getFiyat();
                }

            }

        }
        for (int i = 0; i < elektronikler.size(); i++) {


            if (elektronikler.get(i).getBarkod()==barkod){

                if (elektronikler.get(i).getUrunSayisi()>0){
                    System.out.println(kiyafetler.get(i).getBarkod()+"Barkodlu Ürünün ücreti: "+elektronikler.get(i).getFiyat());
                    elektronikler.get(i).setUrunSayisi(elektronikler.get(i).getUrunSayisi()-1);
                    this.harcanan +=elektronikler.get(i).getFiyat();
                    return elektronikler.get(i).getFiyat();
                }
            }
        }
        return 0;
    }

    public void indirimIsteme(int barkod, ArrayList<Kiyafetler>  kiyafetler){

        if (indirimIsteme){
        for (int i = 0; i < kiyafetler.size(); i++) {

            if (kiyafetler.get(i).getBarkod()==barkod){
                setIndirimIsteme(false);

                kiyafetler.get(i).setiIstem(kiyafetler.get(i).getiIstem()+1);
                if (kiyafetler.get(i).getiIstem()>10 ){
                    kiyafetler.get(i).indirimYap(10);
                    System.out.println("Kıyafette %10 idirim yapıldı");
                }
                System.out.println("İndirim isteme başarılı ");
            }
        }
        }
        else {
            System.out.println("Daha önce indirim istemişsiniz.");
        }
    }
    public void urunIsteme(int barkod , ArrayList<Kiyafetler> kiyafetler){

        if (urunIsteme){
        for (int i = 0; i < kiyafetler.size(); i++) {

            if (kiyafetler.get(i).getBarkod()==barkod){
                setUrunIsteme(false);

                if (kiyafetler.get(i).getUrunSayisi()==0) {
                    kiyafetler.get(i).setuIstem(kiyafetler.get(i).getuIstem()+1);
                    if (kiyafetler.get(i).getuIstem()>10)
                    kiyafetler.get(i).setUrunSayisi(50);
                    System.out.println("Urun isteme başarılı ");
                }
            }
        }
        }
        else {
            System.out.println("Daha önce urun istemişsiniz");
        }
    }



    public boolean isIndirimIsteme() {
        return indirimIsteme;
    }

    public void setIndirimIsteme(boolean indirimIsteme) {
        this.indirimIsteme = indirimIsteme;
    }

    public boolean isUrunIsteme() {
        return urunIsteme;
    }

    public void setUrunIsteme(boolean urunIsteme) {
        this.urunIsteme = urunIsteme;
    }

    @Override
    public String getAd() {
        return super.getAd();
    }

    @Override
    public void setAd(String ad) {
        super.setAd(ad);
    }

    @Override
    public String getSoyAd() {
        return super.getSoyAd();
    }

    @Override
    public void setSoyAd(String soyAd) {
        super.setSoyAd(soyAd);
    }

    @Override
    public String geteMail() {
        return super.geteMail();
    }

    @Override
    public void seteMail(String eMail) {
        super.seteMail(eMail);
    }

    @Override
    public String getParola() {
        return super.getParola();
    }

    @Override
    public void setParola(String parola) {
        super.setParola(parola);
    }

    @Override
    public String getTelofon() {
        return super.getTelofon();
    }

    @Override
    public void setTelofon(String telofon) {
        super.setTelofon(telofon);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public double getHarcanan() {
        return harcanan;
    }

    public void setHarcanan(double harcanan) {//Harcanan kontrolü
        if (harcanan>=0) {
            this.harcanan = harcanan;
        }
        else{
            System.out.println("Harcanan para negatif olamaz.");
        }
    }
}
