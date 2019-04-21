package djava.concurrency.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsynchronousDemo {
	public static void main(String[] args) {
		AsynchronousDemo demo = new AsynchronousDemo();
//		demo.testBlocking();
		demo.testNonBlocking();

	}

	public void testBlocking() {
		ExecutorService service = Executors.newFixedThreadPool(4);
		List<Integer> employeeIds = Arrays.asList(1, 2, 3);
		for (Integer id : employeeIds) {

			try {
				Future<Employee> futureEmployee = service.submit(new EmployeeService(id));
				Employee emp = futureEmployee.get();
				Future<Tax> futureTax = service.submit(new TaxService(emp));
				Tax tax = futureTax.get();
				service.submit(new EmailService(tax));
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e.getMessage());

			}

		}
	}

	public void testNonBlocking() {

		List<Integer> employeeIds = Arrays.asList(1, 2, 3);
		for (Integer id : employeeIds) {
			CompletableFuture.supplyAsync(() -> fetchEmployee(id)).thenApplyAsync(this::fetchTax)
					.thenAcceptAsync(this::fetchEmail);
		}
	}

	public Employee fetchEmployee(int id) {
		return new EmployeeService(id).execute();
	}

	public Tax fetchTax(Employee emp) {
		return new TaxService(emp).execute();
	}

	public void fetchEmail(Tax tax) {
		new EmailService(tax).execute();
	}

	public static class Employee {
		public int id;
	}

	public static class Tax {
		public float tax;
		public Employee emp;
	}

	public static class EmailService implements Runnable {

		private Tax tax;

		public EmailService(Tax tax) {
			this.tax = tax;
		}

		@Override
		public void run() {
			execute();
		}

		public void execute() {
			System.out.println("Email submitted: " + tax.emp.id);
		}

	}

	public static class EmployeeService implements Callable<Employee> {

		private int id;

		public EmployeeService(int id) {
			this.id = id;
		}

		@Override
		public Employee call() {
			return execute();
		}

		public Employee execute() {
			Employee e = new Employee();
			e.id = id;
			return e;
		}

	}

	public static class TaxService implements Callable<Tax> {

		private Employee e;

		public TaxService(Employee e) {
			this.e = e;
		}

		@Override
		public Tax call() {
			return execute();
		}

		public Tax execute() {
			Tax tax = new Tax();
			tax.tax = (float) this.e.id / 10;
			tax.emp = this.e;
			return tax;
		}

	}

}
