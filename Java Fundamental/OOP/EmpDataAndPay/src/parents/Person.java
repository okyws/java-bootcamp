package parents;

public abstract class Person {
  private String name;
  private String address;
  private int age;

  public Person() {
    super();
  }

  public Person(String name, String address, int age) {
    super();
    this.name = name;
    this.address = address;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
