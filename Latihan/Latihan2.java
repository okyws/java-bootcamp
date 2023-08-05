import java.util.Scanner;

public class Latihan2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String word = input.nextLine();

    palindrome(word);
    System.out.println();
    useStringBuilder(word);
    reverseString(word);

    input.close();
  }

  static void useStringBuilder(String word) {
    StringBuilder sb = new StringBuilder(word);
    System.out.println(sb.toString());
    System.out.println(sb.reverse().toString());
  }

  static void reverseString(String word) {
    char[] wordArray = word.toCharArray();
    int length = wordArray.length;
    for (int i = length - 1; i >= 0; i--) {
      System.out.print(wordArray[i]);
    }
  }

  static void palindrome(String word) {
    // cara 1
    // StringBuilder sb = new StringBuilder(word);
    // String reverseWord = sb.reverse().toString();
    // if (word.equals(reverseWord)) {
    // System.out.println("Palindrome");
    // } else {
    // System.out.println("Bukan Palindrome");
    // }

    // cara 2
    // String reverseWord2 = "";
    // for (int i = word.length() - 1; i >= 0; i--) {
    // reverseWord2 += word.charAt(i);
    // }

    // if (word.equals(reverseWord2)) {
    // System.out.println("Palindrome");
    // } else {
    // System.out.println("Bukan Palindrome");
    // }

    // cara 3 tanpa regex
    String reverseWord = "";
    StringBuilder wordNoPunctuation = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (Character.isLetter(c)) {
        wordNoPunctuation.append(Character.toLowerCase(c));
      }
    }

    for (int i = wordNoPunctuation.length() - 1; i >= 0; i--) {
      reverseWord += wordNoPunctuation.charAt(i);
    }

    if (wordNoPunctuation.toString().equals(reverseWord)) {
      System.out.println("Palindrome");
    } else {
      System.out.println("Bukan Palindrome");
    }

    // cara 4 dengan regex
    // String reverseWord = "";
    // String wordNoPunctuation = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    // for (int i = wordNoPunctuation.length() - 1; i >= 0; i--) {
    // reverseWord += wordNoPunctuation.charAt(i);
    // }

    // if (wordNoPunctuation.equals(reverseWord)) {
    // System.out.println("Palindrome");
    // } else {
    // System.out.println("Bukan Palindrome");
    // }

  }
}
