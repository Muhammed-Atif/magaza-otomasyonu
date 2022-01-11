package Insanlar;

import java.util.Scanner;

import Main.Main;
import Urunler.Elektronik;
import Urunler.Kiyafetler;

import java.util.ArrayList;

public class Calisan extends Insan {

    private double maas;

    public Calisan(int id) {
        super(id);
    }

    public Calisan(int id, String ad, String soyAd, String eMail, String parola, String telofon, double maas) {
        super(id, ad, soyAd, eMail, parola, telofon);
        this.maas = maas;

    }

    @Override
    public String bilgilerimiGoster() {
        return super.bilgilerimiGoster() + "\nMaaş: " + maas;
    }

    public String urunBilgisi(int barkod, ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronikler) {

        for (int i = 0; i < kiyafetler.size(); i++) {

            if (kiyafetler.get(i).getBarkod() == barkod) {
                return kiyafetler.get(i).bilgileriGoster() + "\nÜrünün Maliyeti: " + kiyafetler.get(i).getMaliyet();
            }

        }

        for (int i = 0; i < elektronikler.size(); i++) {

            if (elektronikler.get(i).getBarkod() == barkod) {
                return elektronikler.get(i).bilgileriGoster() + "\nÜrünün Maliyeti: " + elektronikler.get(i).getMaliyet();
            }

        }
        return "Urun Bulunamadı";
    }

    public void indirimIstemeSifirlama(ArrayList<Musteri> musteriler, ArrayList<Vip_Musteri> vip_musteriler) {

        for (int i = 0; i < musteriler.size(); i++) {

            musteriler.get(i).setIndirimIsteme(true);
        }

        for (int i = 0; i < vip_musteriler.size(); i++) {
            vip_musteriler.get(i).setIndirimIsteme(true);

        }


    }

    public void urunIstemeSifirlama(ArrayList<Musteri> musteriler, ArrayList<Vip_Musteri> vip_musteriler) {

        for (int i = 0; i < musteriler.size(); i++) {

            musteriler.get(i).setUrunIsteme(true);
        }

        for (int i = 0; i < vip_musteriler.size(); i++) {
            vip_musteriler.get(i).setUrunIsteme(true);
        }
    }


    public void urunBilgiDegistirme(int barkod, ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronikler) {
        String secim = "";
        Scanner scanner = new Scanner(System.in);
        String b;
        for (int i = 0; i < kiyafetler.size(); i++) {

            if (kiyafetler.get(i).getBarkod() == barkod) {
                while (!secim.equals("-1")) {
                    System.out.println("********************************");
                    System.out.println("1-) Ürün Sayısı ");
                    System.out.println("2-) Ürün Fiyatı ");
                    System.out.println("3-) Ürün Maliyeti ");
                    System.out.println("4-) Ürün Markası ");
                    System.out.println("5-) Ürün Türü ");
                    System.out.println("6-) Ürün Rengi ");
                    System.out.println("7-) Ürün Bedeni ");
                    System.out.println("8-) Ürün Cinsiyeti ");
                    System.out.println("Çıkmak için -1");
                    System.out.println("********************************");
                    System.out.println("Yapmak istediğiniz işlemi seçin");
                    secim = scanner.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                    switch (secim) {

                        case "-1":

                            break;

                        case "1":
                            System.out.println("Lütfen ürünün sayısını sayısal bir değer giriniz");
                            System.out.println("Yeni ürün sayısını giriniz: ");
                            try {
                                int urunS = scanner.nextInt();
                                scanner.nextLine();
                                kiyafetler.get(i).setUrunSayisi(urunS);
                                System.out.println("Devam etmek için entera basın");
                                b = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("\n\n\nÜrünün sayısı atanamamıştır.");
                                System.out.println("Devam etmek için entera basın.");
                                b = scanner.nextLine();
                            }


                            break;

                        case "2":
                            System.out.println("Lütfen fiyatı sayısal bir değer giriniz");
                            System.out.println("Yeni ürün fiyatını giriniz: ");
                            try {
                                double fiyat = scanner.nextDouble();
                                scanner.nextLine();
                                kiyafetler.get(i).setFiyat(fiyat);
                                System.out.println("Devam etmek için entera basın");
                                b = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("\n\n\nÜrünün fiyatı atanamamıştır.");
                                System.out.println("Devam etmek için entera basın.");
                                b = scanner.nextLine();
                            }


                            break;

                        case "3":
                            System.out.println("Lütfen maliyeti sayısal bir değer giriniz");
                            System.out.println("Yeni ürün maliyetini giriniz: ");
                            try {
                                double maliyet = scanner.nextDouble();
                                scanner.nextLine();
                                kiyafetler.get(i).setMaliyet(maliyet);
                                System.out.println("Devam etmek için entera basın");
                                b = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("\n\n\nÜrünün maliyeti atanamamıştır.");
                                System.out.println("Devam etmek için entera basın.");
                                b = scanner.nextLine();
                            }


                            break;

                        case "4":
                            System.out.println("Lütfen ürünün markasını giriniz.");
                            String marka=scanner.nextLine();
                            kiyafetler.get(i).setMarka(marka);
                            System.out.println("Devam etmek için entera basın");
                            b = scanner.nextLine();

                            break;


                        case "5":
                            System.out.println("Lütfen ürünün türünü giriniz.");
                            String urunT= scanner.nextLine();
                            kiyafetler.get(i).setUrunTuru(urunT);
                            System.out.println("Devam etmek için entera basın");
                            b = scanner.nextLine();
                            break;


                        case "6":
                            System.out.println("Lütfen ürünün rengini giriniz.");
                            String renk= scanner.nextLine();
                            kiyafetler.get(i).setRenk(renk);
                            System.out.println("Devam etmek için entera basın");
                            b = scanner.nextLine();
                            break;

                        case "7":
                            System.out.println("Lütfen ürünün bedenini giriniz.");
                            String beden=scanner.nextLine();
                            kiyafetler.get(i).setBeden(beden);
                            System.out.println("Devam etmek için entera basın");
                            b = scanner.nextLine();
                            break;

                        case "8":
                            System.out.println("Lütfen ürünün cinsiyetini giriniz.");
                            String cinsiyet=scanner.nextLine();
                            kiyafetler.get(i).setCinsiyet(cinsiyet);
                            System.out.println("Devam etmek için entera basın");
                            b = scanner.nextLine();
                            break;


                        default:
                            System.out.println("Tanımsız girdi");

                            break;


                    }

                }


            }
        }


        for (int i = 0; i < elektronikler.size(); i++) {
            if (elektronikler.get(i).getBarkod() == barkod) {
                while (!secim.equals("-1")) {
                    System.out.println("********************************");
                    System.out.println("1-) Ürün Sayısı ");
                    System.out.println("2-) Ürün Fiyatı ");
                    System.out.println("3-) Ürün Maliyeti ");
                    System.out.println("4-) Ürün Markası ");
                    System.out.println("5-) Ürün Türü ");
                    System.out.println("Çıkmak için -1");
                    System.out.println("********************************");
                    System.out.println("Yapmak istediğiniz işlemi seçin");
                    secim = scanner.nextLine();

                    switch (secim) {

                        case "-1":

                            break;

                        case "1":
                            System.out.println("Lütfen ürünün sayısını sayısal bir değer giriniz");
                            System.out.println("Yeni ürün sayısını giriniz: ");
                            try {
                                int urunS = scanner.nextInt();
                                scanner.nextLine();
                                elektronikler.get(i).setUrunSayisi(urunS);
                                System.out.println("Devam etmek için entera basın");
                                b = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("\n\n\nÜrünün sayısı atanamamıştır.");
                                System.out.println("Devam etmek için entera basın.");
                                b = scanner.nextLine();
                            }

                            break;

                        case "2":
                            System.out.println("Lütfen fiyatı sayısal bir değer giriniz");
                            System.out.println("Yeni ürün fiyatını giriniz: ");
                            try {
                                double fiyat = scanner.nextDouble();
                                scanner.nextLine();
                                elektronikler.get(i).setFiyat(fiyat);
                                System.out.println("Devam etmek için entera basın");
                                b = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("\n\n\nÜrünün sayısı atanamamıştır.");
                                System.out.println("Devam etmek için entera basın.");
                                b = scanner.nextLine();
                            }


                            break;

                        case "3":
                            System.out.println("Lütfen maliyeti sayısal bir değer giriniz");
                            System.out.println("Yeni ürün maliyetini giriniz: ");
                            try {
                                double maliyet = scanner.nextDouble();
                                scanner.nextLine();
                                elektronikler.get(i).setMaliyet(maliyet);
                                System.out.println("Devam etmek için entera basın");
                                b = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("\n\n\nÜrünün maliyeti atanamamıştır.");
                                System.out.println("Devam etmek için entera basın.");
                                b = scanner.nextLine();
                            }


                            break;

                        case "4":
                            System.out.println("Lütfen ürünün markasını giriniz.");
                            String marka=scanner.nextLine();
                            elektronikler.get(i).setMarka(marka);
                            System.out.println("Devam etmek için entera basın");
                            b = scanner.nextLine();

                            break;


                        case "5":
                            System.out.println("Lütfen ürünün türünü giriniz.");
                            String urunT= scanner.nextLine();
                            elektronikler.get(i).setUrunTuru(urunT);
                            System.out.println("Devam etmek için entera basın");
                            b = scanner.nextLine();
                            break;


                        default:
                            System.out.println("Tanımsız girdi");

                            break;


                    }

                }


            }

        }


    }


    public void urunEkleme(ArrayList<Kiyafetler> kiyafetler, ArrayList<Elektronik> elektronik) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-) Kıyafet");
        System.out.println("2-) Elektronik");
        System.out.println("Eklemek istediğiniz ürün tipini seçiniz.");
        String a = scanner.nextLine();
        if (a.equals("1")) {
            Kiyafetler kiyafetler1 = new Kiyafetler(Main.barkodSayac++);
            System.out.println("Lütfen ürünün sayısını sayısal bir değer giriniz");
            System.out.println("Eklemek istediğiniz kıyafetin ürün sayısını giriniz: ");
            try {
                int urunS = scanner.nextInt();
                scanner.nextLine();
                kiyafetler1.setUrunSayisi(urunS);
            } catch (Exception e) {
                System.out.println("\n\n\nÜrünün sayısı atanamamıştır.");
            }
            System.out.println("Eklemek istediğiniz kıyafetin ürün türünü giriniz: ");
            String urunT = scanner.nextLine();
            kiyafetler1.setUrunTuru(urunT);
            System.out.println("Eklemek istediğiniz kıyafetin markasını giriniz: ");
            String marka = scanner.nextLine();
            kiyafetler1.setMarka(marka);
            System.out.println("Lütfen maliyeti sayısal bir değer giriniz");
            System.out.println("Eklemek istediğiniz kıyafetin maliyetini giriniz: ");
            try {
                double maliyet = scanner.nextDouble();
                scanner.nextLine();
                kiyafetler1.setMaliyet(maliyet);
            } catch (Exception e) {
                System.out.println("\n\n\nÜrünün maliyeti atanamamıştır.");
            }
            System.out.println("Lütfen fiyatı sayısal bir değer giriniz");
            System.out.println("Eklemek istediğiniz kıyafetin fiyatını giriniz: ");
            try {
                double fiyat = scanner.nextDouble();
                scanner.nextLine();
                kiyafetler1.setFiyat(fiyat);
            } catch (Exception e) {
                System.out.println("\n\n\nÜrünün fiyatı atanamamıştır.");
            }
            System.out.println("Eklemek istediğiniz kıyafetin rengini giriniz: ");
            String renk = scanner.nextLine();
            kiyafetler1.setRenk(renk);
            System.out.println("Eklemek istediğiniz kıyafetin bedenini giriniz: ");
            String beden = scanner.nextLine();
            kiyafetler1.setBeden(beden);
            System.out.println("Eklemek istediğiniz kıyafetin cinsiyetini giriniz: ");
            String cinsiyet = scanner.nextLine();
            kiyafetler1.setCinsiyet(cinsiyet);
            kiyafetler.add(kiyafetler1);
            System.out.println(kiyafetler1.bilgileriGoster());
            System.out.println("********************************************");
            System.out.println("Devam etmek için entera basın");
            String b = scanner.nextLine();
        } else if (a.equals("2")) {
            Elektronik elektronik1 = new Elektronik(Main.barkodSayac++);
            System.out.println("Lütfen ürün sayısını sayısal bir değer giriniz");
            System.out.println("Eklemek istediğiniz elektronik ürünün sayısını giriniz: ");
            try {
                int urunS = scanner.nextInt();
                scanner.nextLine();
                elektronik1.setUrunSayisi(urunS);
            } catch (Exception e) {
                System.out.println("\n\n\nÜrünün sayısı atanamamıştır.");
            }

            System.out.println("Eklemek istediğiniz elektronik ürünün türünü giriniz: ");
            String urunT = scanner.nextLine();
            elektronik1.setUrunTuru(urunT);
            System.out.println("Eklemek istediğiniz elektronik ürünün markasını giriniz: ");
            String marka = scanner.nextLine();
            elektronik1.setMarka(marka);
            System.out.println("Lütfen maliyeti sayısal bir değer giriniz");
            System.out.println("Eklemek istediğiniz elektronik ürünün maliyetini giriniz: ");
            try {
                double maliyet = scanner.nextDouble();
                scanner.nextLine();
                elektronik1.setMaliyet(maliyet);
            } catch (Exception e) {
                System.out.println("\n\n\nÜrünün fiyatı atanamamıştır.");
            }
            System.out.println("Lütfen fiyatı sayısal bir değer giriniz");
            System.out.println("Eklemek istediğiniz elektronik ürünün fiyatını giriniz: ");
            try {
                double fiyat = scanner.nextDouble();
                scanner.nextLine();
                elektronik1.setFiyat(fiyat);
                elektronik.add(elektronik1);
            } catch (Exception e) {
                System.out.println("\n\n\nÜrünün fiyatı atanamamıştır.");
            }

            System.out.println(elektronik1.bilgileriGoster());
            System.out.println("********************************************");
            System.out.println("Devam etmek için entera basın");
            String b = scanner.nextLine();

        } else {
            System.out.println("Tanımsız girdi");
        }


    }


    @Override
    public int getId() {
        return super.getId();
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        if (maas >= 4250) {
            this.maas = maas;
        } else {
            System.out.println("Maaş asgari ücretin altında olamaz");
        }
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
