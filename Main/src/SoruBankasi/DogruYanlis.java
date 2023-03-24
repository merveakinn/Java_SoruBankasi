package SoruBankasi;
// Soru sinifindan kalitim alan DogruYanlis
public class DogruYanlis extends Soru {
    // dogru yanlis cevabi icin boolean
    private boolean cevap;
    // constructor
    public DogruYanlis(String soruMetni, int puan, String zorluk, boolean cevap) {
        super(soruMetni, puan, zorluk);
        this.cevap = cevap;
    }

    @Override
    public String toString() { // toString metodunu kendine ozgu degiskenleri de yazdirmak icin override ediyoruz
        return "DogruYanlis{" +
                "soru metni='" + this.getSoruMetni() + '\'' +
                ", puan=" + this.getPuan() +
                ", cevap=" + cevap +
                '}';
    }
    // getter setter
    public boolean isCevap() {
        return cevap;
    }

    public void setCevap(boolean cevap) {
        this.cevap = cevap;
    }
}