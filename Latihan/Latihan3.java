import java.util.Scanner;

public class Latihan3 {

  public static void main(String[] args) {
    String playerName = " ";
    int perfectCount, greatCount, goodCount, missCount = 0;
    Scanner sn = new Scanner(System.in);

    playerName = sn.nextLine();
    perfectCount = sn.nextInt();
    greatCount = sn.nextInt();
    goodCount = sn.nextInt();
    missCount = sn.nextInt();

    int totalScore = calculateScore(perfectCount, greatCount, goodCount, missCount);
    int totalMaxScore = calculateMaxScore(perfectCount, greatCount, goodCount, missCount);
    double percentage = (double) totalScore / totalMaxScore;
    // System.out.println(percentage);
    String rank = getRank(percentage);

    printResult(playerName, totalScore, rank);
    sn.close();
  }

  public static int calculateMaxScore(int perfectCount, int greatCount, int goodCount, int missCount) {
    int maxCount = perfectCount + greatCount + goodCount + missCount;
    int maxScore = maxCount * 100;
    return maxScore;
  }

  public static int calculateScore(int perfectCount, int greatCount, int goodCount, int missCount) {
    int totalScore = perfectCount * 100 + greatCount * 80 + goodCount * 60 + missCount * 0;
    return totalScore;
  }

  public static String getRank(double percentage) {
    if (percentage >= 0.9) {
      return "S (Super)";
    } else if (percentage >= 0.8) {
      return "A (Amazing)";
    } else if (percentage >= 0.7) {
      return "B (Brilliant)";
    } else if (percentage >= 0.6) {
      return "C (Cool)";
    } else {
      return "D (Decent)";
    }
  }

  public static void printResult(String playerName, double totalScore, String rank) {
    System.out.printf("%.0f\n", totalScore);
    System.out.println(playerName + " peringkat " + rank);
  }
}
