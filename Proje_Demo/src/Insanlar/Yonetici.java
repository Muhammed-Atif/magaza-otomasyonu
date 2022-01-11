package Insanlar;

import Insanlar.Calisan;
import Main.Main;
import Urunler.Elektronik;
import Urunler.Kiyafetler;
import Urunler.Urunler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Yonetici extends Calisan {


    public Yonetici(int id) {
        super(id);
    }

    public Yonetici(int id,String ad, String soyAd, String eMail, String parola, String telofon, double maas) {
        super(id,ad, soyAd, eMail, parola, telofon, maas);

    }


    @Override
    public String bilgilerimiGoster() {
        return super.bilgilerimiGoster();
    }

    @Override
    public String urunBilgisi(int barkod, ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronikler) {
        return super.urunBilgisi(barkod, kiyafetler, elektronikler);
    }

    @Override
    public void urunBilgiDegistirme(int barkod, ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronikler) {
        super.urunBilgiDegistirme(barkod, kiyafetler, elektronikler);
    }

    @Override
    public void urunEkleme(ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronik) {
        super.urunEkleme(kiyafetler, elektronik);
    }

    @Override
    public void indirimIstemeSifirlama(ArrayList<Musteri> musteriler, ArrayList<Vip_Musteri> vip_musteriler) {
        super.indirimIstemeSifirlama(musteriler, vip_musteriler);
    }

    @Override
    public void urunIstemeSifirlama(ArrayList<Musteri> musteriler, ArrayList<Vip_Musteri> vip_musteriler) {
        super.urunIstemeSifirlama(musteriler, vip_musteriler);
    }

    public void urunSilme(int barkod, ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronikler) {



        for (int i = 0; i < kiyafetler.size(); i++) {

            if (kiyafetler.get(i).getBarkod()==barkod) {
                kiyafetler.remove(kiyafetler.get(i));
                System.out.println("Ürün silme başarılı");
                return;
            }

        }

        for (int i = 0; i < elektronikler.size(); i++) {
            if (elektronikler.get(i).getBarkod()==barkod) {
                elektronikler.remove(elektronikler.get(i));
                System.out.println("Ürün silme başarılı");
                return;
            }
        }


    }

    public void indirimYap(int barkod, double indirimOrani, ArrayList<Kiyafetler> kiyafetler) {

        for (int i = 0; i < kiyafetler.size(); i++) {
            if (kiyafetler.get(i).getBarkod()==barkod) {

                kiyafetler.get(i).indirimYap(indirimOrani);
            }


        }

    }

    public void personelCikar(int id, ArrayList<Calisan> calisanlar) {

        for (int i = 0; i < calisanlar.size(); i++) {

            if (calisanlar.get(i).getId()==id) {

                calisanlar.remove(calisanlar.get(i));
                System.out.println("Calışan silme başarılı.");
            }

        }


    }

    public void personelEkle(ArrayList<Calisan> calisanlar) {
        Scanner scanner = new Scanner(System.in);
        Calisan c = new Calisan(Main.idSayac++);

        System.out.println("Çalışanın adını giriniz: ");
        String ad = scanner.nextLine();
        c.setAd(ad);
        System.out.println("Çalışanın soyadını giriniz: ");
        String soyad = scanner.nextLine();
        c.setSoyAd(soyad);
        System.out.println("Çalışanın E-mailini giriniz: ");
        String email = scanner.nextLine();
        c.seteMail(email);
        System.out.println("Çalışanın parolasını giriniz: ");
        String parola = scanner.nextLine();
        c.setParola(parola);
        System.out.println("Çalışanın telefonunu giriniz: ");
        String telefon = scanner.nextLine();
        c.setTelofon(telefon);
        System.out.println("Lütfen maaşı sayısal bir değer girin.");
        System.out.println("Çalışanın maaşını giriniz: ");
        try {
            double maas = scanner.nextDouble();
            scanner.nextLine();
            c.setMaas(maas);
        }catch (Exception e){
            System.out.println("\n\n\n\nÇalışan maaşı atanamamıştır");

        }

        calisanlar.add(c);


    }

    public void musteriCikar(int id, ArrayList<Musteri> musteriler, ArrayList<Vip_Musteri> vip_musteriler) {


        for (int i = 0; i < musteriler.size(); i++) {

            if (musteriler.get(i).getId()==id) {

                musteriler.remove(musteriler.get(i));
                System.out.println("Musteri silme başarılı.");
            }

        }

        for (int i = 0; i < vip_musteriler.size(); i++) {

            if (vip_musteriler.get(i).getId()==id) {
                vip_musteriler.remove(vip_musteriler.get(i));
                System.out.println("Musteri silme başarılı.");

            }

        }

    }


    @Override
    public double getMaas() {
        return super.getMaas();
    }

    @Override
    public void setMaas(double maas) {
        super.setMaas(maas);
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
}
