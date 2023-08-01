import menu.EmployeeAction;
import menu.MenuUtils;
import parents.EmployeeManager;
import repository.RepositoryPrinter;

public class EmployeeMenu {
  public static void main(String[] args) {
    EmployeeManager employeeManager = new EmployeeManager();
    RepositoryPrinter repositoryPrinter = new RepositoryPrinter();
    repositoryPrinter.setEmployeeManager(employeeManager);

    int choice;
    boolean isLooping = true;

    do {
      displayMenu();
      try {
        if (MenuUtils.scanner.hasNextLine()) {
          choice = Integer.parseInt(MenuUtils.scanner.nextLine());
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
          EmployeeAction.addEmployee(repositoryPrinter, employeeManager);
          break;
        case 2:
          repositoryPrinter.printAllEmployees();
          EmployeeAction.editEmployee(employeeManager);
          MenuUtils.waitForBackToMenu();
          break;
        case 3:
          repositoryPrinter.printAllEmployees();
          MenuUtils.waitForBackToMenu();
          break;
        case 4:
          repositoryPrinter.printAllEmployeesPayroll();
          MenuUtils.waitForBackToMenu();
          break;
        case 5:
          repositoryPrinter.printAllEmployees();
          EmployeeAction.deleteEmployee(employeeManager);
          MenuUtils.waitForBackToMenu();
          break;
        case 6:
          EmployeeAction.searchEmployee(employeeManager);
          MenuUtils.waitForBackToMenu();
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
    System.out.println("=====================================================================");
    System.out.println("  Selamat Datang di Aplikasi Pendataan Karyawan PT. Secret Semut 79  ");
    System.out.println("=====================================================================");
    System.out.println("1. Add Employee");
    System.out.println("2. Edit Employee");
    System.out.println("3. Data Employee");
    System.out.println("4. Data Payroll");
    System.out.println("5. Delete Employee");
    System.out.println("6. Searching");
    System.out.println("0. Exit");
    System.out.println("=====================================================================");
    System.out.print("Please enter your choice: ");
  }
}
