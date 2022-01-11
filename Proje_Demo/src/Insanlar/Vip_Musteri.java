package Insanlar;

import Insanlar.Musteri;
import Urunler.Urunler;
import Urunler.Kiyafetler;
import Urunler.Elektronik;
import java.util.ArrayList;

public class Vip_Musteri extends Musteri {

    private boolean urunIsteme;
    private boolean indirimIsteme;
    public Vip_Musteri(int id){
        super(id);
    }
    public Vip_Musteri(int id,String ad, String soyAd, String eMail, String parola, String telofon, double harcanan) {
        super(id,ad, soyAd, eMail, parola, telofon, harcanan);
        this.indirimIsteme=true;
        this.urunIsteme=true;
    }

    @Override
    public String bilgilerimiGoster() {
        return "        VİP\n"+super.bilgilerimiGoster();
    }




    @Override
    public double urunAlma(int barkod, ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronikler) {
        return super.urunAlma(barkod, kiyafetler, elektronikler);
    }

    @Override
    public void indirimIsteme(int barkod, ArrayList<Kiyafetler> kiyafetler) {
        if (indirimIsteme){
            for (int i = 0; i < kiyafetler.size(); i++) {

                if (kiyafetler.get(i).getBarkod()==barkod){
                    setIndirimIsteme(false);

                    kiyafetler.get(i).setiIstem(kiyafetler.get(i).getiIstem()+5);
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

    @Override
    public void urunIsteme(int barkod, ArrayList<Kiyafetler> kiyafetler) {
        if (urunIsteme) {
            for (int i = 0; i < kiyafetler.size(); i++) {

                if (kiyafetler.get(i).getBarkod()==barkod) {
                    setUrunIsteme(false);

                    if (kiyafetler.get(i).getUrunSayisi() == 0) {
                        kiyafetler.get(i).setuIstem(kiyafetler.get(i).getuIstem() + 5);
                        if (kiyafetler.get(i).getuIstem()>10)
                        kiyafetler.get(i).setUrunSayisi(50);
                        System.out.println("Urun isteme başarılı ");
                    }
                }
            }
        }
    }

    @Override
    public boolean isIndirimIsteme() {
        return super.isIndirimIsteme();
    }

    @Override
    public void setIndirimIsteme(boolean indirimIsteme) {
        super.setIndirimIsteme(indirimIsteme);
    }

    @Override
    public boolean isUrunIsteme() {
        return super.isUrunIsteme();
    }

    @Override
    public void setUrunIsteme(boolean urunIsteme) {
        super.setUrunIsteme(urunIsteme);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public double getHarcanan() {
        return super.getHarcanan();
    }

    @Override
    public void setHarcanan(double harcanan) {
        super.setHarcanan(harcanan);
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
}
