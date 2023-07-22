public class MainApp {
  public static void main(String[] args) {
    // Create Instance of Person
    Person person = new Person();

    /*
     * Jika kita menggunakan cara ini maka kita tidak bisa mengakses
     * attribute name, age, dan country karena attribute tersebut bersifat private
     * dan hanya bisa diakses di dalam class Person
     *
     * person.name = "Arthfael Viktorija";
     * person.age = 25;
     * person.country = "USA";
     *
     * untuk mengakses attribute tersebut kita harus menggunakan setter dan getter
     * yang sudah kita buat di dalam class Person jika kita menggunakan
     * Encapsulation
     */

    // Set Attribute Value Directly using Setter
    person.setName("Arthfael Viktorija");
    person.setAge(25);
    person.setCountry("USA");

    // Get Attribute Value Directly using Getter
    String name = person.getName();
    int age = person.getAge();
    String country = person.getCountry();

    // Print Attribute Value
    String info = person.printInformation(name, age, country);
    System.out.println(info);
  }
}
