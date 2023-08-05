import java.util.Scanner;

public class soal2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String world = input.nextLine();
    int result = countWords(world);

    System.out.println(result);
    input.close();
  }

  static int countWords(String world) {
    int result = 0;
    for (int i = 0; i < world.length(); i++) {
      char capital = world.charAt(i);
      switch (capital) {
        case 'A':
        case 'a':
          result += 1;
          break;
        case 'D':
        case 'd':
          result += 1;
          break;
        case 'O':
        case 'o':
          result += 1;
          break;
        case 'P':
        case 'p':
          result += 1;
          break;
        case 'R':
        case 'r':
          result += 1;
          break;
        case 'Q':
        case 'q':
          result += 1;
          break;
        case 'B':
        case 'b':
          result += 2;
          break;
        default:
          break;
      }
    }
    return result;
  }
}
