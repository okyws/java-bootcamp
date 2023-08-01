package repository;

import java.util.ArrayList;
import java.util.List;

import childs.DataAnalyst;
import childs.Programmer;
import childs.ProjectLeader;
import parents.Employee;
import parents.Placement;

public class RepositoryEmployee {

  public List<Employee> getAllDummEmployees() {
    List<Employee> dummyEmployees = new ArrayList<>();
    // Employee dummy
    dummyEmployees.add(new Employee("Emp-001", "Susi", "Bandung", 27, "Admin", new Placement("Jakarta"), 4453935.0));
    dummyEmployees
        .add(new Employee("Emp-002", "Anto", "Bandung", 35, "Office Boy", new Placement("Bandung"), 3742276.0));
    dummyEmployees.add(
        new Employee("Emp-003", "Riman", "Jakarta", 28, "Human Resource Dev", new Placement("Bandung"), 3742276.0));

    // Programmer dummy
    dummyEmployees.add(new Programmer("PRO-001", "Budi", "Bandung", 25, "Back End Dev", new Placement("Jakarta"),
        new String[] { "Java" }, 2));
    dummyEmployees.add(new Programmer("PRO-002", "Ani", "Bandung", 30, "Front End Dev",
        new Placement("Bandung"), new String[] { "React Js" }, 6));
    dummyEmployees.add(new Programmer("PRO-003", "Ujang", "Jakarta", 28, "Full Stack Dev",
        new Placement("Bandung"), new String[] { "Kotlin" }, 4));

    // Project Leader dummy
    dummyEmployees.add(new ProjectLeader("PL-001", "Ahmad", "Bandung", 25, "Project Leader",
        new Placement("Garut"), 2));
    dummyEmployees.add(new ProjectLeader("PL-002", "Dani", "Bandung", 30, "Scrum Master",
        new Placement("Bekasi"), 1));
    dummyEmployees.add(new ProjectLeader("PL-003", "Cecep", "Jakarta", 28, "Project Owner",
        new Placement("Bogor"), 4));

    // Data Analyst dummy
    dummyEmployees.add(new DataAnalyst("AL-001", "Indah", "Garut", 25, "Data Analyst",
        new Placement("Jakarta")));
    dummyEmployees.add(new DataAnalyst("AL-002", "Puspa", "Bandung", 30, "Data Analyst",
        new Placement("Bekasi")));
    dummyEmployees.add(new DataAnalyst("AL-003", "Sari", "Jakarta", 28, "Data Analyst",
        new Placement("Bogor")));

    return dummyEmployees;
  }
}
