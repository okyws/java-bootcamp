import java.util.Scanner;

public class soal4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String[] inputString = input.nextLine().split(" ");
    int[] arr = new int[inputString.length];

    for (int i = 0; i < inputString.length; i++) {
      arr[i] = Integer.parseInt(inputString[i]);
    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    input.close();
  }
}
