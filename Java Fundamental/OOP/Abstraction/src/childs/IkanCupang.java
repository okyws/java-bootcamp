package childs;

import parents.HewanAir;

public class IkanCupang extends HewanAir {
  // Attribute / Field / Properties
  private String warnaSisik;

  // Constructor default
  public IkanCupang() {
    super();
  }

  // Constructor dengan parameter
  public IkanCupang(String nama, int usia, boolean hidupDiLaut, String warnaSisik) {
    super(nama, usia, hidupDiLaut);
    this.warnaSisik = warnaSisik;
  }

  // Getter & Setter
  public String getWarnaSisik() {
    return warnaSisik;
  }

  public void setWarnaSisik(String warnaSisik) {
    this.warnaSisik = warnaSisik;
  }

  // Method / Function yang sudah diimplementasikan / override
  @Override
  public void suara() {
    System.out.println("Suaraku ...");
  }

  @Override
  public void gerak() {
    System.out.println("Aku berenang untuk bergerak");
  }
}
