import java.util.Scanner;

import childs.EmployeePrinter;
import childs.Programmer;
import childs.ProjectLeader;
import parents.Employee;
import parents.Placement;

public class MenuAddEmployee {
  private final static Scanner input = new Scanner(System.in);

  public static void addEmployee() {
    String name, address, jobDescription, city;
    int age, experience, totalProject;
    String[] programmingLanguages;
    System.out.print("Input your name : ");
    name = input.nextLine();
    System.out.print("Input your address : ");
    address = input.nextLine();
    System.out.print("Input your age : ");
    age = Integer.parseInt(input.nextLine());
    System.out.print("Input your job description : ");
    jobDescription = input.nextLine();
    System.out.print("Input your placement city : ");
    city = input.nextLine();

    System.out.println();
    System.out.println("For programmer");
    System.out.print("Input your programming languages (separated by comma) : ");
    programmingLanguages = input.nextLine().split(",");
    System.out.print("Input your experience : ");
    experience = Integer.parseInt(input.nextLine());
    System.out.println();

    System.out.println("For Project Leader");
    System.out.print("Total Project : ");
    totalProject = Integer.parseInt(input.nextLine());
    System.out.println();

    Employee employee = new Employee(name, address, age, jobDescription, new Placement(city), 0.0);
    EmployeePrinter employeePrinter = new EmployeePrinter(employee);
    double salary = employee.getSalary();
    employeePrinter.printDetails();

    System.out.println();

    Employee programmer = new Programmer(name, address, age, jobDescription, new Placement(city),
        programmingLanguages, experience, salary);
    EmployeePrinter programmerPrinter = new EmployeePrinter(programmer);
    programmerPrinter.printDetails();

    System.out.println();

    Employee projectLeader = new ProjectLeader(name, address, age, jobDescription, new Placement(city), totalProject,
        salary);
    EmployeePrinter projectLeaderPrinter = new EmployeePrinter(projectLeader);
    projectLeaderPrinter.printDetails();

    input.close();
  }
}
