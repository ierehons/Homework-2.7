import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeesBook {
    private final Map<String, Employee> employees;

    public EmployeesBook() {
        employees = new HashMap<>();
    }

    private java.lang.String getKey(Employee employee) {
        return employee.getFirstName() + " " + employee.getLastName() + " " + employee.getMiddleName();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String firstName,
                            String lastName,
                            String middleName,
                            double salary,
                            int department) {
        addEmployee(new Employee(firstName, lastName, middleName, salary, department));
    }


    public void removeEmployee(Employee employee) {

        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        for (Map.Entry<String, Employee> entry :
                employees.entrySet()) {
            String key = entry.getKey();
            Employee employee = entry.getValue();
            if (employee.getId() == id) {
                employees.remove(key);
                break;
            }
        }
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }

    //замена отдела
    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setDepartment(newDepartment);
        }
    }

    public void printEmployeesByDepartment() {
        // отделы от 1-5
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудник из отдела " + department + ":");
            for (Employee employee : employees.values()) {
                if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                    System.out.println(employee.getLastName() + " " + employee.getFirstName() + " "
                            + employee.getMiddleName());
                }
            }
        }
    }

    public void printEmployeesWithSalaryLessThen(double bound) {
        System.out.println("Сотрдник с меньшей зарплатой, чем " + bound + ":");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalary() < bound) {
                System.out.printf(
                        "id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary()
                );
            }
        }
    }

    public void printEmployeesWithSalaryGreaterEqualThen(double bound) {
        System.out.println("Сотрудник с зарплатой большей или равной, чем " + bound + ":");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalary() >= bound) {
                System.out.printf(
                        "id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary()
                );
            }
        }
    }

    public void indexSalaries(double index) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public void indexSalariesForDepartment(double index, int department) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public double averageSalary() {
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                count++;
            }
        }
        if (count != 0) {
            return totalSalaries() / count;
        }
        return 0;
    }

    public double averageSalaryForDepartment(int department) {
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                totalSalaryForDepartment += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalaryForDepartment / count;
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department
                    && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department
                    && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public double totalSalariesForDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void printFullNameEmployees() {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                System.out.println(
                        employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
            }
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                System.out.println(employee);
            }
        }
    }

    public void printAllEmployeesFromDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                System.out.printf(
                        "id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary()
                );
            }
        }
    }
}
