package childs;

import parents.Employee;

public class EmployeePrinter {
  private Employee employee;

  public EmployeePrinter(Employee employee) {
    super();
    this.employee = employee;
  }

  public void printDetails() {
    System.out.println("Name : " + employee.getName());
    System.out.println("Address : " + employee.getAddress());
    System.out.println("Age : " + employee.getAge());
    System.out.println("Employee ID : " + employee.generateEmployeeID(employee));
    System.out.println("Job Description : " + employee.getJobDescription());
    System.out.println("Placement : " + employee.getPlacement().getCity());
    System.out.println("Salary : " + employee.getSalary());
    System.out.printf("Allowance : %.2f\n", employee.calculateAllowance());
    if (employee instanceof Programmer) {
      Programmer programmer = (Programmer) employee;
      System.out.println("Programming Languages : ");
      for (String programmingLanguage : programmer.getProgrammingLanguages()) {
        System.out.println("- " + programmingLanguage);
      }
      System.out.println("Experience : " + programmer.getExperience());
    } else if (employee instanceof ProjectLeader) {
      ProjectLeader projectLeader = (ProjectLeader) employee;
      System.out.println("Total Project : " + projectLeader.getTotalProject());
    }
  }
}
