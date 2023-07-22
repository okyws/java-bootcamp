package childs;

import parents.HewanDarat;

public class Burung extends HewanDarat {
  // Attribute / Field / Properties
  private String warnaBulu;

  // Constructor default
  public Burung() {
    super();
  }

  // Constructor dengan parameter
  public Burung(String nama, int usia, int jumlahKaki, String warnaBulu) {
    super(nama, usia, jumlahKaki);
    this.warnaBulu = warnaBulu;
  }

  // Getter & Setter
  public String getWarnaBulu() {
    return warnaBulu;
  }

  public void setWarnaBulu(String warnaBulu) {
    this.warnaBulu = warnaBulu;
  }

  // Method / Function yang sudah diimplementasikan / override
  @Override
  public void suara() {
    System.out.println("Suaraku Chirp!!");
  }

  @Override
  public void gerak() {
    System.out.println("Aku terbang untuk bergerak");
  }
}
