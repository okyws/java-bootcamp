package childs;

import parents.Employee;

public class Manager extends Employee {
  // Atribut / Properties / Fields
  private String department;

  // Constructor default
  public Manager() {
    super();
  }

  // Constructor berparameter
  public Manager(String name, int age, double salary, String department) {
    super(name, age, salary);
    this.department = department;
  }

  // Getters dan Setters
  public String getdepartment() {
    return department;
  }

  public void setdepartment(String department) {
    this.department = department;
  }

  // Method untuk menampilkan informasi
  public void displayInformation() {
    super.displayInformation();
    System.out.println("Department: " + department);
  }
}
