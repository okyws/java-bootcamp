import java.util.Scanner;

import childs.DataAnalyst;
import childs.Programmer;
import childs.ProjectLeader;
import parents.Employee;
import parents.EmployeeManager;
import parents.Placement;
import repository.RepositoryPrinter;

public class MenuAddEmployee {
  private static final Scanner input = new Scanner(System.in);

  private static String getUserInput() {
    return input.nextLine();
  }

  private static int getValidNumericInput() {
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

  private static int getValidAgeFromUser() {
    int age;
    while (true) {
      System.out.print("Input your age: ");
      age = getValidNumericInput();
      if (age < 0 || age > 120) {
        System.out.println("Invalid age. Please enter a valid age between 0 and 120.");
      } else {
        break;
      }
    }
    return age;
  }

  private static int getEmployeeTypeFromUser() {
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

  public static void addEmployee(RepositoryPrinter repositoryPrinter, EmployeeManager employeeManager) {
    boolean isLooping = true;
    while (isLooping) {
      System.out.print("Input your name: ");
      String name = getUserInput();
      System.out.print("Input your address: ");
      String address = getUserInput();
      int age = getValidAgeFromUser();
      System.out.print("Input your job description: ");
      String jobDescription = getUserInput();
      System.out.print("Input your placement city: ");
      String city = getUserInput();
      int employeeType = getEmployeeTypeFromUser();

      Employee employee;

      if (employeeType == 1) {
        employee = new Employee(name, address, age, jobDescription, new Placement(city));
      } else if (employeeType == 2) {
        System.out.print("Input your programming languages (separated by comma): ");
        String[] programmingLanguages = getUserInput().split(",");
        if (programmingLanguages.length == 0) {
          System.out.println("At least one programming language is required for a programmer.");
          return;
        }
        System.out.print("Input your experience (in years): ");
        int experience = getValidNumericInput();
        employee = new Programmer(name, address, age, jobDescription, new Placement(city),
            programmingLanguages, experience);
      } else if (employeeType == 3) {
        System.out.print("Input your total project: ");
        int totalProject = getValidNumericInput();
        employee = new ProjectLeader(name, address, age, jobDescription, new Placement(city), totalProject);
      } else if (employeeType == 4) {
        employee = new DataAnalyst(name, address, age, jobDescription, new Placement(city));
      } else {
        System.out.println("Invalid employee type selected. Adding as a regular employee.");
        employee = new Employee(name, address, age, jobDescription, new Placement(city));
      }

      double salary = employee.getSalary();
      employee.setSalary(salary);
      employeeManager.addEmployee(employee);

      System.out.println("Employee added successfully!");
      System.out.print("Do you want to add another employee? (Y/N): ");
      String choice = getUserInput();
      if (!choice.equalsIgnoreCase("Y")) {
        isLooping = false;
      }
    }
    repositoryPrinter.printAllEmployees();
  }
}
