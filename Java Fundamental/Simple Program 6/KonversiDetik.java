import java.util.Scanner;

public class KonversiDetik {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int detik;

    detik = input.nextInt();
    input.close();

    System.out.println(konversiDetik(detik));
  }

  public static String konversiDetik(int detik) {
    int hari, jam, menit, sisaDetik;
    int detikPerHari = 86400;
    int detikPerJam = 3600;
    int detikPerMenit = 60;
    int jamPerHari = 24;

    hari = detik / detikPerHari;
    jam = (detik / detikPerJam) % jamPerHari;
    menit = (detik / detikPerMenit) % detikPerMenit;
    sisaDetik = detik % detikPerMenit;

    return hari + "\n" + jam + "\n" + menit + "\n" + sisaDetik;
  }
}
