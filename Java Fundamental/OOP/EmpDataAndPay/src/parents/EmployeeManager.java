package parents;

import java.util.ArrayList;
import java.util.List;

import repository.RepositoryEmployee;
import repository.RepositoryPrinter;

public class EmployeeManager {
  private List<Employee> employees;
  private RepositoryEmployee repoEmployee = new RepositoryEmployee();
  private RepositoryPrinter repositoryPrinter;

  public EmployeeManager() {
    this.employees = new ArrayList<>();
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
  }

  public Employee getEmployeeByEmployeeId(String employeeId) {
    List<Employee> employees = getAllEmployees();

    for (Employee employee : employees) {
      if (employee.getEmployeeID().equals(employeeId)) {
        return employee;
      }
    }
    return null;
  }

  public List<Employee> getEmployeeByCity(String city) {
    getAllEmployees();
    List<Employee> searchResults = new ArrayList<>();

    for (Employee employee : employees) {
      if (employee.getPlacement().getCity().equalsIgnoreCase(city)) {
        searchResults.add(employee);
      }
    }
    return searchResults;
  }

  public List<Employee> getAllEmployees() {
    if (employees.isEmpty()) {
      employees.addAll(repoEmployee.getAllDummEmployees());
    } else if (repositoryPrinter != null) {
      repositoryPrinter.printAllEmployees();
    }
    return employees;
  }

  public boolean editEmployeePlacement(String employeeId, Placement newPlacement) {
    Employee employee = getEmployeeByEmployeeId(employeeId);
    if (employee == null) {
      System.out.println("Employee with ID " + employeeId + " not found.");
      return false;
    }

    employee.getPlacement().setCity(newPlacement.getCity());

    System.out.println("Placement for Employee with ID " + employeeId + " has been updated.");
    return true;
  }

  public boolean deleteEmployee(String employeeId) {
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getEmployeeID().equals(employeeId)) {
        employees.remove(i);
        return true;
      }
    }
    return false;
  }
}
