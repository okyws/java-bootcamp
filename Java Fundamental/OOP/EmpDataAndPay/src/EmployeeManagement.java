import java.util.ArrayList;
import java.util.Scanner;

import parents.Employee;
import parents.Placement;
import repository.RepositoryEmployee;

public class EmployeeManagement {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    EmployeeManagement employeeManagement = new EmployeeManagement();
    RepositoryEmployee employees = new RepositoryEmployee(new ArrayList<Employee>());

    int choice;
    boolean isLooping = true;

    do {
      employeeManagement.displayMenu();
      choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          employeeManagement.addEmployee();
          break;
        case 2:
          employeeManagement.editEmployee();
          break;
        case 3:
          employeeManagement.displayEmployeeData();
          employees.getAllEmployees();
          break;
        case 4:
          employeeManagement.displayPayrollData();
          break;
        case 5:
          employeeManagement.deleteEmployee();
          break;
        case 6:
          employeeManagement.searchEmployee();
          break;
        case 7:
          Placement.getAllUMK();
          break;
        case 0:
          System.out.println("Exiting the program...");
          isLooping = false;
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    } while (isLooping == true);
  }

  public void displayMenu() {
    System.out.println("\nSelamat Datang di Aplikasi Pendataan Karyawan PT. Secret Semut 79\n");
    System.out.println("1. Add Employee");
    System.out.println("2. Edit Employee");
    System.out.println("3. Data Employee");
    System.out.println("4. Data Payroll");
    System.out.println("5. Delete Employee");
    System.out.println("6. Searching");
    System.out.println("7. UMK");
    System.out.println("0. Exit");
    System.out.print("Please enter your choice: ");
  }

  public void addEmployee() {
    // Add employee logic
    System.out.println("Add Employee option selected");
  }

  public void editEmployee() {
    // Edit employee logic
    System.out.println("Edit Employee option selected");
  }

  public void displayEmployeeData() {
    // Display employee data logic
    System.out.println("Data Employee option selected");
  }

  public void displayPayrollData() {
    // Display payroll data logic
    System.out.println("Data Payroll option selected");
  }

  public void deleteEmployee() {
    // Delete employee logic
    System.out.println("Delete Employee option selected");
  }

  public void searchEmployee() {
    // Search employee logic
    System.out.println("Searching option selected");
  }
}
