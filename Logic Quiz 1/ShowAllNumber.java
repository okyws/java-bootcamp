import java.util.Scanner;

public class ShowAllNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x, y, maxValue = 100;

    x = input.nextInt();
    y = input.nextInt();

    if ((x >= 0 && x <= maxValue) && (y >= x && y <= maxValue)) {
      for (int i = x; i <= y; i++) {
        System.out.print(i + " ");
      }
    }

    input.close();
  }
}

/*
 * Latihan ulang
 *
 * import java.util.Scanner;
 *
 * public class Latihan {
 * public static void main(String args[]) {
 * Scanner input = new Scanner(System.in);
 * int awal, akhir;
 *
 * System.out.print("Masukkan angka awal: ");
 * awal = input.nextInt();
 * System.out.print("Masukkan angka akhir: ");
 * akhir = input.nextInt();
 *
 * hitung(input, awal, akhir);
 * input.close();
 * }
 *
 * static void hitung(Scanner input, int awal, int akhir) {
 * if (awal > akhir) {
 * System.out.println("Angka akhir harus lebih besar / sama dengan Angka awal\n"
 * );
 * }
 *
 * while ((awal < 0 || awal > akhir) || (awal > 100 || akhir > 100)) {
 * System.out.print("Masukkan angka awal: ");
 * awal = input.nextInt();
 * System.out.print("Masukkan angka akhir: ");
 * akhir = input.nextInt();
 * }
 *
 * System.out.println("\nAngka di antara nilai " + awal + " dan nilai " +
 * akhir);
 * for (int i = awal; i <= akhir; i++) {
 * System.out.println(i);
 * }
 * }
 * }
 */
