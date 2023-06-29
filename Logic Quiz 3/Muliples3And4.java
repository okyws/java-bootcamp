import java.util.Scanner;

public class Muliples3And4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = 0;

    while (n < 1 || n > 100) {
      n = input.nextInt();
    }

    if (n % 3 == 0 && n % 4 == 0) {
      System.out.print("1");
    } else {
      System.out.println("0");
    }

    input.close();
  }
}
