import java.util.Scanner;

public class Yudisium {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double ipk, totalPoints = 0;
    int amountGrade;
    String judiciary;

    amountGrade = input.nextInt();
    input.nextLine();

    for (int i = 0; i < amountGrade; i++) {
      String grade = input.nextLine();
      int point = converGrade(grade);
      totalPoints += point;
    }

    ipk = totalPoints / amountGrade;
    judiciary = determineJudicium(ipk);

    System.out.print(judiciary);

    input.close();
  }

  public static int converGrade(String grade) {
    if (grade.equalsIgnoreCase("A")) {
      return 4;
    } else if (grade.equalsIgnoreCase("B")) {
      return 3;
    } else if (grade.equalsIgnoreCase("C")) {
      return 2;
    } else if (grade.equalsIgnoreCase("D")) {
      return 1;
    } else {
      return 0;
    }
  }

  public static String determineJudicium(double ipk) {
    if (ipk >= 3.5) {
      return "Cum Laude";
    } else if (ipk >= 2.75 && ipk < 3.5) {
      return "Sangat Memuaskan";
    } else if (ipk > 2 && ipk < 2.75) {
      return "Memuaskan";
    } else {
      return "Pending";
    }
  }
}
