import java.util.Scanner;

public class EvenOdd2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();

    if (number < 100) {
      if (number % 2 == 0) {
        System.out.print("genap");
      } else {
        System.out.print("ganjil");
      }
    }

    input.close();
  }
}
