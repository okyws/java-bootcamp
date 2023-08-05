import java.util.Scanner;

public class soal4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String[] inputString = input.nextLine().split(" ");
    int[] arr = new int[inputString.length];
    int temp = arr[0];

    // masukan input ke array
    inputToArray(inputString, arr);
    // urutkan array
    sortFromHigh(arr, temp);
    // cetak array
    show(arr);

    input.close();
  }

  static int[] inputToArray(String[] inputString, int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(inputString[i]);
    }

    return arr;
  }

  static void sortFromHigh(int[] arr, int temp) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  static void show(int[] numbers) {
    // cara 1
    for (int i : numbers) {
      System.out.print(i + " ");
    }
    // cara 2
    // for (int i = 0; i < arr.length; i++) {
    // System.out.print(arr[i] + " ");
    // }
  }
}
