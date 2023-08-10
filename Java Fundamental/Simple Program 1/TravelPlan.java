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

    System.out.println(lombokCost);
    System.out.println(bangkokCost);
    System.out.println(singapuraCost);
    System.out.println(tokyoCost);

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

/*
 * Alternative solution using array 2D
 *
 * import java.util.Scanner;
 * 
 * public class Main {
 * public static void main(String[] args) {
 * int p, d, b = 0;
 * 
 * Scanner sn = new Scanner(System.in);
 * p = sn.nextInt(); // banyak orang yang ikut travel
 * d = sn.nextInt(); // berapa lama hari menginap
 * b = sn.nextInt(); // budget untuk travel
 * 
 * String tempatRekomendasi = menetukanBudgetRekomendasi(p, d, b);
 * System.out.print(tempatRekomendasi);
 * }
 * 
 * public static String menetukanBudgetRekomendasi(int p, int d, int b) {
 * int[][] harga = {
 * { 4760000, 170000, 105000, 325000 }, // Tokyo
 * { 3780000, 155000, 55000, 300000 }, // bangkok
 * { 2170000, 125000, 75000, 250000 }, // lombok
 * { 1200000, 170000, 85000, 360000 } // singapura
 * };
 * 
 * String[] tempatRekomendasi = { "Tokyo", "Bangkok", "Lombok", "Singapura" };
 * int hargaTerdekat = Integer.MAX_VALUE;
 * int kurangBudget = -1;
 * 
 * for (int i = 0; i < harga.length; i++) {
 * int baseCost = harga[i][0] * p;
 * int transportationCost = (harga[i][1] + harga[i][2]) * p * d;
 * int accommodationCost = harga[i][3] * p;
 * int totalHarga = baseCost + transportationCost + accommodationCost;
 * 
 * // System.out.println(tempatRekomendasi[i] + " : " + totalHarga);
 * if (totalHarga <= b && Math.abs(totalHarga - b) < Math.abs(hargaTerdekat -
 * b)) {
 * hargaTerdekat = totalHarga;
 * kurangBudget = i;
 * }
 * }
 * 
 * if (kurangBudget == -1) {
 * return "Need more budget";
 * }
 * 
 * return tempatRekomendasi[kurangBudget] + " " + hargaTerdekat;
 * }
 * }
 * 
 */
