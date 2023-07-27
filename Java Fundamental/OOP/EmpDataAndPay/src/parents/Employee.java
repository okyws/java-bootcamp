package parents;

import childs.Programmer;
import childs.ProjectLeader;
import interfaces.IAllowance;
import interfaces.ISalary;

public class Employee extends Person implements ISalary, IAllowance {
  private String employeeID;
  private String jobDescription;
  private Placement placement;
  protected double salary;
  private static int employeeCounter = 1;
  private static int programmerCounter = 1;
  private static int projectLeaderCounter = 1;

  public Employee() {
    super();
    this.employeeID = generateEmployeeID(this);
  }

  public Employee(String name, String address, int age, String jobDescription, Placement placement, double salary) {
    super(name, address, age);
    this.jobDescription = jobDescription;
    this.placement = placement;
    this.salary = salary;
  }

  public Employee(String employeeID, String name, String address, int age, String jobDescription, Placement placement,
      double salary) {
    super();
  }

  public String getEmployeeID() {
    return employeeID;
  }

  public String getJobDescription() {
    return jobDescription;
  }

  public Placement getPlacement() {
    return placement;
  }

  public double getSalary() {
    this.salary = calculateSalary();
    return salary;
  }

  public void setEmployeeID(String employeeID) {
    this.employeeID = generateEmployeeID(null);
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  public void setPlacement(Placement placement) {
    this.placement = placement;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String generateEmployeeID(Employee employee) {
    String prefix;
    String id;

    if (employee instanceof ProjectLeader) {
      prefix = "PL";
      id = prefix + "-" + String.format("%03d", projectLeaderCounter++);
    } else if (employee instanceof Programmer) {
      prefix = "PRO";
      id = prefix + "-" + String.format("%03d", programmerCounter++);
    } else {
      prefix = "Emp";
      id = prefix + "-" + String.format("%03d", employeeCounter++);
    }
    return id;
  }

  @Override
  public double calculateSalary() {
    return salary = this.placement.getUMK();
  }

  @Override
  public double calculateAllowance() {
    double allowance = salary * 0.0;
    return allowance;
  }
}
