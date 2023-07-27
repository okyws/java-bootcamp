package repository;

import java.util.ArrayList;
import java.util.List;

import parents.Employee;
import parents.Placement;

public class RepositoryEmployee {
  public List<Employee> employees;

  public RepositoryEmployee() {
    super();
  }

  public RepositoryEmployee(List<Employee> employees) {
    super();
    this.employees = employees;
  }

  public List<Employee> getAllEmployees() {
    this.employees = new ArrayList<>();
    this.employees.add(new Employee("Emp-001", "Susi", "Bandung", 27, "Admin", new Placement("Jakarta"), 1500));
    this.employees.add(new Employee("Emp-002", "Anto", "Bandung", 35, "Office Boy", new Placement("Bandung"), 1000));
    this.employees
        .add(new Employee("Emp-003", "Riman", "Jakarta", 28, "Human Resource Dev", new Placement("Bandung"), 2000));

    return this.employees;
  }

  public int getIndexByEmployeeID(String employeeID) {
    List<Employee> employees = getAllEmployees();
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getEmployeeID().equals(employeeID)) {
        return i;
      }
    }
    return -1; // Employee not found
  }
}
