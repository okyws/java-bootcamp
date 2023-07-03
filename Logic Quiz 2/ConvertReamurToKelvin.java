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

/*
 * Latihan ulang quiz 2
 *
 * import java.util.Scanner;
 *
 * public class Latihan {
 * public static void main(String args[]) {
 * Scanner input = new Scanner(System.in);
 * double reamur;
 *
 * System.out.print("Masukkan nilai reamur: ");
 * reamur = input.nextDouble();
 *
 * System.out.printf("%s %.2f", "Suhu hasil konversi: ", convert(input,
 * reamur));
 * input.close();
 * }
 *
 * static double convert(Scanner input, double reamur) {
 * if (reamur < -273 || reamur > 80) {
 * System.out.println("angka harus sekitar -273 dan 80");
 * }
 *
 * while (reamur < -273 || reamur > 80) {
 * System.out.print("Masukkan nilai reamur: ");
 * reamur = input.nextDouble();
 * }
 *
 * return reamur * 1.25 + 273;
 * }
 * }
 */
