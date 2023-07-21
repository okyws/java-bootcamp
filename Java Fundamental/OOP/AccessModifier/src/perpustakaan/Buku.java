package perpustakaan;

class Buku {
  /*
   * Access Modifier untuk dapat mengakses class ini di package yang sama
   * bisa menggunakan access modifier default (tidak menggunakan access modifier)
   *
   * bisa juga menggunakan access modifier public dan protected
   * namun jika menggunakan access modifier protected, maka class ini hanya dapat
   * diakses oleh class yang berada di package yang sama atau class yang merupakan
   * turunan dari class ini yang berada di package sama maupun yang berbeda
   *
   * untuk attribute / field / properties bisa menggunakan access
   * modifier public, protected, default, dan private. Namun, jika kasusnya masih
   * sederhana seperti ini, maka cukup menggunakan access modifier default
   * (tidak menggunakan access modifier) untuk method bisa menggunakan access
   * modifier public, protected, dan default.
   *
   * tabel access modifier: https://www.javatpoint.com/access-modifiers
   */

  // Attribute / Field / Properties
  String judul;
  String pengarang;

  // Constructor Default
  public Buku() {
    super();
  }

  // Constructor dengan parameter
  public Buku(String judul, String pengarang) {
    super();
    this.judul = judul;
    this.pengarang = pengarang;
  }

  // Getter & Setter
  public String getJudul() {
    return judul;
  }

  public void setJudul(String judul) {
    this.judul = judul;
  }

  public String getPengarang() {
    return pengarang;
  }

  public void setPengarang(String pengarang) {
    this.pengarang = pengarang;
  }

  // Method
  void printInformation() {
    System.out.println("Judul Buku: " + this.judul);
    System.out.println("Pengarang: " + this.pengarang);
  }
}
