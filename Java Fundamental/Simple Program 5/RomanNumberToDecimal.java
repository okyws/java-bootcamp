import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumberToDecimal {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int decimalNumber;
    String romanNumber;

    decimalNumber = getDecimalInput(input);
    romanNumber = toRomanNumber(decimalNumber);
    System.out.print(romanNumber);

    input.close();
  }

  public static int getDecimalInput(Scanner input) {
    int decimalNumber;

    do {
      decimalNumber = input.nextInt();
    } while (decimalNumber < 1 || decimalNumber > 3999);

    input.close();
    return decimalNumber;
  }

  public static String toRomanNumber(int decimalNumber) {
    Map<Integer, String> romanSymbols = new LinkedHashMap<>();
    romanSymbols.put(1000, "M");
    romanSymbols.put(900, "CM");
    romanSymbols.put(800, "DCCC");
    romanSymbols.put(700, "DCC");
    romanSymbols.put(600, "DC");
    romanSymbols.put(500, "D");
    romanSymbols.put(400, "CD");
    romanSymbols.put(300, "CCC");
    romanSymbols.put(200, "CC");
    romanSymbols.put(100, "C");
    romanSymbols.put(90, "XC");
    romanSymbols.put(80, "LXXX");
    romanSymbols.put(70, "LXX");
    romanSymbols.put(60, "LX");
    romanSymbols.put(50, "L");
    romanSymbols.put(40, "XL");
    romanSymbols.put(30, "XXX");
    romanSymbols.put(20, "XX");
    romanSymbols.put(10, "X");
    romanSymbols.put(9, "IX");
    romanSymbols.put(8, "VIII");
    romanSymbols.put(7, "VII");
    romanSymbols.put(6, "VI");
    romanSymbols.put(5, "V");
    romanSymbols.put(4, "IV");
    romanSymbols.put(3, "III");
    romanSymbols.put(2, "II");
    romanSymbols.put(1, "I");

    StringBuilder romanNumber = new StringBuilder();

    for (Map.Entry<Integer, String> entry : romanSymbols.entrySet()) {
      int value = entry.getKey();
      String symbol = entry.getValue();

      while (decimalNumber >= value) {
        romanNumber.append(symbol);
        decimalNumber -= value;
      }
    }

    return romanNumber.toString();
  }
}
