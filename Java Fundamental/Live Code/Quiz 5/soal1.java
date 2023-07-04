import java.util.Scanner;

public class soal1 {
  public static void main(String[] args) {
    int x, y, z;

    Scanner input = new Scanner(System.in);
    x = input.nextInt();
    y = input.nextInt();
    z = input.nextInt();

    int terbesar = x;
    if (x >= y && x >= z) {
      terbesar = x;
    } else if (y >= z && y >= x) {
      terbesar = y;
    } else {
      terbesar = z;
    }

    input.close();
    System.out.println(terbesar);
  }
}
