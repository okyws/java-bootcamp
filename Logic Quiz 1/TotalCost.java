import java.util.Scanner;

public class TotalCost {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double downPayment, interest, totalPayment, maxValue = 150000;
    int percentage = 100, maxInterest = 100;

    downPayment = input.nextDouble();
    interest = input.nextDouble();

    if (interest >= 0 && interest <= maxInterest) {
      if (downPayment >= 0 && downPayment <= maxValue) {
        totalPayment = downPayment + downPayment * interest / percentage;
        System.out.printf("%.2f", totalPayment);
      }
    }

    input.close();
  }
}
