package SoruBankasi;
// Soru sinifindan kalitim alan BoslukDoldurma
public class BoslukDoldurma extends Soru {
    // cevabi tutmak icin degisken
    private String cevap;
    // constructor
    public BoslukDoldurma(String soruMetni, int puan, String zorluk, String cevap) {
        super(soruMetni, puan, zorluk);
        this.cevap = cevap;
    }

    @Override
    public String toString() {  // toString metodunu kendine ozgu degiskenleri de yazdirmak icin override ediyoruz
        return "BoslukDoldurma{" +
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
