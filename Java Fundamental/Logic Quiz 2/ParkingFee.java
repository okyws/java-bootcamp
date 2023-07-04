import java.util.Scanner;

public class ParkingFee {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int fee, type, time;

    fee = 0;
    type = input.nextInt();
    time = input.nextInt();

    if (type == 1) {
      fee = 2000;
      if (time > 1) {
        fee += (time - 1) * 1000;
      }
    } else if (type == 2) {
      fee = 1000;
      if (time > 1) {
        fee += (time - 1) * 500;
      }
    } else {
      System.out.println("Jenis kendaraan tidak valid.");
    }

    input.close();
    System.out.print(fee);
  }
}
