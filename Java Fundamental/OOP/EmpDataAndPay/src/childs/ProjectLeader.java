package childs;

import parents.Employee;
import parents.Placement;

public class ProjectLeader extends Employee {
  private int totalProject;

  public ProjectLeader() {
    super();
  }

  public ProjectLeader(String name, String address, int age, String jobDescription, Placement placement,
      int totalProject, double salary) {
    super(name, address, age, jobDescription, placement, salary);
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
    salary = super.salary * ProjectLeaderUMK;
    return salary;
  }

  @Override
  public double calculateAllowance() {
    double allowance = (this.getTotalProject() >= 2) ? salary * 0.15
        : salary * 0.05;
    return allowance;
  }
}
