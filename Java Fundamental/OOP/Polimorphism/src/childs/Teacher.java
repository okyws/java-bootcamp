package childs;

import parents.Person;

public class Teacher extends Person {
  // Attributes / Fields / Properties
  private String subject;

  // Constructor Default
  public Teacher() {
    super();
  }

  // Constructor dengan parameter
  public Teacher(String name, int age, String subject) {
    super(name, age);
    this.subject = subject;
  }

  // Getter & Setter
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  // Method / Function yang sudah di override
  @Override
  public void greeting() {
    System.out.println("Hello, Nama saya " + this.getName() + ", berumur " + this.getAge() + " tahun.");
    System.out.println("Saya menguasai mata pelajaran " + this.subject + ".");
  }
}
