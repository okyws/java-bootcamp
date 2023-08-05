import java.util.Scanner;

public class soal5 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int baris = 4;
    int kolom = 4;
    int[][] array2D = new int[baris][kolom];

    // masukan input ke array 2 dimensi
    addInput(array2D, input);

    // hitung jumlah bilangan ganjil
    System.out.println("ganjil : " + countOdd(array2D));
    System.out.println("genap : " + countEven(array2D));

    input.close();
  }

  static int[][] addInput(int[][] numbers, Scanner input) {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers[i].length; j++) {
        numbers[i][j] = Integer.parseInt(input.next());
      }
    }

    return numbers;
  }

  static int countOdd(int[][] numbers) {
    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers[i].length; j++) {
        if (numbers[i][j] % 2 != 0) {
          count++;
        }
      }
    }

    return count;
  }

  static int countEven(int[][] numbers) {
    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers[i].length; j++) {
        if (numbers[i][j] % 2 == 0) {
          count++;
        }
      }
    }

    return count;
  }
}
