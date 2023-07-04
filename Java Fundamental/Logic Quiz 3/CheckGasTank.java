import java.util.Scanner;

public class CheckGasTank {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int money, minValue = 7600, maxValue = 76000;
    double capacity, totalGas, gasPrice = 7600;

    do {
      System.out.print("jumlah uang (7600 - 76000): ");
      money = input.nextInt();
    } while (money < minValue || money > maxValue);

    do {
      System.out.print("kapasitas tangki (1 - 10): ");
      capacity = input.nextDouble();
    } while (capacity < 1 || capacity > 10);

    totalGas = money / gasPrice;
    System.out.printf("%.2f", totalGas);

    if (totalGas > capacity) {
      System.out.print("Bensin Berlebih");
    }

    input.close();
  }
}
