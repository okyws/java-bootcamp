package menu;

import java.util.Scanner;

public class MenuUtils {
  public static Scanner scanner = new Scanner(System.in);

  protected static String getUserInput() {
    return scanner.nextLine();
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
      age = getValidNumericInput();
      if (age < 18 || age > 120) {
        System.out.println("Invalid age. Please enter a valid age between 18 and 120.");
      } else {
        break;
      }
    }
    return age;
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
