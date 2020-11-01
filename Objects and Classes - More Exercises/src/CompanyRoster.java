import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String email = "n/a";
            int age = -1;
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            if (data.length == 5) {
                try {
                    age = Integer.parseInt(data[4]);
                } catch (Exception ignored) {
                    email = data[4];
                }
            } else if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            employees.add(employee);
        }

        List<String> dep = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        List<Department> departments = new ArrayList<>();
        for (String department : dep) {
            departments.add(new Department(department, employees.stream().filter(e -> e.getDepartment().equals(department)).collect(Collectors.toList())));
        }
        departments.sort(Comparator.comparingDouble(Department::getAverageSalary).reversed());
        Department department = departments.get(0);
        department.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployees()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }

    private static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }
    }

    private static class Department {
        String name;
        double averageSalary;
        List<Employee> employees;

        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
            this.averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        }

        public String getName() {
            return name;
        }


        public double getAverageSalary() {
            return averageSalary;
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }
}