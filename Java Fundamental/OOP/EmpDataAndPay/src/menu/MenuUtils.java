package menu;

import java.util.Scanner;

import parents.Placement;

public class MenuUtils {
  public static Scanner scanner = new Scanner(System.in);

  protected static String getUserInput() {
    return scanner.nextLine();
  }

  protected static String getValidName() {
    String input = scanner.nextLine();
    while (!isValidName(input)) {
      System.out.println("Invalid input. Please enter a valid name (3-30 characters).");
      System.out.print("Input your name: ");
      input = getUserInput();
    }

    return input;
  }

  protected static boolean isValidName(String input) {
    String regex = "^[A-Za-z\\s]{3,30}$";
    return input.matches(regex);
  }

  protected static String getValidAddress() {
    String input = scanner.nextLine();
    while (!isValidAddress(input)) {
      System.out.println("Invalid input. Please enter a valid address.");
      System.out.print("Input your address: ");
      input = getUserInput();
    }

    return input;
  }

  public static boolean isValidAddress(String address) {
    String regex = "^[A-Za-z0-9\\s.,-]+$";
    return address.matches(regex);
  }

  protected static int getValidNumericInput() {
    int value;
    while (true) {
      try {
        value = Integer.parseInt(getUserInput());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid numeric value.");
      }
    }
    return value;
  }

  protected static int getValidAgeFromUser() {
    int age;
    while (true) {
      System.out.print("Input your age: ");
      String input = getUserInput();
      if (input.matches("^(1[8-9]|[2-9][0-9]|1[01][0-9]|120)$")) {
        age = Integer.parseInt(input);
        break;
      } else {
        System.out.println("Invalid age. Please enter a valid age between 18 and 120.");
      }
    }
    return age;
  }

  protected static String getValidCity() {
    String input = scanner.nextLine();
    while (!isValidCity(input)) {
      System.out.println("Invalid input. Please enter a valid city.");
      System.out.print("Input your city: ");
      input = getUserInput();
    }

    return input;
  }

  private static boolean isValidCity(String city) {
    return Placement.getCityUMK().containsKey(city);
  }

  protected static int getEmployeeTypeFromUser() {
    int employeeType;
    while (true) {
      System.out
          .print("Select the type of employee (1: Employee, 2: Programmer, 3: Project Leader, 4. Data Analyst): ");
      employeeType = getValidNumericInput();
      if (employeeType < 1 || employeeType > 4) {
        System.out.println("Invalid employee type. Please enter a valid employee type.");
      } else {
        break;
      }
    }
    return employeeType;
  }

  public static boolean yesOrNo(boolean isLooping) {
    String choice = MenuUtils.getUserInput();
    if (!choice.equalsIgnoreCase("Y")) {
      isLooping = false;
    }
    return isLooping;
  }

  public static void waitForBackToMenu() {
    System.out.print("0. back to menu: ");
    String input = scanner.nextLine();
    if (!input.equalsIgnoreCase("0")) {
      waitForBackToMenu();
    }
  }
}
