import java.util.Scanner;

public class Latihan1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int length = input.nextInt();

    int[] numbers = new int[length];

    addInput(numbers, input);
    max(numbers);
    min(numbers);
    sum(numbers);
    mean(numbers);
    median(numbers);
    System.out.println();
    sortFromLow(numbers);
    sortFromHigh(numbers);
    input.close();
  }

  static void addInput(int[] numbers, Scanner input) {
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(input.next());
    }
  }

  static void sortFromLow(int[] numbers) {
    int temp = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        if (numbers[i] < numbers[j]) {
          temp = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = temp;
        }
      }
    }
    show(numbers);
  }

  static void sortFromHigh(int[] numbers) {
    int temp = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        if (numbers[i] > numbers[j]) {
          temp = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = temp;
        }
      }
    }
    show(numbers);
  }

  static void sum(int[] numbers) {
    int sum = 0;
    for (int i : numbers) {
      sum += i;
    }
    System.out.print(" Sum: " + sum);
  }

  static void mean(int[] numbers) {
    int sum = 0;
    for (int i : numbers) {
      sum += i;
    }
    System.out.print(" Mean: " + sum / numbers.length);
  }

  static void median(int[] numbers) {
    int median = 0;
    if (numbers.length % 2 == 0) {
      median = (numbers[numbers.length / 2] + numbers[(numbers.length / 2) - 1]) / 2;
    } else {
      median = numbers[numbers.length / 2];
    }
    System.out.print(" Median: " + median);
  }

  static void show(int[] numbers) {
    for (int i : numbers) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  static void max(int[] numbers) {
    int max = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }
    System.out.print("Max: " + max);
  }

  static void min(int[] numbers) {
    int min = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] < min) {
        min = numbers[i];
      }
    }
    System.out.print(" Min: " + min);
  }
}
