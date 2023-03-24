package SoruBankasi;

import java.util.Arrays;
// Soru sinifindan kalitim alan CoktanSecmeli
public class CoktanSecmeli extends Soru {
    // siklar icin bir dizi ve dogru cevap
    private String[] siklar = new String[4];
    private String cevap;
    // constructor
    public CoktanSecmeli(String soruMetni, int puan, String zorluk, String[] siklar, String cevap) {
        super(soruMetni, puan, zorluk);
        this.siklar = siklar;
        this.cevap = cevap;
    }

    @Override
    public String toString() { // toString metodunu kendine ozgu degiskenleri de yazdirmak icin override ediyoruz
        return "CoktanSecmeli{" +
                "soru metni='" + this.getSoruMetni() + '\'' +
                ", puan=" + this.getPuan() +
                ", siklar=" + Arrays.toString(siklar) +
                ", cevap='" + cevap + '\'' +
                '}';
    }
    // dogru siklar uzerinde aramayi override edip siklari donduruyoruz
    public String[] dogruSiklarUzerindenArama() {
        return this.getSiklar();
    }
    // dogru cevaplar uzerinde aramayi override edip dogru cevabi donduruyoruz
    public String dogruCevaplarUzerindenArama() {
        return this.getCevap();
    }
    // getter setter
    public String[] getSiklar() {
        return siklar;
    }

    public void setSiklar(String[] siklar) {
        this.siklar = siklar;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }
    
   
    
    
    
} 