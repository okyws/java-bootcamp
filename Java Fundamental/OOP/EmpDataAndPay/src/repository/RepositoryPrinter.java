package repository;

import java.util.List;

import parents.Employee;
import parents.EmployeeManager;

/*
 * Penggunaan tabel yang belum rapih karena terlalu fokus pada masalh data dummy
 * dan juga terpotong oleh kerjaan yang lain, jadi belum sempat merapihkannya
 */

public class RepositoryPrinter {
  private EmployeeManager employeeManager;

  public RepositoryPrinter() {
    super();
  }

  public RepositoryPrinter(EmployeeManager employeeManager) {
    this.employeeManager = employeeManager;
  }

  public void printAllEmployees() {
    if (employeeManager == null) {
      System.out.println("EmployeeManager instance is not set. Cannot print employees.");
      return;
    }

    List<Employee> employees = employeeManager.getAllEmployees();

    StringBuilder sb = new StringBuilder();
    sb.append("====================================================================================================\n");
    sb.append("|| No || Employee ID || Name || Address || Age || Description || Placement ||\n");
    sb.append("====================================================================================================\n");

    int i = 1;
    for (Employee employee : employees) {
      sb.append("|| ");
      sb.append(String.format("%2d ", i++));
      sb.append("|| ");
      sb.append(String.format("%-14s", employee.getEmployeeID()));
      sb.append("|| ");
      sb.append(String.format("%-8s", employee.getName()));
      sb.append("|| ");
      sb.append(String.format("%-16s", employee.getAddress()));
      sb.append("|| ");
      sb.append(String.format("%-4d", employee.getAge()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getJobDescription()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getPlacement().getCity()));
      sb.append("||\n");
    }

    sb.append("====================================================================================================\n");
    System.out.print(sb.toString());
  }

  public void printAllEmployeesPayroll() {
    if (employeeManager == null) {
      System.out.println("EmployeeManager instance is not set. Cannot print employees.");
      return;
    }

    List<Employee> employees = employeeManager.getAllEmployees();

    StringBuilder sb = new StringBuilder();
    sb.append(
        "=====================================================================================================================================================================\n");
    sb.append(
        "|| No || EmployeeID\t|| \t Name  || \tAddress\t || Age || \tDescription\t || \tPlacement\t || \t Salary \t\t || \tAllowance \t\t||\n");
    sb.append(
        "=====================================================================================================================================================================\n");

    int i = 1;
    for (Employee employee : employees) {
      sb.append("|| ");
      sb.append(String.format("%2d ", i++));
      sb.append("|| ");
      sb.append(String.format("%-14s", employee.getEmployeeID()));
      sb.append("|| ");
      sb.append(String.format("%-8s", employee.getName()));
      sb.append("|| ");
      sb.append(String.format("%-16s", employee.getAddress()));
      sb.append("|| ");
      sb.append(String.format("%-4d", employee.getAge()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getJobDescription()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getPlacement().getCity()));
      sb.append("||\t");
      sb.append(String.format("Salary : %.2f", employee.getSalary()));
      sb.append("||\t");
      sb.append(String.format("Allowance : %.2f", employee.calculateAllowance()));
      sb.append("||\n");
    }

    sb.append(
        "=====================================================================================================================================================================\n");
    System.out.print(sb.toString());
  }

  public void printEmployeesByCity(String city) {
    List<Employee> employees = employeeManager.getEmployeeByCity(city);

    if (employees.isEmpty()) {
      System.out.println("No employees found in the city: " + city);
    } else {
      System.out.println("Employees in the city: " + city);
      System.out.println(detailFindTableEmployee(employees));
    }
  }

  public String detailFindTableEmployee(List<Employee> employees) {
    StringBuilder sb = new StringBuilder();
    sb.append("====================================================================================================\n");
    sb.append("|| No || Employee ID || \tName\t || Address || Age || Description || Placement || Salary ||\n");
    sb.append("====================================================================================================\n");

    int i = 1;
    for (Employee employee : employees) {
      sb.append("|| ");
      sb.append(String.format("%2d ", i++));
      sb.append("|| ");
      sb.append(String.format("%-11s", employee.getEmployeeID()));
      sb.append("|| ");
      sb.append(String.format("%-15s", employee.getName()));
      sb.append("|| ");
      sb.append(String.format("%-16s", employee.getAddress()));
      sb.append("|| ");
      sb.append(String.format("%-4d", employee.getAge()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getJobDescription()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getPlacement().getCity()));
      sb.append("||\n");
    }
    sb.append("====================================================================================================\n");
    return sb.toString();
  }

  public void setEmployeeManager(EmployeeManager employeeManager) {
    this.employeeManager = employeeManager;
  }
}
