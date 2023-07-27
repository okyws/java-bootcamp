package childs;

import parents.Employee;
import parents.Placement;

public class ProjectLeader extends Employee {
  private int totalProject;

  public ProjectLeader() {
    super();
  }

  public ProjectLeader(String name, String address, int age, String jobDescription, Placement placement,
      int totalProject) {
    super(name, address, age, jobDescription, placement);
    this.totalProject = totalProject;
  }

  public int getTotalProject() {
    return totalProject;
  }

  public void setTotalProject(int totalProject) {
    this.totalProject = totalProject;
  }

  @Override
  public double calculateSalary() {
    double ProjectLeaderUMK = 2.0;
    salary = super.calculateSalary() * ProjectLeaderUMK;
    return salary;
  }

  @Override
  public double calculateAllowance() {
    double allowance = (this.getTotalProject() >= 2) ? super.calculateSalary() * 0.15
        : super.calculateSalary() * 0.05;
    return allowance;
  }
}
