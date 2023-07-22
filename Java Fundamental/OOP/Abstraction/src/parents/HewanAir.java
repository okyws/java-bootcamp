package parents;

import defaults.HewanPeliharaan;

public class HewanAir extends HewanPeliharaan {
  // Attribute / Field / Properties
  private boolean hidupDiLaut;

  // Constructor default
  public HewanAir() {
    super();
  }

  // Constructor dengan parameter
  public HewanAir(String nama, int usia, boolean hidupDiLaut) {
    super(nama, usia);
    this.hidupDiLaut = hidupDiLaut;
  }

  // Getter & Setter
  public boolean isHidupDiLaut() {
    return hidupDiLaut;
  }

  public void setHidupDiLaut(boolean hidupDiLaut) {
    this.hidupDiLaut = hidupDiLaut;
  }

  // Method / Function yang masih sudah diimplementasikan / override
  @Override
  public void suara() {
    System.out.println("Suara Hewan Air");
  }

  @Override
  public void gerak() {
    System.out.println("Gerakan Hewan Air");
  }
}
