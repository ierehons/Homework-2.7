public class Main {
    public static void main(String[] args) {
        EmployeesBook employeesBook = new EmployeesBook();
        Employee ivan = new Employee("Иванов", "Иван", "Иванович", 1, 48000);
        employeesBook.addEmployee(new Employee("Рогачёв", "Николай", "Михайлович",
                2, 49560.0));
        employeesBook.addEmployee(ivan);
        employeesBook.changeSalary(ivan, 30000);

        employeesBook.printEmployeesByDepartment();

        employeesBook.printAllEmployees();
        double totalSalaries = employeesBook.totalSalaries();
        System.out.printf("Сумма ЗП всех сотрудников за месяц: %.3f%n", totalSalaries);
        Employee employeeWithMinSalary = employeesBook.findEmployeeWithMinSalary();
        System.out.printf("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);
        Employee employeeWithMaxSalary = employeesBook.findEmployeeWithMaxSalary();
        System.out.printf("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);
        double averageSalary = employeesBook.averageSalary();
        System.out.printf("Средняя ЗП всех сотрудников за месяц: %.3f%n", averageSalary);
        employeesBook.printFullNameEmployees();

        employeesBook.indexSalaries(10);
        System.out.println("После индексации");
        employeesBook.printAllEmployees();

        System.out.printf("Сотрудник с минимальной ЗП из %d отдела: %s%n", 1, employeesBook.findEmployeeWithMinSalaryFromDepartment(1));
        System.out.printf("Сотрудник с максимальной ЗП из %d отдела: %s%n", 2, employeesBook.findEmployeeWithMaxSalaryFromDepartment(2));
        System.out.printf("Сумма ЗП всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeesBook.totalSalariesForDepartment(3));
        System.out.printf("Средняя исумма ЗП всех сотрудников за месяц из отдела %d: %.3f%n", 4, employeesBook.averageSalaryForDepartment(4));
        employeesBook.indexSalariesForDepartment(5, 1);
        System.out.println("После индексации для отдела " + 1);
        employeesBook.printAllEmployeesFromDepartment(1);
        employeesBook.printEmployeesWithSalaryLessThen(55000);
    }
}
