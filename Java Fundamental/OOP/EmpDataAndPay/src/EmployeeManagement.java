import java.util.List;
import java.util.Scanner;

import parents.Employee;
import parents.EmployeeManager;
import parents.Placement;
import repository.RepositoryPrinter;

public class EmployeeManagement {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    EmployeeManager employeeManager = new EmployeeManager();
    RepositoryPrinter repositoryPrinter = new RepositoryPrinter();
    repositoryPrinter.setEmployeeManager(employeeManager);
    employeeManager.setRepositoryPrinter(repositoryPrinter);

    int choice;
    boolean isLooping = true;

    do {
      displayMenu();
      try {
        if (scanner.hasNextLine()) {
          choice = Integer.parseInt(scanner.nextLine());
        } else {
          System.out.println("No input found. Exiting the program...");
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid numeric choice.");
        continue;
      }

      switch (choice) {
        case 1:
          addEmployee(repositoryPrinter, employeeManager);
          break;
        case 2:
          repositoryPrinter.printAllEmployees();
          editEmployee(employeeManager);
          waitForBackToMenu();
          break;
        case 3:
          repositoryPrinter.printAllEmployees();
          waitForBackToMenu();
          break;
        case 4:
          repositoryPrinter.printAllEmployeesPayroll();
          waitForBackToMenu();
          break;
        case 5:
          repositoryPrinter.printAllEmployees();
          deleteEmployee(employeeManager);
          break;
        case 6:
          searchEmployee(employeeManager);
          waitForBackToMenu();
          break;
        case 0:
          System.out.println("Exiting the program...");
          isLooping = false;
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    } while (isLooping);
  }

  public static void displayMenu() {
    System.out.println("\nSelamat Datang di Aplikasi Pendataan Karyawan PT. Secret Semut 79\n");
    System.out.println("1. Add Employee");
    System.out.println("2. Edit Employee");
    System.out.println("3. Data Employee");
    System.out.println("4. Data Payroll");
    System.out.println("5. Delete Employee");
    System.out.println("6. Searching");
    System.out.println("0. Exit");
    System.out.print("Please enter your choice: ");
  }

  private static void waitForBackToMenu() {
    System.out.print("0. back to menu: ");
    String input = scanner.nextLine();
    if (!input.equalsIgnoreCase("0")) {
      waitForBackToMenu();
    }
  }

  public static void addEmployee(RepositoryPrinter repositoryPrinter, EmployeeManager employeeManager) {
    MenuAddEmployee.addEmployee(repositoryPrinter, employeeManager);
  }

  public static void editEmployee(EmployeeManager employeeManager) {
    System.out.print("Enter the Employee ID to edit their Placement: ");
    String employeeId = scanner.nextLine();

    Placement newPlacement = new Placement();
    String newCity;
    while (true) {
      System.out.print("Enter the new Placement city: ");
      newCity = scanner.nextLine().trim();
      if (isValidCity(newCity)) {
        newPlacement.setCity(newCity);
        break;
      } else {
        System.out.println("Invalid city name. Please enter a valid city name.");
        return;
      }
    }

    boolean isUpdated = employeeManager.editEmployeePlacement(employeeId, newPlacement);
    if (isUpdated) {
      System.out.println("Employee Placement has been updated successfully!");
    } else {
      System.out.println("Failed to update Employee Placement. Employee not found.");
    }
  }

  private static boolean isValidCity(String city) {
    return !city.isEmpty() && city.matches("^[a-zA-Z ]+$");
  }

  public static void deleteEmployee(EmployeeManager employeeManager) {
    System.out.print("Enter the Employee ID to delete: ");
    String employeeID = scanner.nextLine();
    boolean isDeleted = employeeManager.deleteEmployee(employeeID);

    if (isDeleted) {
      System.out.println("Employee with Employee ID " + employeeID + " deleted successfully.");
    } else {
      System.out.println("Employee with Employee ID " + employeeID + " not found.");
    }

    waitForBackToMenu();
  }

  public static void searchEmployee(EmployeeManager employeeManager) {
    System.out.print("Enter the city to search for employees: ");
    String city = scanner.nextLine();
    List<Employee> employeesFound = employeeManager.getEmployeeByCity(city);

    if (employeesFound.isEmpty()) {
      System.out.println("No employees found in the city: " + city);
    } else {
      System.out.println("Employees in the city: " + city);
      RepositoryPrinter repositoryPrinter = new RepositoryPrinter();
      System.out.println(repositoryPrinter.detailFindTableEmployee(employeesFound));
    }
  }

}
