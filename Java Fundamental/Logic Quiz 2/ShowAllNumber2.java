import java.util.Scanner;

public class ShowAllNumber2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x, y, maxValue = 100;

    x = input.nextInt();
    y = input.nextInt();

    if ((x >= 0 && x <= maxValue) && (y >= x && y <= maxValue)) {
      for (int i = x; i <= y; i++) {
        System.out.println(i);
      }
    }

    input.close();
  }
}
