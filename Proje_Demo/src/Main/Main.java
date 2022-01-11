package Main;

import Insanlar.*;
import Urunler.Urunler;
import Urunler.Kiyafetler;
import Urunler.Elektronik;

import java.awt.desktop.UserSessionEvent;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int idSayac = 1;
    public static int barkodSayac = 1000;

    public static void kiyafetleriYazdir(ArrayList<Kiyafetler> kiyafetler) {//Kıyafetleri kıyafetler.txt dosyasına yazdırmayı sağlıyor.
        try {
            FileWriter yazici = new FileWriter("Kiyafetler.txt");
            for (int i = 0; i < kiyafetler.size(); i++) {
                yazici.write(kiyafetler.get(i).bilgileriGoster() + "\n****************************************\n");
            }
            yazici.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elektronikleriYazdir(ArrayList<Elektronik> elektronik) {//Elektronikleri elektronikler.txt dosyasına yazdırmayı sağlıyor.
        try {
            FileWriter yazici = new FileWriter("Elektronikler.txt");
            for (int i = 0; i < elektronik.size(); i++) {
                yazici.write(elektronik.get(i).bilgileriGoster() + "\n****************************************\n");
            }
            yazici.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void musterileriYazdir(ArrayList<Musteri> musteris, ArrayList<Vip_Musteri> vip_musteris) {

        //Müşterileri ve Vip Müşterileri Müşteriler.txt dosyasına yazdırıyor.

        try {
            FileWriter yazici = new FileWriter("Müşteriler.txt");
            for (int i = 0; i < musteris.size(); i++) {
                yazici.write(musteris.get(i).bilgilerimiGoster() + "\n****************************************\n");
            }
            for (int i = 0; i < vip_musteris.size(); i++) {
                yazici.write(vip_musteris.get(i).bilgilerimiGoster() + "\n****************************************\n");
            }

            yazici.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void calisanlariYazdir(ArrayList<Calisan> calisans) {//Çalışanları Calışanlar.txt dosyasına yazdırıyor.
        try {
            FileWriter yazici = new FileWriter("Calışanlar.txt");
            for (int i = 0; i < calisans.size(); i++) {
                yazici.write(calisans.get(i).bilgilerimiGoster() + "\n****************************************\n");
            }
            yazici.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calisanlarDosyasiniBosalt() {//Calışanlar.txt dosyasını boşaltıyor.

        try {
            FileWriter yazici = new FileWriter("Calışanlar.txt");
            yazici.write("");
            yazici.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void musterilerDosyasiniBosalt() {//Musteriler.txt dosyasını boşaltıyor.

        try {
            FileWriter yazici = new FileWriter("Müşteriler.txt");
            yazici.write("");
            yazici.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean vipGecis(ArrayList<Musteri> musteriler, ArrayList<Vip_Musteri> vip_musteriler) {

        //Müşterilerden harcaması Vip ye geçmeye yeten müşteriyi vip yapıyor.

        Musteri m = new Musteri(idSayac++);
        for (int i = 0; i < musteriler.size(); i++) {

            if (musteriler.get(i).getHarcanan() >= 50000) {
                m = musteriler.get(i);
                Vip_Musteri v = new Vip_Musteri(m.getId(), m.getAd(), m.getSoyAd(), m.geteMail(), m.getParola(), m.getTelofon(), m.getHarcanan());
                vip_musteriler.add(v);
                musteriler.remove(musteriler.get(i));
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ArrayList<Musteri> musteriler = new ArrayList<>();
        ArrayList<Vip_Musteri> vip_musteriler = new ArrayList<>();
        ArrayList<Calisan> calisanlar = new ArrayList<>();
        ArrayList<Yonetici> yoneticiler = new ArrayList<>();
        ArrayList<Kiyafetler> kiyafetler = new ArrayList<>();
        ArrayList<Elektronik> elektronikler = new ArrayList<>();

        //Data base kulanmadığımız için nesneleri array olarak tanımlayıp kodda kullanım kolaylığı sağlaması namına arraylistlere atadık.
        Musteri[] geciciMusteriler = new Musteri[50];
        Vip_Musteri[] geciciVipMusteriler = new Vip_Musteri[50];
        Calisan[] geciciCalisanlar = new Calisan[50];
        Yonetici[] geciciYoneticiler = new Yonetici[50];
        Kiyafetler[] geciciKiyafetler = new Kiyafetler[50];
        Elektronik[] geciciElektronik = new Elektronik[50];

        geciciMusteriler[0] = new Musteri(idSayac++, "Kutay", "Yıldırım", "kurtiyildo@gmail.com", "123456789", "05746489156", 49990);
        musteriler.add(geciciMusteriler[0]);
        geciciMusteriler[1] = new Musteri(idSayac++, "Alperen", "Küçüközkan", "alperen@gmail.com", "123456789", "05056349875", 5000);
        musteriler.add(geciciMusteriler[1]);
        geciciMusteriler[2] = new Musteri(idSayac++, "Mehmet", "Akgül", "mehmet@gmail.com", "123456789", "05056385275", 5000);
        musteriler.add(geciciMusteriler[2]);
        geciciMusteriler[3] = new Musteri(idSayac++, "Ahmet", "Telci", "ahmet@gmail.com", "123456789", "05056654875", 5000);
        musteriler.add(geciciMusteriler[3]);
        geciciMusteriler[4] = new Musteri(idSayac++, "Muzaffer", "Yahşi", "muzo@gmail.com", "123456789", "05059549875", 5000);
        musteriler.add(geciciMusteriler[4]);
        geciciMusteriler[5] = new Musteri(idSayac++, "Gül", "Pembe", "gülo@gmail.com", "123456789", "05056348875", 5000);
        musteriler.add(geciciMusteriler[5]);

        geciciVipMusteriler[0] = new Vip_Musteri(idSayac++, "Yusuf", "Seyfeli", "seyfeli@gmail.com", "123456789", "05621654684", 65000);
        vip_musteriler.add(geciciVipMusteriler[0]);
        geciciVipMusteriler[1] = new Vip_Musteri(idSayac++, "Emre", "Güngör", "emre@gmail.com", "123456789", "05621675484", 65000);
        vip_musteriler.add(geciciVipMusteriler[1]);
        geciciVipMusteriler[2] = new Vip_Musteri(idSayac++, "Nur", "Yıldız", "nur@gmail.com", "123456789", "05621675324", 65000);
        vip_musteriler.add(geciciVipMusteriler[2]);
        geciciVipMusteriler[3] = new Vip_Musteri(idSayac++, "Dilara", "Toprakçı", "dilara@gmail.com", "123456789", "05621684584", 65000);
        vip_musteriler.add(geciciVipMusteriler[3]);
        geciciVipMusteriler[4] = new Vip_Musteri(idSayac++, "Canan", "Canan", "canan@gmail.com", "123456789", "05621659514", 65000);
        vip_musteriler.add(geciciVipMusteriler[4]);

        geciciCalisanlar[0] = new Calisan(idSayac++, "Yaren", "Sarı", "yarensarı@gmail.com", "123456789", "05926846674", 7500);
        calisanlar.add(geciciCalisanlar[0]);
        geciciCalisanlar[1] = new Calisan(idSayac++, "Aslan", "Aslan", "aslan@gmail.com", "123456789", "05926654674", 5000);
        calisanlar.add(geciciCalisanlar[1]);
        geciciCalisanlar[2] = new Calisan(idSayac++, "Ali", "Demirkesen", "ali@gmail.com", "123456789", "05926846612", 6000);
        calisanlar.add(geciciCalisanlar[2]);
        geciciCalisanlar[3] = new Calisan(idSayac++, "Veli", "Sarı", "veli@gmail.com", "123456789", "05926898674", 4300);
        calisanlar.add(geciciCalisanlar[3]);


        geciciKiyafetler[0] = new Kiyafetler(barkodSayac++, 100, "Adidas", "Hoodie", 100, 500, "Mavi", "XXL", "Erkek");
        kiyafetler.add(geciciKiyafetler[0]);
        geciciElektronik[0] = new Elektronik(barkodSayac++, 100, "Samsung", "Telefon", 500, 6000);
        elektronikler.add(geciciElektronik[0]);
        geciciYoneticiler[0] = new Yonetici(idSayac++, "Atıf", "Küçüközkan", "a", "1", "05070646146", 10000);
        yoneticiler.add(geciciYoneticiler[0]);
        geciciKiyafetler[1] = new Kiyafetler(barkodSayac++);


        System.out.println("Hoşgeldiniz");
        Scanner scanner = new Scanner(System.in);
        kiyafetleriYazdir(kiyafetler);
        elektronikleriYazdir(elektronikler);


        while (true) {//Giriş Döngüsü
            boolean kontrolMekanizmasi = true;// Hatalı girişi kontrol etmek için tanımlı
            System.out.println("1-) Yönetici Girişi");
            System.out.println("2-) Çalışan Girişi");
            System.out.println("3-) Müşteri Girişi");
            System.out.println("4-) Müşteri Kayıt Olma");
            System.out.println("Çıkmak için -1");
            System.out.println("********************************");
            System.out.println("Giriş Tipini seçiniz:");
            String secim = scanner.nextLine();//Seçimleri atadığımız kısım
            String b;//Boşun b si kod çalşırken anlık geçişler olmaması için b yi atadık atamasak da olurdu atadık çünkü boş adamlarız
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            int barkod;
            switch (secim) {

                case "-1"://Çıkış
                    System.exit(0);//Programın çalışmasını durdurur
                    break;
                case "1"://Yönetici Girişi
                    Yonetici y = new Yonetici(idSayac++);//Yoneticinin girişini kontrol etmek amaçlı oluşturulmuş bir yönetici nesnesi
                    System.out.println("E-mailinizi Girin: ");
                    y.seteMail(scanner.nextLine());
                    System.out.println("Parolanızı Girin: ");
                    y.setParola(scanner.nextLine());

                    for (int i = 0; i < yoneticiler.size(); i++) {

                        if (y.geteMail().equals(yoneticiler.get(i).geteMail()) && y.getParola().equals(yoneticiler.get(i).getParola())) {//Yönetici giriş kontrol kısmı
                            kontrolMekanizmasi = false;
                            musterileriYazdir(musteriler, vip_musteriler);//Yöneticinin müşterilerin bilgilerine kolayca ulaşmasına olanak sağlıyoruz
                            calisanlariYazdir(calisanlar);//Yöneticinin çalışanların bilgilerine kolayca ulaşmasına olanak sağlıyoruz
                            while (!secim.equals("-1")) {
                                System.out.println("********************************");
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                System.out.println("1-) Bilgilerinizi kontrol edin: ");
                                System.out.println("2-) Ürün Ekleme: ");
                                System.out.println("3-) Ürün Silme: ");
                                System.out.println("4-) İndirim Yapma: ");
                                System.out.println("5-) Çalışan Ekleme: ");
                                System.out.println("6-) Çalışan Çıkarma: ");
                                System.out.println("7-) Müşteri Çıkarma: ");
                                System.out.println("8-) Bilgilerinizi Güncelleyin: ");
                                System.out.println("9-) Ürün bilgisi Görme: ");
                                System.out.println("10-) Çalışan maaşını değiştirme: ");
                                System.out.println("11-) Ürün bilgisi değiştirme:  ");
                                System.out.println("12-) Müşterilerin indirim istemelerini sıfırlama:  ");
                                System.out.println("13-) Müşterilerin ürün istemelerini sıfırlama:  ");
                                System.out.println("Çıkmak için -1");
                                System.out.println("********************************");
                                System.out.println("Yapmak istediğiniz işlemi seçin: ");

                                secim = scanner.nextLine();
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                switch (secim) {


                                    case "-1"://Ana menüye dönmek için
                                        musterilerDosyasiniBosalt();//yöneticinin dışındakilerin bu bilgilere erişememesi için
                                        calisanlarDosyasiniBosalt();//yöneticinin dışındakilerin bu bilgilere erişememesi için
                                        break;

                                    case "1"://Yöneticinin kendi bilgilerine bakması için
                                        System.out.println(yoneticiler.get(i).bilgilerimiGoster());
                                        System.out.println("********************************************");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();

                                        break;

                                    case "2"://Yöneticinin ürün eklemesi için
                                        yoneticiler.get(i).urunEkleme(kiyafetler, elektronikler);
                                        kiyafetleriYazdir(kiyafetler);
                                        elektronikleriYazdir(elektronikler);
                                        break;

                                    case "3"://Yöneticinin ürün silmesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Silmek istediğininz ürünün barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            yoneticiler.get(i).urunSilme(barkod, kiyafetler, elektronikler);
                                            kiyafetleriYazdir(kiyafetler);
                                            elektronikleriYazdir(elektronikler);

                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        } catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        }

                                        break;

                                    case "4"://Yöneticinin indirim yapması için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("İndirim yapmak istediğiniz kıyafetin barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("İndirim oranını giriniz.");
                                            double indirimOrani = scanner.nextDouble();
                                            scanner.nextLine();
                                            yoneticiler.get(i).indirimYap(barkod, indirimOrani, kiyafetler);
                                            kiyafetleriYazdir(kiyafetler);
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        }

                                        break;

                                    case "5"://Yöneticinin personel eklemesi için
                                        yoneticiler.get(i).personelEkle(calisanlar);
                                        calisanlariYazdir(calisanlar);//Calışanlar.txt dosyasının güncellenmesi için
                                        System.out.println("Devam etmek için entera basın.");
                                        b = scanner.nextLine();

                                        break;
                                    case "6"://Yöneticinin personel çıkarması için
                                        System.out.println("Lütfen id yi sayısal bir değer giriniz");
                                        System.out.println("Çıkarmak istediğiniz çalışanın id sini giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            //yoneticiler.get(i).personelCikar(barkod,calisanlar);
                                            for (int j = 0; j < calisanlar.size(); j++) {
                                                if (calisanlar.get(j).getId() == barkod) {
                                                    calisanlar.remove(calisanlar.get(j));
                                                    System.out.println("Calışan çıkarma başarılı");
                                                }
                                            }
                                            calisanlariYazdir(calisanlar);//Calışanlar.txt dosyasının güncellenmesi için
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı id girdiniz");
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        }

                                        break;
                                    case "7"://Yöneticinin müşteri çkarması için
                                        System.out.println("Lütfen id yi sayısal bir değer giriniz");
                                        System.out.println("Çıkarmak istediğiniz müşterinin id sini giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            //yoneticiler.get(i).musteriCikar(barkod,musteriler,vip_musteriler);
                                            for (int j = 0; j < musteriler.size(); j++) {

                                                if (musteriler.get(j).getId() == barkod) {
                                                    musteriler.remove(musteriler.get(j));
                                                }
                                            }
                                            for (int j = 0; j < vip_musteriler.size(); j++) {

                                                if (vip_musteriler.get(j).getId() == barkod) {
                                                    vip_musteriler.remove(vip_musteriler.get(j));
                                                }
                                            }
                                            musterileriYazdir(musteriler, vip_musteriler);//Müşteriler.txt dosyasının güncellenmesi için
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı id girdiniz");
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        }

                                        break;

                                    case "8"://Yöneticinin kendi bilgilerini güncellemesi için
                                        System.out.println(yoneticiler.get(i).bilgilerimiGoster());

                                        while (!secim.equals("-1")) {
                                            System.out.println("********************************");
                                            System.out.println("1-) Ad");
                                            System.out.println("2-) Soyad");
                                            System.out.println("3-) E-mail");
                                            System.out.println("4-) Parola");
                                            System.out.println("5-) Telefon");
                                            System.out.println("Çıkmak için -1");
                                            System.out.println("********************************");
                                            System.out.println("Değiştirmek istediğiniz bilginizi seçin.");
                                            secim = scanner.nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                            switch (secim) {


                                                case "-1"://Çıkarken güncel bilgilerini görmesi için

                                                    System.out.println(yoneticiler.get(i).bilgilerimiGoster());
                                                    System.out.println("Devam etmek için entera basın");
                                                    b = scanner.nextLine();
                                                    break;

                                                case "1":
                                                    System.out.println("Yeni Adınızı giriniz");
                                                    String ad = scanner.nextLine();
                                                    yoneticiler.get(i).setAd(ad);
                                                    break;

                                                case "2":
                                                    System.out.println("Yeni Soyadınızı giriniz");
                                                    String soyad = scanner.nextLine();
                                                    yoneticiler.get(i).setSoyAd(soyad);
                                                    break;

                                                case "3":
                                                    System.out.println("Yeni E-mailinizi giriniz");
                                                    String email = scanner.nextLine();
                                                    yoneticiler.get(i).seteMail(email);
                                                    break;

                                                case "4":
                                                    System.out.println("Yeni Parolanızı giriniz");
                                                    String parola = scanner.nextLine();
                                                    yoneticiler.get(i).setParola(parola);
                                                    break;

                                                case "5":
                                                    System.out.println("Yeni Telefonunuzu giriniz");
                                                    String telefon = scanner.nextLine();
                                                    yoneticiler.get(i).setTelofon(telefon);
                                                    break;

                                                default:
                                                    System.out.println("Tanımsız girdi.");
                                                    break;

                                            }
                                        }

                                        break;

                                    case "9"://Yöneticinin ürünlerin detaylı bilgilerini görmesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Bilgisini görmek istediğiniz ürünün barkodunu giriniz.");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println(yoneticiler.get(i).urunBilgisi(barkod, kiyafetler, elektronikler));

                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basın");
                                            b = scanner.nextLine();
                                        }


                                        break;

                                    case "10"://Yöneticinin çalışanların maaşını değiştirmesi için
                                        System.out.println("Lütfen id yi sayısal bir değer giriniz");
                                        System.out.println("Maaşını değiştirmek istediğiniz çalışanın id sini giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            for (int j = 0; j < calisanlar.size(); j++) {

                                                if (calisanlar.get(j).getId() == barkod) {
                                                    System.out.println("Çalışanın şuanki maaşı: " + calisanlar.get(j).getMaas());
                                                    System.out.println("******************************");
                                                    System.out.println("Çalışanın yeni maaşını giriniz: ");
                                                    double maas = scanner.nextDouble();
                                                    calisanlar.get(j).setMaas(maas);
                                                    calisanlariYazdir(calisanlar);
                                                    System.out.println("Devam etmek için entera basın");
                                                    b = scanner.nextLine();
                                                    break;
                                                }
                                            }
                                        }catch (Exception e){
                                            System.out.println("Hatalı id girdiniz");
                                            System.out.println("Devam etmek için entera basın");
                                            b = scanner.nextLine();
                                        }


                                        break;

                                    case "11"://Yöneticinin ürünlerin bilgisini değiştirmesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Bilgisini değiştirmek istediğiniz ürünün barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            yoneticiler.get(i).urunBilgiDegistirme(barkod, kiyafetler, elektronikler);
                                            kiyafetleriYazdir(kiyafetler);
                                            elektronikleriYazdir(elektronikler);
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basın");
                                            b = scanner.nextLine();
                                        }


                                        break;

                                    case "12"://Yöneticinin müşterilerin indirim isteme haklarını sıfırlaması için
                                        yoneticiler.get(i).indirimIstemeSifirlama(musteriler, vip_musteriler);
                                        System.out.println("İşlem Başarılı\n");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();
                                        break;

                                    case "13"://Yöneticinin müşterilerin ürün isteme haklarını sıfırlaması için
                                        yoneticiler.get(i).urunIstemeSifirlama(musteriler, vip_musteriler);
                                        System.out.println("İşlem Başarılı\n");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();
                                        break;

                                    default:
                                        System.out.println("Tanımsız Girdi...");
                                        break;
                                }


                            }

                        }
                    }
                    if (kontrolMekanizmasi) {
                        System.out.println("E-mail veya parola hatalı");
                    }

                    break;

                case "2"://Çalışan Girişi
                    Calisan c = new Calisan(idSayac++);//Calışanın girişini kontrol etmek amaçlı oluşturulmuş bir çalışan nesnesi
                    System.out.println("E-mailinizi Girin: ");
                    c.seteMail(scanner.nextLine());
                    System.out.println("Parolanızı Girin: ");
                    c.setParola(scanner.nextLine());

                    for (int i = 0; i < calisanlar.size(); i++) {

                        if (c.geteMail().equals(calisanlar.get(i).geteMail()) && c.getParola().equals(calisanlar.get(i).getParola())) {//Çalışanın giriş kontrolü

                            kontrolMekanizmasi = false;
                            musterileriYazdir(musteriler, vip_musteriler);//Çalışanların müşterilerin bilgilerine kolayca ulaşabilmesi için
                            while (!secim.equals("-1")) {
                                System.out.println("********************************");
                                System.out.println("1-) Bilgirinizi kontrol edin: ");
                                System.out.println("2-) Urun ekleme: ");
                                System.out.println("3-) Bilgilerinizi Güncelleyin: ");
                                System.out.println("4-) Ürün bilgisi Görme: ");
                                System.out.println("5-) Ürün bilgisi değiştirme: ");
                                System.out.println("6-) Müşterilerin indirim istemelerini sıfırlama: ");
                                System.out.println("7-) Müşterilerin ürün istemelerini sıfırlama: ");
                                System.out.println("Çıkış için -1");
                                System.out.println("********************************");
                                System.out.println("Yapmak istediğiniz işlemi seçin: ");

                                secim = scanner.nextLine();
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                switch (secim) {

                                    case "-1":
                                        musterilerDosyasiniBosalt();//Müşterilerin bilgilerinin başkaları tarafından öğrenilmemesi için
                                        break;

                                    case "1"://Çalışanların kendi bilgilerini öğrenmesi için
                                        System.out.println(calisanlar.get(i).bilgilerimiGoster());
                                        System.out.println("********************************************");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();

                                        break;


                                    case "2"://Çalışanların ürün eklemesi için
                                        calisanlar.get(i).urunEkleme(kiyafetler, elektronikler);
                                        kiyafetleriYazdir(kiyafetler);
                                        elektronikleriYazdir(elektronikler);
                                        break;

                                    case "3"://Çalışanların kendi bilgilerini güncellemesi için
                                        System.out.println(calisanlar.get(i).bilgilerimiGoster());

                                        while (!secim.equals("-1")) {
                                            System.out.println("********************************");
                                            System.out.println("1-) Ad");
                                            System.out.println("2-) Soyad");
                                            System.out.println("3-) E-mail");
                                            System.out.println("4-) Parola");
                                            System.out.println("5-) Telefon");
                                            System.out.println("Çıkmak için -1");
                                            System.out.println("********************************");
                                            System.out.println("Değiştirmek istediğiniz bilginizi seçin.");
                                            secim = scanner.nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                            switch (secim) {


                                                case "-1":
                                                    System.out.println(calisanlar.get(i).bilgilerimiGoster());
                                                    System.out.println("Devam etmek için entera basın");
                                                    b = scanner.nextLine();

                                                    break;

                                                case "1":
                                                    System.out.println("Yeni Adınızı giriniz");
                                                    String ad = scanner.nextLine();
                                                    calisanlar.get(i).setAd(ad);
                                                    break;

                                                case "2":
                                                    System.out.println("Yeni Soyadınızı giriniz");
                                                    String soyad = scanner.nextLine();
                                                    calisanlar.get(i).setSoyAd(soyad);
                                                    break;

                                                case "3":
                                                    System.out.println("Yeni E-mailinizi giriniz");
                                                    String email = scanner.nextLine();
                                                    calisanlar.get(i).seteMail(email);
                                                    break;

                                                case "4":
                                                    System.out.println("Yeni Parolanızı giriniz");
                                                    String parola = scanner.nextLine();
                                                    calisanlar.get(i).setParola(parola);
                                                    break;

                                                case "5":
                                                    System.out.println("Yeni Telefonunuzu giriniz");
                                                    String telefon = scanner.nextLine();
                                                    calisanlar.get(i).setTelofon(telefon);
                                                    break;

                                                default:
                                                    System.out.println("Tanımsız girdi.");
                                                    break;

                                            }
                                        }


                                        break;
                                    case "4"://Çalışanların ürünlerin detalı bilgilerini öğrenmesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Bilgisini görmek istediğiniz ürünün barkodunu giriniz.");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println(calisanlar.get(i).urunBilgisi(barkod, kiyafetler, elektronikler));
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basın");
                                            b = scanner.nextLine();

                                        }

                                        break;

                                    case "5"://Çalışanların ürünlerin bilgilerini değiştirmesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Bilgisini değiştirmek istediğininz ürünün barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            calisanlar.get(i).urunBilgiDegistirme(barkod, kiyafetler, elektronikler);
                                            kiyafetleriYazdir(kiyafetler);
                                            elektronikleriYazdir(elektronikler);
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basın");
                                            b = scanner.nextLine();
                                        }


                                        break;

                                    case "6"://Çalışanların Müşterilerin indirim isteme haklarını sıfırlaması için
                                        calisanlar.get(i).indirimIstemeSifirlama(musteriler, vip_musteriler);
                                        System.out.println("İşlem Başarılı\n");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();
                                        break;
                                    case "7"://Çalışanların Müşterilerin ürün isteme haklarını sıfırlaması için
                                        calisanlar.get(i).urunIstemeSifirlama(musteriler, vip_musteriler);
                                        System.out.println("İşlem Başarılı\n");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();

                                        break;
                                    default:
                                        System.out.println("Tanımsız Girdi...");
                                        break;
                                }
                            }
                        }
                    }
                    if (kontrolMekanizmasi) {
                        System.out.println("E-mail veyya parola hatalı");
                    }

                    break;

                case "3"://Müşteri Girişi
                    Musteri m = new Musteri(idSayac++);//Müşterilerin girişini kontrol etmek amaçlı oluşturulmuş bir müşteri nesnesi
                    Vip_Musteri v = new Vip_Musteri(idSayac++);
                    System.out.println("E-mailinizi Girin: ");
                    m.seteMail(scanner.nextLine());
                    v.seteMail(m.geteMail());
                    System.out.println("Parolanızı Girin: ");
                    m.setParola(scanner.nextLine());
                    v.setParola(m.getParola());

                    for (int i = 0; i < musteriler.size(); i++) {

                        if (m.geteMail().equals(musteriler.get(i).geteMail()) && m.getParola().equals(musteriler.get(i).getParola())) {//müşterinin kontrol aşaması

                            kontrolMekanizmasi = false;
                            while (!secim.equals("-1")) {
                                System.out.println("********************************");
                                System.out.println("1-) Bilgilerimi Göster: ");
                                System.out.println("2-) Ürün Alma: ");
                                System.out.println("3-) İndirim İsteme: ");
                                System.out.println("4-) Ürün İsteme: ");
                                System.out.println("5-) Bilgilerinizi Güncelleyin: ");
                                System.out.println("6-) Sepet oluşturma: ");
                                System.out.println("Çıkış İçin -1 ");
                                System.out.println("********************************");
                                System.out.println("Yapmak istediğiniz işlemi seçin: ");
                                secim = scanner.nextLine();
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                switch (secim) {

                                    case "-1":

                                        break;

                                    case "1"://Müşterilerin bilgilerini görmesi için
                                        System.out.println(musteriler.get(i).bilgilerimiGoster());
                                        System.out.println("********************************************");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();

                                        break;


                                    case "2"://Müşterilerin ürün alması için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Almak istediğiniz ürünün barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            musteriler.get(i).urunAlma(barkod, kiyafetler, elektronikler);
                                            if (vipGecis(musteriler, vip_musteriler)) {
                                                System.out.println("Tebrikler Artık Vip bir müşterisiniz.\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\"");
                                                secim = "-1";
                                            }
                                            kiyafetleriYazdir(kiyafetler);
                                            elektronikleriYazdir(elektronikler);
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basınız.");
                                            b = scanner.nextLine();
                                        }

                                        break;

                                    case "3"://müşterilerin indirim istemesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("İndirime girmesini istediğiniz kıyafetin barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            musteriler.get(i).indirimIsteme(barkod, kiyafetler);
                                            kiyafetleriYazdir(kiyafetler);
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basınız.");
                                            b = scanner.nextLine();

                                        }

                                        break;

                                    case "4"://Müşterilerin ürün sayısı0 olan ürünlerin gelmesini istemesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Gelmesini istediğiniz kıyafetin barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            musteriler.get(i).urunIsteme(barkod, kiyafetler);
                                            kiyafetleriYazdir(kiyafetler);
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz");
                                            System.out.println("Devam etmek için entera basınız.");
                                            b = scanner.nextLine();
                                        }


                                        break;

                                    case "5"://Müşterilerin kendi bilgilerini değiştirmesi için
                                        System.out.println(musteriler.get(i).bilgilerimiGoster());

                                        while (!secim.equals("-1")) {
                                            System.out.println("********************************");
                                            System.out.println("1-) Ad");
                                            System.out.println("2-) Soyad");
                                            System.out.println("3-) E-mail");
                                            System.out.println("4-) Parola");
                                            System.out.println("5-) Telefon");
                                            System.out.println("Çıkmak için -1");
                                            System.out.println("********************************");
                                            System.out.println("Değiştirmek istediğiniz bilginizi seçin.");
                                            secim = scanner.nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                            switch (secim) {


                                                case "-1":
                                                    System.out.println(musteriler.get(i).bilgilerimiGoster());
                                                    System.out.println("Devam etmek için entera basın");
                                                    b = scanner.nextLine();

                                                    break;

                                                case "1":
                                                    System.out.println("Yeni Adınızı giriniz");
                                                    String ad = scanner.nextLine();
                                                    musteriler.get(i).setAd(ad);
                                                    break;

                                                case "2":
                                                    System.out.println("Yeni Soyadınızı giriniz");
                                                    String soyad = scanner.nextLine();
                                                    musteriler.get(i).setSoyAd(soyad);
                                                    break;

                                                case "3":
                                                    System.out.println("Yeni E-mailinizi giriniz");
                                                    String email = scanner.nextLine();
                                                    musteriler.get(i).seteMail(email);
                                                    break;

                                                case "4":
                                                    System.out.println("Yeni Parolanızı giriniz");
                                                    String parola = scanner.nextLine();
                                                    musteriler.get(i).setParola(parola);
                                                    break;

                                                case "5":
                                                    System.out.println("Yeni Telefonunuzu giriniz");
                                                    String telefon = scanner.nextLine();
                                                    musteriler.get(i).setTelofon(telefon);
                                                    break;

                                                default:
                                                    System.out.println("Tanımsız girdi.");
                                                    break;

                                            }
                                        }


                                        break;

                                    case "6"://Müşterilerin Spet oluşturması için
                                        double toplam = 0;
                                        ArrayList<Integer> secimler = new ArrayList<>();
                                        while (!secim.equals("-1")) {

                                            System.out.println("\n\nÜrün eklemek için 1");
                                            System.out.println("Sepeti almak için 2");
                                            System.out.println("Çıkış için -1");
                                            System.out.println("*****************************");
                                            System.out.println("Yapmak istediğinizi seçin.");
                                            secim = scanner.nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            switch (secim) {

                                                case "-1":
                                                    if (vipGecis(musteriler, vip_musteriler)){
                                                        System.out.println("Tebrikler Artık Vip bir müşterisiniz.\n\n\n\n\n\n\n");
                                                        secim = "-1";

                                                    }
                                                    System.out.println("Devam etmek için entera basın.");
                                                    b = scanner.nextLine();

                                                    break;

                                                case "1":
                                                    System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                                    System.out.println("\n\nEklemek istediğiniz ürünün barkodunu giriniz.");
                                                    try {
                                                        barkod = scanner.nextInt();
                                                        scanner.nextLine();
                                                        secimler.add(barkod);
                                                    }catch (Exception e){
                                                        System.out.println("Hatalı barkod girdiniz.");
                                                    }


                                                    break;

                                                case "2":
                                                    for (int j = 0; j < secimler.size(); j++) {
                                                        toplam += musteriler.get(i).urunAlma(secimler.get(j), kiyafetler, elektronikler);
                                                    }
                                                    System.out.println("Toplam Ücret             : " + toplam);
                                                    musteriler.get(i).setHarcanan(musteriler.get(i).getHarcanan() + toplam);
                                                    secimler.clear();
                                                    toplam = 0;
                                                    if (vipGecis(musteriler, vip_musteriler)){
                                                        System.out.println("Tebrikler Artık Vip bir müşterisiniz.\n\n\n\n\n\n\n");
                                                        secim = "-1";
                                                    }
                                                    break;


                                                default:
                                                    System.out.println("Tanımsız girdi\n\n");
                                                    break;

                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Tanımsız Girdi...");
                                        break;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < vip_musteriler.size(); i++) {

                        if (v.geteMail().equals(vip_musteriler.get(i).geteMail()) && v.getParola().equals(vip_musteriler.get(i).getParola())) {

                            kontrolMekanizmasi = false;
                            while (!secim.equals("-1")) {
                                System.out.println("********************************");
                                System.out.println("        Vip");
                                System.out.println("1-) Bilgilerimi Göster: ");
                                System.out.println("2-) Ürün Alma: ");
                                System.out.println("3-) İndirim İsteme: ");
                                System.out.println("4-) Ürün İsteme: ");
                                System.out.println("5-) Bilgilerinizi Güncelleyin: ");
                                System.out.println("6-) Sepet oluştumak için : ");
                                System.out.println("Çıkış İçin -1 ");
                                System.out.println("********************************");
                                System.out.println("Yapmak istediğiniz işlemi seçin: ");

                                secim = scanner.nextLine();
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                switch (secim) {

                                    case "-1":

                                        break;

                                    case "1"://Viplerin bigilerini görmesi için
                                        System.out.println(vip_musteriler.get(i).bilgilerimiGoster());
                                        System.out.println("********************************************");
                                        System.out.println("Devam etmek için entera basın");
                                        b = scanner.nextLine();

                                        break;


                                    case "2"://Viplerin ürün alması için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Almak istediğiniz ürünün barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            vip_musteriler.get(i).urunAlma(barkod, kiyafetler, elektronikler);
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();

                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz.");
                                            System.out.println("Devam etmek için entera basınız.");
                                            b = scanner.nextLine();
                                        }

                                        break;

                                    case "3"://Viplerin indirim istemesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("İndirime girmseini istediğiniz ürünün baarkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            vip_musteriler.get(i).indirimIsteme(barkod, kiyafetler);
                                            kiyafetleriYazdir(kiyafetler);
                                            System.out.println("Devam etmek için entera basınız.");
                                            b = scanner.nextLine();
                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz.");
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        }

                                        break;

                                    case "4"://Viplerin ürün istemesi için
                                        System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                        System.out.println("Gelmesini istediğiniz ürünün barkodunu giriniz: ");
                                        try {
                                            barkod = scanner.nextInt();
                                            scanner.nextLine();
                                            vip_musteriler.get(i).urunIsteme(barkod, kiyafetler);
                                            kiyafetleriYazdir(kiyafetler);
                                            System.out.println("Devam etmek için entera basınız.");
                                            b = scanner.nextLine();
                                        }catch (Exception e){
                                            System.out.println("Hatalı barkod girdiniz.");
                                            System.out.println("Devam etmek için entera basın.");
                                            b = scanner.nextLine();
                                        }

                                        break;

                                    case "5"://Viplerin bilgi güncellemesi
                                        System.out.println(vip_musteriler.get(i).bilgilerimiGoster());

                                        while (!secim.equals("-1")) {
                                            System.out.println("********************************");
                                            System.out.println("1-) Ad");
                                            System.out.println("2-) Soyad");
                                            System.out.println("3-) E-mail");
                                            System.out.println("4-) Parola");
                                            System.out.println("5-) Telefon");
                                            System.out.println("Çıkmak için -1");
                                            System.out.println("********************************");
                                            System.out.println("Değiştirmek istediğiniz bilginizi seçin.");
                                            secim = scanner.nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                            switch (secim) {

                                                case "-1":
                                                    System.out.println(vip_musteriler.get(i).bilgilerimiGoster());
                                                    System.out.println("Devam etmek için entera basın");
                                                    b = scanner.nextLine();

                                                    break;

                                                case "1":
                                                    System.out.println("Yeni Adınızı giriniz");
                                                    String ad = scanner.nextLine();
                                                    vip_musteriler.get(i).setAd(ad);
                                                    break;

                                                case "2":
                                                    System.out.println("Yeni Soyadınızı giriniz");
                                                    String soyad = scanner.nextLine();
                                                    vip_musteriler.get(i).setSoyAd(soyad);
                                                    break;

                                                case "3":
                                                    System.out.println("Yeni E-mailinizi giriniz");
                                                    String email = scanner.nextLine();
                                                    vip_musteriler.get(i).seteMail(email);
                                                    break;

                                                case "4":
                                                    System.out.println("Yeni Parolanızı giriniz");
                                                    String parola = scanner.nextLine();
                                                    vip_musteriler.get(i).setParola(parola);
                                                    break;

                                                case "5":
                                                    System.out.println("Yeni Telefonunuzu giriniz");
                                                    String telefon = scanner.nextLine();
                                                    vip_musteriler.get(i).setTelofon(telefon);
                                                    break;

                                                default:
                                                    System.out.println("Tanımsız girdi.");
                                                    break;

                                            }
                                        }

                                        break;
                                    case "6"://Viplerin sepeti
                                        double toplam = 0;
                                        ArrayList<Integer> secimler = new ArrayList<>();
                                        while (!secim.equals("-1")) {

                                            System.out.println("\n\nÜrün eklemek için 1");
                                            System.out.println("Sepeti almak için 2");
                                            System.out.println("Çıkış için -1");
                                            System.out.println("*****************************");
                                            System.out.println("Yapmak istediğinizi seçin.");
                                            secim = scanner.nextLine();
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            switch (secim) {

                                                case "-1":

                                                    break;

                                                case "1":
                                                    System.out.println("Lütfen barkodu sayısal bir değer giriniz");
                                                    System.out.println("\n\nEklemek istediğiniz ürünün barkodunu giriniz.");
                                                    try {
                                                        barkod = scanner.nextInt();
                                                        scanner.nextLine();
                                                        secimler.add(barkod);
                                                    }catch (Exception e){
                                                        System.out.println("Hatalı barkod girdiniz.");
                                                    }


                                                    break;

                                                case "2":
                                                    for (int j = 0; j < secimler.size(); j++) {
                                                        toplam += vip_musteriler.get(i).urunAlma(secimler.get(j), kiyafetler, elektronikler);
                                                    }
                                                    System.out.println("Toplam Ücret             : " + toplam);
                                                    vip_musteriler.get(i).setHarcanan(vip_musteriler.get(i).getHarcanan() + toplam);
                                                    secimler.clear();
                                                    toplam = 0;
                                                    break;

                                                default:
                                                    System.out.println("Tanımsız girdi\n\n");
                                                    break;

                                            }
                                        }
                                        break;

                                    default:
                                        System.out.println("Tanımsız Girdi...");
                                        break;
                                }
                            }
                        }
                    }
                    if (kontrolMekanizmasi) {
                        System.out.println("E-mail veya parola hatalı");
                    }

                    break;

                case "4"://Kaydı olmayan birinin müşteri olarak kayıt olması için
                    Musteri musteri = new Musteri(idSayac++);

                    System.out.println("Adınızı giriniz: ");
                    String ad = scanner.nextLine();
                    musteri.setAd(ad);
                    System.out.println("Soyadınızı giriniz: ");
                    String soyad = scanner.nextLine();
                    musteri.setSoyAd(soyad);
                    System.out.println("E-mailinizi giriniz: ");
                    String email = scanner.nextLine();
                    musteri.seteMail(email);
                    System.out.println("Parolanızı giriniz: ");
                    String parola = scanner.nextLine();
                    musteri.setParola(parola);
                    System.out.println("Telefon numaranızı giriniz: ");
                    String telefon = scanner.nextLine();
                    musteri.setTelofon(telefon);
                    musteri.setHarcanan(0);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Bilgileriniz: ");
                    System.out.println(musteri.bilgilerimiGoster());
                    musteriler.add(musteri);
                    System.out.println("Devam etmek için entera basınız.");
                    b = scanner.nextLine();

                    break;

                default:
                    System.out.println("Tanımsız girdi ");
                    break;
            }
        }
    }
}
