import java.util.Scanner;

public class TubeVolume {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double t, R, V;

    R = input.nextDouble();

    while (R < 0 || R > 100) {
      System.out.println("Jari-jari tidak valid. Jari jari harus bilangan positif.");
      System.out.print("Masukkan jari-jari tabung: ");
      R = input.nextDouble();
    }

    t = input.nextDouble();

    while (t < 0 || t > 100) {
      System.out.println("Tinggi tidak valid. Tinggi harus bilangan positif.");
      System.out.print("Masukkan tinggi tabung: ");
      t = input.nextDouble();
    }

    input.close();

    V = 3.14 * R * R * t;

    System.out.printf("%.2f", V);
  }
}
