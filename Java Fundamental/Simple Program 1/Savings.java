import java.util.Scanner;

public class Savings {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int m = input.nextInt();
    int n = input.nextInt();
    input.close();

    int totalSavings = savings(m, n);
    System.out.println(totalSavings);
  }

  public static int savings(int m, int n) {
    int totalSavings = 0;

    for (int i = 1; i <= n; i++) {
      int daysInMonth;
      switch (i) {
        case 2:
          daysInMonth = 29;
          break;
        case 4:
        case 6:
        case 9:
        case 11:
          daysInMonth = 30;
          break;
        default:
          daysInMonth = 31;
      }

      for (int j = 1; j <= daysInMonth; j++) {
        totalSavings += j * 1000;
      }
    }

    totalSavings *= m;
    return totalSavings;
  }
}
