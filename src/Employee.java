import java.util.Objects;

public class Employee {
    private static int counter = 1;


    private final String lastName;
    private final String firstName;
    private final String middleName;

    private double department;
    private double salary;
    private final int id;

    public Employee(String lastName, String firstName, String middleName, double department, double salary) {
        this.id = counter++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public double getDepartment() {
        return department;
    }


    public double getSalary() {
        return salary;
    }

    public long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName)
                && lastName.equals(employee.lastName)
                && middleName.equals(employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, department, salary, id);
    }

    @Override
    public String toString() {
        return String.format(
                "id: %d, ФИО: %s %s %s, ЗП: %.2f, № отдела: %f",
                id,
                lastName,
                firstName,
                middleName,
                salary,
                department
        );
    }
}
