import java.util.Scanner;

public class StarPattern {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N;

    N = input.nextInt();
    while (N < 1 || N > 10) {
      N = input.nextInt();
    }

    input.close();
    printPattern(N);

    System.out.print("Akhir dari program");
  }

  private static void printPattern(int N) {
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
