import java.util.Scanner;

public class DoubleTheNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x, hasil = 0;

    x = input.nextInt();

    if (x >= 0 && x <= 100) {
      hasil = x * 2;
      System.out.print(hasil);
    }

    input.close();
  }
}

/*
 * Latihan ulang quiz
 *
 * import java.util.Scanner;
 *
 * public class Latihan {
 * public static void main(String args[]) {
 * Scanner input = new Scanner(System.in);
 *
 * System.out.print("Masukkan angka: ");
 * int x = input.nextInt();
 *
 * System.out.println(kaliDua(input, x));
 * input.close();
 * }
 *
 * static int kaliDua(Scanner input, int x) {
 * while (x < 0 || x > 100) {
 * System.out.println("Masukkan angka antara 0 - 100");
 * x = input.nextInt();
 * }
 *
 * return x * 2;
 * }
 * }
 */
