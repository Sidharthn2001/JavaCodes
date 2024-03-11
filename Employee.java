import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Employee {
	private String name;
	private int age;
	private double salary;

	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
	}

	public static List<Employee> generateRandomEmployees(int numEmployees) {
		List<Employee> employees = new ArrayList<>();
		Random random = new Random();
		String[] names = { "John", "Jane", "Bob", "Alice", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi" };

		for (int i = 0; i < numEmployees; i++) {
			String name = names[random.nextInt(names.length)];
			int age = random.nextInt(100);
			double salary = random.nextDouble() * 100000;
			employees.add(new Employee(name, age, salary));
		}

		return employees;
	}

	public static void sortEmployeesByAge(List<Employee> employees) {
		Collections.sort(employees, Comparator.comparingInt(Employee::getAge));
	}

	public static void sortEmployeesBySalary(List<Employee> employees) {
		Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
	}

	public static void main(String[] args) {
		List<Employee> employees = generateRandomEmployees(10);

		System.out.println("Employees sorted by age:");
		sortEmployeesByAge(employees);
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("\nEmployees sorted by salary:");
		sortEmployeesBySalary(employees);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}

