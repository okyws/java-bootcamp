import java.util.Scanner;

public class Security {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int caseCount, caseNumber;

    caseNumber = input.nextInt();
    caseCount = input.nextInt();

    if (caseNumber == 1) {
      tindakanKasus1(caseCount);
    } else if (caseNumber == 2) {
      tindakanKasus2();
    }

    input.close();
  }

  public static void tindakanKasus1(int caseCount) {
    if (caseCount < 4) {
      System.out.print("Serahkan KTP anda !!!");
    } else {
      System.out.print("Bayar Denda 10000 !!!");
    }
  }

  public static void tindakanKasus2() {
    System.out.print("Ambil STNK dulu !!!");
  }
}
