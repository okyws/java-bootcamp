import java.util.Scanner;

public class WeekendParking {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int vehicleType, parkingDuration;

    vehicleType = input.nextInt();
    parkingDuration = input.nextInt();

    int parkingFee = calculateParkingFee(vehicleType, parkingDuration);

    if (parkingFee == 0) {
      System.out.print("disegel");
    } else {
      System.out.print(parkingFee);
    }

    input.close();
  }

  private static int calculateParkingFee(int vehicleType, int parkingDuration) {
    int baseRate, extraHours;
    int additionalRate = 500;
    int maxDurationWithoutSeal = 5;
    int maxDurationWithSeal = 8;

    if (vehicleType == 1) {
      baseRate = 1500;
    } else if (vehicleType == 2) {
      baseRate = 1000;
    } else {
      return 0;
    }

    if (parkingDuration > maxDurationWithSeal) {
      return 0;
    } else if (parkingDuration > maxDurationWithoutSeal) {
      extraHours = (parkingDuration - maxDurationWithoutSeal) * additionalRate;
      return baseRate * parkingDuration + extraHours;
    } else {
      return baseRate * parkingDuration;
    }
  }
}
