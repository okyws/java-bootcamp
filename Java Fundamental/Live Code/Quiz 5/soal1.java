import java.util.Scanner;

public class soal1 {
  public static void main(String[] args) {
    int x, y, z;

    Scanner input = new Scanner(System.in);

    x = input(-30, 30, "Nilai x tidak valid!", input);
    y = input(-30, 30, "Nilai y tidak valid!", input);
    z = input(-30, 30, "Nilai z tidak valid!", input);

    input.close();
    System.out.println("x = " + x + ", y = " + y + ", z = " + z);
    int max = terbesar(x, y, z);
    System.out.println("Nilai terbesar adalah " + max);
  }

  static int input(int min, int max, String message, Scanner input) {
    int num = Integer.parseInt(input.nextLine());
    while (num < min || num > max) {
      System.out.println(message);
      num = Integer.parseInt(input.nextLine());
    }
    return num;
  }

  static int terbesar(int x, int y, int z) {
    int max = x;
    if (y > max) {
      max = y;
    }
    if (z > max) {
      max = z;
    }
    return max;
  }
}
