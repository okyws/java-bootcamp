class Person {
  // Attributes / Fields / Properties
  private String name;
  private int age;
  private String country;

  // Constructor Default
  public Person() {
    super();
  }

  // Constructor Dengan Parameter
  public Person(String name, int age, String country) {
    super();
    this.name = name;
    this.age = age;
    this.country = country;
  }

  // Getter dan Setter
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  // Method untuk menampilkan informasi
  String printInformation(String name, int age, String country) {
    return String.format("Name: %s\nAge: %d\nCountry: %s", name, age, country);
  }
}
