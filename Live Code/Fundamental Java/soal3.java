import java.util.Scanner;

public class soal3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double itemPrice;
    int dateOfBirth;

    itemPrice = input.nextDouble();
    dateOfBirth = input.nextInt();

    double result;
    double discount = 0;

    input.close();
    discount = (0.02 * dateOfBirth * itemPrice);
    if (itemPrice >= 50000) {
      itemPrice -= discount;
      System.out.printf("%.2f", itemPrice);
    } else {
      result = itemPrice;
      System.out.printf("%.2f", result);
    }
  }
}
