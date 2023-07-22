package parents;

import defaults.HewanPeliharaan;

public class HewanDarat extends HewanPeliharaan {
  // Attribute / Field / Properties
  private int jumlahKaki;

  // Constructor default
  public HewanDarat() {
    super();
  }

  // Constructor dengan parameter
  public HewanDarat(String nama, int usia, int jumlahKaki) {
    super(nama, usia);
    this.jumlahKaki = jumlahKaki;
  }

  // Getter & Setter
  public int getJumlahKaki() {
    return jumlahKaki;
  }

  public void setJumlahKaki(int jumlahKaki) {
    this.jumlahKaki = jumlahKaki;
  }

  // Method / Function yang yang sudah diimplementasikan / override
  @Override
  public void suara() {
    System.out.println("Suara Hewan Darat");
  }

  @Override
  public void gerak() {
    System.out.println("Gerakan Hewan Darat");
  }
}
