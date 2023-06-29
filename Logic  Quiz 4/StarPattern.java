import java.util.Scanner;

public class StarPattern {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N;

    do {
      N = input.nextInt();
    } while (N < 1 || N > 10);

    printPattern(N);

    input.close();
  }

  private static void printPattern(int N) {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
