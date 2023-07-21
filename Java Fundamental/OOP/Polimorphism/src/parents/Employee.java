package parents;

public class Employee extends Person {
  // Attributes / Fields / Properties
  private String companyName;

  // Constructor Default
  public Employee() {
    super();
  }

  // Constructor dengan parameter
  public Employee(String name, int age, String companyName) {
    super(name, age);
    this.companyName = companyName;
  }

  // Getter & Setter
  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  // Method / Function yang sudah di override
  @Override
  public void greeting() {
    System.out.println("Hello, Nama saya " + this.getName() + ", berumur " + this.getAge() + " tahun.");
  }
}
