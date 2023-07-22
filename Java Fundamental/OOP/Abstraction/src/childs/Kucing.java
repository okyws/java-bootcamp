package childs;

import parents.HewanDarat;

public class Kucing extends HewanDarat {
  // Attribute / Field / Properties
  private String warnaRambut;

  // Constructor default
  public Kucing() {
    super();
  }

  // Constructor dengan parameter
  public Kucing(String nama, int usia, int jumlahKaki, String warnaRambut) {
    super(nama, usia, jumlahKaki);
    this.warnaRambut = warnaRambut;
  }

  // Getter & Setter
  public String getWarnaRambut() {
    return warnaRambut;
  }

  public void setWarnaRambut(String warnaRambut) {
    this.warnaRambut = warnaRambut;
  }

  // Method / Function yang sudah diimplementasikan / override
  @Override
  public void suara() {
    System.out.println("Suaraku Meow!!");
  }

  @Override
  public void gerak() {
    System.out.println("Aku berjalan untuk bergerak");
  }

}
