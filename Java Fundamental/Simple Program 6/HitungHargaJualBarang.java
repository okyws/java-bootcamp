import java.util.Scanner;

public class HitungHargaJualBarang {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int jumlahBarang;
    String[] namaBarang;
    String[] labelBarang;
    double[] hargaSatuanBarang;
    double[] hargaJualBarang;
    double labaPerBarang;

    jumlahBarang = input.nextInt();
    input.nextLine();

    namaBarang = new String[jumlahBarang];
    labelBarang = new String[jumlahBarang];
    hargaSatuanBarang = new double[jumlahBarang];
    hargaJualBarang = new double[jumlahBarang];

    for (int i = 0; i < jumlahBarang; i++) {
      namaBarang[i] = input.nextLine();
      labelBarang[i] = input.nextLine();
      hargaSatuanBarang[i] = input.nextDouble();
      input.nextLine();

      labaPerBarang = getlabaPerBarang(labelBarang[i]);
      hargaJualBarang[i] = kalkulasiHargaJual(labaPerBarang, hargaSatuanBarang[i]);
    }

    for (int i = 0; i < jumlahBarang; i++) {
      System.out.printf("%s\n%.0f\n", namaBarang[i], hargaJualBarang[i]);
      if (i != jumlahBarang - 1) {
        System.out.println();
      }
    }

    input.close();
  }

  public static double getlabaPerBarang(String labelBarang) {
    double labaPerBarang;
    switch (labelBarang.toLowerCase()) {
      case "best seller":
        labaPerBarang = 0.35;
        break;
      case "recommended":
        labaPerBarang = 0.25;
        break;
      case "good":
        labaPerBarang = 0.15;
        break;
      default:
        labaPerBarang = 0.10;
        break;
    }
    return labaPerBarang;
  }

  public static double kalkulasiHargaJual(double labaPerBarang, double hargaSatuanBarang) {
    return (labaPerBarang * hargaSatuanBarang) + hargaSatuanBarang;
  }
}
