import java.util.Scanner;

public class TravelPlan {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int p = input.nextInt();
    int d = input.nextInt();
    int b = input.nextInt();
    input.close();

    String destination = determineDestination(p, d, b);
    System.out.println(destination);
  }

  public static String determineDestination(int p, int d, int b) {
    int lombokCost = calculateLombokCost(p, d);
    int bangkokCost = calculateBangkokCost(p, d);
    int singapuraCost = calculateSingapuraCost(p, d);
    int tokyoCost = calculateTokyoCost(p, d);

    if (tokyoCost <= b) {
      return "Tokyo " + tokyoCost;
    } else if (bangkokCost <= b) {
      return "Bangkok " + bangkokCost;
    } else if (lombokCost <= b) {
      return "Lombok " + lombokCost;
    } else if (singapuraCost <= b) {
      return "Singapura " + singapuraCost;
    } else {
      return "Need more budget";
    }
  }

  public static int calculateLombokCost(int p, int d) {
    int baseCost = 2170000 * p;
    int transportationCost = (125000 + 75000) * p * d;
    int accommodationCost = 250000 * p;
    return baseCost + transportationCost + accommodationCost;
  }

  public static int calculateBangkokCost(int p, int d) {
    int baseCost = 3780000 * p;
    int transportationCost = (155000 + 55000) * p * d;
    int accommodationCost = 300000 * p;
    return baseCost + transportationCost + accommodationCost;
  }

  public static int calculateSingapuraCost(int p, int d) {
    int baseCost = 1200000 * p;
    int transportationCost = (170000 + 85000) * p * d;
    int accommodationCost = 360000 * p;
    return baseCost + transportationCost + accommodationCost;
  }

  public static int calculateTokyoCost(int p, int d) {
    int baseCost = 4760000 * p;
    int transportationCost = (170000 + 105000) * p * d;
    int accommodationCost = 325000 * p;
    return baseCost + transportationCost + accommodationCost;
  }
}
