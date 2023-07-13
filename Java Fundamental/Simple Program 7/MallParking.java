// import java.util.Scanner;

// public class MallParking {
// public static void main(String[] args) {
// Scanner input = new Scanner(System.in);
// int jenisKendaraan, lamaParkir, biayaParkir;

// jenisKendaraan = input.nextInt();
// lamaParkir = input.nextInt();
// biayaParkir = hitungBiayaParkir(jenisKendaraan, lamaParkir);

// if (lamaParkir <= 0) {
// biayaParkir = -1;
// }

// if (biayaParkir == -1) {
// System.out.println("Input Error!!!");
// } else {
// System.out.println(biayaParkir);
// }
// input.close();
// }

// public static int hitungBiayaParkir(int jenisKendaraan, int lamaParkir) {
// int biayaPerJam;
// int kenaikanBiayaPerJam;
// int tarifMaksimal;

// switch (jenisKendaraan) {
// case 1:
// biayaPerJam = 5000;
// kenaikanBiayaPerJam = 2000;
// tarifMaksimal = 25000;
// break;
// case 2:
// biayaPerJam = 2000;
// kenaikanBiayaPerJam = 1000;
// tarifMaksimal = 10000;
// break;
// case 3:
// biayaPerJam = 10000;
// kenaikanBiayaPerJam = 5000;
// tarifMaksimal = 50000;
// break;
// default:
// return -1;
// }

// int totalBiaya = ((lamaParkir - 1) * kenaikanBiayaPerJam) + biayaPerJam;

// if (totalBiaya > tarifMaksimal) {
// totalBiaya = tarifMaksimal;
// }

// return totalBiaya;
// }
// }

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MallParking {
  private static final Map<Integer, Integer> biayaPerJamMap = new HashMap<>();
  private static final Map<Integer, Integer> kenaikanBiayaPerJamMap = new HashMap<>();
  private static final Map<Integer, Integer> tarifMaksimalMap = new HashMap<>();

  public static void main(String[] args) {
    initializeMaps();
    Scanner input = new Scanner(System.in);

    while (input.hasNext()) {
      int jenisKendaraan = input.nextInt();
      int lamaParkir = input.nextInt();

      int biayaParkir = hitungBiayaParkir(jenisKendaraan, lamaParkir);
      printBiayaParkir(biayaParkir);
    }

    input.close();
  }

  private static void initializeMaps() {
    biayaPerJamMap.put(1, 5000);
    biayaPerJamMap.put(2, 2000);
    biayaPerJamMap.put(3, 10000);

    kenaikanBiayaPerJamMap.put(1, 2000);
    kenaikanBiayaPerJamMap.put(2, 1000);
    kenaikanBiayaPerJamMap.put(3, 5000);

    tarifMaksimalMap.put(1, 25000);
    tarifMaksimalMap.put(2, 10000);
    tarifMaksimalMap.put(3, 50000);
  }

  private static int hitungBiayaParkir(int jenisKendaraan, int lamaParkir) {
    int biayaPerJam = biayaPerJamMap.getOrDefault(jenisKendaraan, -1);
    int kenaikanBiayaPerJam = kenaikanBiayaPerJamMap.getOrDefault(jenisKendaraan, -1);
    int tarifMaksimal = tarifMaksimalMap.getOrDefault(jenisKendaraan, -1);

    if (biayaPerJam == -1 || kenaikanBiayaPerJam == -1 || tarifMaksimal == -1 || lamaParkir < 0) {
      return -1;
    }

    int totalBiaya = ((lamaParkir - 1) * kenaikanBiayaPerJam) + biayaPerJam;

    if (totalBiaya > tarifMaksimal) {
      totalBiaya = tarifMaksimal;
    }

    return totalBiaya;
  }

  private static void printBiayaParkir(int biayaParkir) {
    if (biayaParkir == -1) {
      System.out.println("Input Error!!!");
    } else {
      System.out.println(biayaParkir);
    }
  }
}
