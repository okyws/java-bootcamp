import java.util.Scanner;

public class Discount {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double discount, itemPrice, totalPrice;
    int totalItem;

    do {
      itemPrice = input.nextDouble();
    } while (itemPrice < 10000 || itemPrice > 1000000);

    do {
      totalItem = input.nextInt();
    } while (totalItem < 1 || totalItem > 100);

    totalPrice = itemPrice * totalItem;

    if (totalItem % 3 == 0 && totalItem % 4 == 0) {
      discount = 0.15 * totalPrice;
      totalPrice -= discount;
    }

    System.out.printf("%.2f", totalPrice);

    input.close();
  }
}
