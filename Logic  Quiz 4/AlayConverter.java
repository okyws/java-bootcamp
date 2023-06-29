import java.util.Scanner;

public class AlayConverter {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String sentence = input.nextLine();
    String alaySentence = convertToAlay(sentence);

    System.out.println(alaySentence);

    input.close();
  }

  private static String convertToAlay(String sentence) {
    StringBuilder alaySentence = new StringBuilder();

    for (int i = 0; i < sentence.length(); i++) {
      char currentChar = sentence.charAt(i);

      switch (currentChar) {
        case 'A':
        case 'a':
          alaySentence.append('4');
          break;
        case 'I':
        case 'i':
          alaySentence.append('1');
          break;
        case 'Z':
        case 'z':
          alaySentence.append('2');
          break;
        case 'E':
        case 'e':
          alaySentence.append('3');
          break;
        case 'G':
        case 'g':
          alaySentence.append('6');
          break;
        case 'J':
        case 'j':
          alaySentence.append('7');
          break;
        case 'B':
        case 'b':
          alaySentence.append('8');
          break;
        default:
          alaySentence.append(currentChar);
          break;
      }
    }

    return alaySentence.toString();
  }
}
