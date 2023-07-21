import interfaces.InterfaceOperasiBangunDatar;

public class PersegiPanjang implements InterfaceOperasiBangunDatar {
  // Attributes / Fields / Properties
  private double panjang;
  private double lebar;

  // Constructors Default
  public PersegiPanjang() {
    super();
  }

  // Constructors Dengan Parameter
  public PersegiPanjang(double panjang, double lebar) {
    super();
    this.panjang = panjang;
    this.lebar = lebar;
  }

  // Getters & Setters
  public double getPanjang() {
    return panjang;
  }

  public void setPanjang(double panjang) {
    this.panjang = panjang;
  }

  public double getLebar() {
    return lebar;
  }

  public void setLebar(double lebar) {
    this.lebar = lebar;
  }

  // Methods / Functions yang sudah di Override
  @Override
  public double getLuas() {
    return panjang * lebar;
  }

  @Override
  public double getKeliling() {
    return 2 * (panjang + lebar);
  }
}
