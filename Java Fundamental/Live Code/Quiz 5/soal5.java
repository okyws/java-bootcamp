import java.util.Scanner;

public class soal5 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] X = new int[4][4];

    for (int i = 0; i < X.length; i++) {
      for (int j = 0; j < X[i].length; j++) {
        X[i][j] = input.nextInt();
      }
    }

    int count = 0;

    for (int i = 0; i < X.length; i++) {
      for (int j = 0; j < X[i].length; j++) {
        if (X[i][j] % 2 != 0) {
          count++;
        }
      }
    }

    input.close();
    System.out.println(count);
  }
}
