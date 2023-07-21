package perpustakaan;

public class MainApp {
  public static void main(String[] args) throws Exception {
    // Membuat objek buku1 dari class Buku
    Buku buku1 = new Buku("Pemrograman Java untuk programmer", "Sianipar, R.H");

    // Memanggil method printInformation() dari objek buku1
    buku1.printInformation();
  }
}
