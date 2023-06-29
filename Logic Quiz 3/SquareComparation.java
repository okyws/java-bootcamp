/*
 * import java.util.Scanner;
 *
 * public class SquareComparation {
 * public static void main(String[] args) {
 * Scanner input = new Scanner(System.in);
 * int R1, R2, R3;
 * double S, area1, area2, area3, result;
 *
 * do {
 * R1 = input.nextInt();
 * } while (R1 < 0 || R1 > 100);
 *
 * do {
 * R2 = input.nextInt();
 * } while (R2 < 0 || R2 > 100);
 *
 * do {
 * R3 = input.nextInt();
 * } while (R3 < 0 || R3 > 100);
 *
 * do {
 * S = input.nextDouble();
 * } while (S < 0 || S > 100);
 *
 * area1 = S * S;
 * area2 = (R2 * R2) * area1 / (R1 * R1);
 * area3 = (R3 * R3) * area1 / (R1 * R1);
 *
 * result = area1 + area2 + area3;
 *
 * System.out.printf("%.2f", result);
 *
 * input.close();
 * }
 * }
 *
 */

import java.util.Scanner;

public class SquareComparation {
  private static final int RANGE_LIMIT = 100;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int radius1, radius2, radius3;
    double side, area1, area2, area3, result;

    radius1 = validateInput(input, 1, RANGE_LIMIT);
    radius2 = validateInput(input, 1, RANGE_LIMIT);
    radius3 = validateInput(input, 1, RANGE_LIMIT);
    side = validateInput(input, 1, RANGE_LIMIT);

    area1 = side * side;
    area2 = (radius2 * radius2) * area1 / (radius1 * radius1);
    area3 = (radius3 * radius3) * area1 / (radius1 * radius1);

    result = area1 + area2 + area3;

    System.out.printf("%.2f", result);

    input.close();
  }

  private static int validateInput(Scanner input, int min, int max) {
    int value;
    do {
      value = input.nextInt();
    } while (value < min || value > max);
    return value;
  }
}
