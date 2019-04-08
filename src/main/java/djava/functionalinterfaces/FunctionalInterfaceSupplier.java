package djava.functionalinterfaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

//T get()
public class FunctionalInterfaceSupplier {

	public void execute() {
		String f1 = "12341234123412";
		String f2 = "12341234112223412";

		CompletableFuture<BigDecimal> future = CompletableFuture.supplyAsync(() -> {
			BigDecimal bf1 = new BigDecimal(f1);
			BigDecimal bf2 = new BigDecimal(f2);
			return bf1.multiply(bf2);
		});
		
		System.out.println(future.join().toPlainString());
	}

	public static void main(String[] args) {
		FunctionalInterfaceSupplier fis = new FunctionalInterfaceSupplier();
		fis.execute();
	}

}
