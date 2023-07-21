import interfaces.InterfaceOperasiBangunDatar;

public class Persegi implements InterfaceOperasiBangunDatar {
  // Attributes / Fields / Properties
  private double sisi;

  // Constructors Default
  public Persegi() {
    super();
  }

  // Constructors Dengan Parameter
  public Persegi(double sisi) {
    super();
    this.sisi = sisi;
  }

  // Getters & Setters
  public double getSisi() {
    return sisi;
  }

  public void setSisi(double sisi) {
    this.sisi = sisi;
  }

  // Methods / Functions yang sudah di Override
  @Override
  public double getKeliling() {
    return 4 * sisi;
  }

  @Override
  public double getLuas() {
    return sisi * sisi;
  }

}
