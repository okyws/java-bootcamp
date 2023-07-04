import java.util.Scanner;

public class CountHole {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String world = input.nextLine();

    int result = 0;
    for (int i = 0; i < world.length(); i++) {
      char capital = world.charAt(i);

      switch (capital) {
        case 'A':
        case 'a':
          result += 1;
          break;
        case 'B':
          result += 2;
          break;
        case 'b':
          result += 1;
          break;
        case 'D':
        case 'd':
          result += 1;
          break;
        case 'e':
          result += 1;
          break;
        case 'g':
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
        case 'Q':
        case 'q':
          result += 1;
          break;
        case 'R':
          result += 1;
          break;
        case '4':
          result += 1;
          break;
        case '6':
          result += 1;
          break;
        case '8':
          result += 2;
          break;
        case '9':
          result += 1;
          break;
        case '0':
          result += 1;
        default:
          break;
      }
    }

    input.close();
    System.out.println(result);
  }
}
