package SoruBankasi;
// Soru sinifi, diger soru tipleri bundan kalitim aliyorlar ve Comparable arayuzu implemente ediliyor
public class Soru implements Comparable<Soru> {
    // soru metni, puan ve zorluk hepsinde ortak olduklari icin buradalar
    private String soruMetni;
    private int puan;
    private String zorluk;
    // constructor
    public Soru(String soruMetni, int puan, String zorluk) {
        this.soruMetni = soruMetni;
        this.puan = puan;
        this.zorluk = zorluk;
    }

    @Override
    public String toString() { // ekrana yazdirma icin toString override ediyoruz
        return "Soru{" +
                "soru metni='" + soruMetni + '\'' +
                ", puan=" + puan +
                ", zorluk='" + zorluk + '\'' +
                '}';
    }

    @Override
    public int compareTo(Soru o) { // Karsilastirma icin compareto override ediyoruz
        if (this.puan == o.puan)
            return 0;
        else if (this.puan > o.puan)
            return 1;
        else
            return -1;
    }

    public String[] dogruSiklarUzerindenArama() { // dogru siklarda arama icin metod. CoktanSecmeli'de override ediyoruz
        return null;
    }

    public String dogruCevaplarUzerindenArama() { // dogru cevaplarda arama icin metod. CoktanSecmeli'de override ediyoruz
        return null;
    }
    // getter setter
    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public String getZorluk() {
        return zorluk;
    }

    public void setZorluk(String zorluk) {
        this.zorluk = zorluk;
    }

    public String getSoruMetni() {
        return soruMetni;
    }

    public void setSoruMetni(String soruMetni) {
        this.soruMetni = soruMetni;
    }
}
