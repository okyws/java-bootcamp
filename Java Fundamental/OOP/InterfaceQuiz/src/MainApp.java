public class MainApp {
  public static void main(String[] args) {
    // Membuat Objek dari Class yang di buat sebelumnya
    PersegiPanjang persegiPanjang1 = new PersegiPanjang(11.0, 7.0);
    Persegi persegi1 = new Persegi(9.0);
    Lingkaran lingkaran1 = new Lingkaran(11.0);
    Lingkaran lingkaran2 = new Lingkaran(8);

    // Menampilkan Hasil Perhitungan
    System.out.println(persegiPanjang1.getKeliling());
    System.out.println(persegiPanjang1.getLuas());
    System.out.println();
    System.out.println(persegi1.getKeliling());
    System.out.println(persegi1.getLuas());
    System.out.println();
    System.out.println(lingkaran1.getKeliling());
    System.out.println(lingkaran1.getLuas());
    System.out.println();
    System.out.println(lingkaran2.getKeliling());
    System.out.println(lingkaran2.getLuas());
  }
}
