import java.util.Scanner;

public class Latihan {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String word;
    char result;
    int isUpperCase = 0;
    int isLowerCase = 0;
    int isDigit = 0;
    int isSymbol = 0;

    System.out.print("Masukkan kata: ");
    word = input.nextLine();

    for (int i = 0; i < word.length(); i++) {
      result = word.charAt(i);

      if (Character.isUpperCase(result)) {
        isUpperCase++;
      } else if (Character.isLowerCase(result)) {
        isLowerCase++;
      } else if (Character.isDigit(result)) {
        isDigit++;
      } else {
        isSymbol++;
      }
    }
    input.close();

    System.out.println("Jumlah huruf besar: " + isUpperCase);
    System.out.println("Jumlah huruf kecil: " + isLowerCase);
    System.out.println("Jumlah angka: " + isDigit);
    System.out.println("Jumlah simbol: " + isSymbol);

  }
}

/*
 * Latihan: Mengurutkan array
 *
 * import java.util.Arrays;
 * import java.util.Scanner;
 *
 * public class Latihan {
 *
 * public static void main(String args[]) {
 * int[] arr = new int[5];
 * Scanner input = new Scanner(System.in);
 *
 * for (int i = 0; i < arr.length; i++) {
 * System.out.printf("Masukkan angka ke-%d: ", i + 1);
 * arr[i] = input.nextInt();
 * }
 *
 * for (int i = 0; i < arr.length; i++) {
 * for (int j = 0; j < arr.length; j++) {
 * if (arr[i] > arr[j]) {
 * int temp = arr[i];
 * arr[i] = arr[j];
 * arr[j] = temp;
 * }
 * }
 * }
 *
 * input.close();
 * System.out.printf("Array terurut: %s", Arrays.toString(arr));
 *
 * }
 * }
 *
 */

/*
 * Latihan: Membuat bintang
 *
 * import java.util.Scanner;
 *
 * public class Latihan {
 *
 * public static void main(String args[]) {
 * int a;
 * Scanner input = new Scanner(System.in);
 *
 * System.out.print("Masukkan angka: ");
 * a = input.nextInt();
 *
 * while (a < 5) {
 * System.out.print("Masukkan angka: ");
 * a = input.nextInt();
 * }
 *
 * print(a);
 * input.close();
 * }
 *
 * public static void print(int a) {
 * for (int i = 1; i <= a; i++) {
 * for (int j = 1; j <= i; j++) {
 * System.out.print("* ");
 * // System.out.println("i: " + i + " j: " + j);
 * }
 * System.out.println();
 * }
 *
 * System.out.println("\nSwap\n");
 * for (int i = a; i >= 1; i--) {
 * for (int j = 1; j <= i; j++) {
 * System.out.print("* ");
 * }
 * System.out.println();
 * }
 * }
 * }
 */

/*
 * Latihan: Menghitung jumlah huruf
 *
 * import java.util.Scanner;
 *
 * public class Latihan {
 *
 * public static void main(String args[]) {
 * Scanner input = new Scanner(System.in);
 * String word;
 * char result;
 * int isUpperCase = 0;
 * int isLowerCase = 0;
 * int isDigit = 0;
 * int isSymbol = 0;
 *
 * System.out.print("Masukkan kata: ");
 * word = input.nextLine();
 *
 * for (int i = 0; i < word.length(); i++) {
 * result = word.charAt(i);
 *
 * if (Character.isUpperCase(result)) {
 * isUpperCase++;
 * } else if (Character.isLowerCase(result)) {
 * isLowerCase++;
 * } else if (Character.isDigit(result)) {
 * isDigit++;
 * } else {
 * isSymbol++;
 * }
 * }
 * input.close();
 *
 * System.out.println("Jumlah huruf besar: " + isUpperCase);
 * System.out.println("Jumlah huruf kecil: " + isLowerCase);
 * System.out.println("Jumlah angka: " + isDigit);
 * System.out.println("Jumlah simbol: " + isSymbol);
 *
 * }
 * }
 */
