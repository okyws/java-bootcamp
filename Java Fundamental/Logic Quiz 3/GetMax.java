/*
 * import java.util.Scanner;
 *
 * public class GetMax {
 * public static void main(String[] args) {
 * Scanner input = new Scanner(System.in);
 *
 * int bilangan1, bilangan2, bilangan3, terbesar;
 *
 * do {
 * System.out.print("Masukkan bilangan pertama (-30 s/d 30): ");
 * bilangan1 = input.nextInt();
 * } while (bilangan1 < -30 || bilangan1 > 30);
 *
 * do {
 * System.out.print("Masukkan bilangan kedua (-30 s/d 30): ");
 * bilangan2 = input.nextInt();
 * } while (bilangan2 < -30 || bilangan2 > 30);
 *
 * do {
 * System.out.print("Masukkan bilangan ketiga (-30 s/d 30): ");
 * bilangan3 = input.nextInt();
 * } while (bilangan3 < -30 || bilangan3 > 30);
 *
 * if (bilangan1 > bilangan2 && bilangan1 > bilangan3) {
 * terbesar = bilangan1;
 * } else if (bilangan2 > bilangan1 && bilangan2 > bilangan3) {
 * terbesar = bilangan2;
 * } else {
 * terbesar = bilangan3;
 * }
 *
 * System.out.print(terbesar);
 *
 * input.close();
 * }
 * }
 *
 */

// perbaikan code

import java.util.Scanner;

public class GetMax {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int number1, number2, number3, largest;

    number1 = getInputWithinRange(input, -30, 30);
    number2 = getInputWithinRange(input, -30, 30);
    number3 = getInputWithinRange(input, -30, 30);

    if (number1 >= number2 && number1 >= number3) {
      largest = number1;
    } else if (number2 >= number1 && number2 >= number3) {
      largest = number2;
    } else {
      largest = number3;
    }

    System.out.print(largest);

    input.close();
  }

  private static int getInputWithinRange(Scanner input, int min, int max) {
    int number;
    do {
      number = input.nextInt();
    } while (number < min || number > max);
    return number;
  }
}
