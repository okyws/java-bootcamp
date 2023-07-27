package parents;

import java.util.concurrent.atomic.AtomicInteger;

import childs.DataAnalyst;
import childs.Programmer;
import childs.ProjectLeader;
import interfaces.IAllowance;
import interfaces.ISalary;

public class Employee extends Person implements ISalary, IAllowance {
  private String employeeID;
  private String jobDescription;
  private Placement placement;
  protected double salary;
  private static final AtomicInteger employeeCounter = new AtomicInteger(1);
  private static final AtomicInteger programmerCounter = new AtomicInteger(1);
  private static final AtomicInteger projectLeaderCounter = new AtomicInteger(1);
  private static final AtomicInteger dataAnalystCounter = new AtomicInteger(1);

  public Employee() {
    super();
    this.employeeID = generateEmployeeID(this);
  }

  public Employee(String name, String address, int age, String jobDescription, Placement placement) {
    super(name, address, age);
    this.employeeID = generateEmployeeID(this);
    this.jobDescription = jobDescription;
    this.placement = placement;
  }

  public Employee(String employeeID, String name, String address, int age, String jobDescription, Placement placement,
      double salary) {
    super(name, address, age);
    this.employeeID = employeeID;
    this.jobDescription = jobDescription;
    this.placement = placement;
    this.salary = salary;
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
    this.employeeID = employeeID;
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
      id = prefix + "-" + String.format("%03d", projectLeaderCounter.getAndIncrement());
    } else if (employee instanceof Programmer) {
      prefix = "PRO";
      id = prefix + "-" + String.format("%03d", programmerCounter.getAndIncrement());
    } else if (employee instanceof DataAnalyst) {
      prefix = "DA";
      id = prefix + "-" + String.format("%03d", dataAnalystCounter.getAndIncrement());
    } else {
      prefix = "Emp";
      id = prefix + "-" + String.format("%03d", employeeCounter.getAndIncrement());
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
