package org.example;

import java.util.Objects;

public class Employee {
    private int id;
    private String first_Name;
    private String last_Name;
    private String role;

    public Employee(int id, String first_Name, String last_Name, String role) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(first_Name, employee.first_Name) && Objects.equals(last_Name, employee.last_Name) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_Name, last_Name, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
