package defaults;

public abstract class HewanPeliharaan {
  // Atribut / Field / Properties
  private String nama;
  private int usia;

  // Constructor default
  public HewanPeliharaan() {
    super();
  }

  // Constructor dengan parameter
  public HewanPeliharaan(String nama, int usia) {
    super();
    this.nama = nama;
    this.usia = usia;
  }

  // Getter & Setter
  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public int getUsia() {
    return usia;
  }

  public void setUsia(int usia) {
    this.usia = usia;
  }

  // Method / Function yang masih abstrak
  public abstract void suara();

  public abstract void gerak();
}
