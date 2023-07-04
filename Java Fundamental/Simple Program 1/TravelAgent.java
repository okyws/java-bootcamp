import java.util.Scanner;

public class TravelAgent {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int passangers = input.nextInt();
    input.close();

    getBus(passangers);
  }

  public static void getBus(int passangers) {
    int min = 0, max = 100;
    double price = 0, bus1 = 2300000, bus2 = 2000000, bus3 = 1800000, bus4 = 1500000, bus5 = 1300000;
    if (passangers > 60 && passangers <= 120) {
      if (passangers % 60 >= 1 && passangers % 60 <= 12) {
        price = bus1 + bus5;
      } else if (passangers % 60 > 12 && passangers % 60 <= 18) {
        price = bus1 + bus4;
      } else if (passangers % 60 > 18 && passangers % 60 <= 32) {
        price = bus1 + bus3;
      } else if (passangers % 60 > 32 && passangers % 60 <= 45) {
        price = bus1 + bus2;
      } else if (passangers % 60 > 45 || passangers % 60 <= 60) {
        price = bus1 + bus1;
      }
      System.out.printf("%.0f", price);
    } else if (passangers >= min && passangers <= max) {
      if (passangers <= 60 && passangers > 45) {
        price = bus1;
      } else if (passangers <= 45 && passangers > 32) {
        price = bus2;
      } else if (passangers <= 32 && passangers > 18) {
        price = bus3;
      } else if (passangers <= 18 && passangers > 12) {
        price = bus4;
      } else if (passangers <= 12) {
        price = bus5;
      }
      System.out.printf("%.0f", price);
    }
  }
}
