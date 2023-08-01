package menu;

import java.util.List;
import childs.DataAnalyst;
import childs.Programmer;
import childs.ProjectLeader;
import parents.Employee;
import parents.EmployeeManager;
import parents.Placement;
import repository.RepositoryPrinter;

public class EmployeeAction {
  public static void addEmployee(RepositoryPrinter repositoryPrinter, EmployeeManager employeeManager) {
    boolean isLooping = true;

    while (isLooping) {
      System.out.println("Adding a new employee to the system");
      System.out.print("Input your name: ");
      String name = MenuUtils.getValidName();
      System.out.print("Input your address: ");
      String address = MenuUtils.getValidAddress();
      int age = MenuUtils.getValidAgeFromUser();
      System.out.print("Input your job description: ");
      String jobDescription = MenuUtils.getUserInput();
      System.out.print("Input your placement city: ");
      String city = MenuUtils.getValidCity();
      int employeeType = MenuUtils.getEmployeeTypeFromUser();

      employeeManager.getAllEmployees();
      Employee employee;

      switch (employeeType) {
        case 1:
          employee = new Employee(name, address, age, jobDescription, new Placement(city));
          break;
        case 2:
          System.out.print("Input your programming languages (separated by comma): ");
          String[] programmingLanguages = MenuUtils.getUserInput().trim().split(",");
          if (programmingLanguages.length == 0) {
            System.out.println("At least one programming language is required for a programmer.");
            return;
          }
          System.out.print("Input your experience (in years): ");
          int experience = MenuUtils.getValidNumericInput();
          employee = new Programmer(name, address, age, jobDescription, new Placement(city),
              programmingLanguages, experience);
          break;
        case 3:
          System.out.print("Input your total project: ");
          int totalProject = MenuUtils.getValidNumericInput();
          employee = new ProjectLeader(name, address, age, jobDescription, new Placement(city), totalProject);
          break;
        case 4:
          employee = new DataAnalyst(name, address, age, jobDescription, new Placement(city));
          break;
        default:
          System.out.println("Invalid employee type selected. Adding as a regular employee.");
          employee = new Employee(name, address, age, jobDescription, new Placement(city));
          break;
      }

      double salary = employee.getSalary();
      employee.setSalary(salary);
      employeeManager.addEmployee(employee);

      System.out.println("Employee added successfully!");
      System.out.print("Do you want to add another employee? (Y/N): ");
      isLooping = MenuUtils.yesOrNo(isLooping);
    }
    repositoryPrinter.printAllEmployees();
    System.out.println();
  }

  public static void editEmployee(EmployeeManager employeeManager) {
    String employeeId, newCity;
    boolean isUpdated;
    Placement newPlacement = new Placement();

    do {
      System.out.print("Enter the Employee ID to edit their Placement: ");
      employeeId = MenuUtils.getUserInput();
    } while (employeeManager.getEmployeeByEmployeeId(employeeId) == null);

    while (true) {
      System.out.print("Enter the new Placement city: ");
      newCity = MenuUtils.scanner.nextLine().trim();
      if (isValidCity(newCity)) {
        newPlacement.setCity(newCity);
        break;
      } else {
        System.out.println("Invalid city name. Please enter a valid city name.");
      }
    }

    isUpdated = employeeManager.editEmployeePlacement(employeeId, newPlacement);
    if (isUpdated) {
      System.out.println("Employee Placement has been updated successfully!");
    } else {
      System.out.println("Failed to update Employee Placement. Employee not found.");
    }
  }

  private static boolean isValidCity(String city) {
    return Placement.getCityUMK().containsKey(city);
  }

  public static void deleteEmployee(EmployeeManager employeeManager) {
    boolean isLooping = true;
    while (isLooping) {
      System.out.print("Enter the Employee ID to delete: ");
      String employeeID = MenuUtils.getUserInput();
      boolean isDeleted = employeeManager.deleteEmployee(employeeID);

      if (isDeleted) {
        System.out.println("Employee with Employee ID " + employeeID + " deleted successfully.");
      } else {
        System.out.println("Employee with Employee ID " + employeeID + " not found.");
      }

      System.out.print("Do you want to delete another employee? (Y/N): ");
      isLooping = MenuUtils.yesOrNo(isLooping);
    }
  }

  public static void searchEmployee(EmployeeManager employeeManager) {
    System.out.print("Enter the city to search for employees: ");
    String city = MenuUtils.getUserInput();
    List<Employee> employees = employeeManager.getEmployeeByCity(city);
    RepositoryPrinter repositoryPrinter = new RepositoryPrinter();
    repositoryPrinter.setEmployeeManager(employeeManager);

    if (employees.isEmpty()) {
      System.out.println("No employees found in the city: " + city);
    } else {
      System.out.println("\nEmployees in the city: " + city);
      repositoryPrinter.printEmployeesByCity(employees);
    }

    MenuUtils.waitForBackToMenu();
  }
}
