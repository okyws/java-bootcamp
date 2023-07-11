import java.util.Scanner;

public class MatrixIdentity {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int matrixSize;

    matrixSize = getMatrixSize(input);

    int[][] matrix = createIdentityMatrix(matrixSize);
    printMatrix(matrix);

    input.close();
  }

  public static int getMatrixSize(Scanner input) {
    int matrixSize;

    do {
      matrixSize = input.nextInt();
    } while (matrixSize < 1 || matrixSize > 7);

    return matrixSize;
  }

  public static int[][] createIdentityMatrix(int matrixSize) {
    int[][] matrix = new int[matrixSize][matrixSize];

    int i = 0;
    while (i < matrixSize) {
      int j = 0;
      while (j < matrixSize) {
        if (i == j) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = 0;
        }
        j++;
      }
      i++;
    }

    return matrix;
  }

  public static void printMatrix(int[][] matrix) {
    int i = 0;
    while (i < matrix.length) {
      int j = 0;
      while (j < matrix[i].length) {
        System.out.print(matrix[i][j]);
        j++;
      }
      System.out.println();
      i++;
    }

  }

}
