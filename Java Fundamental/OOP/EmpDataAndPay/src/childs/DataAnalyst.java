package childs;

import interfaces.IAllowance;
import parents.Employee;
import parents.Placement;

public class DataAnalyst extends Employee implements IAllowance {
  public DataAnalyst() {
    super();
  }

  public DataAnalyst(String name, String address, int age, String jobDescription, Placement placement) {
    super(name, address, age, jobDescription, placement);
  }

  public DataAnalyst(String employeeID, String name, String address, int age, String jobDescription,
      Placement placement) {
    super(name, address, age, jobDescription, placement);
  }

  @Override
  public double calculateSalary() {
    double DataAnalystUMK = 1.6;
    salary = super.calculateSalary() * DataAnalystUMK;
    return salary;
  }

  @Override
  public double calculateAllowance() {
    double allowance = super.calculateSalary() * 0.05;
    return allowance;
  }
}
