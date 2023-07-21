package parents;

public class Person {
  // Attributes / Fields / Properties
  private String name;
  private int age;

  // Constructor Default
  public Person() {
    super();
  }

  // Constructor dengan parameter
  public Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  // Getter & Setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  // Method / Function
  public void greeting() {
    System.out.println("Hello, Nama saya " + this.name + ", berumur " + this.age + " tahun.");
  }
}
