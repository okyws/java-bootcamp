package repository;

import java.util.ArrayList;
import java.util.List;

import parents.Employee;
import parents.Placement;

/*
 * Penggunaan Data Dummy belum sesuai, namun jika data di input manual maka program dapat berjalan dengan baik
 * Kendala :
 * 1. Data Dummy ketika di load bisa muncul
 * 2. Data inputan ketika ada dummy menjadi tidak muncul
 * namun jika tidak ada dummy maka data inputan muncul
 */

public class RepositoryEmployee {
  private List<Employee> employees;

  public RepositoryEmployee() {
    this.employees = new ArrayList<>();
    addDummyData();
  }

  private void addDummyData() {
    this.employees.add(new Employee("Emp-001", "Susi", "Bandung", 27, "Admin", new Placement("Jakarta"), 4453935.0));
    this.employees
        .add(new Employee("Emp-002", "Anto", "Bandung", 35, "Office Boy", new Placement("Bandung"), 3742276.0));
    this.employees.add(
        new Employee("Emp-003", "Riman", "Jakarta", 28, "Human Resource Dev", new Placement("Bandung"), 3742276.0));
  }

  public List<Employee> getAllEmployees() {
    return this.employees;
  }
}
