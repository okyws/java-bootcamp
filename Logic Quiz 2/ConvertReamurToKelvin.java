import java.util.Scanner;

public class ConvertReamurToKelvin {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double reamur, kelvin;

    reamur = input.nextDouble();

    while (reamur < -273 || reamur > 80) {
      System.out.println("Suhu tidak valid. Masukkan suhu antara -273 dan 80.");
      reamur = input.nextDouble();
    }

    input.close();

    kelvin = reamur * 1.25 + 273;
    System.out.printf("%.2f", kelvin);

  }
}
