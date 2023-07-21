package childs;

import parents.Employee;

public class Programmer extends Employee {
  // Attributes / Fields / Properties
  private String programmingLanguage;

  // Constructor Default
  public Programmer() {
    super();
  }

  // Constructor dengan parameter
  public Programmer(String name, int age, String companyName, String programmingLanguage) {
    super(name, age, companyName);
    this.programmingLanguage = programmingLanguage;
  }

  // Getter & Setter
  public String getProgrammingLanguage() {
    return programmingLanguage;
  }

  public void setProgrammingLanguage(String programmingLanguage) {
    this.programmingLanguage = programmingLanguage;
  }

  // Method / Function yang sudah di override
  @Override
  public void greeting() {
    System.out.println("Hello, Nama saya " + this.getName() + ", berumur " + this.getAge() + " tahun.");
    System.out.println("Saya bekerja di " + this.getCompanyName() + ".");
    System.out.println("Saya menguasai bahasa pemrograman " + this.programmingLanguage + ".");
  }
}
