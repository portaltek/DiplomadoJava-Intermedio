package djava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ObjectStreamDemo {

	public static void main(String[] args) {
		ObjectStreamDemo s = new ObjectStreamDemo();
		s.getActiveEmployeeFromFirstMin3WithStream();

	}

	public void getActiveEmployeeFromFirstMin3WithStream() {
		List<Employee> employeeList = getEmployeeList();

		employeeList.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).filter(Employee::isActive)
				.limit(3).map(Employee::getName).forEach(System.out::println);
	}

	public void getActiveEmployeeFromFirstMin3WithLoop() {
		List<Employee> employeeList = getEmployeeList();
		List<Employee> copy = new ArrayList<>(employeeList);

		copy.sort((o1, o2) -> o2.getId() - o1.getId());
		int count = 0;
		for (int i = 0; i < 3; i++) {
			Employee e = copy.get(i);
			if (e.isActive()) {
				count++;
				System.out.println(copy.get(i).getName());
			}

		}
		System.out.println("Count:" + count);
	}

	public void getMinEmployeesWithStream() {
		List<Employee> employeeList = getEmployeeList();

		employeeList.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).limit(3)
				.map(Employee::getName).forEach(System.out::println);
	}

	public void getMinEmployeesWithForLoop() {
		List<Employee> employeeList = getEmployeeList();
		List<Employee> copy = new ArrayList<>(employeeList);

		copy.sort((o1, o2) -> o2.getId() - o1.getId());

		for (int i = 0; i < 3; i++) {
			System.out.println(copy.get(i).getName());
		}
	}

	public static List<Employee> getEmployeeList() {
		return Arrays.asList(new Employee(1, "A", "X", true), new Employee(2, "B", "X", false),
				new Employee(3, "C", "Y", true));
	}

}
