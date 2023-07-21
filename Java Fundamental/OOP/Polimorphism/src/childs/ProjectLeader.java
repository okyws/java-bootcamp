package childs;

import parents.Employee;

public class ProjectLeader extends Employee {
  // Attributes / Fields / Properties
  int totalProject;

  // Constructor Default
  public ProjectLeader() {
    super();
  }

  // Constructor dengan parameter
  public ProjectLeader(String name, int age, String companyName, int totalProject) {
    super(name, age, companyName);
    this.totalProject = totalProject;
  }

  // Getter & Setter
  public int getTotalProject() {
    return totalProject;
  }

  public void setTotalProject(int totalProject) {
    this.totalProject = totalProject;
  }

  // Method / Function yang sudah di override
  @Override
  public void greeting() {
    System.out.println("Hello, Nama saya " + this.getName() + ", berumur " + this.getAge() + " tahun.");
    System.out.println("Saya bekerja di " + this.getCompanyName() + ".");
    System.out.println("Saya telah memimpin " + this.getTotalProject() + " Project.");
  }
}
