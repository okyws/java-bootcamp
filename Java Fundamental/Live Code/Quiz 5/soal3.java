import java.util.Scanner;

public class soal3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double itemPrice;
    int dateOfBirth;

    itemPrice = validation(0, 100000, "Harga tidak valid!", input);
    dateOfBirth = (int) validation(0, 31, "Tanggal lahir tidak valid!", input);

    String result = calculateDiscount(itemPrice, dateOfBirth);
    System.out.println(result);

    input.close();
  }

  static String calculateDiscount(double itemPrice, int dateOfBirth) {
    double minimumBill = 50000;
    double discount = 0;
    double percetageDiscount = 0.02;

    if (itemPrice >= minimumBill) {
      discount = percetageDiscount * dateOfBirth * itemPrice;
    }

    double bill = itemPrice - discount;

    return String.format("%.2f", bill);
  }

  static double validation(int min, int max, String message, Scanner input) {
    int param = Integer.parseInt(input.nextLine());
    while (param < min || param > max) {
      System.out.println(message);
      param = Integer.parseInt(input.nextLine());
    }

    return param;
  }
}
