import childs.Programmer;
import childs.ProjectLeader;
import childs.Teacher;
import parents.Employee;
import parents.Person;

public class MainApp {
  public static void main(String[] args) {
    /*
     * Untuk Programmer, ProjectLeader, dan Employee, kita bisa menginstance-nya ke
     * dalam Employee, karena ketiganya adalah turunan dari Person juga.
     *
     * Person person3 = new Employee("Nur", 22, "KahateX");
     *
     * bisa juga seperti ini:
     * Employee person3 = new Employee("Nur", 22, "KahateX");
     *
     * sedangkan untuk Teacher dan Person, kita tidak bisa menginstance-nya ke dalam
     * Employee, karena Teacher dan Person bukanlah turunan dari Employee.
     *
     * Downcasting yang salah:
     * Person person = new Person();
     * Employee employee = (Employee) person; // error
     *
     * Downcasting yang benar:
     * Person person = new Employee();
     * Employee employee = (Employee) person;
     */

    /*
     * jika ingin membuat instance menggunkan constructor default
     * Programmer programmer = new Programmer();
     * programmer.setName("Budi");
     * programmer.setAge(18);
     * programmer.setCompanyName("AprilIndo");
     * programmer.setProgrammingLanguage("Java");
     * programmer.greeting();
     * jenisPekerjaan(programmer);
     */

    /*
     * contoh jika menggunakan downcasting:
     * Person person10 = new Programmer("Nobita", 40, "PT. ABC", "Kotlin");
     * Programmer programmer = (Programmer) person10;
     * programmer.greeting();
     * jenisPekerjaan(programmer);
     */

    // membuat instance dari objek Person dan turunannya
    Person person1 = new Person("Budi", 18);
    Person person2 = new Programmer("Hasbi", 20, "AprilIndo", "Java");
    Person person3 = new Employee("Nur", 22, "KahateX");
    Person person4 = new ProjectLeader("Ridwan", 27, "BatuBintang", 10);
    Person person5 = new Teacher("Anthony", 26, "Matematika");

    // memanggil method greeting() dan jenisPekerjaan()
    person1.greeting();
    jenisPekerjaan(person1);
    System.out.println();
    person2.greeting();
    jenisPekerjaan(person2);
    System.out.println();
    person3.greeting();
    jenisPekerjaan(person3);
    System.out.println();
    person4.greeting();
    jenisPekerjaan(person4);
    System.out.println();
    person5.greeting();
    jenisPekerjaan(person5);
  }

  // method untuk menampilkan jenis pekerjaan
  public static void jenisPekerjaan(Person person) {
    if (person instanceof Programmer) {
      System.out.println("Saya adalah Programmer " + ((Programmer) person).getProgrammingLanguage() + " di "
          + ((Programmer) person).getCompanyName() + ".");
    } else if (person instanceof ProjectLeader) {
      System.out.println("Saya adalah Project Leader utama di " + ((ProjectLeader) person).getCompanyName() + ".");
    } else if (person instanceof Teacher) {
      System.out.println("Saya adalah seorang guru, mengajar " + ((Teacher) person).getSubject() + ".");
    } else if (person instanceof Employee) {
      System.out.println("Saya bekerja di " + ((Employee) person).getCompanyName()
          + ".");
      System.out.println("Salam kenal");
    } else {
      System.out.println("Salam kenal");
    }
  }
}
