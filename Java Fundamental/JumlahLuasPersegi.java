import java.util.Scanner;

public class JumlahLuasPersegi {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double sisi1, sisi2, sisi3, luas1, luas2, luas3, jumlah;
    System.out.print("Masukkan persegi pertama: ");
    sisi1 = input.nextInt();
    System.out.print("Masukkan persegi kedua: ");
    sisi2 = input.nextInt();
    System.out.print("Masukkan persegi ketiga: ");
    sisi3 = input.nextInt();
    System.out.print("Sisi: ");
    double sisi4 = input.nextDouble();
    input.close();

    luas1 = sisi4 * sisi4;
    System.out.println("Luas persegi pertama adalah " + luas1);
    luas2 = Math.pow(((double) sisi2 / sisi1), 2) * luas1;
    System.out.println("Luas persegi kedua adalah " + luas2);
    luas3 = Math.pow(((double) sisi3 / sisi1), 2) * luas1;
    System.out.println("Luas persegi ketiga adalah " + luas3);
    jumlah = Math.round(luas1 + luas2 + luas3);
    System.out.printf("%s %.2f", "Jumlah luas perbandingan tiga persegi adalah ", jumlah);
  }
}
