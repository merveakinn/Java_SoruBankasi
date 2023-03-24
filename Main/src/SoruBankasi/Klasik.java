package SoruBankasi;

// Soru sinifindan kalitim alan Klasik
public class Klasik extends Soru {
    // cevabi tutmak icin degisken
    private String cevap;
    // constructor
    public Klasik(String soruMetni, int puan, String zorluk, String cevap) {
        super(soruMetni, puan, zorluk);
        this.cevap = cevap;
    }

    @Override
    public String toString() {  // toString metodunu kendine ozgu degiskenleri de yazdirmak icin override ediyoruz
        return "Klasik{" +
                "soru metni='" + this.getSoruMetni() + '\'' +
                ", puan=" + this.getPuan() +
                ", cevap='" + cevap + '\'' +
                '}';
    }
    // getter setter
    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }
    
    
   
    
} 
