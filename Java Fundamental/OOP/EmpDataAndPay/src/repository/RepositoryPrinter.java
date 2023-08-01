package repository;

import java.util.List;

import childs.DataAnalyst;
import childs.Programmer;
import childs.ProjectLeader;
import parents.Employee;
import parents.EmployeeManager;

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
    sb.append(
        "============================================================================================================\n");
    sb.append(
        "|| No || EmployeeID\t|| \t Name  || \tAddress\t || Age || \tDescription\t || \tPlacement ||\n");
    sb.append(
        "============================================================================================================\n");
    int i = 1;
    for (Employee employee : employees) {
      sb.append("|| ");
      sb.append(String.format("%2d ", i++));
      sb.append("|| ");
      sb.append(String.format("%-15s", employee.getEmployeeID()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getName()));
      sb.append("|| ");
      sb.append(String.format("%-15s", employee.getAddress()));
      sb.append("|| ");
      sb.append(String.format("%-4d", employee.getAge()));
      sb.append("|| ");
      sb.append(String.format("%-22s", employee.getJobDescription()));
      sb.append("|| ");
      sb.append(String.format("%-14s", employee.getPlacement().getCity()));
      sb.append("||\n");
    }

    sb.append(
        "============================================================================================================\n");
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
        "=======================================================================================================================================================================\n");
    sb.append(
        "|| No || EmployeeID\t|| \t Name  || \tAddress\t || Age || \tDescription\t || \tPlacement || \t Salary \t\t||     \tAllowance \t     ||\n");
    sb.append(
        "=======================================================================================================================================================================\n");

    int i = 1;
    for (Employee employee : employees) {
      sb.append("|| ");
      sb.append(String.format("%2d ", i++));
      sb.append("|| ");
      sb.append(String.format("%-15s", employee.getEmployeeID()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getName()));
      sb.append("|| ");
      sb.append(String.format("%-15s", employee.getAddress()));
      sb.append("|| ");
      sb.append(String.format("%-4d", employee.getAge()));
      sb.append("|| ");
      sb.append(String.format("%-22s", employee.getJobDescription()));
      sb.append("|| ");
      sb.append(String.format("%-14s", employee.getPlacement().getCity()));
      sb.append("|| ");
      sb.append(String.format("%-16s %.2f", "Salary : ", employee.getSalary()));
      if (employee instanceof ProjectLeader) {
        ProjectLeader projectLeader = (ProjectLeader) employee;
        sb.append("|| ");
        sb.append(String.format("%-16s %.2f", "Allowance : ", projectLeader.calculateAllowance()));
      } else if (employee instanceof Programmer) {
        Programmer programmer = (Programmer) employee;
        sb.append("|| ");
        sb.append(String.format("%-16s %.2f", "Allowance : ", programmer.calculateAllowance()));
      } else if (employee instanceof DataAnalyst) {
        DataAnalyst dataAnalyst = (DataAnalyst) employee;
        sb.append("|| ");
        sb.append(String.format("%-16s %.2f", "Allowance : ", dataAnalyst.calculateAllowance()));
      } else {
        sb.append(String.format("|| %-21s %.2f", "Allowance : ", 0.0));
      }
      sb.append("||\n");
    }

    sb.append(
        "=======================================================================================================================================================================\n");
    System.out.print(sb.toString());
  }

  public void printEmployeesByCity(List<Employee> employees) {
    StringBuilder sb = new StringBuilder();
    sb.append(
        "============================================================================================================\n");
    sb.append("|| No || EmployeeID\t|| \t Name || \tAddress\t || Age || \tDescription\t ||\tPlacement ||\n");
    sb.append(
        "============================================================================================================\n");

    int i = 1;
    for (Employee employee : employees) {
      sb.append("|| ");
      sb.append(String.format("%2d ", i++));
      sb.append("|| ");
      sb.append(String.format("%-15s", employee.getEmployeeID()));
      sb.append("|| ");
      sb.append(String.format("%-12s", employee.getName()));
      sb.append("|| ");
      sb.append(String.format("%-15s", employee.getAddress()));
      sb.append("|| ");
      sb.append(String.format("%-4d", employee.getAge()));
      sb.append("|| ");
      sb.append(String.format("%-22s", employee.getJobDescription()));
      sb.append("|| ");
      sb.append(String.format("%-14s", employee.getPlacement().getCity()));
      sb.append("||\n");
    }
    sb.append(
        "============================================================================================================");
    System.out.println(sb.toString());
  }

  public void setEmployeeManager(EmployeeManager employeeManager) {
    this.employeeManager = employeeManager;
  }
}
