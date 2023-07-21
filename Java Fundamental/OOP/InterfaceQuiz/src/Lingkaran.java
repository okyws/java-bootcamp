import interfaces.InterfaceOperasiBangunDatar;
import interfaces.PiInterface;

public class Lingkaran implements PiInterface, InterfaceOperasiBangunDatar {
  // Attributes / Fields / Properties
  private double radius;

  // Constructors Default
  public Lingkaran() {
    super();
  }

  // Constructors Dengan Parameter
  public Lingkaran(double radius) {
    super();
    this.radius = radius;
  }

  // Getters & Setters
  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  // Methods / Functions yang sudah di Override
  @Override
  public double getKeliling() {
    return 2 * PI_VALUE * radius;
  }

  @Override
  public double getLuas() {
    return PI_VALUE * radius * radius;
  }
}
