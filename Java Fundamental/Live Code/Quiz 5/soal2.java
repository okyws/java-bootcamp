import java.util.Scanner;

public class soal2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String world = input.nextLine();

    int result = 0;
    for (int i = 0; i < world.length(); i++) {
      char capital = world.charAt(i);

      // if (capital == 'a' || capital == 'A' || capital == 'D' || capital == 'd' ||
      // capital == 'o' || capital == 'O'
      // || capital == 'P' || capital == 'p' || capital == 'R' || capital == 'r') {
      // result += 1;
      // } else if (capital == 'B' || capital == 'b') {
      // result += 2;
      // }

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

    input.close();
    System.out.println(result);
  }
}
