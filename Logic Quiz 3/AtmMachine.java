import java.util.Scanner;

public class AtmMachine {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int withdraw;
    double balance, admFee = 0.5;

    withdraw = input.nextInt();
    balance = input.nextDouble();

    if (balance >= withdraw + admFee && withdraw % 5 == 0) {
      balance -= withdraw + admFee;
    }

    System.out.printf("%.2f", balance);

    input.close();
  }
}
