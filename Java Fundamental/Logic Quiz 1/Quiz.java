import java.util.Scanner;

public class Quiz {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x, hasil = 0;

    x = input.nextInt();

    if (x >= 0 && x <= 100) {
      hasil = x * 2;
      System.out.println(hasil);
    }
    input.close();
  }
}
