import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int p, d, b = 0;

    Scanner sn = new Scanner(System.in);
    p = sn.nextInt(); // banyak orang yang ikut travel
    d = sn.nextInt(); // berapa lama hari menginap
    b = sn.nextInt(); // budget untuk travel

    String tempatRekomendasi = menetukanBudgetRekomendasi(p, d, b);
    System.out.print(tempatRekomendasi);
  }

  public static String menetukanBudgetRekomendasi(int p, int d, int b) {
    int[][] harga = {
        { 4760000, 170000, 105000, 325000 }, // Tokyo
        { 3780000, 155000, 55000, 300000 }, // bangkok
        { 2170000, 125000, 75000, 250000 }, // lombok
        { 1200000, 170000, 85000, 360000 } // singapura
    };

    String[] tempatRekomendasi = { "Tokyo", "Bangkok", "Lombok", "Singapura" };
    int hargaTerdekat = Integer.MAX_VALUE;
    int kurangBudget = -1;

    for (int i = 0; i < harga.length; i++) {
      int baseCost = harga[i][0] * p;
      int transportationCost = (harga[i][1] + harga[i][2]) * p * d;
      int accommodationCost = harga[i][3] * p;
      int totalHarga = baseCost + transportationCost + accommodationCost;

      // System.out.println(tempatRekomendasi[i] + " : " + totalHarga);
      if (totalHarga <= b && Math.abs(totalHarga - b) < Math.abs(hargaTerdekat -
          b)) {
        hargaTerdekat = totalHarga;
        kurangBudget = i;
      }
    }

    if (kurangBudget == -1) {
      return "Need more budget";
    }

    return tempatRekomendasi[kurangBudget] + " " + hargaTerdekat;
  }
}
