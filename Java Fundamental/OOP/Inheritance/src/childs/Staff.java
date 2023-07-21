package childs;

import parents.Employee;

public class Staff extends Employee {
  // Atribut / Properties / Fields
  private String specialization;

  // Constructor default
  public Staff() {
    super();
  }

  // Constructor berparameter
  public Staff(String name, int age, double salary, String specialization) {
    super(name, age, salary);
    this.specialization = specialization;
  }

  // Getters dan Setters
  public String getDivision() {
    return specialization;
  }

  public void setDivision(String specialization) {
    this.specialization = specialization;
  }

  // Method untuk menampilkan informasi
  public void displayInformation() {
    super.displayInformation();
    System.out.println("Specialization: " + specialization);
  }
}
