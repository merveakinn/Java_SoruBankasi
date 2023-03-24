package SoruBankasi;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in); 

    public static int anaMenu() { // uygulamadaki ana menu
        System.out.println("1 - Soru Ekleme");
        System.out.println("2 - Soru Çıkarma");
        System.out.println("3 - Soru Listeleme");
        System.out.println("4 - Sınav Oluşturma");
        System.out.println("5 - Çıkış");
        System.out.print("=> ");
        return s.nextInt();
    }

    public static int soruTipiSecimi() { // soru eklerken soru tipi secimi yaptigimiz menu
        System.out.println("1 - Çoktan Seçmeli");
        System.out.println("2 - Doğru Yanlış");
        System.out.println("3 - Boşluk Doldurma");
        System.out.println("4 - Klasik");
        System.out.println("5 - Çıkış");
        System.out.print("=> ");
        return s.nextInt();
    }

    public static int listelemeSecimi() { // listeleme yaparken listeme tipi secimi yaptigimiz menu
        System.out.println("1 - Soru Metni İçinde Arama");
        System.out.println("2 - Soru Şıklarının Metinleri İçinde");
        System.out.println("3 - Doğru Şıkları Üzerinden Arama");
        System.out.println("4 - Puan Üzerinden Arama");
        System.out.println("5 - Zorluk Derecesi Üzerinden Listeleme");
        System.out.print("=> ");
        return s.nextInt();
    }

    public static void siralama(Soru[] sorular, int length) { // sorular listelenirken puanlarına göre küçükten büyüğe doğru olacak şekilde listelenmesi icin siralama fonksiyonu
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                Soru tmp;
                if (sorular[i].compareTo(sorular[j]) == 1) {
                    tmp = sorular[i];
                    sorular[i] = sorular[j];
                    sorular[j] = tmp;
                }
            }
        }
    }

    public static void yazdir(int j, Soru[] sorular) { // listelemelerdeki yazdirma islemi
        if (j == 0) { // numaralandirma 0 ise soru bulunamamistir
            System.out.println("Soru yok.");
        } else {
            siralama(sorular, j); // sorulari kucukten buyuge sirala

            for (int i = 0; i < j; i++) {
                System.out.print((i + 1) + ". "); // ekrana soru numarasini yaz
                System.out.println(sorular[i].toString()); // ekrana soruyu yazdir
            }
        }
    }

    // ana fonksiyon
    public static void main(String[] args) {
        Soru[] soruBankasi = new Soru[50]; // 50 soruluk soru tipinda bir dizi
        int soruSayisi = 0; // soru sayimiz
        int secim; // secimler icin degisken

        while (true) { // sonsuz dongu
            secim = anaMenu(); // ana menuyu gosterip secimi aliyoruz

            switch (secim) { // secime gore switch-case
                case 1: // soru ekleme
                    secim = soruTipiSecimi(); // soru tipi menusunu gosterip secimi aliyoruz
                    s.nextLine(); // int okumadan sonra string okuma yapinca bug oluyor Java'da. O yuzden bos bir string okuma var burada, programla alakali degil
                    switch (secim) { // soru tipi secimine gore switch-case
                        case 1: // coktan secmeli
                            System.out.println("Soru metnini girin.");
                            System.out.print("=> ");
                            String soruMetni = s.nextLine(); // soru metnini aliyoruz

                            String[] siklar = new String[4]; // sirasiyla siklari aliyoruz dizi olarak
                            System.out.println("A şıkkını girin.");
                            System.out.print("=> ");
                            siklar[0] = s.nextLine();
                            System.out.println("B şıkkını girin.");
                            System.out.print("=> ");
                            siklar[1] = s.nextLine();
                            System.out.println("C şıkkını girin.");
                            System.out.print("=> ");
                            siklar[2] = s.nextLine();
                            System.out.println("D şıkkını girin.");
                            System.out.print("=> ");
                            siklar[3] = s.nextLine();

                            System.out.println("Doğru şıkkı girin.");
                            System.out.print("=> ");
                            String cevap = s.nextLine(); // dogru cevabi aliyoruz

                            System.out.println("Zorluğunu girin(Kolay/Orta/Zor).");
                            System.out.print("=> ");
                            String zorluk = s.nextLine(); // sorunun zorlugunu aliyoruz

                            System.out.println("Puanı girin.");
                            System.out.print("=> ");
                            int puan = s.nextInt(); // sorunun puanini aliyoruz
                            // Soru tipindeki dizimize CoktanSecmeli tipindeki yeni sorumuzu ekliyoruz ve soru sayisini arttiriyoruz
                            soruBankasi[soruSayisi] = new CoktanSecmeli(soruMetni, puan, zorluk, siklar, cevap);
                            soruSayisi++;

                            break;
                        case 2: // dogru yanlis
                            System.out.println("Soru metnini girin.");
                            System.out.print("=> ");
                            soruMetni = s.nextLine(); // soru metnini aliyoruz

                            System.out.println("Cevabı girin(true/false).");
                            System.out.print("=> ");
                            boolean dogruluk = s.hasNext(); // dogru yanlis cevabi aliyoruz

                            System.out.println("Zorluğunu girin(Kolay/Orta/Zor).");
                            System.out.print("=> ");
                            zorluk = s.nextLine(); // sorunun zorlugunu aliyoruz

                            System.out.println("Puanı girin.");
                            System.out.print("=> ");
                            puan = s.nextInt(); // sorunun puanini aliyoruz
                            // Soru tipindeki dizimize DogruYanlis tipindeki yeni sorumuzu ekliyoruz ve soru sayisini arttiriyoruz
                            soruBankasi[soruSayisi] = new DogruYanlis(soruMetni, puan, zorluk, dogruluk);
                            soruSayisi++;

                            break;
                        case 3: // bosluk doldurma
                            System.out.println("Soru metnini girin. Boşluk olan yere _ koyun.");
                            System.out.print("=> ");
                            soruMetni = s.nextLine(); // soru metnini aliyoruz

                            System.out.println("Boşluğa gelecek cevabı girin.");
                            System.out.print("=> ");
                            cevap = s.nextLine(); // bosluga gelecek dogru cevabi aliyoruz

                            System.out.println("Zorluğunu girin(Kolay/Orta/Zor).");
                            System.out.print("=> ");
                            zorluk = s.nextLine(); // sorunun zorlugunu aliyoruz

                            System.out.println("Puanı girin.");
                            System.out.print("=> ");
                            puan = s.nextInt(); // sorunun puanini aliyoruz
                            // Soru tipindeki dizimize BoslukDoldurma tipindeki yeni sorumuzu ekliyoruz ve soru sayisini arttiriyoruz
                            soruBankasi[soruSayisi] = new BoslukDoldurma(soruMetni, puan, zorluk, cevap);
                            soruSayisi++;

                            break;
                        case 4: // klasik
                            System.out.println("Soru metnini girin.");
                            System.out.print("=> ");
                            soruMetni = s.nextLine(); // soru metnini aliyoruz

                            System.out.println("Cevabı girin.");
                            System.out.print("=> ");
                            cevap = s.nextLine(); // dogru cevabi aliyoruz

                            System.out.println("Zorluğunu girin(Kolay/Orta/Zor).");
                            System.out.print("=> ");
                            zorluk = s.nextLine(); // sorunun zorlugunu aliyoruz

                            System.out.println("Puanı girin.");
                            System.out.print("=> ");
                            puan = s.nextInt(); // sorunun puanini aliyoruz
                            // Soru tipindeki dizimize Klasik tipindeki yeni sorumuzu ekliyoruz ve soru sayisini arttiriyoruz
                            soruBankasi[soruSayisi] = new Klasik(soruMetni, puan, zorluk, cevap);
                            soruSayisi++;

                            break;
                        case 5: // cikis
                            System.out.println("Çıkıldı.");
                            break;
                        default: // yanli secim
                            System.out.println("Hatalı Seçim!");
                    }

                    break;
                case 2: // soru cikarma
                    System.out.println("Aranacak metni girin.");
                    System.out.print("=> ");
                    s.nextLine(); // Java'dan dolayi bos satir okuma.
                    String soruMetni = s.nextLine(); // soru metnini aliyoruz

                    int j = 0; // sorulari numaralandirmak icin degisken
                    Soru[] sorular = new Soru[soruSayisi]; // aramadan cikacak sorulari tutmak icin dizi
                    for (int i = 0; i < soruSayisi; i++) { // butun sorulari donuyoruz
                        if (soruBankasi[i].getSoruMetni().contains(soruMetni)) { // eger aranan metin sorunun metninde varsa
                            System.out.print((j + 1) + ". "); // ekrana soru numarasini yaz
                            System.out.println(soruBankasi[i].toString()); // ekrana soruyu yazdir
                            sorular[j] = soruBankasi[i]; // sorular dizisine soruyu ekle
                            j++; // numaralandirmayi arttiriyoruz
                        }
                    }

                    if (j == 0) { // numaralandirma 0 ise soru bulunamamistir
                        System.out.println("Soru yok.");
                    } else { // sorular bulunmussa
                        System.out.println("Silinecek sorunun numarasını girin.");
                        System.out.print("=> ");
                        j = s.nextInt() - 1; // silinecek sorunun numarasini istiyoruz ve numaralandirma degiskeni 0'dan basladigi icin 1 azaltiyoruz
                        int i; // dongu degiskeni
                        for (i = 0; i < soruSayisi; i++) { // soru bankasini donuyoruz
                            if (soruBankasi[i].getSoruMetni().equals(sorular[j].getSoruMetni())){ // silinecek soru metnine esit mi soru metni
                                break; // esitse donguden cik
                            }
                        }

                        for (int k = i + 1; k < soruSayisi; k++) { // silinecek soruyu silmek icin butun sorulari ondan itibaren sola tasiyoruz
                            soruBankasi[k - 1] = soruBankasi[k];
                        }
                        soruSayisi--; // soru sayisini 1 azaltiyoruz
                    }

                    break;
                case 3: // soru listeleme
                    secim = listelemeSecimi(); // listeleme menusunu gosterip secimi aliyoruz

                    switch (secim) { // listeleme secimine gore switch-case
                        case 1: // Soru Metni İçinde Arama
                            System.out.println("Aranacak metni girin.");
                            System.out.print("=> ");
                            s.nextLine(); // Java'dan dolayi bos string okuma
                            soruMetni = s.nextLine(); // aranacak metni aliyoruz

                            j = 0; // numalandirma
                            sorular = new Soru[soruSayisi]; // bulunan sorular icin dizi
                            for (int i = 0; i < soruSayisi; i++) { // butun sorulari donuyoruz
                                if (soruBankasi[i].getSoruMetni().contains(soruMetni)) { // eger aranan metin sorunun metninde varsa
                                    sorular[j] = soruBankasi[i]; // sorular dizisine soruyu ekle
                                    j++; // numaralandirmayi arttir
                                }
                            }

                            yazdir(j, sorular);

                            break;
                        case 2: // Soru Şıklarının Metinleri İçinde
                            System.out.println("Şıklarda aranacak metni girin.");
                            System.out.print("=> ");
                            s.nextLine(); // Java'dan dolayi bos string okuma
                            String cevapMetni = s.nextLine(); // aranacak metni aliyoruz

                            j = 0; // numalandirma
                            sorular = new Soru[soruSayisi]; // bulunan sorular icin dizi
                            for (int i = 0; i < soruSayisi; i++) { // butun sorulari donuyoruz
                                if (soruBankasi[i].dogruSiklarUzerindenArama() != null) { // bu fonksiyondan null donuyorsa soru coktan secmeli degildir, null gelmiyorsa coktan secmelidir ve icine girer
                                    for (int k = 0; k < soruBankasi[i].dogruSiklarUzerindenArama().length; k++) { // siklar dizisi icin bir dongu
                                        if (soruBankasi[i].dogruSiklarUzerindenArama()[k].contains(cevapMetni)) { // siktaki metinde aranan metin varsa
                                            sorular[j] = soruBankasi[i]; // sorular dizisine soruyu ekle
                                            j++; // numaralandirmayi arttir
                                            break; // diger siklara bakmadan cik donguden
                                        }
                                    }
                                }
                            }

                            yazdir(j, sorular);

                            break;
                        case 3: // Doğru Şıkları Üzerinden Arama
                            System.out.println("Çoktan seçmeli cevaplarında aranacak metni girin.");
                            System.out.print("=> ");
                            s.nextLine(); // Java'dan dolayi bos string okuma
                            String cevapSikki = s.nextLine(); // aranacak metni aliyoruz

                            j = 0; // numalandirma
                            sorular = new Soru[soruSayisi]; // bulunan sorular icin dizi
                            for (int i = 0; i < soruSayisi; i++) { // butun sorulari donuyoruz
                                if (soruBankasi[i].dogruCevaplarUzerindenArama() != null) { // bu fonksiyondan null donuyorsa soru coktan secmeli degildir, null gelmiyorsa coktan secmelidir ve icine girer
                                    if (soruBankasi[i].dogruCevaplarUzerindenArama().equals(cevapSikki)) { // dogru cevap aranan sikka esit mi
                                        sorular[j] = soruBankasi[i]; // sorular dizisine soruyu ekle
                                        j++; // numaralandirmayi arttir
                                    }
                                }
                            }

                            yazdir(j, sorular);

                            break;
                        case 4: // Puan Üzerinden Arama
                            System.out.println("Aranacak puani girin.");
                            System.out.print("=> ");
                            int puan = s.nextInt(); // aranacak puani aliyoruz

                            j = 0; // numalandirma
                            sorular = new Soru[soruSayisi]; // bulunan sorular icin dizi
                            for (int i = 0; i < soruSayisi; i++) { // butun sorulari donuyoruz
                                if (soruBankasi[i].getPuan() == puan) { // aranan puana esit mi
                                    sorular[j] = soruBankasi[i]; // sorular dizisine soruyu ekle
                                    j++; // numaralandirmayi arttir
                                }
                            }

                            yazdir(j, sorular);

                            if (j == 0) { // numaralandirma 0 ise soru bulunamamistir
                                System.out.println("Soru yok.");
                            }

                            break;
                        case 5: // Zorluk Derecesi Üzerinden Listeleme
                            System.out.println("Aranacak zorluğu girin.");
                            System.out.print("=> ");
                            s.nextLine(); // Java'dan dolayi bos string okuma
                            String zorluk = s.nextLine(); // aranacak zorlugu aliyoruz

                            j = 0; // numaralandirma
                            sorular = new Soru[soruSayisi]; // bulunan sorular icin dizi
                            for (int i = 0; i < soruSayisi; i++) { // butun sorulari donuyoruz
                                if (soruBankasi[i].getZorluk().contains(zorluk)) { // aranan zorluk var mi
                                    sorular[j] = soruBankasi[i];  // sorular dizisine soruyu ekle
                                    j++; // numaralandirmayi arttir
                                }
                            }

                            yazdir(j, sorular);

                            break;
                        default: // yanlis secim
                            System.out.println("Hatalı Seçim!");
                    }

                    break;
                case 4: // sinav olusturma
                    System.out.println("1 - Test");
                    System.out.println("2 - Klasik");
                    System.out.println("3 - Karışık");
                    System.out.print("=> ");
                    secim = s.nextInt(); // sinav tipini aliyoruz

                    switch (secim) { // sinav tipine gore switch-case
                        case 1: // test
                            break;
                        case 2: // klasik
                            break;
                        case 3: // karisik
                            break;
                        default: // yanlis secim
                            System.out.println("Hatalı Seçim!");
                    }

                    break;
                case 5: // cikis
                    System.out.println("Çıkıldı.");
                    return;
                default: // yanlis secim
                    System.out.println("Hatalı Seçim!");
            }
        }
    }
}
