package childs;

import parents.Employee;
import parents.Placement;

public class Programmer extends Employee {
  private String[] programmingLanguages;
  private int experience;

  public Programmer() {
    super();
  }

  public Programmer(String name, String address, int age, String jobDescription, Placement placement,
      String[] programmingLanguages, int experience, double salary) {
    super(name, address, age, jobDescription, placement, salary);
    this.programmingLanguages = programmingLanguages;
    this.experience = experience;
  }

  public String[] getProgrammingLanguages() {
    return programmingLanguages;
  }

  public int getExperience() {
    return experience;
  }

  public void setProgrammingLanguages(String[] programmingLanguages) {
    this.programmingLanguages = programmingLanguages;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }

  @Override
  public double calculateSalary() {
    double programmerUMK = 1.5;
    return salary = super.salary * programmerUMK;
  }

  @Override
  public double calculateAllowance() {
    double allowance = (this.getExperience() >= 2) ? salary * 0.2
        : salary * 0.1;
    return allowance;
  }
}
