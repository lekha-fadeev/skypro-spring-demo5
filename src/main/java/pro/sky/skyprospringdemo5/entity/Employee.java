package pro.sky.skyprospringdemo5.entity;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;

    private final double salary;

    private final int departamentid;

    public Employee(String firstName, String lastName, double salary, int departamentid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departamentid = departamentid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {return salary;}

    public int getDepartamentid() {return departamentid;}

    public String getFullName(){return firstName + "" + lastName;}

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departamentid=" + departamentid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && departamentid == employee.departamentid && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departamentid);
    }
}


