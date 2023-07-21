package parents;

public class Employee {
  // Atribut / Properties / Fields
  String name;
  int age;
  double salary;

  // Constructor default
  public Employee() {
    super();
  }

  // Constructor berparameter
  public Employee(String name, int age, double salary) {
    super();
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  // Getters dan Setters
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

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  // Method untuk menampilkan informasi
  public void displayInformation() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Salary: $" + salary);
  }
}
