import childs.Manager;
import childs.Staff;
import parents.Employee;

public class EmployeeHierarchy {
  public static void main(String[] args) throws Exception {
    // Membuat objek dari kelas Employee, Manager, dan Staff
    Employee employee = new Employee("John Doe", 30, 50000.0);
    Manager manager = new Manager("Jane Smith", 35, 80000.0, "Operations");
    Staff staff = new Staff("Mike Johnson", 25, 30000.0, "IT");

    // Memanggil method displayInformation() dari objek yang telah dibuat sebelumnya
    employee.displayInformation();
    System.out.println();
    manager.displayInformation();
    System.out.println();
    staff.displayInformation();
  }
}
